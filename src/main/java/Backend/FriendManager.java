/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abban
 */
public class FriendManager {

    public static String[] getFriends(String username) throws SQLException{
            
            ArrayList<String> friendsArrayList = new ArrayList<>();
            
            int userID = UserManager.getUserID(username);
            
            ResultSet result = DB.query("Select Username from abbankDB.Users,Friends Where (abbankDB.Friends.FriendID = abbankDB.Users.UserID) AND abbankDB.Friends.UserID = " + userID + "");
            
            while(result.next()){
                
                String individualFriend = result.getString(1);
                friendsArrayList.add(individualFriend);
                
            }
            
        String[] friendList = friendsArrayList.toArray(String[]::new);
                
        return friendList;

    }
    
    public static String[] findPeople(String friendString,String username) throws SQLException{
        
        ArrayList<String> peopleArrayList = new ArrayList<>();
        
        ResultSet result = DB.query("SELECT Username from abbankDB.Users");
        
        while(result.next()){
            
            String user = result.getString(1);
            
            if(user.startsWith(friendString) && !(user.equals(username))){
                
                peopleArrayList.add(user);
                
            }
          
            
        }
        
        String[] people = peopleArrayList.toArray(String[]::new);
        
        return people;
        
    }
    

    public static String[] getFriendRequestList(String username) throws SQLException{
        
        ArrayList<String> friendRequestArrayList = new ArrayList<>();
        
        ResultSet result = DB.query("Select Username from abbankDB.Users,FriendRequests Where (abbankDB.FriendRequests.UserID = abbankDB.Users.UserID) AND abbankDB.FriendRequests.FriendID = 1");
        
        while(result.next()){
            
            String individualFriendRequest = result.getString(1);
            friendRequestArrayList.add(individualFriendRequest);
            
        }
        
        String[] incomingFriendRequest = friendRequestArrayList.toArray(String[]::new);
        
        return incomingFriendRequest;
        
    }
    
    public static boolean sendFriendRequest(String username, String friend) throws SQLException{
        
        int userID = UserManager.getUserID(username);
        
        int friendID = UserManager.getUserID(friend);
        
        ResultSet result = DB.query("select count(*) from abbankDB.FriendRequests Where FriendID = " + friendID + "");
        
        result.next();
        
        int friendRequestCount = result.getInt(1);
        
        result = DB.query("select count(*) from abbankDB.Friends Where FriendID = " + friendID + "");
        
        result.next();
        
        int friendCount = result.getInt(1);
        
        if(friendRequestCount == 0 && friendCount == 0){
            
            DB.update("Insert into abbankDB.FriendRequests Values(" + userID + " , " + friendID + ")");
        
            return true;
        
        }
        
        return false;
        
        
    }
    
    //take out jlist
    public static void acceptFriendRequest(String userName, String friendName) throws SQLException{
      
        int userID = UserManager.getUserID(userName);
        
        int friendID = UserManager.getUserID(friendName);
        
        DB.update("Delete from abbankDB.FriendRequests Where UserID = " + userID + " And FriendID = " + friendID + "");
        
        DB.update("Delete from abbankDB.FriendRequests Where UserID = " + friendID + " And FriendID = " + userID + "");
        
        DB.update("Update abbankDB.Friends Set UserID = " + userID + " , FriendID = " + friendID);
        
        DB.update("Update abbankDB.Friends Set UserID = " + friendID + " , FriendID = " + userID);
        
    }
    
    public static void blockFriend(String username,String friend) throws SQLException{
        
        int userID = UserManager.getUserID(username);
        
        int friendID = UserManager.getUserID(friend);
        
        DB.update("Insert into abbankDB.BlockedFriends Values(" + userID + " , " + friendID + " , now())");
    
    }
    
    public static void unblockFriend(String username,String friend )throws SQLException{
        
        int userID = UserManager.getUserID(username);
        
        int friendID = UserManager.getUserID(friend);
        
        DB.update("Delete from abbankDB.BlockedFriends Where UserID = " + userID + " And Where FriendID " + friendID + "");

    }
    
    public static boolean isBlocked(int userID, int friendID) throws SQLException{
        
        ResultSet result = DB.query("Select count(*) from abbankDB.BlockedFriends Where UserID = " + userID + " And FriendID = " + friendID + "");
        
        result.next();
        
        int count = result.getInt(1);
        
        return count == 1;
        
    }
    
    public static Date getBlockedDate(int userID,int friendID) throws SQLException{
        
        ResultSet result = DB.query("Select time from abbankDB.BlockedFriends Where UserID = " + userID + " And FriendID = " + friendID + "");
        
        result.next();
        
        Date time = result.getDate(1);
        
        return time;
    }
    
    public static void removeFriend(String username, String friend) throws SQLException{
        
        String table = username + "_fm";
        
        DB.update("Delete from abbankDB." + table + " Where Friends = '" + friend + "'");
        
        table = friend + "_fm";
        
        DB.update("Delete from abbankDB." + table + " Where Friends = '" + username + "'");
        
    }
    
        public static String getUsernameFromFriend(String username,int index) throws SQLException{
        
        String table = username + "_fm";
        
        ResultSet result = DB.query("Select Friends from abbankDB." + table + "");
        
        for(int i = 0; i < index  + 1;i++){
            
            result.next();
            
        }
        
        String friendUsername = result.getString(1);
        
        return friendUsername;
        
    }
}
