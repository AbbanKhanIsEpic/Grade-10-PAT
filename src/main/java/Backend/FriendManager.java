/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author abban
 */
public class FriendManager {
    
    public static int numberOfFriends(String table) throws SQLException{
        ResultSet numberOfFriends = DB.query("SELECT count(Friends) FROM abbankDB."+table+";");
        numberOfFriends.next();
        int numberOfFriendsInt = numberOfFriends.getInt(1);
        return numberOfFriendsInt;
    }
    
    public static String[] getFriends(String table) throws SQLException{
        
            int numberOfFriends = numberOfFriends(table);
            
            String[] friends = new String[numberOfFriends];
            
            ResultSet getFriends = DB.query("SELECT Friends FROM abbankDB."+table+";");
            
            for(int i = 0; i < numberOfFriends; i++){
                
                getFriends.next();
                String indiviulaFriends = getFriends.getString(1);
                friends[i] = indiviulaFriends;
                
            }
            
            return friends;

    }
    
    public static DefaultListModel findingToSendFriendRequest(String input,String username) throws SQLException{
        
        DefaultListModel DefaultListModel = new DefaultListModel();
        
        ResultSet result = DB.query("SELECT Username from abbankDB.TableOfUsers");
        
        int i = 0;
        while(result.next()){
            
            String user = result.getString(1);
            
            if(user.startsWith(input) && !(user.equals(username))){
                
                DefaultListModel.addElement(user);
                
            }
            else{
  
            }
            
        }
        return DefaultListModel;
        
    }
    
    public static DefaultListModel getReceivingFriendRequest(String username) throws SQLException{
        
        DefaultListModel DefaultListModel = new DefaultListModel();
        
        ResultSet result = DB.query("SELECT fromWho from abbankDB.friendRquest Where toWho = '" + username + "';");
        
        while(result.next()){
            DefaultListModel.addElement(result.getString(1));
        }
        
        return DefaultListModel;
    }
    
    public static void sendFriendRequest(String from, String to) throws SQLException{
        
        ResultSet result = DB.query("select count(*) from abbankDB.friendRquest");
        
        result.next();
        
        int id = result.getInt(1) + 1;
        
        DB.update("Insert into abbankDB.friendRquest Values(" + id + ", '" + from + "', '" + to + "')");
        
        
    }
    
    public static void acceptFriendRequest(String from, String to) throws SQLException{
        
        DB.update("DELETE FROM abbankDB.friendRquest WHERE fromWho = '" + from + "' AND toWho = '" + to + "';");
        DB.update("DELETE FROM abbankDB.friendRquest WHERE fromWho = '" + to + "' AND toWho = '" + from + "';");
        
        String tableFrom = from + "_fm";
        String tableTo = to + "_fm";
        
        DB.update("INSERT INTO abbankDB." + tableFrom + " Values('" + to + "',0,'');");
        DB.update("INSERT INTO abbankDB." + tableTo + " Values('" + from + "',0,'');");
        
    }
}
