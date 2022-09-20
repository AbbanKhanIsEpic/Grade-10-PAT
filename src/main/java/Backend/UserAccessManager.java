/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abban
 */
public class UserAccessManager {
    //Most of the code comes from https://github.com/cliftonbartholomew/SchoolPracticalsGr10/blob/master/src/main/java/SQL/DatabaseManager.java
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://102.130.115.69:3306/abbankDB";
    private static final String user = "abbank";
    private static final String pass = "Reddam2021";
    
   	//INSERT, UPDATE or DELETE
	public static void update(String update) throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, pass);

		PreparedStatement statement = conn.prepareStatement(update);
		statement.executeUpdate();
		statement.close();
	}

	//SELECT
	public static int countQuery(String stmt) throws SQLException {
                int count = 0;
		Connection conn = DriverManager.getConnection(url, user, pass);

		PreparedStatement statement = conn.prepareStatement(stmt);
               
		ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                    count = resultSet.getInt("count(*)");
                }
               return count;
	}
        public static int countRequest(String query) throws SQLException {
                int result = countQuery(query);
                return result;
       
        }
        public static void createAccount(String username,String password){
        try {
            String query = "Insert into abbankDB.TableOfUsers(Username,User_password,DisplayName,AccountCreated,IPAdress) Values ('"+username+"','"+password+"', '"+username+"',current_date(),null);";
            update(query);
            String table_name = username + "_msg";
            query = " CREATE TABLE `" + table_name + "` ( \n" + 
                    "`Friends` varchar(60) NOT NULL,\n " + 
                    "`FriendsBlockOrNot` int(1) DEFAULT NULL,\n" + 
                    "`FriendMessages` longtext NOT NULL,\n" + 
                    "`GroupName` varchar(200) NOT NULL,\n" + 
                    "`GroupList` varchar(200) NOT NULL,\n" + 
                    " `GroupBlockOrNot` int(1) DEFAULT NULL,\n" + 
                    " `GroupMessages` longtext NOT NULL,\n" +
                    " PRIMARY KEY (`Friends`)\n" +
                    " ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
            
            update(query);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserAccessManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        public static String isUsernameAllowed(String username) {
            String result = "Everything looks alright";
            
            //Checking the length of the inputted username
            //This check if username is not blank
            if(username.length() <= 4){
                result = "Username can not be blank";
                
            }
            //This check if the Username is too long
            //In MySQL, table max length is 64 and need some space for the tags
            else if(username.length() >= 45){
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
}
