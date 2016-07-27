package com.sample;

public class CurrentQuestion {
	
	private int currentQuestionID = 0;
	
	public CurrentQuestion(int pCurrentQuestionID) {
		currentQuestionID = pCurrentQuestionID;
	}

	public int getCurrentQuestionID() {
		return currentQuestionID;
	}

	public void setCurrentQuestionID(int pCurrentQuestionID) {
		currentQuestionID = pCurrentQuestionID;
	}
}
