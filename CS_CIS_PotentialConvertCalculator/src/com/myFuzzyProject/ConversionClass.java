package com.myFuzzyProject;

import javax.swing.JOptionPane;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class ConversionClass {
    public static double levelOfAssertionExhibitedByBuchan = 0;
    public static double levelOfPerceivedAbilityByStudent = 0;
    public static double levelOfDesireToCompleteDegree = 0;
    public ConversionInformation ci = new ConversionInformation();
    public static boolean levelOfAssertionIsEmpty = true;
    public static boolean levelOfPerceivedAbilityIsEmpty = true;
    public static boolean leveOfDesireToCompleteMajorIsEmpty = true;
    public static double probabiltyStudentWillConvert = 0;
    

	public static void main(String[] args) throws Exception {
	    
	    
		String filename = "conversionPossibility.fcl";
		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}
		getVariable();
		
		if (levelOfAssertionIsEmpty == false && levelOfPerceivedAbilityIsEmpty == false && leveOfDesireToCompleteMajorIsEmpty == false) {
		 // Get default function block
	                FunctionBlock fb = fis.getFunctionBlock(null);

	                // Set inputs
	                fb.setVariable("levelOfAssertionExhibitedByBuchan", levelOfAssertionExhibitedByBuchan);
	                fb.setVariable("levelOfPerceivedAbilityByStudent", levelOfPerceivedAbilityByStudent);
	                fb.setVariable("levelOfDesireToCompleteDegree", levelOfDesireToCompleteDegree);

	               
	                // Evaluate
	                fb.evaluate();

                        
	                // Show output variable's chart
	                fb.getVariable("likelihoodOfConversion").defuzzify(); 
	                
	                // Print ruleSet
	                JFuzzyChart.get().chart(fb);  
		    
		    
		    
		    
		    
		}
		
		

	}
	
   public static void evaluate() {
       String filename = "conversionPossibility.fcl";
       FIS fis = FIS.load(filename, true);

       if (fis == null) {
               System.err.println("Can't load file: '" + filename + "'");
               System.exit(1);
       }
       
       
       FunctionBlock fb = fis.getFunctionBlock(null);
       
       
       // Set inputs
       fb.setVariable("levelOfAssertionExhibitedByBuchan", levelOfAssertionExhibitedByBuchan);
       fb.setVariable("levelOfPerceivedAbilityByStudent", levelOfPerceivedAbilityByStudent);
       fb.setVariable("levelOfDesireToCompleteDegree", levelOfDesireToCompleteDegree);

       // Evaluate
       fb.evaluate();

       // Show output variable's chart
       fb.getVariable("likelihoodOfConversion").defuzzify(); 
       
    // Print ruleSet
       JOptionPane.showMessageDialog(null, "The likelihood that this student will convert to a CS/CIS degree is: " + fb.getVariable("likelihoodOfConversion").getValue());
       setProbabiltyStudentWillConvert( fb.getVariable("likelihoodOfConversion").getValue());
       JFuzzyChart.get().chart(fb); 
   }

    private static void getVariable() {
        ConversionInformation ci = new ConversionInformation();
        ci.setVisible();
    }

    public double getLevelOfAssertionExhibitedByBuchan() {
        return levelOfAssertionExhibitedByBuchan;
    }

    public static void setLevelOfAssertionExhibitedByBuchan(
            double pLevelOfAssertionExhibitedByBuchan) {
        levelOfAssertionExhibitedByBuchan = pLevelOfAssertionExhibitedByBuchan;
        levelOfAssertionIsEmpty = false;
    }

    public double getLevelOfPerceivedAbilityByStudent() {
        return levelOfPerceivedAbilityByStudent;
    }

    public static void setLevelOfPerceivedAbilityByStudent(
            double pLevelOfPerceivedAbilityByStudent) {
        levelOfPerceivedAbilityByStudent = pLevelOfPerceivedAbilityByStudent;
        levelOfPerceivedAbilityIsEmpty = false;
    }

    public double getLevelOfDesireToCompleteDegree() {
        return levelOfDesireToCompleteDegree;
    }

    public static void setLevelOfDesireToCompleteDegree(
            double pLevelOfDesireToCompleteDegree) {
        levelOfDesireToCompleteDegree = pLevelOfDesireToCompleteDegree;
        leveOfDesireToCompleteMajorIsEmpty = false;
    }

    
    public static void setProbabiltyStudentWillConvert(
            double pProbabilityStudentWillConvert) {
        probabiltyStudentWillConvert = pProbabilityStudentWillConvert;
    }
    
    public double getProbabilityStudentWillConvert() {
        return probabiltyStudentWillConvert;
    }
}
