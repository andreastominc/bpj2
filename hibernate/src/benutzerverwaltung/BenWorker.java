package benutzerverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BenWorker {
	
	public void insertNewUser(String txtusername, String txtpassword) throws Exception
	{																				// ACHTUNG: hier ggf. auf Port 3306 anpassen bei euch !!!!
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/hibernate_test","hibernate_test","hibernate_test");
		PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO benutzer (benutzername, passwort) VALUES " +"('"+txtusername+"','"+txtpassword+"');");
		stmt.executeUpdate();
	}

	// to do .... auf Hibernate umbauen.
	
}
