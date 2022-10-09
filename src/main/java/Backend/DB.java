/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abban
 */
//This class commicate with mySQL database
public class DB {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://102.130.115.69:3306/abbankDB";
    private static final String user = "abbank";
    private static final String pass = "Reddam2021";

    //This code from 23 to the last line of code is repurposed from MrB's github 
    
    //This method purpose is to insert, update or delete values in mySQL Table
    //This method's input is query to the database
    public static void update(String update) throws SQLException {
        
        Connection conn = DriverManager.getConnection(url, user, pass);

        PreparedStatement statement = conn.prepareStatement(update);
        
	statement.executeUpdate();
        
	statement.close();
                
    }

        
    //Purpose of this method is to select something from mySQL Table
    //This method's input is query to the database
    //This method returns the result(ResultSet) from the database 
    public static ResultSet query(String stmt) throws SQLException {
            
	    Connection conn = DriverManager.getConnection(url, user, pass);

	    PreparedStatement statement = conn.prepareStatement(stmt);
                
	    ResultSet resultSet = statement.executeQuery();
                
            return resultSet;
            
	}
}
