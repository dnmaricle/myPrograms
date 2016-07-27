package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.SwingConstants;

public class TestScreen {

	public JFrame frame;
	private JTextField txtQ1A1;
	private JTextField txtQ1A2;
	private int testForm = 0;
	private bp.Test test;
	private JRadioButton question1;
	private JTextField txtQ2A1;
	private JTextField txtQ2A2;
	private JTextField txtQ3A1;
	private JTextField txtQ3A2;
	private JTextField txtQ5A1;
	private JTextField txtQ5A2;
	private JTextField txtQ4A1;
	private JTextField txtQ4A2;
	private JRadioButton question2;
	private JRadioButton question3;
	private JRadioButton question4;
	private JRadioButton question5;
	private JLabel lblTitle;
	private JButton btnSubmitTest;
	private JLabel question1Display;
	private JLabel question2Display;
	private JLabel question3Display;
	private JLabel question4Display;
	private JLabel questions5Display;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	//TODO: remove test form
	public TestScreen(int pTestForm) {
		testForm = pTestForm;
		test = new bp.Test();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 789, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		lblTitle = new JLabel(
				"<html><b><center>Absolute Value Quiz </b></c>");
		lblTitle.setBounds(0, 11, 783, 47);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		frame.getContentPane().add(lblTitle);

		JLabel lblQuestion1 = new JLabel("<html><b>1.) " + test.getQuestion1()
				+ " </b></html>");
		lblQuestion1.setBounds(10, 104, 219, 35);
		frame.getContentPane().add(lblQuestion1);

		JLabel label_2 = new JLabel("<html><b> x = </b>");
		label_2.setBounds(10, 150, 46, 14);
		frame.getContentPane().add(label_2);

		txtQ1A1 = new JTextField();
		txtQ1A1.setBounds(35, 147, 46, 20);
		txtQ1A1.setColumns(10);
		frame.getContentPane().add(txtQ1A1);

		JLabel label_3 = new JLabel("<html><b>or x = </b>");
		label_3.setBounds(91, 150, 46, 14);
		frame.getContentPane().add(label_3);

		txtQ1A2 = new JTextField();
		txtQ1A2.setBounds(126, 147, 46, 20);
		txtQ1A2.setColumns(10);
		frame.getContentPane().add(txtQ1A2);

		question1 = new JRadioButton("<html><b>No solution </b>");
		question1.setBounds(6, 171, 109, 23);
		frame.getContentPane().add(question1);

		btnSubmitTest = new JButton("<html><b>Submit</b>");
		btnSubmitTest.setBounds(458, 368, 305, 88);
		btnSubmitTest.addActionListener(new ButtonActionListener());
		btnSubmitTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnSubmitTest);
		
		frame.getRootPane().setDefaultButton(btnSubmitTest);
		
		question2 = new JRadioButton("<html><b>No solution </b>");
		question2.setBounds(14, 278, 109, 23);
		frame.getContentPane().add(question2);
		
		JLabel label = new JLabel("<html><b> x = </b>");
		label.setBounds(14, 257, 46, 14);
		frame.getContentPane().add(label);
		
		txtQ2A1 = new JTextField();
		txtQ2A1.setBounds(39, 254, 46, 20);
		txtQ2A1.setColumns(10);
		frame.getContentPane().add(txtQ2A1);
		
		JLabel label_1 = new JLabel("<html><b> or x = </b>");
		label_1.setBounds(95, 257, 46, 14);
		frame.getContentPane().add(label_1);
		
		txtQ2A2 = new JTextField();
		txtQ2A2.setBounds(130, 254, 46, 20);
		txtQ2A2.setColumns(10);
		frame.getContentPane().add(txtQ2A2);
		
		JLabel label_4 = new JLabel("<html> <b> 2.)" +test.getQuestion2() + "</b>");
		label_4.setBounds(14, 211, 219, 35);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("<html><b>3.)" + test.getQuestion3() + "</b>");
		label_5.setBounds(10, 330, 257, 35);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("<html> <b>x = </b>");
		label_6.setBounds(10, 376, 46, 14);
		frame.getContentPane().add(label_6);
		
		txtQ3A1 = new JTextField();
		txtQ3A1.setBounds(35, 373, 46, 20);
		txtQ3A1.setColumns(10);
		frame.getContentPane().add(txtQ3A1);
		
