/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author abban
 */
public class MessageManager {
    
    public static String getFriendMessages(String username,String friend) throws SQLException{
        
        String table = username + "_fm";
        ResultSet result = DB.query("Select FriendMessages from abbankDB." + table + " Where Friends = '" + friend + "'");
        
        result.next();
        
        String returnString = result.getString(1);
        
        return returnString;
        
    }
    
    public static void sendFriendMessage(String username, String friend, String sendmessage) throws SQLException{

        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = formatTime.format(LocalTime.now());
        String date = LocalDate.now().toString();
        
        String sendFullMessage = "";
        
        String displayName = UserManager.getDisplayName(username);
        
        String table = friend + "_fm";
        
        if(!(FriendManager.isBlocked(friend, username))){
            
            ResultSet result = DB.query("Select FriendMessages from abbankDB." + table + " Where Friends = '" + username + "'");
            
            result.next();
            
            String message = result.getString(1);
            
            sendFullMessage =  message +  "< " + date + " | " + time + " > " + displayName + ": " + sendmessage + "\n";
            
            DB.update("UPDATE abbankDB." + table + " SET FriendMessages = '" + sendFullMessage + "' WHERE Friends = '" + username + "'");
            
        }
        
        
        
        table = username + "_fm";
        
        if(!(FriendManager.isBlocked(username, friend))){
            
            sendFullMessage = "";
            
            ResultSet result = DB.query("Select FriendMessages from abbankDB." + table + " Where Friends = '" + friend + "'");
            
            result.next();
            
            String message = result.getString(1);
            
            sendFullMessage =  message  + "< " + date + " | " + time + " > " + displayName + ": " + sendmessage + "\n";
            
            DB.update("UPDATE abbankDB." + table + " SET FriendMessages = '" + sendFullMessage + "' WHERE Friends = '" + friend + "'");
            
        }
        
        
    }
    
    public static String getGroupMessages(String username, String groupName) throws SQLException{
        
        String table = username + "_gm";
        
        ResultSet result = DB.query("Select GroupMessages from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        result.next();
        
        String message = result.getString(1);
        
        return message;
    }
    
    public static void sendGroupMessage(String username, String groupName,String sendmessage) throws SQLException{
        
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = formatTime.format(LocalTime.now());
        String date = LocalDate.now().toString();
        
        String sendFullMessage = "";
        
        String table = username + "_gm";
        
        ResultSet result = DB.query("Select GroupMemember1 , GroupMemember2 , GroupMemember3 , GroupMemember4 , GroupMemember5 from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        result.next();
        
        String member1 = result.getString(1);
        String member2 = result.getString(2);
        String member3 = result.getString(3);
        String member4 = result.getString(4);
        String member5 = result.getString(5);
        
        if(!(member1.equals("null")) && !(GroupManager.isBlocked(member1, groupName))){
            
            table = member1 + "_gm";
            
            result = DB.query("Select GroupMessages from abbankDB." + table + " Where GroupName = '" + groupName + "'");
            
            result.next();
            
            String previousMessage = result.getString(1);
            
            sendFullMessage =  previousMessage +  "< " + date + " | " + time + " > " + username + ": " + sendmessage + "\n";
        
            DB.update("UPDATE abbankDB." + table + " Set GroupMessages = '" + sendFullMessage + "' Where GroupName = '" + groupName + "'");
            
        }
        
        if(!(member2.equals("null"))){
            
            table = member2 + "_gm";
            
            sendFullMessage = "";
            
            result = DB.query("Select GroupMessages from abbankDB." + table + " Where GroupName = '" + groupName + "'");
            
            result.next();
            
            String previousMessage = result.getString(1);
            
            sendFullMessage =  previousMessage +  "< " + date + " | " + time + " > " + username + ": " + sendmessage + "\n";
        
            DB.update("UPDATE abbankDB." + table + " Set GroupMessages = '" + sendFullMessage + "' Where GroupName = '" + groupName + "'");
            
        }
        if(!(member3.equals("null"))){
            
            table = member3 + "_gm";
            
            sendFullMessage = "";
            
            result = DB.query("Select GroupMessages from abbankDB." + table + " Where GroupName = '" + groupName + "'");
            
            result.next();
            
            String previousMessage = result.getString(1);
            
            sendFullMessage =  previousMessage +  "< " + date + " | " + time + " > " + username + ": " + sendmessage + "\n";
        
            DB.update("UPDATE abbankDB." + table + " Set GroupMessages = '" + sendFullMessage + "' Where GroupName = '" + groupName + "'");
            
        }
        if(!(member5.equals("null"))){
            
            table = member5 + "_gm";
            
            sendFullMessage = "";
            
            result = DB.query("Select GroupMessages from abbankDB." + table + " Where GroupName = '" + groupName + "'");
            
            result.next();
            
            String previousMessage = result.getString(1);
            
            sendFullMessage =  previousMessage +  "< " + date + " | " + time + " > " + username + ": " + sendmessage + "\n";
        
            DB.update("UPDATE abbankDB." + table + " Set GroupMessages = '" + sendFullMessage + "' Where GroupName = '" + groupName + "'");
            
        }
        
        if(!(member4.equals("null"))){
            
            table = member4 + "_gm";
            
            sendFullMessage = "";
            
            result = DB.query("Select GroupMessages from abbankDB." + table + " Where GroupName = '" + groupName + "'");
            
            result.next();
            
            String previousMessage = result.getString(1);
            
            sendFullMessage =  previousMessage +  "< " + date + " | " + time + " > " + username + ": " + sendmessage + "\n";
            
            DB.update("UPDATE abbankDB." + table + " Set GroupMessages = '" + sendFullMessage + "' Where GroupName = '" + groupName + "'");
        
        } 
    }
    
    public static void deleteGroupMessage(String username, String groupName) throws SQLException{
        
        String table = username + "_gm";
            
        DB.update("UPDATE abbankDB." + table + " Set GroupMessages = '' Where GroupName = '" + groupName + "'");
        
    }
    
    public static void deleteFriendMessage(String username, String to) throws SQLException{
        
        String table = username + "_fm";
        
        DB.update("UPDATE abbankDB." + table + " Set FriendMessages = '' WHERE Friends = '" + to + "'");

    }
    
    public static void updateTextFont(String username, String textFont) throws SQLException{
        
        DB.update("Update abbankDB.userSettings Set MesaageTextFont = '" + textFont + "' Where Username = '" + username + "'");
        
    }
    
    public static void updateTextSize(String username, int textSize) throws SQLException{
        
        DB.update("Update abbankDB.userSettings Set MessageTextSize = " + textSize + " Where Username = '" + username + "'");
        
    }
    
        public static String getTextFont(String username) throws SQLException{
        
        ResultSet result = DB.query("Select MesaageTextFont From abbankDB.userSettings Where Username = '" + username + "'");
        
        result.next();
        
        String textFont = result.getString(1);
        
        return textFont;
        
    }
    
    public static int getTextSize(String username) throws SQLException{
        
        ResultSet result = DB.query("Select MessageTextSize From abbankDB.userSettings Where Username = '" + username + "'");
        
        result.next();
        
        int textSize = result.getInt(1);
        
        return textSize;
        
    }
    
    
    
    
    
}
