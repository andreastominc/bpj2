package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gui {

	private JFrame frame;
	private JTextField txtTbtest;
	private JTextField txtTbtest_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
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
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblTest = new JLabel("Vorname");
		panel.add(lblTest);
		
		txtTbtest = new JTextField();
		txtTbtest.setText("");
		panel.add(txtTbtest);
		txtTbtest.setColumns(10);
		
		JLabel lblTest_1 = new JLabel("Nachname");
		panel.add(lblTest_1);
		
		txtTbtest_1 = new JTextField();
		txtTbtest_1.setText("");
		panel.add(txtTbtest_1);
		txtTbtest_1.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String first = txtTbtest.getText();
				String last = txtTbtest_1.getText();
				test t = new test();
				try {
					t.insertNames(first, last);
					clearTb();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTb();
			}
		});
		panel.add(btnClear);
	}
	
	private void clearTb()
	{
		txtTbtest.setText("");
		txtTbtest_1.setText("");
	}

}
