package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

	public void insertNames(String first, String last) throws Exception
	{
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","hibernate_test","hibernate_test");
		PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO names (first, last) VALUES " +"('"+first+"','"+last+"');");
		stmt.executeUpdate();
	}
}
