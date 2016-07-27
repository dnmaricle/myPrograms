package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {
	private Connection cn = null;

	public Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			cn = DriverManager.getConnection("jdbc:mysql://csserver/absexam?"
					+ "user=absprogram&password=MathDepartmentRocks");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet getExam(int studentID) {
		try {
			PreparedStatement preparedStmt = cn
					.prepareStatement("call usp_GetExam(?)");
			preparedStmt.setInt(1, studentID);
			return preparedStmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String[] getAnswers(int problemID) {
		// placeholder for building result
		List<String> answers = new ArrayList<String>();
		try {
			// hook into the stored procedure for getting answers by problemID
			PreparedStatement preparedStmt = cn
					.prepareStatement("call usp_GetAnswers(?)");
			preparedStmt.setInt(1, problemID);
			// get a result set for this problem
			ResultSet r = preparedStmt.executeQuery();
			while (r.next()) {
				// save each row of the result set answer to the list array
				answers.add(r.getString("AnswerValue"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// return a nice array of the answer values
		if (answers.size() == 0) {
			return null;
		} else {
			String[] answerArray = new String[answers.size()];
			for (int n = 0; n < answerArray.length; ++n) {
				answerArray[n] = answers.get(n);
			}
			return answerArray;
		}

	}
}
