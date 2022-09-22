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

/**
 *
 * @author abban
 */
public class DB {
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
	public static ResultSet query(String stmt) throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, pass);

		PreparedStatement statement = conn.prepareStatement(stmt);
		ResultSet resultSet = statement.executeQuery();
                
                return resultSet;
	}
}
