package com.sample;

public class Decision {
	private int decisionNum = 0;
	
	public Decision(int d) {
		decisionNum = d;
	}
	
	public void setDecisionNum (int pDecision) {
		decisionNum = pDecision;
		System.out.println(getDecisionText());
		if (decisionNum >= 5) {
			System.out.println("End of program");
			System.exit(0);
		}
	}
	
	public int getDecisionNum() {
		return decisionNum;
	}
	
	public String getDecisionText() {
		switch(decisionNum) {
		case 0:
			return "Initial case.  No conclusions yet";
		case 1:
			return "Possibly class I soil.";
		case 2:
			return "Class II soil -- Good land, moderate limitations.";
		case 3:
			return "Class III soil -- Severe limitations in use. Regular cultivation possible if hazzards are provided against.";
		case 4:
			return "Class IV soil -- Very severe limitations. Suited for occasional cultivation or for some kind of limited cultivation.";
		case 5:
			return "This soil is not suited for agriculture.";
		case 11:
			return "Class I soil -- Few limitations, wide latitude for use. Very good land.";
		case 21:
			return "Class II soil -- Moderate limitations due to erosion hazard.";
		case 22:
			return "Class II soil -- Moderate limitations due to rockiness.";
		case 23:
			return "Class II soil -- Moderate limitations due to wetness.";
		case 28:
			return "Class II soil -- Good land, moderate limitations.";
		case 31:
			return "Class III soil -- Severe limitations in use due to erosion hazard.";
		case 32:
			return "Class III soil -- Severe limitations in use due to rockiness.";
		case 33:
			return "Class III soil -- Severe limitations in use due to wetness.";
		case 38:
			return "Class III soil -- Severe limitations in use. Regular cultivation possible if hazards are provided against.";
		case 41:
			return "Class IV soil -- Very severe limitations due to erosion.";
		case 42:
			return "Class IV soil -- Very severe limitations due to rockiness.";
		case 43:
			return "Class IV soil -- Very severe limitations due to wetness.";
		case 99:
			return "There is an inconsistency between soil texture and reported drainage, please recheck data.";
		default:
			return "Cannot reach a decision due to an improper entry.";
		}
	}

	
}
