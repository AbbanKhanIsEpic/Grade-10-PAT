/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abban
 */
public class ProfileManager {
    
    public static void updateProfileIcon(String username, int iconNumber) throws SQLException{
        
        DB.update("Update abbankDB.Users Set ProfileIcon = " + iconNumber + " Where Username = '" + username + "'");
        
    }
    
    public static void updateBio(String username,String bio) throws SQLException{
        
        DB.update("Update abbankDB.Users Set Bio = '" + bio + "' Where Username = '" + username + "'");
        
    }
    
    public static void updateTextFont(String username,String textFont) throws SQLException{
        
        DB.update("Update abbankDB.Users Set BioTextFont = '" + textFont + "' Where Username = '" + username + "'");
        
    }
    
    public static void updateTextSize(String username, int textSize) throws SQLException{
        
        DB.update("Update abbankDB.Users Set BioTextSize = " + textSize + " Where Username = '" + username + "'");
        
    }
    
    public static String getTextFont(String username) throws SQLException{
        
        ResultSet result = DB.query("Select BioTextFont From abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        String textFont = result.getString(1);
        
        return textFont;
        
    }
    
    public static int getTextSize(String username) throws SQLException{
        
        ResultSet result = DB.query("Select BioTextSize From abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        int textSize = result.getInt(1);
        
        return textSize;
        
    }
    
    public static String getBio(String username) throws SQLException{
        
        ResultSet result = DB.query("Select Bio From abbankDB.Users Where Username = '" + username + "'");
        
        result.next();

        
        String bio = result.getString(1);
        
        return bio;
        
        
    }
    
    public static int getProfileIcon(String username) throws SQLException{
        
        ResultSet mySQLresult = DB.query("Select ProfileIcon from abbankDB.Users where Username = '" + username + "'");
        
        mySQLresult.next();
        
        int profileIcon = mySQLresult.getInt(1);
        
        return profileIcon;
        
    }
    
    public static Date getAccountCreated(String username) throws SQLException{
        
        ResultSet mySQLresult = DB.query("Select DateCreated from abbankDB.Users where Username = '" + username + "'");
        
        mySQLresult.next();
        
        Date dateCreated = mySQLresult.getDate(1);
        
        return dateCreated;
        
    }
}