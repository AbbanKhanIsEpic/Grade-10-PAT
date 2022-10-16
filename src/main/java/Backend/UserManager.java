/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abban
 */
public class UserManager {

    //Method checks if the user has enter the login details correctly
    //Inputs are the entered username and password
    public static boolean isLoginValid(String username, String password) throws SQLException {

        //Query to check of the details are correct
        ResultSet mySQLIsLoginValidResult = DB.query("SELECT COUNT(*) FROM abbankDB.Users WHERE Username = '" + username + "' AND Password = '" + password + "';");
        
        mySQLIsLoginValidResult.next();
        
        //Cont query to int
        int count = mySQLIsLoginValidResult.getInt(1);
        
        //return int
        // 1 is true
        // 0 is false
        return count == 1;
    }

    //Method checks if the username entered is aright
    //Input is entered username
    //Output is String, what the user has to fix
    public static String isUsernameValid(String username) {
        String result = "Everything looks alright";

        //Checking the length of the inputted username
        //This check if username is not blank
        if (username.length() <= 0) {
            result = "Username can not be blank";

        } //This check if the Username is too long
        else if (username.length() >= 100) {
            result = "Username is too long";
        } else if (username.equals("null")) {
            result = "Username can't be null";
        }

        //This check if the username is unique
        try {
            ResultSet mySQLIsUsernameUnique = DB.query("SELECT count(*) FROM abbankDB.Users WHERE Username = '" + username + "';");
            mySQLIsUsernameUnique.next();
            int uniqueInt = mySQLIsUsernameUnique.getInt(1);

            if (uniqueInt == 1) {
                result = "This username alright exists";
                return result;

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        //This check if the username is only letters and numbers
        for (int i = 0; i < username.length(); i++) {
            if (!(Character.isDigit(username.charAt(i)) || Character.isLetter(username.charAt(i)))) {
                result = "Username can only be letter or digits";
            }

        }

        return result;
    }

    //Method checks if password entered is safe
    //Inputs are entered password and username
    //Output is string, what the user has to fix
    public static String isPasswordSafe(String password, String username) {
        String result = "Everything looks alright";

        //This check the length
        if (password.length() <= 8) {
            result = "Password too short (More than 8 character)";
            return result;
        } else if (password.length() >= 200) {
            result = "Password too long (200 limit)";
            return result;
        }
        
        boolean check = false;
        
        //Check if the password contains upper case letters
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                check = true;
            }
        }
        
        if (!(check)) {
            result = "Password must contain a capital letter";
            return result;
        }
        
        check = false;
        
        //Check if password contains lower case letters
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                check = true;
            }
        }
        
        if (!(check)) {
            result = "Password must contain a lowercase letter";
            return result;
        }
        
        check = false;
        
        //Check if password contains numbers
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                check = true;
            }
        }
        
        if (!(check)) {
            result = "Password must contain numbers";
        }
        
        check = false;
        
        //Check if password contains special characters
        for (int i = 0; i < password.length(); i++) {
            if (!(Character.isDigit(password.charAt(i))) && !(Character.isLetter(password.charAt(i)))) {
                check = true;
            }
        }
        
        if (!(check)) {
            result = "Password must contain special character like #";
        }
        
        if (password.equals(username)) {
            result = "Password may not be the same as username";
            return result;
        }

        //Return result
        return result;
    }

    //Method creates the account
    //Method inputs are username and password
    public static void createAccount(String username, String password) throws SQLException {

        DB.update("Insert Into abbankDB.Users(Username,DisplayName,Password,DateCreated,ProfileIcon,FirstColourSideMenuBackground,LastColourSideMenuBackground,FirstColourTextingScreenBackground,LastColourTextingScreenBackground,FirstColourProfileScreenBackground,LastColourProfileScreenBackground,BioTextFont,BioTextSize,MessageTextFont,MessageTextSize) Values('" + username + "' , '" + username + "' , '" + password + "' , now(), 1 , '#1CB5E0' , '#1CB5E0' , '#90EE90' , '#90EE90' , '#1CB5E0', '#1CB5E0' , 'Dialog' , 11 , 'Dialog' , 11)");

    }

    //Method returns the account/s connected to the user
    //Inputs is username
    //Output is string array
    public static String[] getConnectedAccount(String username) throws SQLException {
        //Max number of connected account is 3
        String[] account;
        
        //Query to get the connected accounts
        ResultSet mySQLGetConnectedAccountResult = DB.query("Select ConnectAccount1,ConnectAccount2,ConnectAccount3 from abbankDB.Users where Username = '" + username + "';");

        int length = 1;

        mySQLGetConnectedAccountResult.next();

        //For loop to get the number of connected account
        for (int i = 1; i <= 3; i++) {

            String accountAdded = mySQLGetConnectedAccountResult.getString(i);

            if (accountAdded != null) {
                length++;
            }
        }

        account = new String[length];

        account[0] = username;

        //Add connected account/s
        for (int i = 1; i <= 3; i++) {

            String accountAdded = mySQLGetConnectedAccountResult.getString(i);

            if (accountAdded != null) {

                account[i] = accountAdded;

            }
        }

        //Return string array
        return account;
    }

    //Method checks if user's display name is alright
    //Inputs is username
    //Output is string, tell what the user has to fix
    public static String isDisplayNameValid(String displayName) {

        String result = "Everything is alright";

        //Check length
        if (displayName.length() > 200) {

            result = "Display name is too long";

        } 
        else if (displayName.isEmpty()) {

            result = "Display name can't be empty";

        } 
        else if (displayName.isBlank()) {

            result = "Display name can't be blank";

        }

        //Return result
        return result;

    }

    //Method updates user's display name
    //Inputs are username and display name
    public static void updateDisplayName(String username, String displayName) throws SQLException {

        DB.update("Update abbankDB.Users Set DisplayName = '" + displayName + "' Where Username = '" + username + "'");

    }

    //Method returns user's display name
    //Input is username
    public static String getDisplayName(String username) throws SQLException {

        ResultSet mySQLGetDisplayNameResult = DB.query("Select DisplayName from abbankDB.Users Where Username = '" + username + "'");

        mySQLGetDisplayNameResult.next();

        String displayName = mySQLGetDisplayNameResult.getString(1);

        return displayName;

    }

    //Connect account to user 
    //inputs are username and the account to connect
    public static void addConnectedAccount(String username, String addAccount) throws SQLException {

        ResultSet mySQLGetConnectAccountResult = DB.query("Select ConnectAccount1 from abbankDB.Users Where Username = '" + username + "'");

        mySQLGetConnectAccountResult.next();

        String account1 = mySQLGetConnectAccountResult.getString(1);

        //If connect account 1 is empthy, fill it
        if (account1 == null) {

            DB.update("Update abbankDB.Users set ConnectAccount1 = '" + username + "' where Username = '" + addAccount + "'");

            DB.update("Update abbankDB.Users set ConnectAccount1 = '" + addAccount + "' where Username = '" + username + "'");

        } 
        else {

            mySQLGetConnectAccountResult = DB.query("Select ConnectAccount2 from abbankDB.Users Where Username = '" + username + "'");

            mySQLGetConnectAccountResult.next();

            String account2 = mySQLGetConnectAccountResult.getString(1);

            //If connect account 2 is empthy, fill it
            if (account2 == null) {

                DB.update("Update abbankDB.Users set ConnectAccount2 = '" + username + "' where Username = '" + addAccount + "'");

                DB.update("Update abbankDB.Users set ConnectAccount2 = '" + addAccount + "' where Username = '" + username + "'");

            } else {

                DB.update("Update abbankDB.Users set ConnectAccount3 = '" + username + "' where Username = '" + addAccount + "'");

                DB.update("Update abbankDB.Users set ConnectAccount3 = '" + addAccount + "' where Username = '" + username + "'");

            }

        }

    }

    //Remove conncted account
    //inputs are username, account to remove, index of jList
    public static void removeConnectedAccount(String username, String removeAccount, int accountnum) throws SQLException {

        switch (accountnum) {

            case 1 -> {

                DB.update("Update abbankDB.Users Set ConnectAccount1 = null Where Username = '" + username + "'");
                DB.update("Update abbankDB.Users Set ConnectAccount1 = null Where Username = '" + removeAccount + "'");

            }

            case 2 -> {

                DB.update("Update abbankDB.Users Set ConnectAccount2 = null Where Username = '" + username + "'");
                DB.update("Update abbankDB.Users Set ConnectAccount2 = null Where Username = '" + removeAccount + "'");

            }

            default -> {

                DB.update("Update abbankDB.Users Set ConnectAccount3 = null Where Username = '" + username + "'");
                DB.update("Update abbankDB.Users Set ConnectAccount3 = null Where Username = '" + removeAccount + "'");

            }
        }

    }

    //Check if user has already conncted to this account
    //Inputs are username and another account
    public static boolean isAccountConnected(String username, String addAccount) throws SQLException {

        //Query to check if user has conncected
        ResultSet mySQLIsAccountConnectedResult = DB.query("select count(*) from abbankDB.Users Where Username = '" + username + "' And (ConnectAccount1 = '" + addAccount + "' or ConnectAccount2 = '" + addAccount + "' or ConnectAccount3 = '" + addAccount + "')");

        mySQLIsAccountConnectedResult.next();

        int resultInt = mySQLIsAccountConnectedResult.getInt(1);

        //return result
        return resultInt != 0;

    }

    //Get userID from username
    //Return int
    //UserID is used in all table
    public static int getUserID(String username) throws SQLException {

        ResultSet result = DB.query("Select UserID from abbankDB.Users Where Username = '" + username + "'");

        result.next();

        int userID = result.getInt(1);

        return userID;

    }

}
