package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class SignIn {

	JFrame frame;
	//Instantiating the values for the excel spreadsheet.
		public static String studentName = "";
		public static String className = "";
		private JTextField txtName;
		private JComboBox comboBox;
		public static JRadioButton rdbtnSigningIn;
		public static JRadioButton rdbtnSigningOut;

	/**
	 * Launch the application.
	 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SignIn window = new SignIn();
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
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 878, 638);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Math Lab Sign In");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Snap ITC", Font.PLAIN, 35));
		lblTitle.setBounds(0, 0, 712, 78);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblClassName = new JLabel("Class:");
		lblClassName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClassName.setBounds(118, 281, 72, 21);
		frame.getContentPane().add(lblClassName);
		
		JButton btnSubmitChange = new JButton("Submit");
		btnSubmitChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sending the values to the bp, for sending to the excel spreadsheet.
				studentName = txtName.getText();								
				 className = (String) comboBox.getSelectedItem();
				 
				 //Checking to see if the student has entered his/her name
				 if (studentName.equals("")) {
					 JOptionPane.showMessageDialog(null, "Please enter your name!");
				 }
				 else if (!(rdbtnSigningIn.isSelected() || rdbtnSigningOut.isSelected())) {
					 JOptionPane.showMessageDialog(null, "Please indicate if you are signing in or out!");
				 }
				 else {
				 //calls the bp class that records to the excel spreadsheet.
				 bp.RecordStudent.writeFile();
				 //Declaring to user that the field has been recorded
				JOptionPane.showMessageDialog(null, "Student Recorded!");
				//Clearing the text box
					txtName.setText("");
				 }
				
			}
		});
		btnSubmitChange.setFont(new Font("Taffy", Font.BOLD, 30));
		btnSubmitChange.setBounds(175, 438, 325, 151);
		frame.getContentPane().add(btnSubmitChange);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(104, 159, 86, 21);
		frame.getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//Allot only characters, no numbers!
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
		txtName.setColumns(10);
		txtName.setBounds(200, 153, 258, 40);
		frame.getContentPane().add(txtName);
				//Allowing user to press 'enter' to record expense!
				frame.getRootPane().setDefaultButton(btnSubmitChange);
				//Creating the list of class names.
				String[] classNameList = { "Intermediate Algebra","Math Inquiry","College Algebra", "Discrete Math", "Statistics", "Trigonometry", "Calculus I", "Calculus II", "Calculus III","Linear Algebra","Prob and Stats","Complex Variables","Advance Calculus","Math Great Idea","Elem/Midd Math","General Physics", "Changing Universe", "Math Elementary/Middle School Teachers", "Math Secondary School","Number Theory","Differential Equations","Modern Algebra","College Physics","Astronomy","Geometry","Numerical Analysis", "Modern Geometry", "Other" };
				comboBox = new JComboBox(classNameList);
				comboBox.setBounds(200, 285, 265, 40);
				frame.getContentPane().add(comboBox);
				
				//Grouping buttons together 
				ButtonGroup signingInOrOut = new ButtonGroup();
				rdbtnSigningIn = new JRadioButton("Signing In");
				rdbtnSigningIn.setBounds(192, 374, 109, 23);
				frame.getContentPane().add(rdbtnSigningIn);
				signingInOrOut.add(rdbtnSigningIn);
				
				rdbtnSigningOut = new JRadioButton("Signing Out");
				rdbtnSigningOut.setBounds(349, 374, 109, 23);
				frame.getContentPane().add(rdbtnSigningOut);
				signingInOrOut.add(rdbtnSigningOut);
	}
}
