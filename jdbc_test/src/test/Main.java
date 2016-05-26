package test;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","ato2","ato2");
		PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from names;");
		ResultSet result = stmt.executeQuery();
		
		while(result.next())
		{
			System.out.println(result.getString(1)+ " "+result.getString(2));
		}
	}

}
