/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abban
 */
public class FriendManager {

    public static String[] getFriends(String username) throws SQLException{
            
            String table = username + "_fm";
            
            ArrayList<String> friendsArrayList = new ArrayList<>();
            
            ResultSet result = DB.query("SELECT Friends FROM abbankDB."+table+";");
            
            while(result.next()){
                
                String individualFriend = result.getString(1);
                friendsArrayList.add(individualFriend);
                
            }
            
        String[] friendList = friendsArrayList.toArray(String[]::new);
                
        return friendList;

    }
    
    //change
    public static String[] findPeople(String friendString,String username) throws SQLException{
        
        ArrayList<String> peopleArrayList = new ArrayList<>();
        
        ResultSet result = DB.query("SELECT Username from abbankDB.TableOfUsers");
        
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
        
        ResultSet result = DB.query("SELECT fromWho from abbankDB.friendRquest Where toWho = '" + username + "';");
        
        while(result.next()){
            
            String individualFriendRequest = result.getString(1);
            friendRequestArrayList.add(individualFriendRequest);
            
        }
        
        String[] incomingFriendRequest = friendRequestArrayList.toArray(String[]::new);
        
        return incomingFriendRequest;
        
    }
    
    public static boolean sendFriendRequest(String username, String friend) throws SQLException{
        
        String table = username + "_fm";
        
        ResultSet result = DB.query("Select count(*) from abbankDB." + table + " Where Friends = '" + friend +"'");
        
        result.next();
        
        int count1 = result.getInt(1);
        
        result = DB.query("Select count(*) from abbankDB.friendRquest Where fromWho = '" + username + "' AND toWho = '" + friend + "'");
        
        result.next();
        
        int count2 = result.getInt(1);
        
        if(count1 == 0 && count2 == 0){
            
            result = DB.query("select count(*) from abbankDB.friendRquest");
        
            result.next();
        
            int id = result.getInt(1) + 1;

            DB.update("Insert into abbankDB.friendRquest Values(" + id + ", '" + username + "', '" + friend + "')");
        
            return true;
        
        }
        
        return false;
        
        
    }
    
    //take out jlist
    public static void acceptFriendRequest(String user1, String user2) throws SQLException{
        
        DB.update("DELETE FROM abbankDB.friendRquest WHERE fromWho = '" + user1 + "' AND toWho = '" + user2 + "';");
        DB.update("DELETE FROM abbankDB.friendRquest WHERE fromWho = '" + user2 + "' AND toWho = '" + user1 + "';");
        
        String tableFrom = user1 + "_fm";
        String tableTo = user2 + "_fm";
        
        DB.update("INSERT INTO abbankDB." + tableFrom + " Values('" + user2 + "',0,'');");
        DB.update("INSERT INTO abbankDB." + tableTo + " Values('" + user1 + "',0,'');");
        
        
    }
    
    public static void blockFriend(String username,String friend) throws SQLException{
        
        String table = username + "_fm";
        
        DB.update("Update abbankDB." + table + " Set FriendsBlockOrNot = 1 Where Friends = '" + friend +"'");
    
    }
    
    public static void unblockFriend(String username,String friend )throws SQLException{
        
        String table = username + "_fm";
        
        DB.update("Update abbankDB." + table + " Set FriendsBlockOrNot = 0 Where Friends = '" + friend +"'");

    }
    
    public static boolean isBlocked(String username, String friend) throws SQLException{
        
        String table = username + "_fm";
        
        ResultSet result = DB.query("Select FriendsBlockOrNot from abbankDB." + table + " Where Friends = '" + friend + "'");
        
        result.next();
        
        int block = result.getInt(1);
        
        return block == 1;
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
