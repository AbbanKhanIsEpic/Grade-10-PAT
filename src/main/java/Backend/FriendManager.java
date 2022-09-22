/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

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
}
