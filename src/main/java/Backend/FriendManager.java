/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author abban
 */
//This class's purpose is to make,get,update and remove friends
public class FriendManager {

    //This method uses mySQL database to get a list of user's friends
    //This method's input is username
    //This method returns a string array
    public static String[] getFriends(String username) throws SQLException {

        //Used ArrayList because there is not a fixed number of friends a user can have
        ArrayList<String> friendsArrayList = new ArrayList<>();
        
        //Get user's UserID because tables are connected by userID
        int userID = UserManager.getUserID(username);
        
        //Query to get user's friends 
        ResultSet getFriendResult = DB.query("Select Username from abbankDB.Users,Friends Where (abbankDB.Friends.FriendID = abbankDB.Users.UserID) AND abbankDB.Friends.UserID = " + userID + "");
        
        //While loop because we don't know how many friends there are and we want to add indiviual friends to the array list
        while (getFriendResult.next()) {
            
            //Gets indiviual friend
            String individualFriend = getFriendResult.getString(1);
            //Add the indiviual friend to array list
            friendsArrayList.add(individualFriend);

        }

        //Convert Array list to String array
        String[] friendList = friendsArrayList.toArray(String[]::new);
        
        //Return String array
        return friendList;

    }
    
    //Method is used when the user is finding someone to friend
    //Method inputs are user's username and what the user typed in the search text field
    //Method output is a String array of username that begins what the user typed
    public static String[] findPeople(String friendString, String username) throws SQLException {
        
        //Used ArrayList because there is not a fixed number of username
        ArrayList<String> peopleArrayList = new ArrayList<>();
        
        //Query to get all the username from the table
        ResultSet findPeopleResult = DB.query("SELECT Username from abbankDB.Users");
        
        //While loop because we don't know how manu usernames there are and to get indiviual users and add them to the array list
        while (findPeopleResult.next()) {
            
            //Gets indiviual username
            String indiviualUsername = findPeopleResult.getString(1);
            
            //Checks if indiviual username starts with what the user typed and check if the indiviual username is not the user
            if (indiviualUsername.startsWith(friendString) && !(indiviualUsername.equals(username))) {
                
                //If it is true, add it to array list
                peopleArrayList.add(indiviualUsername);

            }

        }
        
        //Convert array list to string array
        String[] people = peopleArrayList.toArray(String[]::new);

        //Return String array
        return people;

    }

    //Method gets user's incoming friend request 
    //Method input is username
    //Method output is people who wants to be friends with the user
    public static String[] getFriendRequestList(String username) throws SQLException {

        //Used ArrayList because there is not a fixed number of people that can friend the user
        ArrayList<String> friendRequestArrayList = new ArrayList<>();
        
        //Get user's userID because tables are connected by userID
        int userID = UserManager.getUserID(username);

        //Query to get incoming friend request
        ResultSet getFriendRequestResult = DB.query("Select Username from abbankDB.Users,FriendRequests Where (abbankDB.FriendRequests.UserID = abbankDB.Users.UserID) AND abbankDB.FriendRequests.FriendID = " + userID + "");
        
        //While loop because we don't know how many incoming friend request there is
        while (getFriendRequestResult.next()) {
            
            //Get individual username that send friend request to the user
            String individualFriendRequest = getFriendRequestResult.getString(1);
            //Add individual username to array list
            friendRequestArrayList.add(individualFriendRequest);

        }
        
        //Convert array list to String list
        String[] incomingFriendRequest = friendRequestArrayList.toArray(String[]::new);
        
        //Return String list
        return incomingFriendRequest;

    }
    
