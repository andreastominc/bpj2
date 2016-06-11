

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PersonImpl_GUI {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonImpl_GUI window = new PersonImpl_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PersonImpl_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblFirstName = new JLabel("First Name:");
		panel.add(lblFirstName);
		
		txtFirstName = new JTextField();
		panel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		panel.add(lblLastName);
		
		//------------ Save Button ----------------------------------------------
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstname = txtFirstName.getText();
				String lastname = txtLastName.getText();
				try {
					insertNewPerson(firstname, lastname);					
					clearTb();
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		
		//------------ Exit Button ----------------------------------------------
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		
		txtLastName = new JTextField();
		panel.add(txtLastName);
		txtLastName.setColumns(10);
		
		panel.add(btnExit);
		panel.add(btnSave);
	}
	
	private void clearTb()
	{
		txtFirstName.setText("");
		txtLastName.setText("");
	}
	
	private static void insertNewPerson (String firstname, String lastname) throws Exception
	{
		System.out.println("-------------------------");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Pers person = new Pers();
		person.setFirst(firstname);
		person.setLast(lastname);

		session.save(person);
		session.flush();
		session.getTransaction().commit();
		session.close();
        
        System.out.println("-------------------------");
        
	}
	
	
}
