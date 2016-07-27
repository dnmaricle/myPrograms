package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Query extends JFrame {

	private JFrame frame;
	private JTextField txtName;
	private JComboBox classPeriod;
	// TODO: Draw password from database instead of hardcoding this in
	private String password = "george";
	private int sel = 0;
	private JPasswordField txtPassword;
	public static String studentID = "";
	public static String name = "";
	private JTextField txtStudentID;
	private JButton btnTakeTest;
	public static Query myQuery = new Query();
	
	/**
	 * Launch the application.
	 */
	/*
	 * Purpose: Give a user an absolute value test, and grade the user's answers
	 * and record grades in a centralized excel document. PseudoCode: Inquiry of
	 * the user their name, student ID, class period, and for the password. If
	 * correct password, launch into one of four tests. If not correct password,
	 * display dialog box asking for correct password.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myQuery.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Query() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 498, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel(
				"<html><span align=center>Absolute Value Quiz</span></html> ");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(-10, 0, 482, 60);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 49));
		frame.getContentPane().add(lblTitle);

		JLabel lblName = new JLabel("<html><b>Name:</b>");
		lblName.setBounds(65, 85, 48, 35);
		lblName.setBackground(new Color(240, 240, 240));
		frame.getContentPane().add(lblName);

		JLabel lblClassPeriod = new JLabel("<html><b>Class Period:</b>");
		lblClassPeriod.setBounds(25, 167, 86, 35);
		frame.getContentPane().add(lblClassPeriod);
		// Drop down menu for the class periods.
		String[] timeStrings = { "8 O'Clock", "9 O'Clock", "10 O'Clock",
				"11 O'Clock", "12 O'Clock", "1 O'Clock", "2 O'Clock",
				"3 O'Clock", "4 O'Clock", "5 O'Clock" };

		JComboBox classPeriod = new JComboBox(timeStrings);
		classPeriod.setBounds(107, 174, 86, 20);
		frame.getContentPane().add(classPeriod);
		classPeriod.setSelectedIndex(1);

		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// put key event here!

				char c = e.getKeyChar();

				// Allow spaces please!
				if (e.getKeyChar() == KeyEvent.VK_SPACE) {
					txtName.setText(txtName.getText() + " ");
				}
				if (((c == '0' || c <= '9'))
						|| ((txtName.getText().length() >= 25))
						|| ((c == KeyEvent.VK_BACK_SPACE)
								|| (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD))) {
					e.consume();
				}
			}
		});
		txtName.setBounds(107, 92, 126, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		btnTakeTest = new JButton("<html><b>Take Test</b>");
		btnTakeTest.setBounds(25, 284, 195, 35);
		btnTakeTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Checking if password is correct.
				if (txtPassword.getText().equals(password)) {
					if (txtName.getText().length() == 0) {
						JOptionPane.showMessageDialog(null,
								"Please enter your name.");
					} else if (txtStudentID.getText().length() == 0) {
						JOptionPane.showMessageDialog(null,
								"Please enter your Student ID");
					} else {
						// Setting the values of name and student ID
						name = txtName.getText();
						studentID = txtStudentID.getText();
						// Setting the test screen visible
						TestScreen test = new TestScreen(sel);
						test.frame.setVisible(true);
						test.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						//test.frame.setAlwaysOnTop(true);

						//Getting rid of the query window
						myQuery.dispose();
						frame.dispose();
					}
				} else {
					JOptionPane
							.showMessageDialog(null,
									"Password is incorrect. Please enter in correct password.");
				}
			}
		});

		frame.getContentPane().add(btnTakeTest);

		JButton btnCancel = new JButton("<html><b>Cancel</b>");
		btnCancel.setBounds(313, 290, 159, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnCancel);

		JLabel lblPassword = new JLabel("<html><b> Password: </b>");
		lblPassword.setBounds(41, 220, 72, 14);
		frame.getContentPane().add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(107, 217, 126, 20);
		frame.getContentPane().add(txtPassword);

		JLabel lblStudentID = new JLabel("<html><b>Student ID:</b>");
		lblStudentID.setBounds(35, 131, 72, 25);
		frame.getContentPane().add(lblStudentID);

		txtStudentID = new JTextField();
		txtStudentID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((!(c == '0' || c <= '9'))
						|| ((txtStudentID.getText().length() >= 10))
						|| ((c == KeyEvent.VK_BACK_SPACE)
								|| (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD))) {
					e.consume();
				}
			}
		});
		txtStudentID.setBounds(107, 131, 126, 20);
		frame.getContentPane().add(txtStudentID);
		txtStudentID.setColumns(10);
		//Defaulting enter button to clicking the "select" button
		frame.getRootPane().setDefaultButton(btnTakeTest);
	}
}
