/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;


import java.net.Inet4Address;
import java.net.UnknownHostException;
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
            
            ResultSet user = DB.query("SELECT COUNT(*) FROM TableOfUsers WHERE Username = '" + username +"' AND Password = '" + password +"';");
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
            //In MySQL, table max length is 64 and need some space for creating the type of table for user
            else if(username.length() >= 45){
                result = "Username is too long";
            }
            
            else if(username.equals("null")){
                result = "Username can't be null";
            }
            
            //This check if the username is unique
            try {
                ResultSet unique = DB.query("SELECT count(*) FROM abbankDB.TableOfUsers WHERE Username = '"+username+"';");
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
            else if(password.length() >= 100){
                result = "Password too long (Less than 100 character)";
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
       DB.update("INSERT INTO abbankDB.TableOfUsers Values('"+username+"','"+password+"','"+username+"',current_date());");
       
       DB.update("INSERT INTO abbankDB.userSettings Values('"+ username + "',1,null,null,null,null,'#1CB5E0','#000046','#90EE90','FA8C05','#1CB5E0','#000046','Dialog',11,'Dialog',11);");
       //msg is short for friend messages
       String table = username + "_fm";
       
       DB.update(" CREATE TABLE `" + table + "` ( \n" + 
                    "`Friends` varchar(60) NOT NULL,\n " + 
                    "`FriendsBlockOrNot` int(1) DEFAULT NULL,\n" + 
                    "`FriendMessages` longtext NOT NULL,\n" + 
                    " PRIMARY KEY (`Friends`)\n" +
                    " ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci");
       //msg is short for group messages
       
       table = username + "_gm";
  
       DB.update(" CREATE TABLE `" + table + "` ( \n" +
                    "`GroupName` varchar(200) NOT NULL,\n" + 
                    "`GroupMemember1` varchar(60) NOT NULL,\n" + 
                    "`GroupMemember2` varchar(60) NOT NULL,\n" + 
                    "`GroupMemember3` varchar(60) NOT NULL,\n" + 
                    "`GroupMemember4` varchar(200) NOT NULL,\n" +
                    "`GroupMemember5` varchar(200) NOT NULL,\n" + 
                    "`GroupBlockOrNot` int(1) DEFAULT NULL,\n" + 
                    "`GroupMessages` longtext NOT NULL,\n" +
                    " PRIMARY KEY (`GroupName`)\n" +
                    " ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci");
          
    }

    public static String[] getConnectedAccount(String username) throws SQLException {
        String[] account;
        
        ResultSet result = DB.query("Select Account1,Account2,Account3 from abbankDB.userSettings where Username = '" + username + "';");
        
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
        
        DB.update("Update abbankDB.TableOfUsers Set DisplayName = '" + displayName + "' Where Username = '" + username + "'");
        
    }
    
    public static String getDisplayName(String username) throws SQLException{
        
        ResultSet result = DB.query("Select DisplayName from abbankDB.TableOfUsers Where Username = '" + username + "'");
        
        result.next();
        
        String displayName = result.getString(1);
        
        return displayName;
        
    }
    
    
    public static void addConnectedAccount(String username,String addAccount) throws SQLException{
        
        ResultSet result = DB.query("Select Account1 from abbankDB.userSettings Where Username = '" + username + "'");
        
        result.next();
        
        String account1 = result.getString(1);
        
        if(account1 == null){
            
            DB.update("Update abbankDB.userSettings set Account1 = '" + username + "' where Username = '"+ addAccount + "'");
            
            DB.update("Update abbankDB.userSettings set Account1 = '" + addAccount + "' where Username = '"+ username + "'");
            
        }
        else{
            
            result = DB.query("Select Account2 from abbankDB.userSettings Where Username = '" + username + "'");
        
            result.next();
        
            String account2 = result.getString(1);
            
            if(account2 == null){
                
                DB.update("Update abbankDB.userSettings set Account2 = '" + username + "' where Username = '"+ addAccount + "'");
            
                DB.update("Update abbankDB.userSettings set Account2 = '" + addAccount + "' where Username = '"+ username + "'");
                
                result = DB.query("select Account1 from abbankDB.userSettings Where Username = '" + username + "'");
                
                result.next();
                
                String member = result.getString(1);
                
                DB.update("Update abbankDB.userSettings set Account1 = '" + member + "' where Username = '"+ addAccount + "'");
                
                DB.update("Update abbankDB.userSettings set Account2 = '" + addAccount + "' where Username = '"+ member + "'");
                
            }
            else{
                
                DB.update("Update abbankDB.userSettings set Account3 = '" + username + "' where Username = '"+ addAccount + "'");
            
                DB.update("Update abbankDB.userSettings set Account3 = '" + addAccount + "' where Username = '"+ username + "'");
                
                result = DB.query("select Account1 from abbankDB.userSettings Where Username = '" + username + "'");
                
                result.next();
                
                String member = result.getString(1);
                
                DB.update("Update abbankDB.userSettings set Account1 = '" + member + "' where Username = '"+ addAccount + "'");
                
                DB.update("Update abbankDB.userSettings set Account3 = '" + addAccount + "' where Username = '"+ member + "'");
                
                result = DB.query("select Account2 from abbankDB.userSettings Where Username = '" + username + "'");
                
                result.next();
                
                member = result.getString(1);
                
                DB.update("Update abbankDB.userSettings set Account2 = '" + member + "' where Username = '"+ addAccount + "'");
                
                DB.update("Update abbankDB.userSettings set Account3 = '" + addAccount + "' where Username = '"+ member + "'");
                
            }
            
        }
        
    }
    
    public static void removeConnectedAccount(String username,String removeAccount,int accountnum) throws SQLException{
        
        if(accountnum == 1){
            
            DB.update("Update abbankDB.userSettings Set Account1 = null Where Username = '" + username + "'");
            
            DB.update("Update abbankDB.userSettings Set Account1 = null Where Username = '" + removeAccount + "'");
            
        }
        else if(accountnum == 2){
            
            DB.update("Update abbankDB.userSettings Set Account2 = null Where Username = '" + username + "'");
            
            DB.update("Update abbankDB.userSettings Set Account2 = null Where Username = '" + removeAccount + "'");
            
        }
        else{
            
            DB.update("Update abbankDB.userSettings Set Account3 = null Where Username = '" + username + "'");
            
            DB.update("Update abbankDB.userSettings Set Account3 = null Where Username = '" + removeAccount + "'");
            
        }
        
    }
    
    public static boolean isAccountConnected(String username,String addAccount) throws SQLException{
        
        ResultSet result = DB.query("select count(*) from abbankDB.userSettings Where Username = '" + username + "' And Account1 = '" + addAccount + "' or Account2 = 'Testing3' or Account3 = 'Testing3'");
        
        result.next();
        
        int resultInt = result.getInt(1);
        
        return resultInt != 0;
        
    }
    
}
