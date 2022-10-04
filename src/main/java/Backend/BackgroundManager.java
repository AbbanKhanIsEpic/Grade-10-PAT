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
public class BackgroundManager {
    
    public static void updateSideMenuBackground(String username,String colour1, String colour2) throws SQLException{
        
        DB.update("Update abbankDB.Users Set FirstColourSideMenuBackground = '" + colour1 + "' Where Username = '" + username + "'");
        
        DB.update("Update abbankDB.Users Set LastColourSideMenuBackground = '" + colour2 + "' Where Username = '" + username + "'");
        
    }
    
    public static void updateTextingBackground(String username,String colour1, String colour2) throws SQLException{
        
        DB.update("Update abbankDB.Users Set FirstColourTextingScreenBackground = '" + colour1 + "' Where Username = '" + username + "'");
        
        DB.update("Update abbankDB.Users Set LastColourTextingScreenBackground = '" + colour2 + "' Where Username = '" + username + "'");
        
    }
    
    public static void updateProfileBackground(String username,String colour1, String colour2) throws SQLException{
        
        DB.update("Update abbankDB.Users Set FirstColourProfileScreenBackground = '" + colour1 + "' Where Username = '" + username + "'");
        
        DB.update("Update abbankDB.Users Set LastColourProfileScreenBackground = '" + colour2 + "' Where Username = '" + username + "'");
        
    }
    
    public static String getFirstColourSideMenuBackground(String username) throws SQLException{
        
        ResultSet result = DB.query("Select FirstColourSideMenuBackground from abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        String colour = result.getString(1);
        
        return colour;
    
    }
    
    public static String getLastColourSideMenuBackground(String username) throws SQLException{
        
        ResultSet result = DB.query("Select LastColourSideMenuBackground from abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        String colour = result.getString(1);
        
        return colour;
    
    }
    
    public static String getFirstColourTextingBackground(String username) throws SQLException{
        
        ResultSet result = DB.query("Select FirstColourTextingScreenBackground from abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        String colour = result.getString(1);
        
        return colour;
        
    }
    
    public static String getLastColourTextingBackground(String username) throws SQLException{
        
        ResultSet result = DB.query("Select LastColourTextingScreenBackground from abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        String colour = result.getString(1);
        
        return colour;
        
    }
    
    public static String getFirstColourProfileBackground(String username) throws SQLException{
        
        ResultSet result = DB.query("Select FirstColourProfileScreenBackground from abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        String colour = result.getString(1);
        
        return colour;
        
    }
    
    public static String getLastColourProfileBackground(String username) throws SQLException{
        
        ResultSet result = DB.query("Select LastColourProfileScreenBackground from abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        String colour = result.getString(1);
        
        return colour;
        
    }
}
