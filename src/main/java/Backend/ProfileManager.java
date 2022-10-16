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
//Method is controls the profile screen
public class ProfileManager  {

    //Method save user's profile icon
    //Inputs are user's username and the selected profile icon
    public static void updateProfileIcon(String username, int iconNumber) throws SQLException {

        //Save the profile icon
        DB.update("Update abbankDB.Users Set ProfileIcon = " + iconNumber + " Where Username = '" + username + "'");

    }

    //Method save user's bio
    //Inputs are user's username and bio
    public static void updateBio(String username, String bio) throws SQLException {

        //Save the bio
        DB.update("Update abbankDB.Users Set Bio = '" + bio + "' Where Username = '" + username + "'");

    }

    //Method saves user's bio text font
    //Inputs are user's username and the text font
    public static void updateTextFont(String username, String textFont) throws SQLException {

        //Save the bio's text font
        DB.update("Update abbankDB.Users Set BioTextFont = '" + textFont + "' Where Username = '" + username + "'");

    }

    //Method saves the user's bio text size
    //Inputs are the user's username and tex size
    public static void updateTextSize(String username, int textSize) throws SQLException {

        //Save the bio's text size
        DB.update("Update abbankDB.Users Set BioTextSize = " + textSize + " Where Username = '" + username + "'");

    }

    //Method returns user bio's text font
    //Method returns string
    public static String getTextFont(String username) throws SQLException {

        //Query to get text font
        ResultSet mySQLGetTextFontResult = DB.query("Select BioTextFont From abbankDB.Users Where Username = '" + username + "'");

        mySQLGetTextFontResult.next();

        //Get text font
        String textFont = mySQLGetTextFontResult.getString(1);

        //Return text font
        return textFont;

    }

    //Method returns user bio's text size
    //Input is user's username
    //Return int
    public static int getTextSize(String username) throws SQLException {

        //Query to get user bio's text size
        ResultSet mySQLGetTextSizeResult = DB.query("Select BioTextSize From abbankDB.Users Where Username = '" + username + "'");

        mySQLGetTextSizeResult.next();

        //Get text size as int
        int textSize = mySQLGetTextSizeResult.getInt(1);

        //return int
        return textSize;

    }

    //Method returns user bio
    //Input is username
    //Method return a multiline string
    public static String getBio(String username) throws SQLException {

        //Query to get bio
        ResultSet mySQLGetBioResult = DB.query("Select Bio From abbankDB.Users Where Username = '" + username + "'");

        mySQLGetBioResult.next();

        //Get bio as String
        String bio = mySQLGetBioResult.getString(1);

        //Return bio
        return bio;

    }

    //Method returns user's profile icon
    //Input is username
    //Returns int
    public static int getProfileIcon(String username) throws SQLException {

        //Query to get user's profile icon
        ResultSet mySQLGetProfileIconresult = DB.query("Select ProfileIcon from abbankDB.Users where Username = '" + username + "'");

        mySQLGetProfileIconresult.next();

        //Get profile icon as int
        int profileIcon = mySQLGetProfileIconresult.getInt(1);

        //Return int
        return profileIcon;

    }

    //Method returns when the user created account
    //Method input is user's username
    //Method return date
    public static Date getAccountCreated(String username) throws SQLException {

        //Query to get when the user created their accout
        ResultSet mySQLGetAccountCreatedResult = DB.query("Select DateCreated from abbankDB.Users where Username = '" + username + "'");

        mySQLGetAccountCreatedResult.next();

        //Get result as date
        Date accountCreatedDate = mySQLGetAccountCreatedResult.getDate(1);

        //Return date
        return accountCreatedDate;

    }
}
