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

    public static String getFriendMessages(String username, String friend) throws SQLException {
        boolean friendBlock = FriendManager.isBlocked(username, friend);

        boolean friendMessageDelete = FriendManager.isMessageDelete(username, friend);

        int userID = UserManager.getUserID(username);

        int friendID = UserManager.getUserID(friend);

        String completedMessage = "";
        ResultSet result = DB.query("SELECT UserID,Time,Message FROM abbankDB.FriendMessages Where (UserID = " + userID + " And FriendID = " + friendID + ") OR (UserID = " + friendID + " And FriendID = " + userID + ") ORDER BY Time asc;");

        if (friendBlock && friendMessageDelete) {

            while (result.next()) {
                int userWhoSendMessage = result.getInt(1);

                Timestamp blockedDate = FriendManager.getWhenBlocked(userID, friendID);

                Timestamp deletedate = FriendManager.getWhenMessageDelete(userID, friendID);

                Timestamp date = result.getTimestamp(2);

                String dateString = date.toString();

                String message = result.getString(3);

                if (deletedate.before(date) && blockedDate.after(date)) {

                    String completeLineMessage = "< " + dateString + " > " + message + "\n";

                    completedMessage = completedMessage + completeLineMessage;

                } else if (deletedate.before(date) && blockedDate.before(date) && userWhoSendMessage == userID) {
                    String completeLineMessage = "< " + dateString + " > " + message + "\n";

                    completedMessage = completedMessage + completeLineMessage;

                }
            }

        }

        if (friendBlock) {

            while (result.next()) {

                Timestamp blockedDate = FriendManager.getWhenBlocked(userID, friendID);

                int userWhoSendMessage = result.getInt(1);

                Timestamp date = result.getTimestamp(2);

                String dateString = date.toString();

                String message = result.getString(3);

                if (blockedDate.after(date)) {

                    String completeLineMessage = "< " + dateString + " > " + message + "\n";

                    completedMessage = completedMessage + completeLineMessage;

                } else if (blockedDate.before(date) && userWhoSendMessage == userID) {

                    String completeLineMessage = "< " + dateString + " > " + message + "\n";

                    completedMessage = completedMessage + completeLineMessage;

                }
            }

        } else if (friendMessageDelete) {

            while (result.next()) {

                Timestamp deletedate = FriendManager.getWhenMessageDelete(userID, friendID);

                result.getInt(1);

                Timestamp date = result.getTimestamp(2);

                String dateString = date.toString();

                String message = result.getString(3);

                if (deletedate.before(date)) {

                    String completeLineMessage = "< " + dateString + " > " + message + "\n";

                    completedMessage = completedMessage + completeLineMessage;

                }
            }
        } else {

            while (result.next()) {

                result.getInt(1);

                Timestamp date = result.getTimestamp(2);

                String dateString = date.toString();

                String message = result.getString(3);

                String completeLineMessage = "< " + dateString + " > " + message + "\n";

                completedMessage = completedMessage + completeLineMessage;

            }

        }

        return completedMessage;
    }

    public static void sendFriendMessage(String username, String friend, String sendmessage) throws SQLException {

        int userID = UserManager.getUserID(username);

        int friendID = UserManager.getUserID(friend);

        String displayName = UserManager.getDisplayName(username);

        String message = displayName + ": " + sendmessage;

        DB.update("Insert into abbankDB.FriendMessages(UserID,FriendID,Time,Message) Values(" + userID + " , " + friendID + " , now() , '" + message + "')");

    }

    public static String getGroupMessages(String username, int index) throws SQLException {

        boolean groupBlock = GroupManager.isBlocked(username, index);

        boolean groupMessageDelete = GroupManager.isMessageDelete(username, index);

        int groupID = GroupManager.getGroupID(username, index);

        int userID = UserManager.getUserID(username);

        String completedMessage = "";

        ResultSet result = DB.query("Select userID,time,message from abbankDB.GroupMessages Where groupID = " + groupID + "");

        if (groupBlock && groupMessageDelete) {

            while (result.next()) {

                Timestamp whenBlocked = GroupManager.getWhenBlocked(username, index);

                Timestamp whenMessageDelete = GroupManager.getWhenMessageDelete(username, index);

                int userWhoSendMessage = result.getInt(1);

                Timestamp date = result.getTimestamp(2);

                String dateString = date.toString();

                String message = result.getString(3);

                if (whenMessageDelete.before(date) && whenBlocked.after(date)) {

                    String completeLineMessage = "< " + dateString + " > " + message + "\n";

                    completedMessage = completedMessage + completeLineMessage;

                } else if (whenMessageDelete.before(date) && whenBlocked.before(date) && userWhoSendMessage == userID) {

                    String completeLineMessage = "< " + dateString + " > " + message + "\n";

                    completedMessage = completedMessage + completeLineMessage;

                }
            }
        } else if (groupMessageDelete) {

            while (result.next()) {

                Timestamp whenMessageDelete = GroupManager.getWhenMessageDelete(username, index);

                result.getInt(1);

                Timestamp date = result.getTimestamp(2);

                String dateString = date.toString();

                String message = result.getString(3);

                if (whenMessageDelete.before(date)) {

                    String completeLineMessage = "< " + dateString + " > " + message + "\n";

                    completedMessage = completedMessage + completeLineMessage;

                }
            }

        } else if (groupBlock) {

            while (result.next()) {

                Timestamp whenBlocked = GroupManager.getWhenBlocked(username, index);

                int userWhoSendMessage = result.getInt(1);

                Timestamp date = result.getTimestamp(2);

                String dateString = date.toString();

                String message = result.getString(3);

                if (whenBlocked.after(date)) {

                    String completeLineMessage = "< " + dateString + " > " + message + "\n";

                    completedMessage = completedMessage + completeLineMessage;

                } else if (whenBlocked.before(date) && userWhoSendMessage == userID) {

                    String completeLineMessage = "< " + dateString + " > " + message + "\n";

                    completedMessage = completedMessage + completeLineMessage;

                }
            }

        } else {

            while (result.next()) {

                result.getInt(1);

                Timestamp date = result.getTimestamp(2);

                String dateString = date.toString();

                String message = result.getString(3);

                String completeLineMessage = "< " + dateString + " > " + message + "\n";

                completedMessage = completedMessage + completeLineMessage;

            }

        }

        return completedMessage;
    }

    public static void sendGroupMessage(String username, int index, String sendmessage) throws SQLException {

        int groupID = GroupManager.getGroupID(username, index);

        int userID = UserManager.getUserID(username);

        String message = username + ": " + sendmessage;

        DB.update("Insert into abbankDB.GroupMessages(UserID,groupID,time,message) Values(" + userID + " , " + groupID + " , now() , '" + message + "')");

    }

}
