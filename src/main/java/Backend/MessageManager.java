/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author abban
 */
public class MessageManager {

    //Method returns friend message as a multilined string 
    //Method inputs are user's username and friend's username
    public static String getFriendMessages(String username, String friend) throws SQLException {
        
        //Check if the user blocked the friend
        boolean isFriendBlocked = FriendManager.isBlocked(username, friend);

        //Check if the user delete friend message
        boolean isFriendMessageDeleted = FriendManager.isMessageDelete(username, friend);

        //Get userID of user
        int userID = UserManager.getUserID(username);

        //Get userID of friend
        int friendID = UserManager.getUserID(friend);

        String completedMessage = "";
        
        //Query to get who send the message to who, when the message was send and what was the message. The time is in asc because the message has to be in chronoical order
        ResultSet mySQLFriendMessageResult = DB.query("SELECT UserID,Time,Message FROM abbankDB.FriendMessages Where (UserID = " + userID + " And FriendID = " + friendID + ") OR (UserID = " + friendID + " And FriendID = " + userID + ") ORDER BY Time asc;");

        //Check if the user blocked and delete friend message
        if (isFriendBlocked && isFriendMessageDeleted) {

            //If true, a while loop is run to every single message send
            while (mySQLFriendMessageResult.next()) {
                
                //Get who send the message
                int userWhoSendMessage = mySQLFriendMessageResult.getInt(1);

                //Get when the user blocked the friend
                Timestamp blockedFriendTimestamp = FriendManager.getWhenBlocked(userID, friendID);

                //Get when the user delete friend message
                Timestamp deleteFriendMessageTimestamp = FriendManager.getWhenMessageDelete(userID, friendID);

                //Get when the who send the message
                Timestamp messageSentTimestamp = mySQLFriendMessageResult.getTimestamp(2);

                //Convert timestamp to string
                String messageSentString = messageSentTimestamp.toString();

                //Get the message
                String message = mySQLFriendMessageResult.getString(3);

                //Check if the messages is after the delete friend message and before the block
                if (deleteFriendMessageTimestamp.before(messageSentTimestamp) && blockedFriendTimestamp.after(messageSentTimestamp)) {
                    
                    //Complete line message
                    String completeLineMessage = "< " + messageSentString + " > " + message + "\n";

                    //Add line message to full message
                    completedMessage = completedMessage + completeLineMessage;

                } 
                //Check if the message is sent after the block and if the person who send the message is the user
                else if (deleteFriendMessageTimestamp.before(messageSentTimestamp) && blockedFriendTimestamp.before(messageSentTimestamp) && userWhoSendMessage == userID) {
                   
                    //Complete line message
                    String completeLineMessage = "< " + messageSentString + " > " + message + "\n";

                    //Add line message to full message
                    completedMessage = completedMessage + completeLineMessage;

                }
            }

        }

        //Check if the user blocked their friend
        else if (isFriendBlocked) {

            //If true, a while loop is run to every single message send
            while (mySQLFriendMessageResult.next()) {

                //Get when the user blocked their friend
                Timestamp blockedFriendTimestamp = FriendManager.getWhenBlocked(userID, friendID);
 
                 //Get who send the message
                int userWhoSendMessage = mySQLFriendMessageResult.getInt(1);

                //Get when the person send the message
                Timestamp messageSentTimestamp = mySQLFriendMessageResult.getTimestamp(2);

                //Comvert Timestamp to string
                String messageSentString = messageSentTimestamp.toString();

                //Get the message sent
                String message = mySQLFriendMessageResult.getString(3);

                //Check if the message send is before the block
                if (blockedFriendTimestamp.after(messageSentTimestamp)) {

                    //Complete line message
                    String completeLineMessage = "< " + messageSentString + " > " + message + "\n";

                    //Add complete line message to full message
                    completedMessage = completedMessage + completeLineMessage;

                } 
                
                //Check if the message send is after the block and the person who send the message is the user
                else if (blockedFriendTimestamp.before(messageSentTimestamp) && userWhoSendMessage == userID) {

                    //Complete line message
                    String completeLineMessage = "< " + messageSentString + " > " + message + "\n";

                    //Add complete line message to full message
                    completedMessage = completedMessage + completeLineMessage;

                }
            }

        } 
        
        //Check if user delete friend message
        else if (isFriendMessageDeleted) {

            //If true, a while loop is run to every single message send
            while (mySQLFriendMessageResult.next()) {

                //Get when the user delete friend message
                Timestamp deleteFriendTimestamp = FriendManager.getWhenMessageDelete(userID, friendID);

                mySQLFriendMessageResult.getInt(1);

                //Get when message is sent
                Timestamp messageSentTimestamp = mySQLFriendMessageResult.getTimestamp(2);

                //Convert timestamp to string
                String messageSentString = messageSentTimestamp.toString();

                //Get message sent
                String message = mySQLFriendMessageResult.getString(3);

                //Check if the message sent is after the delete friend message
                if (deleteFriendTimestamp.before(messageSentTimestamp)) {
                    
                    //Complete line message
                    String completeLineMessage = "< " + messageSentString + " > " + message + "\n";

                    //Add line message to complete message
                    completedMessage = completedMessage + completeLineMessage;

                }
            }
        }
        else {

            
            while (mySQLFriendMessageResult.next()) {

                mySQLFriendMessageResult.getInt(1);

                //Get when the message is sent
                Timestamp messageSentTimeStamp = mySQLFriendMessageResult.getTimestamp(2);

                //Convert Timestamp to string
                String messageSentString = messageSentTimeStamp.toString();

                //Get message
                String message = mySQLFriendMessageResult.getString(3);

                //Complete line message
                String completeLineMessage = "< " + messageSentString + " > " + message + "\n";

                //Add line message to complete message
                completedMessage = completedMessage + completeLineMessage;

            }

        }

        //Return message
        return completedMessage;
    }

