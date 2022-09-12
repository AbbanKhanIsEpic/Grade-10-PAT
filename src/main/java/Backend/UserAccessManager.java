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
        String displayName = username;
        username = username + "main";
        try {
            String query = "Insert into abbankDB.TableOfUsers(Username,User_password,DisplayName,AccountCreated) Values ('"+username+"','"+password+"', '"+displayName+"',current_date());";
            update(query);
            String table_name = displayName + "_msg";
            query = " CREATE TABLE `" + table_name + "` ( \n" + 
                    "`Friends` varchar(60) NOT NULL,\n " + 
                    "`FriendsBlockOrNot` int(1) DEFAULT NULL,\n" + 
                    "`FriendMessages` longtext Not Null,\n" + 
                    "`GroupName` varchar(200) NOT NULL,\n" + 
                    " `GroupList` varchar(200) NOT NULL,\n" + 
                    " `GroupBlockOrNot` int(1) DEFAULT NULL,\n" + 
                    " `GroupMessages` longtext Not Null,\n" +
                    " PRIMARY KEY (`Friends`)\n" +
                    " ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
            
            update(query);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserAccessManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
