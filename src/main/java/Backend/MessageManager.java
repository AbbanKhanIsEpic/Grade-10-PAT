/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author abban
 */
public class MessageManager {
    
    public static String sendMessage(String from, String to, String message) throws SQLException{

        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = formatTime.format(LocalTime.now());
        String date = LocalDate.now().toString();
        
        message = "\n" + "< " + date + " | " + time + " > " + from + ": " + message;
        
        DB.update("UPDATE abbankDB." + to + "SET FriendMessages = " + message + "WHERE Friends = " + from);
        DB.update("UPDATE abbankDB." + from + "SET FriendMessages = " + message + "WHERE Friends = " + to);
        
        return message;
        
    }
}
