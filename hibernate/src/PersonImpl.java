

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("connections.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		Pers person = new Pers();
		person.setId(3);
		person.setFirst("Philipp");
		person.setLast("Hierzerer");
		
		s.save(person);
		s.flush();
		tx.commit();
		
		System.out.println("Test queryPerson:");
		queryPerson(s);
		
		s.close();
	}
	

	/**
	 * Methode zum Abfragen und Ausgeben aller Personen.
	 * Zur Info:
	 * wenn man via Hibernate HQL Query auf die DB abfragen will, 
	 * dann muss man den Namen vom Type in der Query angeben, also "Pers",
	 * und NICHT den Namen der DB-Tabelle ("person"). Dieses Mapping ist eh in
	 * der Datei "mapping.hbm.xml" definiert.
	 * 
	 * @param session
	 */
	private static void queryPerson(Session session) {
		System.out.println("-------------------------");
		List <Pers> list = (List<Pers>) session.createQuery("from Pers").list();
        
        java.util.Iterator<Pers> iter = list.iterator();
        while (iter.hasNext()) {
        	Pers person = iter.next();
        	System.out.println("Person: \"" + person.getFirst() +
                          "\", " + person.getLast() +
                          "\", " + person.getId());
        }
        session.getTransaction().commit();
        System.out.println("-------------------------");
	}


}
