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
    
    public static String getFriendMessages(String from,String to) throws SQLException{
        
        String table = from + "_fm";
        ResultSet result = DB.query("Select FriendMessages from abbankDB." + table + " Where Friends = '" + to + "'");
        
        result.next();
        
        String returnString = result.getString(1);
        
        return returnString;
        
    }
    
    public static String sendFriendMessage(String from, String to, String sendmessage,String messageFromTextArea) throws SQLException{

        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = formatTime.format(LocalTime.now());
        String date = LocalDate.now().toString();
        
        
        String sendMessage =  messageFromTextArea + "\n" + "< " + date + " | " + time + " > " + from + ": " + sendmessage;
        
        String table = to + "_fm";
        DB.update("UPDATE abbankDB." + table + " SET FriendMessages = '" + sendMessage + "' WHERE Friends = '" + from + "'");
        
        table = from + "_fm";
        DB.update("UPDATE abbankDB." + table + " SET FriendMessages = '" + sendMessage + "' WHERE Friends = '" + to + "'");
        
        return sendMessage;
        
    }
    
    public static String getGroupMessages(String username, String groupName) throws SQLException{
        
        String table = username + "_gm";
        
        ResultSet result = DB.query("Select GroupMessages from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        result.next();
        
        String message = result.getString(1);
        
        return message;
    }
    
    public static String sendGroupMessages(String username, String groupName,String sendmessage,String messageFromTextArea) throws SQLException{
        
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = formatTime.format(LocalTime.now());
        String date = LocalDate.now().toString();
        
        String sendMessage =  messageFromTextArea + "< " + date + " | " + time + " > " + username + ": " + sendmessage + "\n" ;
        
        String table = username + "_gm";
        
        ResultSet result = DB.query("Select GroupMemember1 , GroupMemember2 , GroupMemember3 , GroupMemember4 , GroupMemember5 from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        result.next();
        
        String member1 = result.getString(1);
        String member2 = result.getString(2);
        String member3 = result.getString(3);
        String member4 = result.getString(4);
        String member5 = result.getString(5);
        
        if(!(member1.equals("null"))){
            
            table = member1 + "_gm";
        
            DB.update("UPDATE abbankDB." + table + " Set GroupMessages = '" + sendMessage + "' Where GroupName = '" + groupName + "'");
            
        }
        
        if(!(member2.equals("null"))){
            
            table = member2 + "_gm";
        
            DB.update("UPDATE abbankDB." + table + " Set GroupMessages = '" + sendMessage + "' Where GroupName = '" + groupName + "'");
            
        }
        if(!(member3.equals("null"))){
            
            table = member3 + "_gm";
        
            DB.update("UPDATE abbankDB." + table + " Set GroupMessages = '" + sendMessage + "' Where GroupName = '" + groupName + "'");
            
        }
        if(!(member5.equals("null"))){
            
            table = member5 + "_gm";
        
            DB.update("UPDATE abbankDB." + table + " Set GroupMessages = '" + sendMessage + "' Where GroupName = '" + groupName + "'");
            
        }
        if(!(member4.equals("null"))){
            
            table = member4 + "_gm";
            
            DB.update("UPDATE abbankDB." + table + " Set GroupMessages = '" + sendMessage + "' Where GroupName = '" + groupName + "'");
        
        } 
        
        return sendMessage;
    }
    
    
    
    
}
