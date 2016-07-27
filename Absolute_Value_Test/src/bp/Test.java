package bp;

import gui.Query;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import db.Database;

public class Test {
	private String question1;
	private String question2;
	private String question3;
	private String question4;
	private String question5;
	
	private String[] answer1;
	private String[] answer2;
	private String[] answer3;
	private String[] answer4;
	private String[] answer5;
	private String[] studentAnswer1;
	private String[] studentAnswer2;
	private String[] studentAnswer3;
	private String[] studentAnswer4;
	private String[] studentAnswer5;
	//Standard format of all non-integer answers
	private DecimalFormat standardFormat = new DecimalFormat("0.0000##");
	//File path for the excel spreadsheet to save the student scores
	public static final String FILE_TO_WRITE = "\\\\cs.cofo.edu\\StudentShare\\151217\\TestAnswers\\Bradshaw.csv";
	public static final boolean SET_TO_APPEND_INSTEAD_OF_OVERWRITE = true;
	public String allDataToSaveToFile = "";
	public double percentScore = 0;
	public boolean hasPassed = false;

	// constructor
	/**
	 * 
	 * @param pTestForm
	 *            The form (1,2,3,4) of the test to initialize.
	 */
	public Test() {
		Database myDb = new Database();
		
		ResultSet questions = myDb.getExam(Integer.parseInt(Query.studentID));
		
		try {
			//go to first row
			questions.next();
			question1 = questions.getString("ProblemText");
			answer1 = myDb.getAnswers(questions.getInt("ProblemID"));
			
			//do the next four
			questions.next();
			question2 = questions.getString("ProblemText");
			answer2 = myDb.getAnswers(questions.getInt("ProblemID"));
			questions.next();
			question3 = questions.getString("ProblemText");
			answer3 = myDb.getAnswers(questions.getInt("ProblemID"));
			questions.next();
			question4 = questions.getString("ProblemText");
			answer4 = myDb.getAnswers(questions.getInt("ProblemID"));
			questions.next();
			question5 = questions.getString("ProblemText");
			answer5 = myDb.getAnswers(questions.getInt("ProblemID"));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	// assessors
	public String getQuestion1() {
		return question1;
	}
	public String getQuestion2() {
		return question2;
	}
	public String getQuestion3() {
		return question3;
	}
	public String getQuestion4() {
		return question4;
	}
	public String getQuestion5() {
		return question5;
	}

	//get all correct answers
	public String[] getCorrectAnswer1() {
		if (answer1 == null) {
			answer1 = new String[]{"No Solution"};
		}
		return answer1;
	}

	public String[] getCorrectAnswer2() {
		if (answer2 == null) {
			answer2 = new String[]{"No Solution"};
		}
		return answer2;
	}
	public String[] getCorrectAnswer3() {
		if (answer3 == null) {
			answer3 = new String[]{"No Solution"};
		}
		return answer3;

	}	public String[] getCorrectAnswer4() {
		if (answer4 == null) {
			answer4 = new String[]{"No Solution"};
		}
		return answer4;

	}
	public String[] getCorrectAnswer5() {
		if (answer5 == null) {
			answer5 = new String[]{"No Solution"};
		}
		return answer5;
	}
	
	
	public String[] getStudentsAnswer1() {
		return studentAnswer1;
	}

	public String[] getStudentsAnswer2() {
		return studentAnswer2;
	}

	public String[] getStudentsAnswer3() {
		return studentAnswer3;
	}

	public String[] getStudentsAnswer4() {
		return studentAnswer4;
	}

	public String[] getStudentsAnswer5() {
		return studentAnswer5;
	}

	// mutators
	public void setStudentAnswer1(String[] pStudentAnswer1) {
		Arrays.sort(pStudentAnswer1);
		studentAnswer1 = pStudentAnswer1; 
	}
	public void setStudentAnswer2(String[] pStudentAnswer2) {
		Arrays.sort(pStudentAnswer2);
		studentAnswer2 = pStudentAnswer2; 
	}
	public void setStudentAnswer3(String[] pStudentAnswer3) {
		Arrays.sort(pStudentAnswer3);
		studentAnswer3 = pStudentAnswer3; 
	}
	public void setStudentAnswer4(String[] pStudentAnswer4) {
		Arrays.sort(pStudentAnswer4);
		studentAnswer4 = pStudentAnswer4; 
	}
	public void setStudentAnswer5(String[] pStudentAnswer5) {
		Arrays.sort(pStudentAnswer5);
		studentAnswer5 = pStudentAnswer5; 
	}
	//QUERIES
	public boolean isQuestion1Correct() {
		boolean firstAnswerIsFraction = false;
		boolean secondAnswerIsFraction = false;
		double firstAnswer = 0;
		double correctFirstAnswer = 0;
		double secondAnswer = 0;
		double correctSecondAnswer = 0;
		
		//get the sorted right answer
		String[] correctAnswer1 = getCorrectAnswer1();
		Arrays.sort(correctAnswer1);

		//Checking to see if this is a faction
		for (int i = 0; i < studentAnswer1.length; ++i) {
			if (studentAnswer1[i].contains("/")  &&  i == (studentAnswer1.length - 2)) {
				firstAnswerIsFraction = true;
				correctFirstAnswer = Double.parseDouble(correctAnswer1[i]);
				correctAnswer1[i] = standardFormat.format(correctFirstAnswer);
			} if (studentAnswer1[i].contains("/") && i == (studentAnswer1.length - 1)) {
				secondAnswerIsFraction = true;
				correctSecondAnswer = Double.parseDouble(correctAnswer1[i]);
				correctAnswer1[i] = standardFormat.format(correctSecondAnswer);
			}
		}
		
		//If the first answer is a fraction, convert it to a decimal
		if (firstAnswerIsFraction) {
			firstAnswer = convertStringToDecimal(studentAnswer1[studentAnswer1.length - 2]);
			studentAnswer1[studentAnswer1.length - 2] = standardFormat.format(firstAnswer); 
		}

		//If the second answer is a fraction, convert it to a decimal
		if (secondAnswerIsFraction) {
			secondAnswer = convertStringToDecimal(studentAnswer1[studentAnswer1.length - 1]);
			studentAnswer1[studentAnswer1.length - 1] = standardFormat.format(secondAnswer);
		}

		//if any of the student's answers do not match the right answer return false
		for (int n = 0; n< correctAnswer1.length; ++n) {
			if (!correctAnswer1[n].equals(studentAnswer1[n])) {
				return false;
			}
		}
		//if it survived the above, return true
		return true;
	}
	public boolean isQuestion2Correct() {
		boolean firstAnswerIsFraction = false;
		boolean secondAnswerIsFraction = false;
		double firstAnswer = 0;
		double correctFirstAnswer = 0;
		double secondAnswer = 0;
		double correctSecondAnswer = 0;
		//get the sorted right answer
		String[] correctAnswer2 = getCorrectAnswer2();
			Arrays.sort(correctAnswer2);
			//Checking to see if this is a faction
			for (int i = 0; i < studentAnswer2.length; ++i) {
				if (studentAnswer2[i].contains("/")  &&  i == (studentAnswer2.length - 2)) {
					firstAnswerIsFraction = true;
					correctFirstAnswer = Double.parseDouble(correctAnswer2[i]);
					correctAnswer2[i] = standardFormat.format(correctFirstAnswer);
				} if (studentAnswer2[i].contains("/") && i == (studentAnswer2.length - 1)) {
					secondAnswerIsFraction = true;
					correctSecondAnswer = Double.parseDouble(correctAnswer2[i]);
					correctAnswer2[i] = standardFormat.format(correctSecondAnswer);
				}
			}

			//If the first answer is a fraction, convert it to a decimal
			if (firstAnswerIsFraction) {
				firstAnswer = convertStringToDecimal(studentAnswer2[studentAnswer2.length - 2]);
				studentAnswer2[studentAnswer2.length - 2] = standardFormat.format(firstAnswer); 
			}

			//If the second answer is a fraction, convert it to a decimal
			if (secondAnswerIsFraction) {
				secondAnswer = convertStringToDecimal(studentAnswer2[studentAnswer2.length - 1]);
				studentAnswer2[studentAnswer2.length - 1] = standardFormat.format(secondAnswer);
			}

		//if any of the student's answers do not match the right answer return false
		for (int n = 0;n< correctAnswer2.length;++n) {
			if (!correctAnswer2[n].equals(studentAnswer2[n])) {
				return false;
			}
		}
		//if it survived the above, return true
		return true;
	}
	public boolean isQuestion3Correct() {
		boolean firstAnswerIsFraction = false;
		boolean secondAnswerIsFraction = false;
		double firstAnswer = 0;
		double correctFirstAnswer = 0;
		double secondAnswer = 0;
		double correctSecondAnswer = 0;
		//get the sorted right answer
		String[] correctAnswer3 = getCorrectAnswer3();
			Arrays.sort(correctAnswer3);
			//Checking to see if this is a faction
			for (int i = 0; i < studentAnswer3.length; ++i) {
				if (studentAnswer3[i].contains("/")  &&  i == (studentAnswer3.length - 2)) {
					firstAnswerIsFraction = true;
					correctFirstAnswer = Double.parseDouble(correctAnswer3[i]);
					correctAnswer3[i] = standardFormat.format(correctFirstAnswer);
				} if (studentAnswer3[i].contains("/") && i == (studentAnswer3.length - 1)) {
					secondAnswerIsFraction = true;
					correctSecondAnswer = Double.parseDouble(correctAnswer3[i]);
					correctAnswer3[i] = standardFormat.format(correctSecondAnswer);
				}
			}

			//If the first answer is a fraction, convert it to a decimal
			if (firstAnswerIsFraction) {
				firstAnswer = convertStringToDecimal(studentAnswer3[studentAnswer3.length - 2]);
				studentAnswer3[studentAnswer3.length - 2] = standardFormat.format(firstAnswer); 
			}
			//If the second answer is a fraction, convert it to a decimal
			if (secondAnswerIsFraction) {
				secondAnswer = convertStringToDecimal(studentAnswer3[studentAnswer3.length - 1]);
				studentAnswer3[studentAnswer3.length - 1] = standardFormat.format(secondAnswer);
			}

		//if any of the student's answers do not match the right answer return false
		for (int n = 0;n< correctAnswer3.length;++n) {
			if (!correctAnswer3[n].equals(studentAnswer3[n])) {
				return false;
			}
		}
		//if it survived the above, return true
		return true;
	}
	public boolean isQuestion4Correct() {
		boolean firstAnswerIsFraction = false;
		boolean secondAnswerIsFraction = false;
		double firstAnswer = 0;
		double correctFirstAnswer = 0;
		double secondAnswer = 0;
		double correctSecondAnswer = 0;
		//get the sorted right answer
		String[] correctAnswer4 = getCorrectAnswer4();
			Arrays.sort(correctAnswer4);
			//Checking to see if this is a faction
			for (int i = 0; i < studentAnswer4.length; ++i) {
				if (studentAnswer4[i].contains("/")  &&  i == (studentAnswer4.length - 2)) {
					firstAnswerIsFraction = true;
					correctFirstAnswer = Double.parseDouble(correctAnswer4[i]);
					correctAnswer4[i] = standardFormat.format(correctFirstAnswer);
				} if (studentAnswer4[i].contains("/") && i == (studentAnswer4.length - 1)) {
					secondAnswerIsFraction = true;
					correctSecondAnswer = Double.parseDouble(correctAnswer4[i]);
					correctAnswer4[i] = standardFormat.format(correctSecondAnswer);
				}
			}

			//If the first answer is a fraction, convert it to a decimal
			if (firstAnswerIsFraction) {
				firstAnswer = convertStringToDecimal(studentAnswer4[studentAnswer4.length - 2]);
				studentAnswer4[studentAnswer4.length - 2] = standardFormat.format(firstAnswer); 
			}
			//If the second answer is a fraction, convert it to a decimal
			if (secondAnswerIsFraction) {
				secondAnswer = convertStringToDecimal(studentAnswer4[studentAnswer4.length - 1]);
				studentAnswer4[studentAnswer4.length - 1] = standardFormat.format(secondAnswer);
			}

		//if any of the student's answers do not match the right answer return false
		for (int n = 0;n< correctAnswer4.length;++n) {
			if (!correctAnswer4[n].equals(studentAnswer4[n])) {
				return false;
			}
		}
		//if it survived the above, return true
		return true;
	}
	public boolean isQuestion5Correct() {
		boolean firstAnswerIsFraction = false;
		boolean secondAnswerIsFraction = false;
		double firstAnswer = 0;
		double correctFirstAnswer = 0;
		double secondAnswer = 0;
		double correctSecondAnswer = 0;
		//get the sorted right answer
		String[] correctAnswer5 = getCorrectAnswer5();
			Arrays.sort(correctAnswer5);
			//Checking to see if this is a faction
			for (int i = 0; i < studentAnswer5.length; ++i) {
				if (studentAnswer5[i].contains("/")  &&  i == (studentAnswer5.length - 2)) {
					firstAnswerIsFraction = true;
					correctFirstAnswer = Double.parseDouble(correctAnswer5[i]);
					correctAnswer5[i] = standardFormat.format(correctFirstAnswer);
				} if (studentAnswer5[i].contains("/") && i == (studentAnswer5.length - 1)) {
					secondAnswerIsFraction = true;
					correctSecondAnswer = Double.parseDouble(correctAnswer5[i]);
					correctAnswer5[i] = standardFormat.format(correctSecondAnswer);
				}
			}

			//If the first answer is a fraction, convert it to a decimal
			if (firstAnswerIsFraction) {
				firstAnswer = convertStringToDecimal(studentAnswer5[studentAnswer5.length - 2]);
				studentAnswer5[studentAnswer5.length - 2] = standardFormat.format(firstAnswer); 
			}
			//If the second answer is a fraction, convert it to a decimal
			if (secondAnswerIsFraction) {
				secondAnswer = convertStringToDecimal(studentAnswer5[studentAnswer5.length - 1]);
				studentAnswer5[studentAnswer5.length - 1] = standardFormat.format(secondAnswer);
			}

		//if any of the student's answers do not match the right answer return false
		for (int n = 0;n< correctAnswer5.length;++n) {
			if (!correctAnswer5[n].equals(studentAnswer5[n])) {
				return false;
			}
		}
		//if it survived the above, return true
		return true;
	}
	public int getFinalRawScore() {
		int runningTotalCorrect = 0;
		if (isQuestion1Correct()) {
			++runningTotalCorrect;
		}
		//Increasing score for every correct answer.
		if (isQuestion2Correct()) {
			++runningTotalCorrect;
		}
		if (isQuestion3Correct()) {
			++runningTotalCorrect;
		}
		if (isQuestion4Correct()) {
			++runningTotalCorrect;
		}
		if (isQuestion5Correct()) {
			++runningTotalCorrect;
		}
		
		return runningTotalCorrect;
	}
	
	public int getPercentCorrect() {
		return (int) (getFinalRawScore() / 5.0 * 100);
	}
	
	public boolean isPassingGrade() {
		if (getFinalRawScore() >= 4) {
			return true;
		} else {
			return false;
		}
	}
	
	public double convertStringToDecimal(String pAnswer) {
		//Getting the numerator
		int firstPartInIndex = pAnswer.indexOf("/");
		String myNumerator = pAnswer.substring(0, firstPartInIndex);
		int numerator = Integer.parseInt(myNumerator);
		//Getting the denominator
		int lastPartInIndex = pAnswer.length();
		String myDenominator = pAnswer.substring(firstPartInIndex + 1, lastPartInIndex);
		int denominator = Integer.parseInt(myDenominator);
		//Dividing the two and returning the answer
		double answer = (double) numerator/denominator;
		return answer;
	}
	
	public void saveTestToFile() {
		percentScore = getPercentCorrect();
		hasPassed = isPassingGrade();
		StringBuilder sb = new StringBuilder();
    	sb.append(Query.name + ",");
    	sb.append(Query.studentID + ",");
    	sb.append(studentAnswer1 + ",");
    	sb.append(studentAnswer2 + ",");
    	sb.append(studentAnswer3 + ",");
    	sb.append(studentAnswer4 + "," );
    	sb.append(studentAnswer5 + ",");
    	sb.append(hasPassed + ",");
    	sb.append(percentScore + "," + "\n");
    	allDataToSaveToFile = sb.toString();	
    	
    	 // DON'T OPEN FILE UNTIL READY TO WRITE AND CLOSE IN ONE RAPID
        // SWOOP.
    	FileWriter writer = null;
	
		try {
			writer = new FileWriter(FILE_TO_WRITE,
			        SET_TO_APPEND_INSTEAD_OF_OVERWRITE);

			writer.write(allDataToSaveToFile);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch
			e.printStackTrace();
		}
		
	}
}
