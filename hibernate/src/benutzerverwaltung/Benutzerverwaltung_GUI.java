package benutzerverwaltung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;


import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Benutzerverwaltung_GUI {

	private JFrame frame;
	private JTextField txtTxtusername;
	private JPasswordField pwdTxtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Benutzerverwaltung_GUI window = new Benutzerverwaltung_GUI();
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
	public Benutzerverwaltung_GUI() {
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
		
		JLabel lblUsername = new JLabel("Username:");
		panel.add(lblUsername);
		
		txtTxtusername = new JTextField();
		panel.add(txtTxtusername);
		txtTxtusername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		panel.add(lblPassword);
		
		pwdTxtpassword = new JPasswordField();
		panel.add(pwdTxtpassword);
		
		//------------ Save Button ----------------------------------------------
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtusername = txtTxtusername.getText();
				String txtpassword = new String(pwdTxtpassword.getPassword());
				BenWorker t = new BenWorker();
				try {
					t.insertNewUser(txtusername, txtpassword);
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
		
		panel.add(btnExit);
		panel.add(btnSave);
	}
	
	private void clearTb()
	{
		txtTxtusername.setText("");
		pwdTxtpassword.setText("");
	}

}