		JLabel label_7 = new JLabel("<html><b> or x = </b>");
		label_7.setBounds(91, 376, 46, 14);
		frame.getContentPane().add(label_7);
		
		txtQ3A2 = new JTextField();
		txtQ3A2.setBounds(126, 373, 46, 20);
		txtQ3A2.setColumns(10);
		frame.getContentPane().add(txtQ3A2);
		
		question3 = new JRadioButton("<html><b>No solution </b>");
		question3.setBounds(6, 397, 109, 23);
		frame.getContentPane().add(question3);
		
		question5 = new JRadioButton("<html><b>No solution </b>");
		question5.setBounds(474, 281, 109, 23);
		frame.getContentPane().add(question5);
		
		JLabel label_8 = new JLabel("<html> <b>x = </b>");
		label_8.setBounds(474, 260, 46, 14);
		frame.getContentPane().add(label_8);
		
		txtQ5A1 = new JTextField();
		txtQ5A1.setBounds(499, 257, 46, 20);
		txtQ5A1.setColumns(10);
		frame.getContentPane().add(txtQ5A1);
		
		JLabel label_9 = new JLabel("<html><b> or x = </b>");
		label_9.setBounds(555, 260, 46, 14);
		frame.getContentPane().add(label_9);
		
		txtQ5A2 = new JTextField();
		txtQ5A2.setBounds(594, 257, 46, 20);
		txtQ5A2.setColumns(10);
		frame.getContentPane().add(txtQ5A2);
		
		JLabel label_10 = new JLabel("<html><b>5.)" + test.getQuestion5() + "</b>");
		label_10.setBounds(474, 211, 177, 27);
		frame.getContentPane().add(label_10);
		
		question4 = new JRadioButton("<html><b>No solution </b>");
		question4.setBounds(474, 142, 109, 23);
		frame.getContentPane().add(question4);
		
		JLabel label_11 = new JLabel("<html> <b>x = </b>");
		label_11.setBounds(474, 121, 46, 14);
		frame.getContentPane().add(label_11);
		
		txtQ4A1 = new JTextField();
		txtQ4A1.setBounds(499, 121, 46, 20);
		txtQ4A1.setColumns(10);
		frame.getContentPane().add(txtQ4A1);
		
		JLabel label_12 = new JLabel("<html><b> or x = </b>");
		label_12.setBounds(555, 124, 46, 14);
		frame.getContentPane().add(label_12);
		
		txtQ4A2 = new JTextField();
		txtQ4A2.setBounds(594, 121, 46, 20);
		txtQ4A2.setColumns(10);
		frame.getContentPane().add(txtQ4A2);
		
		JLabel label_13 = new JLabel("<html> <b> 4.)" + test.getQuestion4() + "</b>");
		label_13.setBounds(474, 78, 234, 32);
		frame.getContentPane().add(label_13);
		
		question1Display = new JLabel("");
		question1Display.setBounds(29, 60, 96, 50);
		frame.getContentPane().add(question1Display);
		
		question2Display = new JLabel("");
		question2Display.setBounds(33, 188, 96, 50);
		frame.getContentPane().add(question2Display);
		
		question3Display = new JLabel("");
		question3Display.setBounds(29, 307, 96, 50);
		frame.getContentPane().add(question3Display);
		
		question4Display = new JLabel("");
		question4Display.setBounds(499, 60, 96, 50);
		frame.getContentPane().add(question4Display);
		
		questions5Display = new JLabel("");
		questions5Display.setBounds(499, 188, 96, 50);
		frame.getContentPane().add(questions5Display);
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			if (question1.isSelected()) {
				test.setStudentAnswer1(new String[]{"No Solution"});
			} else {
				test.setStudentAnswer1(new String[]{txtQ1A1.getText(),txtQ1A2.getText()});
			}
			if (question2.isSelected()) {
				test.setStudentAnswer2(new String[]{"No Solution"});
			} else {
				test.setStudentAnswer2(new String[]{txtQ2A1.getText(),txtQ2A2.getText()});
			}
			if (question3.isSelected()) {
				test.setStudentAnswer3(new String[]{"No Solution"});
			} else {
				test.setStudentAnswer3(new String[]{txtQ3A1.getText(),txtQ3A2.getText()});
			}
			if (question4.isSelected()) {
				test.setStudentAnswer4(new String[]{"No Solution"});
			} else {
				test.setStudentAnswer4(new String[]{txtQ4A1.getText(),txtQ4A2.getText()});
			}
			if (question5.isSelected()) {
				test.setStudentAnswer5(new String[]{"No Solution"});
			} else {
				test.setStudentAnswer5(new String[]{txtQ5A1.getText(),txtQ5A2.getText()});
			}
			
