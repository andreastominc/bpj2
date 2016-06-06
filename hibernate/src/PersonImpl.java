

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
		person.setLast("Hierzer");
		
		s.save(person);
		s.flush();
		tx.commit();
	}

}
