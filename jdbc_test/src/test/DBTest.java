package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

public class DBTest {

	
	public static void main(String[] args) {
		DBTest t = new DBTest();
		System.out.println("Test1");
		try {
			t.insertNames3("hansi","huber");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test2");
	}
	

	/**
	 * hab eine online gratis mysql datenbank angelegt bei db4free.net.
	 * diese methode fuegt einen datensatz zur tabelle person hinzu.
	 * fuer die db-verbindung werden die zugangsdaten aus dem db.properties file ausgelesen.
	 * 
	 * @param first
	 * @param last
	 * @throws Exception
	 */
	public void insertNames3(String first, String last) throws Exception
	{
		Connection conn = null;
	    try {
	      // get connection to database
	      conn = getConnection();
	      System.out.println("conn=" + conn);
	      
	      if (conn != null){
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("INSERT INTO person (first, last) VALUES " +"('"+first+"','"+last+"');");
			stmt.executeUpdate();
	      } else {
	    	 System.out.println(" unable to create connection");
	      }

	    } catch (Exception e) {
	      // handle the exception
	      e.printStackTrace();
	      System.exit(1);
	    } finally {
	      // release database resources
	      try {
	        conn.close();
	      } catch (Exception ignore) {
	      }
	    }
	}
	

	/**
	 * Auslesen der Zugangsdaten aus der Datei db.properties zum Aufbauen einer Verbindung zur Datenbank.
	 * Wegen Security sollte man die Zugangsdaten immer auslagern.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Properties loadPropertiesFile() throws Exception {		
		Properties prop = new Properties();
		InputStream in = new FileInputStream("db.properties");
		prop.load(in);
		in.close();
		return prop;
	}
	
	/**
	 * Aufbauen einer Connection zur DB.
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		Properties prop = loadPropertiesFile();

		String driverClass = prop.getProperty("MYSQLJDBC.driver");
		String url = prop.getProperty("MYSQLJDBC.url");
		String username = prop.getProperty("MYSQLJDBC.username");
		String password = prop.getProperty("MYSQLJDBC.password");

		Class.forName(driverClass);
	    Connection conn = (Connection) DriverManager.getConnection(url, username,password);
	    return conn;
	  }


}
