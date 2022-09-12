/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import static Backend.UserAccessManager.countQuery;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abban
 */
public class TextFieldManager {
        public static String isUsernameAllowed(String username) {
            String result = "Everything looks alright";
            
            //Checking the length of the inputted username
            //This check if username is not blank
            if(username.length() <= 4){
                result = "Username can not be blank";
                
            }
            //This check if the Username is too long
            //In MySQL, table max length is 64 (14 character for the tags)
            else if(username.length() >= 50){
                result = "Username is too long";
            }
            
            //This check if the username is unique
            try {
                int unique = countQuery("SELECT count(*) FROM abbankDB.TableOfUsers WHERE Username = '"+username+"';");
                if(unique == 1){
                     result = "This username alright exists";
                     return result;
                
            }
            } catch (SQLException ex) {
                Logger.getLogger(TextFieldManager.class.getName()).log(Level.SEVERE, null, ex);
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
}
