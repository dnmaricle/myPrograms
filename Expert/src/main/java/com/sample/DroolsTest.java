package com.sample;



import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	Question q1 = new Question(1);
        	CurrentQuestion cq = new CurrentQuestion(1);
        	Decision d = new Decision(0);
        	
        	//Inject both the question and decision for the first question, as well as fire all da rulz
            kSession.insert(q1);
            kSession.insert(d);
            kSession.insert(cq);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Message {
    	//Instantiation
    	public static final int I_CAME = 0;
    	public static final int I_SAW = 1;
    	public static final int I_CONQUERED = 2;
    	private int status;
    	 
    	//if, else if, else if
    	public String getMessage() {
    		if (status == I_CAME) {
    			return "I came.";
    	} else if (status == I_SAW) {
    		return "I saw.";
    	} else {
    		return "I conquered.";
    	}
    }
    	 
    	public int getStatus() {
    		return this.status;
    	}
    	 
    	public void setStatus(int status) {
    		this.status = status;
    	}
    	 
    }
}
