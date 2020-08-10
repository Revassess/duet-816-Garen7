package com.revature.config;

import org.postgresql.Driver;

import java.sql.*;

/**
 * 
 * @author Revature
 *
 *         This is a paceholder class to hold the configurations of your db
 *         connection. You should change the url, username, and password. DO NOT
 *         CHANGE THE MODIFIERS OR THE NAMES OF THE VARIABLES. These are used to
 *         test your db schema.
 */
public class ConnectionUtil {
	//for singleton instance
	private static ConnectionUtil cu;
	
	// add your jdbc url
	public static final String URL = "jdbc:postgresql://event-staff-manager.cnjiicotuaxa.us-east-1.rds.amazonaws.com:5432/postgres";
	// add your jdbc username
	public static final String USERNAME = "trevor_serpas";
	// add your jdbc password
	public static final String PASSWORD = "password2007";
	// name of the created stored procedure in tier 3
	public static final String TIER_3_PROCEDURE_NAME = "";
	// name of the created sequence in tier 3
	public static final String TIER_3_SEQUENCE_NAME = "answer2";

	// implement this method to connect to the db and return the connection object
	public Connection connect(){
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}


	//implement this method with a callable statement that calls the absolute value sql function
	public long callAbsoluteValueFunction(long value){
		try {
			CallableStatement cs = connect().prepareCall("{call public.abscaller(?)}");
			cs.setLong(1, value);
			ResultSet rs = cs.executeQuery();
			if(rs.next())
				return rs.getInt(1);
			else
				return 1/0;
		}
		catch (SQLException e){
			e.printStackTrace();
			return 1/0;
		}
	}
	

	//make the class into a singleton
	private ConnectionUtil(){
		super();
		try {
			DriverManager.registerDriver(new Driver());
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public static ConnectionUtil getInstance(){
		if(cu == null){
			cu = new ConnectionUtil();
		}
		return cu;
	}
}
