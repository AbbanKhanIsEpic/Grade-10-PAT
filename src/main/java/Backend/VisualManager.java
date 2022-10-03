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
public class VisualManager {
    
    public static void updateSideMenuBackground(String username,String colour1, String colour2) throws SQLException{
        
        DB.update("Update abbankDB.userSettings Set FistColourSideMenu = '" + colour1 + "' Where Username = '" + username + "'");
        
        DB.update("Update abbankDB.userSettings Set LastColourSideMenu = '" + colour2 + "' Where Username = '" + username + "'");
        
    }
    
    public static void updateTextingBackground(String username,String colour1, String colour2) throws SQLException{
        
        DB.update("Update abbankDB.userSettings Set FistColourTextingArea = '" + colour1 + "' Where Username = '" + username + "'");
        
        DB.update("Update abbankDB.userSettings Set LastColourTextingArea = '" + colour2 + "' Where Username = '" + username + "'");
        
    }
    
    public static void updateProfileBackground(String username,String colour1, String colour2) throws SQLException{
        
        DB.update("Update abbankDB.userSettings Set FistColourProfileMenu = '" + colour1 + "' Where Username = '" + username + "'");
        
        DB.update("Update abbankDB.userSettings Set LastColourProfileMenu = '" + colour2 + "' Where Username = '" + username + "'");
        
    }
    
    public static String getFirstColourSideMenuBackground(String username) throws SQLException{
        
        ResultSet result = DB.query("Select FistColourSideMenu from abbankDB.userSettings Where Username = '" + username + "'");
        
        result.next();
        
        String colour = result.getString(1);
        
        return colour;
    
    }
    
    public static String getLastColourSideMenuBackground(String username) throws SQLException{
        
        ResultSet result = DB.query("Select LastColourSideMenu from abbankDB.userSettings Where Username = '" + username + "'");
        
        result.next();
        
        String colour = result.getString(1);
        
        return colour;
    
    }
    
    public static String getFirstColourTextingBackground(String username) throws SQLException{
        
        ResultSet result = DB.query("Select FistColourTextingArea from abbankDB.userSettings Where Username = '" + username + "'");
        
        result.next();
        
        String colour = result.getString(1);
        
        return colour;
        
    }
    
    public static String getLastColourTextingBackground(String username) throws SQLException{
        
        ResultSet result = DB.query("Select LastColourTextingArea from abbankDB.userSettings Where Username = '" + username + "'");
        
        result.next();
        
        String colour = result.getString(1);
        
        return colour;
        
    }
    
    public static String getFirstColourProfileBackground(String username) throws SQLException{
        
        ResultSet result = DB.query("Select FistColourProfileMenu from abbankDB.userSettings Where Username = '" + username + "'");
        
        result.next();
        
        String colour = result.getString(1);
        
        return colour;
        
    }
    
    public static String getLastColourProfileBackground(String username) throws SQLException{
        
        ResultSet result = DB.query("Select FistColourProfileMenu from abbankDB.userSettings Where Username = '" + username + "'");
        
        result.next();
        
        String colour = result.getString(1);
        
        return colour;
        
    }
}
