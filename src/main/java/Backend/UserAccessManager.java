/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/*

This class focus on user control. This will be:
When login, the project will check if the user has entered the username and password correcly
When login, the project will check if the user said yes or no to remember them for 30 days
When at Welcome Screen, the program will check if the ip-address has an account that wanted the program to remember them
When at RegisterScreen, the program will check if the user entered a username that has not exsit 
When at RegisterScreen, the program will check if the user entered something that will be restricted like if the username is too long
This program also check if the user wants to delete their account
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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
	public static void query(String stmt) throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, pass);

		PreparedStatement statement = conn.prepareStatement(stmt);
		ResultSet resultSet = statement.executeQuery();

		statement.close();
	}
        public static void main(String[] args) {
		UserAccessManager dm = new UserAccessManager();
		try {
			//dm.update("INSERT INTO books VALUES(1334, 'Hills have eyes','Peter Peterson', 2, 2.75)");

			dm.query("SELECT * FROM books");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
