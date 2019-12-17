

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCExample1 {

	public static void main(String[] argv) {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
		Connection connection = null;
    	Statement statement = null;
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

	

		try {
System.out.println(System.currentTimeMillis());
		/*	connection = DriverManager.getConnection(
					"jdbc:postgresql://10.135.146.68:5432/ssdp", "ssdp",
					"ssdp123");*/

		connection = DriverManager.getConnection(
		"jdbc:postgresql://10.135.146.68:5432/ssdp", "usr_ssdp",
		"ssdp123");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			try {
				String sqlQueries = "select * from auto.stages  where activityid='SSDP000036' ;";
				statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sqlQueries);
				
				ResultSetMetaData rsmd = rs.getMetaData(); 
				int columnCount = rsmd.getColumnCount();
				 
				ArrayList<String> resultList= new ArrayList<>(columnCount); 
				while (rs.next()) {
				   int i = 1;
				   while(i <= columnCount) {
					   System.out.println("*******"+rs.getString(i++));
				        resultList.add(rs.getString(i++));
				   }
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Failed to make connection!");
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		{
			
		}
	}

}