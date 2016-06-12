package afdb_package;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AFDB_Tests {

	public static void main(String[] args) {
		
		queryArten();
		
	}
	
	

	private static void queryArten() {
		System.out.println("-------------------------");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		List <AFDB_Art> list = (List<AFDB_Art>) session.createQuery("from AFDB_Art").list(); // ACHTUNG: Hier den Klassen-Namen angeben, und NICHT den Tabellen-Namen !!
        
        java.util.Iterator<AFDB_Art> iter = list.iterator();
        while (iter.hasNext()) {
        	AFDB_Art arten = iter.next();
        	System.out.println(arten.toString());
        }
        session.getTransaction().commit();
        System.out.println("-------------------------");
	}


}
