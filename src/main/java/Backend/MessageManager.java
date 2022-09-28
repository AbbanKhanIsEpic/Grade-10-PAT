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
    
    
}
