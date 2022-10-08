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
    
        public static boolean isLoginValid(String username, String password) throws SQLException{
            
            ResultSet user = DB.query("SELECT COUNT(*) FROM abbankDB.Users WHERE Username = '" + username +"' AND Password = '" + password +"';");
            user.next();
            int count = user.getInt(1);
            return count==1;
        }   
        
        public static String isUsernameValid(String username){
            String result = "Everything looks alright";
            
            //Checking the length of the inputted username
            //This check if username is not blank
            if(username.length() <= 0){
                result = "Username can not be blank";
                
            }
            //This check if the Username is too long
            else if(username.length() >= 100){
                result = "Username is too long";
            }
            
            else if(username.equals("null")){
                result = "Username can't be null";
            }
            
            //This check if the username is unique
            try {
                ResultSet unique = DB.query("SELECT count(*) FROM abbankDB.Users WHERE Username = '"+username+"';");
                unique.next();
                int uniqueInt = unique.getInt(1);
                
                if(uniqueInt == 1){
                     result = "This username alright exists";
                     return result;
                
            }
            } catch (SQLException ex) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //This check if the username is only letters and numbers
            for(int i = 0; i < username.length(); i++){
               if(!(Character.isDigit(username.charAt(i))|| Character.isLetter(username.charAt(i)))){
                   result = "Username can only be letter or digits";
               }
               
            }
          
            return result;
        }
        
    public static String isPasswordSafe(String password,String username){
            String result = "Everything looks alright";
            
            //This check the length
            if(password.length() <= 8){
                result = "Password too short (More than 8 character)";
                return result;
            }
            else if(password.length() >= 200){
                result = "Password too long (200 limit)";
                return result;
            }
            boolean check = false;
            for(int i = 0; i < password.length(); i++){
                if(Character.isUpperCase(password.charAt(i))){
                    check = true;
                }
            }
            if(!(check)){
                result = "Password must contain a capital letter";
                return result;
            }
            check = false;
            for(int i = 0; i < password.length(); i++){
                if(Character.isLowerCase(password.charAt(i))){
                    check = true;
                }
            }
            if(!(check)){
                result = "Password must contain a lowercase letter";
                return result;
            }
            check = false;
            for(int i = 0; i < password.length(); i++){
                if(Character.isDigit(password.charAt(i))){
                    check = true;
                }
            }
            if(!(check)){
                result = "Password must contain numbers";
            }
            check = false;
            for(int i = 0; i < password.length(); i++){
                if(!(Character.isDigit(password.charAt(i)))&&!(Character.isLetter(password.charAt(i)))){
                    check = true;
                }
            }
            if(!(check)){
                result = "Password must contain special character like #";
            }
            if(password.equals(username)){
                result = "Password may not be the same as username";
                return result;
            }
                    
            return result;
        }
    
    public static void createAccount(String username, String password) throws SQLException{
        
        DB.update("Insert Into abbankDB.Users(Username,DisplayName,Password,DateCreated,ProfileIcon,FirstColourSideMenuBackground,LastColourSideMenuBackground,FirstColourTextingScreenBackground,LastColourTextingScreenBackground,FirstColourProfileScreenBackground,LastColourProfileScreenBackground,BioTextFont,BioTextSize,MessageTextFont,MessageTextSize) Values('" + username + "' , '" + username + "' , '" + password + "' , now(), 1 , '#1CB5E0' , '#1CB5E0' , '#90EE90' , '#90EE90' , '#1CB5E0', '#1CB5E0' , 'Dialog' , 11 , 'Dialog' , 11)");
          
    }

    //remove
    public static String[] getConnectedAccount(String username) throws SQLException {
        String[] account;
        
        ResultSet result = DB.query("Select ConnectAccount1,ConnectAccount2,ConnectAccount3 from abbankDB.Users where Username = '" + username + "';");
        
        int length = 1;
        
        result.next();
        
        for(int i = 1; i <= 3; i++){
            
            String accountAdded = result.getString(i);
            
            if(accountAdded != null){
                length++;
            }
        }
        
        account = new String[length];
        
        account[0] = username;
        
        for(int i = 1; i <= 3; i++){
            
            String accountAdded = result.getString(i);
            
            if(accountAdded != null){
                
                account[i] = accountAdded;
                
            }
        }
      
                                
        return account;
    }
    
    public static String isDisplayNameValid(String displayName){
        
        String result = "Everything is alright";
        
        if(displayName.length() > 200){
            
            result = "Display name is too long";
            
        }
        else if(displayName.isEmpty()){
            
            result = "Display name can't be empty";
            
        }
        else if(displayName.isBlank()){
            
            result = "Display name can't be blank";
            
        }
        
        return result;
        
    }
    
    public static void updateDisplayName(String username, String displayName) throws SQLException{
        
        DB.update("Update abbankDB.Users Set DisplayName = '" + displayName + "' Where Username = '" + username + "'");
        
    }
    
    public static String getDisplayName(String username) throws SQLException{
        
        ResultSet result = DB.query("Select DisplayName from abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        String displayName = result.getString(1);
        
        return displayName;
        
    }
    
    public static void addConnectedAccount(String username,String addAccount) throws SQLException{
        
        ResultSet result = DB.query("Select ConnectAccount1 from abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        String account1 = result.getString(1);
        
        if(account1 == null){
            
            DB.update("Update abbankDB.Users set ConnectAccount1 = '" + username + "' where Username = '"+ addAccount + "'");
            
            DB.update("Update abbankDB.Users set ConnectAccount1 = '" + addAccount + "' where Username = '"+ username + "'");
            
        }
        else{
            
            result = DB.query("Select ConnectAccount2 from abbankDB.Users Where Username = '" + username + "'");
        
            result.next();
        
            String account2 = result.getString(1);
            
            if(account2 == null){
                
                DB.update("Update abbankDB.Users set ConnectAccount2 = '" + username + "' where Username = '"+ addAccount + "'");
            
                DB.update("Update abbankDB.Users set ConnectAccount2 = '" + addAccount + "' where Username = '"+ username + "'");
                
            }
            else{
                
                DB.update("Update abbankDB.Users set ConnectAccount3 = '" + username + "' where Username = '"+ addAccount + "'");
            
                DB.update("Update abbankDB.Users set ConnectAccount3 = '" + addAccount + "' where Username = '"+ username + "'");
                
            }
            
        }
        
    }
    
    //remove
    public static void removeConnectedAccount(String username,String removeAccount,int accountnum) throws SQLException{
        
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
    
    public static boolean isAccountConnected(String username,String addAccount) throws SQLException{
        
        ResultSet result = DB.query("select count(*) from abbankDB.Users Where Username = '" + username + "' And (ConnectAccount1 = '" + addAccount + "' or ConnectAccount2 = '" + addAccount + "' or ConnectAccount3 = '" + addAccount + "')");
        
        result.next();
        
        int resultInt = result.getInt(1);
        
        return resultInt != 0;
        
    }
    
    public static int getUserID(String username) throws SQLException{
        
        ResultSet result = DB.query("Select UserID from abbankDB.Users Where Username = '" + username + "'");
        
        result.next();
        
        int userID = result.getInt(1);
        
        return userID;
        
    }
    
}
