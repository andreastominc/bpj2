package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

	public void insertNames(String first, String last) throws Exception
	{																				// ACHTUNG: hier ggf. auf Port 3306 anpassen bei euch !!!!
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/hibernate_test","hibernate_test","hibernate_test");
		PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO person (first, last) VALUES " +"('"+first+"','"+last+"');");
		stmt.executeUpdate();
	}
}
