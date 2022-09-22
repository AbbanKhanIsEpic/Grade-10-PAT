/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;


import com.mysql.cj.protocol.Resultset;
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
                Logger.getLogger(UserAccessManager.class.getName()).log(Level.SEVERE, null, ex);
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
       DB.update("INSERT INTO abbankDB.TableOfUsers Values('"+username+"','"+password+"','"+username+"',current_date(),null);");
       //msg is short for Messages
       String table = username + "_msg";
       
       DB.update(" CREATE TABLE `" + table + "` ( \n" + 
                    "`Friends` varchar(60) NOT NULL,\n " + 
                    "`FriendsBlockOrNot` int(1) DEFAULT NULL,\n" + 
                    "`FriendMessages` longtext NOT NULL,\n" + 
                    "`GroupName` varchar(200) NOT NULL,\n" + 
                    "`GroupMemember1` varchar(60) NOT NULL,\n" + 
                    "`GroupMemember2` varchar(60) NOT NULL,\n" + 
                    "`GroupMemember3` varchar(60) NOT NULL,\n" + 
                    "`GroupMemember4` varchar(200) NOT NULL,\n" +
                    "`GroupMemember5` varchar(200) NOT NULL,\n" + 
                    " `GroupBlockOrNot` int(1) DEFAULT NULL,\n" + 
                    " `GroupMessages` longtext NOT NULL,\n" +
                    " PRIMARY KEY (`Friends`)\n" +
                    " ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci");
       
       //Set is short for setting
       table = username + "_set";
       DB.update(" CREATE TABLE `" + table + "` ( \n" + 
                    "`ProfileIcon` int(1) NOT NULL,\n " + 
                    "`Autobiography` varchar(255) DEFAULT NULL,\n" + 
                    "`Account1` varchar(60) NOT NULL,\n" + 
                    "`Account2` varchar(60) NOT NULL,\n" + 
                    "`Account3` varchar(60) NOT NULL,\n" + 
                    "`FistColourSideMenu` varchar(7) NOT NULL,\n" +
                    "`LastColourSideMenu` varchar(7) NOT NULL,\n" + 
                    "`FistColourTextingArea` varchar(7) NOT NULL,\n" +
                    "`LastColourTextingArea` varchar(7) NOT NULL,\n" +
                    "`FistColourProfileMenu` varchar(7) NOT NULL,\n" +
                    "`LastColourProfileMenu` varchar(7) NOT NULL,\n" + 
                    " `GroupBlockOrNot` int(1) DEFAULT NULL,\n" + 
                    " `GroupMessages` longtext NOT NULL,\n" +
                    " PRIMARY KEY (`Friends`)\n" +
                    " ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci");
       
       
    }
}