    //Method send friend request from the user to the other user
    //Method inputs are username and friend
    //Method returns a boolean to state that if the friend request as successful
    public static boolean sendFriendRequest(String username, String friend) throws SQLException {

        //Getting userID of user
        int userID = UserManager.getUserID(username);

        //Getting userID of who the user chose to send the friend request
        int friendID = UserManager.getUserID(friend);
        
        //Query to ask if the user already send a friend request to the person (count because it is simple)
        ResultSet mySQLSendFriendRequestResult = DB.query("Select count(*) from abbankDB.FriendRequests Where UserID = " + userID + " And FriendID = " + friendID + "");

        mySQLSendFriendRequestResult.next();
        
        //Get the count result as int
        int friendRequestCount = mySQLSendFriendRequestResult.getInt(1);

        //Query to ask if the user is already friend with the person
        mySQLSendFriendRequestResult = DB.query("Select count(*) from abbankDB.Friends Where UserID = " + userID + " And FriendID = " + friendID + "");

        mySQLSendFriendRequestResult.next();
        
        //Get the count result as int
        int friendCount = mySQLSendFriendRequestResult.getInt(1);
        
        //Check if the result from the two query is false
        //0 is false and 1 is true
        if (friendRequestCount == 0 && friendCount == 0) {
            
            //If it is true, send the friend request
            DB.update("Insert into abbankDB.FriendRequests Values(" + userID + " , " + friendID + ")");
            
            //Returns true to say that the friend request was successful
            return true;

        }
        
        //Returns false to say that the friend request as a failure 
        return false;

    }
    
    //Method accepts the friend request
    //Method inputs are the user and the person the user chose to accept their friend request
    public static void acceptFriendRequest(String userName, String friendName) throws SQLException {
        
        //Get userID of user
        int userID = UserManager.getUserID(userName);
        
        //Get userID of the person the user chose to accept their friend request
        int friendID = UserManager.getUserID(friendName);

        //Remove the friend request
        DB.update("Delete from abbankDB.FriendRequests Where UserID = " + userID + " And FriendID = " + friendID + "");
        
        //Remove the friend request
        DB.update("Delete from abbankDB.FriendRequests Where UserID = " + friendID + " And FriendID = " + userID + "");
        
        //Make the user friend with the person
        DB.update("Insert into abbankDB.Friends Values(" + userID + " , " + friendID + ")");
        
        //Make the person friend with the user
        DB.update("Insert into abbankDB.Friends Values(" + friendID + " , " + userID + ")");

    }

    //Method blocks  selected friend
    //Method inputs are user and selected friend
    public static void blockFriend(String username, String friend) throws SQLException {

        //Get userID Of user
        int userID = UserManager.getUserID(username);
        
        //Get userID of seleced friend
        int friendID = UserManager.getUserID(friend);

        //Makes the update to block the friend
        //Save time because we have to know when the user blocked the friend so the user will not recieve message after the block time
        DB.update("Insert into abbankDB.BlockedFriends Values(" + userID + " , " + friendID + " , now())");

    }

    //Method unblock the selected friend
    //Method inputs are username and selected friend
    public static void unblockFriend(String username, String friend) throws SQLException {

        //Get userID of user
        int userID = UserManager.getUserID(username);
        
        //Get userID of selected friend
        int friendID = UserManager.getUserID(friend);

        //Delete the block friend
        //Time is removed so the user will recieve all the message from friend so the user can decised if they want to block their friend again or not
        DB.update("Delete from abbankDB.BlockedFriends Where UserID = " + userID + " And FriendID = " + friendID + "");

    }
    
    //Method checks if the user has blocked their friend
    public static boolean isBlocked(String username, String friend) throws SQLException {
        
        //Get userID of user
        int userID = UserManager.getUserID(username);
        
        //Get userID of friend
        int friendID = UserManager.getUserID(friend);
        
        //Query to check if the user has blocked the friend (count query becuase it is easier)
        ResultSet mySQLIsBlockedResult = DB.query("Select count(*) from abbankDB.BlockedFriends Where UserID = " + userID + " And FriendID = " + friendID + "");

        mySQLIsBlockedResult.next();

        //Get result as int
        int isBlockedCount = mySQLIsBlockedResult.getInt(1);

        //Return count 
        //If count is 1, the user block friend
        //If count is 0, the user did not block friend
        return isBlockedCount == 1;

    }
    
