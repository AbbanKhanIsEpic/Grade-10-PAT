/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abban
 */
public class MessageVisualManager {
    
    public static void updateTextFont(String username, String textFont) throws SQLException{
        
        DB.update("Update abbankDB.userSettings Set MesaageTextFont = '" + textFont + "' Where Username = '" + username + "'");
        
    }
    
    public static void updateTextSize(String username, int textSize) throws SQLException{
        
        DB.update("Update abbankDB.userSettings Set MessageTextSize = " + textSize + " Where Username = '" + username + "'");
        
    }
    
        public static String getTextFont(String username) throws SQLException{
        
        ResultSet result = DB.query("Select MessageTextFont From abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        String textFont = result.getString(1);
        
        return textFont;
        
    }
    
    public static int getTextSize(String username) throws SQLException{
        
        ResultSet result = DB.query("Select MessageTextSize From abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        int textSize = result.getInt(1);
        
        return textSize;
        
    }
    
}
