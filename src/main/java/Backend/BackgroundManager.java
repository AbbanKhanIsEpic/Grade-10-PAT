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
//This class handle with updating and receiving colours of backgrounds
public class BackgroundManager {

    //This method updates the user's side menu background
    //This method's inputs are username, first colour of the screen and the last colour of the screen
    public static void updateSideMenuBackground(String username, String firstColour, String lastColour) throws SQLException {
        
        //Query to update the first colour of side menu background
        DB.update("Update abbankDB.Users Set FirstColourSideMenuBackground = '" + firstColour + "' Where Username = '" + username + "'");

        //Query to  updates the last colour of side menu background
        DB.update("Update abbankDB.Users Set LastColourSideMenuBackground = '" + lastColour + "' Where Username = '" + username + "'");

    }

    //This method updates the user's texting background
    //This method's inputs are username, first colour of the screen and the last colour of the screen
    public static void updateTextingBackground(String username, String firstColour, String lastColour) throws SQLException {
        
        //Query to updates the first colour of texting background
        DB.update("Update abbankDB.Users Set FirstColourTextingScreenBackground = '" + firstColour + "' Where Username = '" + username + "'");
        
        //Query to updates the last colour of texting background
        DB.update("Update abbankDB.Users Set LastColourTextingScreenBackground = '" + lastColour + "' Where Username = '" + username + "'");

    }

    //This method updates the user's profile background
    //This method's inputs are username, first colour of the screen and the last colour of the scre
    public static void updateProfileBackground(String username, String firstColour, String lastColour) throws SQLException {
        
        //Query to updates the first colour of profile background
        DB.update("Update abbankDB.Users Set FirstColourProfileScreenBackground = '" + firstColour + "' Where Username = '" + username + "'");
        
        //Query to updates the last colour of profile background
        DB.update("Update abbankDB.Users Set LastColourProfileScreenBackground = '" + lastColour + "' Where Username = '" + username + "'");

    }

    //This method gets the first colour of the user's side menu background
    //This method returns a string
    //This method's input is username
    public static String getFirstColourSideMenuBackground(String username) throws SQLException {

        //Query to get the first colour of side menu background
        ResultSet mysqlColourBackgroundResult = DB.query("Select FirstColourSideMenuBackground from abbankDB.Users Where Username = '" + username + "'");

        mysqlColourBackgroundResult.next();
        
        //Get the colour as String
        String firstSideMenuBackgroundColour = mysqlColourBackgroundResult.getString(1);

        //Return colout
        return firstSideMenuBackgroundColour;

    }

    //This method gets the last colour of the user's side menu background
    //This method returns a string
    //This method's input a username
    public static String getLastColourSideMenuBackground(String username) throws SQLException {
        
        //Query to get the last colour of side menu background
        ResultSet mysqlSideMenuColourBackgroundResult = DB.query("Select LastColourSideMenuBackground from abbankDB.Users Where Username = '" + username + "'");

        mysqlSideMenuColourBackgroundResult.next();
        
        //Get colour as String
        String lastSideMenuBackgroundColour = mysqlSideMenuColourBackgroundResult.getString(1);
        
        //Return colour
        return lastSideMenuBackgroundColour;

    }

    //This method gets the first colour of the user's texting background
    //This method returns a string
    //This method's input is username
    public static String getFirstColourTextingBackground(String username) throws SQLException {
        
        //Query to get the first colour of texting background
        ResultSet mysqlColourTextingBackgroundResult = DB.query("Select FirstColourTextingScreenBackground from abbankDB.Users Where Username = '" + username + "'");

        mysqlColourTextingBackgroundResult.next();
        
        //Get colour as String
        String firstTextingBackgroundColour = mysqlColourTextingBackgroundResult.getString(1);
        
        //Return colour
        return firstTextingBackgroundColour;

    }

    //This method gets the last colour of the user's texting background
    //This method returns a string
    //This method's input is username
    public static String getLastColourTextingBackground(String username) throws SQLException {
        
        //Query to get the last colour of texting background
        ResultSet mysqlColourTextingBackgroundResult = DB.query("Select LastColourTextingScreenBackground from abbankDB.Users Where Username = '" + username + "'");

        mysqlColourTextingBackgroundResult.next();
        
        //Get colour as String
        String lastTextingBackgroundColour = mysqlColourTextingBackgroundResult.getString(1);
        
        //Return colour
        return lastTextingBackgroundColour;

    }

    //This method gets the first colour of user's profile screen
    //This method returns a string
    //This method's input is username
    public static String getFirstColourProfileBackground(String username) throws SQLException {
        
        //Query to get the first colour of profile background
        ResultSet mysqlColourProfileBackgroundResult = DB.query("Select FirstColourProfileScreenBackground from abbankDB.Users Where Username = '" + username + "'");

        mysqlColourProfileBackgroundResult.next();
        
        //Get colour as String
        String firstProfileBackgroundColour = mysqlColourProfileBackgroundResult.getString(1);

        //Return colour
        return firstProfileBackgroundColour;

    }

    //This method gets the last colour of the user's profile screen
    //This method returns a string
    //This method's input is username
    public static String getLastColourProfileBackground(String username) throws SQLException {

        //Query to get the last colour of profile background
        ResultSet mysqlColourProfileBackgroundResult = DB.query("Select LastColourProfileScreenBackground from abbankDB.Users Where Username = '" + username + "'");

        mysqlColourProfileBackgroundResult.next();
        
        //Get colour as String
        String lastProfileBackgroundColour = mysqlColourProfileBackgroundResult.getString(1);

        //Return colour
        return lastProfileBackgroundColour;

    }
}