    //Method send message to friend
    //Method inputs are user's username, friend's username and message
    public static void sendFriendMessage(String username, String friend, String sendmessage) throws SQLException {

        //Get userID
        int userID = UserManager.getUserID(username);

        //Get friendID
        int friendID = UserManager.getUserID(friend);

        //Get display name of user
        String displayNameOfUser = UserManager.getDisplayName(username);

        //Add display name to the message
        String message = displayNameOfUser + ": " + sendmessage;

        //Save the message
        DB.update("Insert into abbankDB.FriendMessages(UserID,FriendID,Time,Message) Values(" + userID + " , " + friendID + " , now() , '" + message + "')");

    }

    //Method gets group message from user's username and the selected index of jList
    public static String getGroupMessages(String username, int index) throws SQLException {

        //Check if the user blocked the group
        boolean isGroupBlocked = GroupManager.isBlocked(username, index);

        //Check if the user delete group message
        boolean isGroupMessageDelete = GroupManager.isMessageDelete(username, index);

        //Get groupID
        int groupID = GroupManager.getGroupID(username, index);

        //Get userID
        int userID = UserManager.getUserID(username);

        String completedMessage = "";

        //Get who send the message, when the message was sent and what the message was
        ResultSet mySQLGroupMessageResult = DB.query("Select userID,time,message from abbankDB.GroupMessages Where groupID = " + groupID + "");

        //Check if user block group and user delete group message
        if (isGroupBlocked && isGroupMessageDelete) {

            //If true, a while loop is run to every single message send
            while (mySQLGroupMessageResult.next()) {

                //Get when user blocked the group
                Timestamp groupBlockedTimestamp = GroupManager.getWhenBlocked(username, index);

                //Get when user delete group message
                Timestamp groupMessageDeleteTimeStamp = GroupManager.getWhenMessageDelete(username, index);

                //Get who send the message
                int userWhoSendMessage = mySQLGroupMessageResult.getInt(1);

                //Get when the message was sent
                Timestamp messageSentTimestamp = mySQLGroupMessageResult.getTimestamp(2);

                //Convert timestamp to string
                String messageSentString = messageSentTimestamp.toString();

                //Get message sent
                String message = mySQLGroupMessageResult.getString(3);

                //Check if the message sent was after the delete message timestamp and if message sent was before the block
                if (groupMessageDeleteTimeStamp.before(messageSentTimestamp) && groupBlockedTimestamp.after(messageSentTimestamp)) {

                    //Complete line messsage
                    String completeLineMessage = "< " + messageSentString + " > " + message + "\n";

                    //Add line message to full message
                    completedMessage = completedMessage + completeLineMessage;

                } 
                //Check if the message was after the block and if the person who sent the message was the user
                else if (groupMessageDeleteTimeStamp.before(messageSentTimestamp) && groupBlockedTimestamp.before(messageSentTimestamp) && userWhoSendMessage == userID) {

                    //Complete line message
                    String completeLineMessage = "< " + messageSentString + " > " + message + "\n";

                    //Add line message to full message
                    completedMessage = completedMessage + completeLineMessage;

                }
            }
        } 
        //Check if the user delete group message
        else if (isGroupMessageDelete) {

            //If true, a while loop is run to every single message send
            while (mySQLGroupMessageResult.next()) {

                //Get when user delete group message
                Timestamp groupMessageDeleteTimestamp = GroupManager.getWhenMessageDelete(username, index);

                mySQLGroupMessageResult.getInt(1);

                //Get when the message was sent
                Timestamp messageSentTimestamp = mySQLGroupMessageResult.getTimestamp(2);

                //Convert timestamp to string
                String messageSentString = messageSentTimestamp.toString();

                String message = mySQLGroupMessageResult.getString(3);

                //Check if message sent was after the group message delete time
                if (groupMessageDeleteTimestamp.before(messageSentTimestamp)) {

                    //Complete line message
                    String completeLineMessage = "< " + messageSentString + " > " + message + "\n";

                    //Add complete line message to full message
                    completedMessage = completedMessage + completeLineMessage;

                }
            }

        }
        //Check if the user blocked group
        else if (isGroupBlocked) {

            //If true, a while loop is run to every single message send
            while (mySQLGroupMessageResult.next()) {

                //Get when user blocked the group
                Timestamp groupBlockedTimestamp = GroupManager.getWhenBlocked(username, index);

                //Get who send the message
                int userWhoSendMessage = mySQLGroupMessageResult.getInt(1);

                //Get when the message was sent
                Timestamp messageSentTimestamp = mySQLGroupMessageResult.getTimestamp(2);

                //Convert timestamp to string
                String messageSentString = messageSentTimestamp.toString();

                String message = mySQLGroupMessageResult.getString(3);

                //Check if message sent is before the block
                if (groupBlockedTimestamp.after(messageSentTimestamp)) {

                    //Complete line message
                    String completeLineMessage = "< " + messageSentString + " > " + message + "\n";

                    //Add complete line message to full message
                    completedMessage = completedMessage + completeLineMessage;

                } 
                //Check if the message is after the block and the person who sent the message is the user
                else if (groupBlockedTimestamp.before(messageSentTimestamp) && userWhoSendMessage == userID) {

                    //Complete line message
                    String completeLineMessage = "< " + messageSentString + " > " + message + "\n";

                    //Add complete line message to full message
                    completedMessage = completedMessage + completeLineMessage;

                }
            }

        } else {

            //If true, a while loop is run to every single message send
            while (mySQLGroupMessageResult.next()) {

                mySQLGroupMessageResult.getInt(1);

                //Get when the message was sent
                Timestamp messageSentTimestamp = mySQLGroupMessageResult.getTimestamp(2);

                //Convert timestamp to string
                String messageSentString = messageSentTimestamp.toString();

                String message = mySQLGroupMessageResult.getString(3);

                //Complete line message
                String completeLineMessage = "< " + messageSentString + " > " + message + "\n";

                //Add complete line message to full message
                completedMessage = completedMessage + completeLineMessage;

            }

        }

        //Return message
        return completedMessage;
    }

    //Method save group message 
    //Method inputs are user's username, selected index of jList and message
    public static void sendGroupMessage(String username, int index, String sendmessage) throws SQLException {

        //Get groupID
        int groupID = GroupManager.getGroupID(username, index);

        //Get userID
        int userID = UserManager.getUserID(username);
        
        //Get display name of user
        String displayNameOfUser = UserManager.getDisplayName(username);

        //Add display name to message
        String message = displayNameOfUser + ": " + sendmessage;

        //Save message
        DB.update("Insert into abbankDB.GroupMessages(UserID,groupID,time,message) Values(" + userID + " , " + groupID + " , now() , '" + message + "')");

    }

}
