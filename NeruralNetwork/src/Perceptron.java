import java.util.ArrayList;
import java.util.List;


public class Perceptron {
    public static final double LEARNING_RATE = 0.2;
    private List<Double> weights = new ArrayList<>();
    private double threshold;
    
    public Perceptron(double pThreshold,List<Double> pWeights) {
        threshold = pThreshold;
        weights = pWeights;
    }
    
    public List<Double> getWeights() {
        return weights;
    }
    
    public void setWeights(List<Double> pWeights) {
        weights = pWeights;
    }
    
    public double getThreshold() {
        return threshold;
    }
    
    public void setThreshold(double pThreshold) {
        threshold = pThreshold;
    }
    
    public Boolean isFired(List<Boolean> pInputs) {
        double totalInput = 0;
        for (int n = 0; n < pInputs.size(); ++n) {
            totalInput += booleanToInt(pInputs.get(n)) * weights.get(n);       
        }
        return (totalInput >= threshold);
    }
    
    public void train(List<Boolean> pInputs, Boolean pOutput) {
        int error;
        if (isFired(pInputs) != pOutput) {
            for (int n = 0; n < pInputs.size(); ++n) {
                weights.set(n, 
                        weights.get(n) + LEARNING_RATE * booleanToInt(pInputs.get(n)));
            }
        } 
        
    }
    
    private int booleanToInt(Boolean pBooleanToConvert) {
        if (pBooleanToConvert) {
            return 1;
        } else {
            return 0;
        }
    }
}