			StringBuilder question1Result = new StringBuilder("Question 1: ");
			StringBuilder question2Result = new StringBuilder("Question 2: ");
			StringBuilder question3Result = new StringBuilder("Question 3: ");
			StringBuilder question4Result = new StringBuilder("Question 4: ");
			StringBuilder question5Result = new StringBuilder("Question 5: ");
			//Constructing question 1 response.
			question1Result.append("Your answer: " + Arrays.toString(test.getStudentsAnswer1()) + " ");
			question1Result.append("Correct answer: " + Arrays.toString(test.getCorrectAnswer1()) + " ");
			if (test.isQuestion1Correct()) {
				question1Result.append("(Correct) ");	
			} else {
				question1Result.append("(Incorrect) ");	
			}
			question1Result.append("\n");
			//Constructing question 2 response.
			question2Result.append("Your answer: " + Arrays.toString(test.getStudentsAnswer2()) + " ");
			question2Result.append("Correct answer: " + Arrays.toString(test.getCorrectAnswer2()) + " ");
			if (test.isQuestion2Correct()) {
				question2Result.append("(Correct) ");	
			} else {
				question2Result.append("(Incorrect) ");	
			}
			question2Result.append("\n");
			//Construction question 3 response.
			question3Result.append("Your answer: " + Arrays.toString(test.getStudentsAnswer3()) + " ");
			question3Result.append("Correct answer: " + Arrays.toString(test.getCorrectAnswer3()) + " ");
			if (test.isQuestion3Correct()) {
				question3Result.append("(Correct) ");	
			} else {
				question3Result.append("(Incorrect) ");	
			}
			question3Result.append("\n");
			//Construction question 4 response.
			question4Result.append("Your answer: " + Arrays.toString(test.getStudentsAnswer4()) + " ");
			question4Result.append("Correct answer: " + Arrays.toString(test.getCorrectAnswer4()) + " ");
			if (test.isQuestion4Correct()) {
				question4Result.append("(Correct) ");	
			} else {
				question4Result.append("(Incorrect) ");	
			}
			question4Result.append("\n");
			//Construction question 5 response.
			question5Result.append("Your answer: " + Arrays.toString(test.getStudentsAnswer5()) + " ");
			question5Result.append("Correct answer: " + Arrays.toString(test.getCorrectAnswer5()) + " ");
			if (test.isQuestion5Correct()) {
				question5Result.append("(Correct) ");	
			} else {
				question5Result.append("(Incorrect) ");	
			}
			question5Result.append("\n");

			
			//Displaying "checkmark" or "red-X" beside each question
			if (test.isQuestion1Correct()) {
				//Putting green check-mark beside question
				question1Display.getGraphics();
			} else {
				//Putting "red-X" beside question
			}
			if (test.isQuestion2Correct()) {
				//Putting green check-mark beside question
			} else {
				//Putting "red-X" beside question
			}
			if (test.isQuestion3Correct()) {
				//Putting green check-mark beside question
			} else {
				//Putting "red-X" beside question
			}
			if (test.isQuestion4Correct()) {
				//Putting green check-mark beside question
			} else {
				//Putting "red-X" beside question
			}
			if (test.isQuestion5Correct()) {
				//Putting green check-mark beside question
			} else {
				//Putting "red-X" beside question
			}
			
			//Displaying results
			question5Result.append("Your score: " + test.getPercentCorrect() + "\n");
			if (test.isPassingGrade()) {
				question5Result.append("Final Result (pass/fail): Congratulations! You passed the test!");
			} else {
				question5Result.append("Final Result (pass/fail): I'm sorry, but you did not pass the test.");
			}
			
			
			JOptionPane.showMessageDialog(null, question1Result.toString() 
						+ question2Result.toString() + question3Result.toString() + 
						question4Result.toString() + question5Result.toString());
			//Saving student's name/ID/question/scores to the excel spreadsheet
			test.saveTestToFile();
			//Preventing the student from resubmitting their exam after knowing the correct answers
			btnSubmitTest.setEnabled(false);
		}
	}
}