    //Method to get when the user blocked the friend
    public static Timestamp getWhenBlocked(int userID, int friendID) throws SQLException {
        
        //Query to get time of when the user blocked friend
        ResultSet mySQLWhenBlockedResult = DB.query("Select time from abbankDB.BlockedFriends Where UserID = " + userID + " And FriendID = " + friendID + "");

        mySQLWhenBlockedResult.next();

        //Get time as Timestamp
        Timestamp whenBlockedTimestamp = mySQLWhenBlockedResult.getTimestamp(1);

        //Return time
        return whenBlockedTimestamp;
    }

    //Method checks if the user deleted friend message
    //Method input is username and friend
    //Method returns true if the user delete friend message
    public static boolean isMessageDelete(String username, String friend) throws SQLException {

        //Get userID of user
        int userID = UserManager.getUserID(username);
        
        //Get userID of friend
        int friendID = UserManager.getUserID(friend);

        //Query to check if the user has delete friend message ( count query because it is easy)
        ResultSet mySQLIsMessageDeleteResult = DB.query("Select count(*) from abbankDB.DeleteFriendMessage Where UserID = " + userID + " And FriendID = " + friendID + "");

        mySQLIsMessageDeleteResult.next();

        //Get result as int
        int isMessageDeleteCount = mySQLIsMessageDeleteResult.getInt(1);

        //Return int
        //1 is true
        //0 is false
        return isMessageDeleteCount == 1;

    }

    //Method gets when the user delete friend message
    //Method inputs are userID and friendID
    //Method outputs is Timestamp
    public static Timestamp getWhenMessageDelete(int userID, int friendID) throws SQLException {
        
        //Query to get the time of when the user delete friend message
        ResultSet mySQLGetWhenMessageDeleteResult = DB.query("Select time from abbankDB.DeleteFriendMessage Where UserID = " + userID + " And FriendID = " + friendID + "");

        mySQLGetWhenMessageDeleteResult.next();

        //Get the result from the query as timestamp
        Timestamp whenMessageDeleteTimestamp = mySQLGetWhenMessageDeleteResult.getTimestamp(1);

        //Return time
        return whenMessageDeleteTimestamp;

    }

    //Method delete friend message
    //Method input are username and friend
    public static void deleteMessage(String username, String friend) throws SQLException {
        
        //Check if user has already have delete friend message
        if (isMessageDelete(username, friend)) {

            //True, change the time
            DB.update("Update abbankDB.DeleteFriendMessage Set time = now()");

        } else {
            
            //False
            //Get userID of user
            int userID = UserManager.getUserID(username);
            
            //Get userID of Friend
            int friendID = UserManager.getUserID(friend);
            
            //Create a new delete friend message 
            DB.update("Insert Into abbankDB.DeleteFriendMessage Values(" + userID + " , " + friendID + " , now() )");

        }

    }

    //Method make user no more friends with the friend
    //Method inputs are username and friend
    public static void removeFriend(String username, String friend) throws SQLException {

        //Get userID of user
        int userID = UserManager.getUserID(username);
        
        //Get userID of friend
        int friendID = UserManager.getUserID(friend);

        //Made that the user is no more friend with the friend
        DB.update("Delete from abbankDB.Friends Where UserID = " + userID + " And FriendID = " + friendID + "");
        
        //Made that the friend is no more friend with user
        DB.update("Delete from abbankDB.Friends Where UserID = " + friendID + " And FriendID = " + userID + "");

    }

    //Method get friend's username
    //Method inputs are username and jList selected index
    public static String getFriendUsername(String username, int index) throws SQLException {
        
        //Get all friend
        String[] currentFriendList = FriendManager.getFriends(username);

        //Get friend at the index
        String friendAtIndex = currentFriendList[index];
        
        //Return friend
        return friendAtIndex;

    }
}
