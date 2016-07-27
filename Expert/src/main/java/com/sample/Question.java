package com.sample;

import java.util.Scanner;
import java.util.Scanner;

import com.sample.DroolsTest.Message;

public class Question {
	private int answerNum = 0;
	private int questionID = 0;
	//private static int currentQuestionID=0;
	
	//Constructor
	public Question(int qd) {
		questionID = qd;
		answerNum = 0;
		//Asking the questions based off of the question's ID
		switch(questionID) {
		case 1:
			answerNum = firstQuestion();
			break;
		case 2:
			answerNum = secondQuestion();
			break;
		case 3:
			answerNum = thirdQuestion();
			break;
		case 4:
			answerNum = fourthQuestion();
			break;
		case 5:
			answerNum = fifthQuestion();
			break;
		case 6: 
			answerNum = sixthQuestion();
			break;
		case 7:
			answerNum = seventhQuestion();
			break;
		case 8:
			answerNum = eigthQuestion();
			break;
		case 9:
			answerNum = ninthQuestion();
			break;
		case 10:
			answerNum = tenthQuestion();
			break;
		case 11:
			answerNum = eleventhQuestion();
			break;
		case 12:
			answerNum = twelfthQuestion();
			break;
		case 13:
			answerNum = thirteenthQuestion();
			break;
		default:
				System.out.println("Question not here");
				break;
		}
		
	}
	
	
	public int firstQuestion () {
		Scanner in = new Scanner(System.in);
		System.out.print("What is the slope of the land? Please pick from the following: "
      			+ "\n1.) 0 - 3%"
      			+ "\n2.) 3 - 8%"
      			+ "\n3.) 8 - 15% "
      			+ "\n4.) 15 - 25%"
      			+ "\n5.) 25% and up : ");
		answerNum = in.nextInt();
		return answerNum;
	}

	public int secondQuestion () {
			Scanner in = new Scanner(System.in);
			System.out.print("What is the texture of the soil? Please pick from the following: "
					+ "\n (This is a key factor in determining water holding capactiy, draining, and natural fertility)"
	      			+ "\n1.) Clay"
	      			+ "\n2.) Loam"
	      			+ "\n3.) Sandy :  ");	
			answerNum = in.nextInt();
			return answerNum;
	}

	public int thirdQuestion () {
		Scanner in = new Scanner(System.in);
		System.out.print("What is the drainage capactiy of the soil? Please pick from the following: "
				+ "\n (Drainage effects the ability to sustain certain crops)"
      			+ "\n1.) Well drained"
      			+ "\n2.) Moderately well drained"
      			+ "\n3.) Poorly drained : ");	
		answerNum = in.nextInt();
		return answerNum;
	}
	
	public int fourthQuestion () {
		Scanner in = new Scanner(System.in);
		System.out.print("What is the depth to bedrock? Please pick from the following: "
      			+ "\n1.) 0 - 20 cm"
      			+ "\n2.) 20 - 60 cm"
      			+ "\n3.) 60cm and up : ");	
		answerNum = in.nextInt();
		return answerNum;
	}
	
	public int fifthQuestion () {
		Scanner in = new Scanner(System.in);
		System.out.print("What percentage of the soil is rocky? Please pick from the following: "
      			+ "\n1.) 0 - 20%"
      			+ "\n2.) 20 - 50%"
      			+ "\n3.) 50% and up : ");	
		answerNum = in.nextInt();
		return answerNum;
	}
	
	public int sixthQuestion () {
		Scanner in = new Scanner(System.in);
		System.out.print("What is the degree of erosion? Please pick from the following: "
      			+ "\n1.) Light"
      			+ "\n2.) Moderate"
      			+ "\n3.) Severe : ");	
		answerNum = in.nextInt();
		return answerNum;
	}
	
	public int seventhQuestion () {
		Scanner in = new Scanner(System.in);
		System.out.print("Is there a fragipan present? Please pick from the following: "
				+ "\n (This tells about erosion, age of soil, and the amount of viable planting soil for the land)"
      			+ "\n1.) Yes"
      			+ "\n2.) No : ");	
		answerNum = in.nextInt();
		return answerNum;
	}
	
	public int eigthQuestion () {
		Scanner in = new Scanner(System.in);
		System.out.print("What is the depth of the A horizon? Please pick from the following: "
      			+ "\n1.) 0 - 3cm"
      			+ "\n2.) 4 - 10cm"
      			+ "\n3.) 11cm and up : ");	
		answerNum = in.nextInt();
		return answerNum;
	}
	
	public int ninthQuestion () {
		Scanner in = new Scanner(System.in);
		System.out.print("What is the average amount of rainfall? Please pick from the following: "
				+ "\n (Gives an indication of the amount of runoff the site will experience)"
      			+ "\n1.) 0 - 30cm"
      			+ "\n2.) 30 - 60cm"
      			+ "\n3.) 60cm and up : ");	
		answerNum = in.nextInt();
		return answerNum;
	}
	
	public int tenthQuestion () {
		Scanner in = new Scanner(System.in);
		System.out.print("What is the ph of the soil? Please pick from the following: "
				+ "\n (Is an important factor relating to plant growth)"
      			+ "\n1.) < 5"
      			+ "\n2.) 5 - 8"
      			+ "\n3.) > 8 : ");	
		answerNum = in.nextInt();
		return answerNum;
	}
	
	public int eleventhQuestion () {
		Scanner in = new Scanner(System.in);
		System.out.print("What percentage of the land experiences rock outcrops? Please pick from the following: "
				+ "\n (To determine farming limitations)"
      			+ "\n1.) 0%"
      			+ "\n2.) 0 - 20%"
      			+ "\n3.) 20% and up : ");	
		answerNum = in.nextInt();
		return answerNum;
	}
	
	public int twelfthQuestion () {
		Scanner in = new Scanner(System.in);
		System.out.print("What is the tilth of the soil? Please pick from the following: "
				+ "\n (It is a qualitative way to determine the workability of the soil)"
      			+ "\n1.) Good"
      			+ "\n2.) Bad : ");	
		answerNum = in.nextInt();
		return answerNum;
	}
	
	public int thirteenthQuestion () {
		Scanner in = new Scanner(System.in);
		System.out.print("What is the annual corn yield per acre? Please pick from the following: "
				+ "\n (Describes the general productivity of the land)"
      			+ "\n1.) <100 bushels per year"
      			+ "\n2.) >100 bushels per year : ");	
		answerNum = in.nextInt();
		return answerNum;
	}
	
	public int getAnswerNum () {
		return answerNum;
	}
	
	public int getQuestionID() {
		return questionID;
	}
}
