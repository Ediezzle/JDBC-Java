package jdbc;

import java.sql.*;

public class DbQuery 
{

	public static void main(String[] args) 
	{
		// Get connection, execute query, get the result set
		// and print the entries from the result rest
		//try-with-resources eliminates the need to explicitly call connection.close()
		//on Connection, Statement, and 
		//ResultSet in a finally block since we used try-with-resources
		try (
				Connection connection = DbConnector.connectToDb();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM contact")
			)
		{
			System.out.println("ID \tfName \tlName \temail \t\tphoneNo");
			while (resultSet.next()) 
			{
				System.out.println(resultSet.getInt("id") + "\t"
				+ resultSet.getString("firstName") + "\t"
				+ resultSet.getString("lastName") + "\t"
				+ resultSet.getString("email") + "\t"
				+ resultSet.getString("phoneNo"));
				
				/* OR
				 * System.out.println(resultSet.getInt(1) + "\t"
				+ resultSet.getString(2) + "\t"
				+ resultSet.getString(3) + "\t"
				+ resultSet.getString(4) + "\t"
				+ resultSet.getString(5));*/
			}
		}

		catch (SQLException sqle) 
		{
			sqle.printStackTrace();
		}
	}
	
}
