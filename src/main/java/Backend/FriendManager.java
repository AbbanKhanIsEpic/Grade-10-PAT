/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author abban
 */
public class FriendManager {

    public static String[] getFriends(String table) throws SQLException{
            
            table = table + "_fm";
            
            ResultSet result = DB.query("SELECT count(*) FROM abbankDB."+table+";");
            
            result.next();
            
            int length = result.getInt(1);
            
            result = DB.query("SELECT Friends FROM abbankDB."+table+";");
            
            String[] listOfFriends = new String[length];
            
            for(int i = 0; i < length; i++){
                
                result.next();
                listOfFriends[i] = result.getString(1);
                
            }

        return listOfFriends;

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
    
    public static boolean sendFriendRequest(String from, String to) throws SQLException{
        
        String table = from + "_fm";
        
        ResultSet result = DB.query("Select count(*) from abbankDB." + table + " Where Friends = '" + to +"'");
        
        result.next();
        
        int count1 = result.getInt(1);
        
        result = DB.query("Select count(*) from abbankDB.friendRquest Where fromWho = '" + from + "' AND '" + to + "'" );
        
        result.next();
        
        int count2 = result.getInt(1);
        
        if(count1 == 0 && count2 == 0){
            
        result = DB.query("select count(*) from abbankDB.friendRquest");
        
        result.next();
        
        int id = result.getInt(1) + 1;
        
        
        
        DB.update("Insert into abbankDB.friendRquest Values(" + id + ", '" + from + "', '" + to + "')");
        
        return true;
        
        }
        
        return false;
        
        
    }
    
    public static void acceptFriendRequest(String from, String to,JList jList) throws SQLException{
        
        DB.update("DELETE FROM abbankDB.friendRquest WHERE fromWho = '" + from + "' AND toWho = '" + to + "';");
        DB.update("DELETE FROM abbankDB.friendRquest WHERE fromWho = '" + to + "' AND toWho = '" + from + "';");
        
        String tableFrom = from + "_fm";
        String tableTo = to + "_fm";
        
        DB.update("INSERT INTO abbankDB." + tableFrom + " Values('" + to + "',0,'');");
        DB.update("INSERT INTO abbankDB." + tableTo + " Values('" + from + "',0,'');");
        
        DefaultListModel DefaultListModel = FriendManager.getReceivingFriendRequest(from);
        
        jList.setModel(DefaultListModel);
        
    }
    public static void blockFriend(String username,String to) throws SQLException{
        
        String table = username + "_fm";
        
        DB.update("Update abbankDB." + table + " Set FriendsBlockOrNot = 1 Where Friends = '" + to +"'");
    
    }
    
    public static void unblockFriend(String username,String to) throws SQLException{
        
        String table = username + "_fm";
        
        DB.update("Update abbankDB." + table + " Set FriendsBlockOrNot = 0 Where Friends = '" + to +"'");

    }
    
    public static boolean isFriendBlock(String username, String to) throws SQLException{
        
        String table = username + "_fm";
        
        ResultSet result = DB.query("Select FriendsBlockOrNot from abbankDB." + table + " Where Friends = '" + to + "'");
        
        result.next();
        
        int block = result.getInt(1);
        
        return block == 1;
    }
    
    public static void removeFriend(String from, String to) throws SQLException{
        
        String table = from + "_fm";
        
        DB.update("Delete from abbankDB." + table + " Where Friends = '" + to + "'");
        
        table = to + "_fm";
        
        DB.update("Delete from abbankDB." + table + " Where Friends = '" + from + "'");
        
    }
}
