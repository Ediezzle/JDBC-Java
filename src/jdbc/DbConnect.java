package jdbc;

import java.sql.*;

public class DbConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// url points to jdbc protocol : mysql subprotocol; localhost is the address
		// of the server where we installed our DBMS (i.e. on local machine) and
		// 3306 is the port on which we need to contact our DBMS
		String url = "jdbc:mysql://localhost:3306/";
		// we are connecting to the addressBook database we created earlier
		String database = "addressBook";
		// we login as "root" user with password "mysql123"
		String userName = "root";
		String password = "";
		
		//try-with-resources
		try 
		(
				Connection connection = DriverManager.getConnection
				(url + database, userName, password)
		)
		
		{
			System.out.println("Database connection: Successful");
			//no need to call connection.close() on Connection, Statement, and 
			//ResultSet in a finally block since we used try-with-resources
		} 
		
		catch (Exception e) 
		{
			System.out.println("Database connection: Failed");
			e.printStackTrace();
		}

	}

}
