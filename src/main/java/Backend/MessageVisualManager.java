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
//This method changes the appearance of messages
public class MessageVisualManager  {

   //Method changes the messages' text font
   //Inputs are user's username and the text font
    public static void updateTextFont(String username, String textFont) throws SQLException {

        //Updates the text font
        DB.update("Update abbankDB.userSettings Set MesaageTextFont = '" + textFont + "' Where Username = '" + username + "'");

    }

    //Method changes the messages' text size
    //Inputs are user's username and the text size
    public static void updateTextSize(String username, int textSize) throws SQLException {

        DB.update("Update abbankDB.userSettings Set MessageTextSize = " + textSize + " Where Username = '" + username + "'");

    }

    //Method returns user's message text font
    //Method input is username
    public static String getTextFont(String username ) throws SQLException {

        //Query to get user's message text font
        ResultSet mySQLGetTextFontResult = DB.query("Select MessageTextFont From abbankDB.Users Where Username = '" + username + "'");

        mySQLGetTextFontResult.next();

        //Get the text font
        String textFont = mySQLGetTextFontResult.getString(1);

        //Return text font
        return textFont;

    }

    //Method returns user's message text size
    //Method input is username
    public static int getTextSize(String username) throws SQLException {

        //Query to get user's message text size
        ResultSet mySQLGetTextSizeResult = DB.query("Select MessageTextSize From abbankDB.Users Where Username = '" + username + "'"); 

        mySQLGetTextSizeResult.next();

        //Get text size
        int textSize = mySQLGetTextSizeResult.getInt(1);

        //Return text size
        return textSize;

    }

}
