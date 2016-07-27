package bp;

import gui.Query;

import java.io.FileWriter;
import java.io.IOException;

public class StoreData  {
	/*
	public static final boolean SET_TO_APPEND_INSTEAD_OF_OVERWRITE = true;
    public static final String FILE_TO_WRITE2 = "\\\\cs.cofo.edu\\StudentShare\\151217\\TestAnswers\\Bradshaw.csv";
    //Instantiating the values of question answers to test 1.
    private static String question1a1t1 = "";
    private static String question1a2t1 = "";
    private static String question2a1t1 = "";
    private static String question2a2t1 = "";
    private static String question3a1t1 = "";
    private static String question3a2t1 = "";
    private static String question4t1 = "";
    private static String question4a1t1 = "";
    private static String question4a2t1 = "";
    private static String question5a1t1 = "";
    private static String question5a2t1 = "";
    
  //Instantiating the values of question answers to test 2.
    private static String question1a1t2 = "";
    private static String question1a2t2 = "";
    private static String question2a1t2 = "";
    private static String question2a2t2 = "";
    private static String question3a1t2 = "";
    private static String question3a2t2 = "";
    private static String question4a1t2 = "";
    private static String question4a2t2 = "";
    private static String question5a1t2 = "";
    private static String question5a2t2 = "";
    
  //Instantiating the values of question answers to test 3.
    private static String question1a1t3 = "";
    private static String question1a2t3 = "";
    private static String question2a1t3 = "";
    private static String question2a2t3 = "";
    private static String question3a1t3 = "";
    private static String question3a2t3 = "";
    private static String question4a1t3 = "";
    private static String question4a2t3 = "";
    private static String question5a1t3 = "";
    private static String question5a2t3 = "";
    
  //Instantiating the values of question answers to test 4.
    private static String question1a1t4 = "";
    private static String question1a2t4 = "";
    private static String question2a1t4 = "";
    private static String question2a2t4 = "";
    private static String question3a1t4 = "";
    private static String question3a2t4 = "";
    private static String question4a1t4 = "";
    private static String question4a2t4 = "";
    private static String question5a1t4 = "";
    private static String question5a2t4 = "";
    
    //Instantiating the value of numRight for t1
    private static int numberRightT1 = 0;
    
    //Instantiating the value of numRight for t2
    private static int numberRightT2 = 0;
    
    //Instantiating the value of numRight for t3
    private static int numberRightT3 = 0;
    
    //Instantiating the value of numRight for t4.
    private static int numberRightT4 = 0;
    
  //Writing to file instantiation
    public static String testAnswers = "";
    
	public StoreData() {
	}
       
    public void WriteFile() {    

		//Create instance of query class.
    	//gui.Query q1 = new Query();
    	
    	//Create instance of test 1
    	//gui.Test t1 = new Test();
    	
    	//Create instance of test 2
    	//gui.Test2 t2 = new Test2();
    	
    	//Create instance of test 3
    	//gui.Test3 t3 = new Test3();
    	
    	//Create instance of test 4
    	//gui.Test4 t4 = new Test4();
    	
    	
    	if (Query.sel == 1) {
    		//Values of question 1
    		question1a1t1 = Test.q1a1t1;
    		question1a2t1 = Test.q1a2t1;
    		
    		//Values of question 2
    		question2a1t1 = Test.q2a1t1;
    		question2a2t1 = Test.q2a2t1;
    		
    		//Values of question 3
    		question3a1t1 = Test.q3a1t1;
    		question3a2t1 = Test.q3a2t1;
    		
    		//Values of question 4
    		question4a1t1 = Test.q4a1t1;
    		question4a2t1 = Test.q4a2t1;
    		
    		
    		//Values of question 5
    		question5a1t1 = Test.q5a1t1;
    		question5a2t1 = Test.q5a2t1;
    		
    		//Number Right
    		numberRightT1 = Test.numRightT1;
    		
    		
    		//Creating string to save to file.
    		StringBuilder sb = new StringBuilder();
        	sb.append(Query.name + ",");
        	sb.append(Query.studentID + ",");
        	sb.append("Form A,");
        	sb.append(Test.q1a1t1 + ",");
        	sb.append(Test.q1a2t1 + ",");
        	sb.append(Test.q2a1t1 + ",");
        	sb.append(Test.q2a2t1 + "," );
        	sb.append(Test.q3a1t1 + ",");
        	sb.append(Test.q3a2t1 + ",");
        	sb.append(Test.q4a1t1 + ",");
        	sb.append(Test.q4a2t1 + ",");
        	sb.append(Test.q5a1t1 + ",");
        	sb.append(Test.q5a2t1 + ",");
        	sb.append(numberRightT1 + "," + "\n");
        	testAnswers = sb.toString();	
    	}
    	else if (Query.sel == 2) {
    		//Values of question 1
    		question1a1t2 = Test2.q1a1t2;
    		question1a2t2 = Test2.q1a2t2;
    		
    		//Values of question 2
    		question2a1t2 = Test2.q2a1t2;
    		question2a2t2 = Test2.q2a2t2;
    		
    		//Values of question 3
    		question3a1t2 = Test2.q3a1t2;
    		question3a2t2 = Test2.q3a2t2;
    		
    		//values of question 4
    		question4a1t2 = Test2.q4a1t2;
    		question4a2t2 = Test2.q4a2t2;
    		
    		//Values of question 5
    		question5a1t2 = Test2.q5a1t2;
    		question5a2t2 = Test2.q5a2t2;
    		
    		//Number Right
    		numberRightT2 = Test2.numRightT2;
    		
    		//Creating string to save to file.
    		StringBuilder sb = new StringBuilder();
        	sb.append(Query.name + ",");
        	sb.append(Query.studentID + ",");
        	sb.append("Form B,");
        	sb.append(question1a1t2 + ",");
        	sb.append(question1a2t2 + ",");
        	sb.append(question2a1t2 + ",");
        	sb.append(question2a2t2 + "," );
        	sb.append(question3a1t2 + ",");
        	sb.append(question3a2t2 + ",");
        	sb.append(question4a1t2 + ",");
        	sb.append(question4a2t2 + ",");
        	sb.append(question5a1t2 + ",");
        	sb.append(question5a2t2 + ",");
        	sb.append(numberRightT2 + "," + "\n");
        	testAnswers = sb.toString();
    		
    	}

    	else if (Query.sel == 3) {
    		//Values of question 1
    		question1a1t3 = Test3.q1a1t3;
    		question1a2t3 = Test3.q1a2t3;
    		
    		//Values of question 2
    		question2a1t3 = Test3.q2a1t3;
    		question2a2t3 = Test3.q2a2t3;
    		
    		//Values of question 3
    		question3a1t3 = Test3.q3a1t3;
    		question3a2t3 = Test3.q3a2t3;
    		
    		//values of question 4
    		question4a1t3 = Test3.q4a1t3;
    		question4a2t3 = Test3.q4a2t3;
    		
    		//Values of question 5
    		question5a1t3 = Test3.q5a1t3;
    		question5a2t3 = Test3.q5a2t3;
    		
    		//Number right
    		numberRightT3 = Test3.numRightT3;
    		
    		//Creating string to save to file.
    		StringBuilder sb = new StringBuilder();
        	sb.append(Query.name + ",");
        	sb.append(Query.studentID + ",");
        	sb.append("Form C,");
        	sb.append(question1a1t3 + ",");
        	sb.append(question1a2t3 + ",");
        	sb.append(question2a1t3 + ",");
        	sb.append(question2a2t3 + "," );
        	sb.append(question3a1t3 + ",");
        	sb.append(question3a2t3 + ",");
        	sb.append(question4a1t3 + ",");
        	sb.append(question4a2t3 + ",");
        	sb.append(question5a1t3 + ",");
        	sb.append(question5a2t3 + ",");
        	sb.append(numberRightT3 + "," + "\n");
        	testAnswers = sb.toString();
    		
    	}
    	else {
    		//Values of question 1
    		question1a1t4 = Test4.q1a1t4;
    		question1a2t4 = Test4.q1a2t4;
    		
    		//Values of question 2
    		question2a1t4 = Test4.q2a1t4;
    		question2a2t4 = Test4.q2a2t4;
    		
    		//Values of question 3
    		question3a1t4 = Test4.q3a1t4;
    		question3a2t4 = Test4.q3a2t4;
    		
    		//values of question 4
    		question4a1t4 = Test4.q4a1t4;
    		question4a2t4 = Test4.q4a2t4;
    		
    		//Values of question 5
    		question5a1t4 = Test4.q5a1t4;
    		question5a2t4 = Test4.q5a2t4;
    		
    		//number right
    		numberRightT4 = Test4.numRightT4;
    		
    		//Creating string to save to file.
    		StringBuilder sb = new StringBuilder();
        	sb.append(Query.name + ",");
        	sb.append(Query.studentID + ",");
        	sb.append("Form D,");
        	sb.append(question1a1t4 + ",");
        	sb.append(question1a2t4 + ",");
        	sb.append(question2a1t4 + ",");
        	sb.append(question2a2t4 + "," );
        	sb.append(question3a1t4 + ",");
        	sb.append(question3a2t4 + ",");
        	sb.append(question4a1t4 + ",");
        	sb.append(question4a2t4 + ",");
        	sb.append(question5a1t4 + ",");
        	sb.append(question5a2t4 + ",");
        	sb.append(numberRightT4 + "," + "\n");
        	 testAnswers = sb.toString();	
    	}
    	
        // DON'T OPEN FILE UNTIL READY TO WRITE AND CLOSE IN ONE RAPID
        // SWOOP.
    	FileWriter writer = null;
	
		try {
			writer = new FileWriter(FILE_TO_WRITE2,
			        SET_TO_APPEND_INSTEAD_OF_OVERWRITE);

			//writer.write("Name, Student ID, question1a, question1b, question2a, question2b, question3a, question3b, question4a, question4b, question5a, question5b, Number Correct");
			writer.write(testAnswers);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch
			e.printStackTrace();
		}
    } 
    */
}



