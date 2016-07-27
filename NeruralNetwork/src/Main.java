import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<Double> weights = new ArrayList<>();
        weights.add(.3);
        weights.add(.1);
        Perceptron logicalOr = new Perceptron(1, weights);
        System.out.println("This is a logical Or");
       
        showOutput(logicalOr);
       
        while (logicalOr.isFired(Arrays.asList(false, false)) != false
                || logicalOr.isFired(Arrays.asList(false, true)) != true
                || logicalOr.isFired(Arrays.asList(true, false)) != true
                || logicalOr.isFired(Arrays.asList(true, true)) != true) {
            
            
           
            System.out.println("Training...");
            logicalOr.train(Arrays.asList(false, false), false);
            logicalOr.train(Arrays.asList(false, true), true);
            logicalOr.train(Arrays.asList(true, false), true);
            logicalOr.train(Arrays.asList(true, true), true);
            
            System.out.println("How about this??");
            showOutput(logicalOr);
            
            
        }
       
        
        
        System.out.println("Final weights: ");
        System.out.println(logicalOr.getWeights());
       
        }
    static void showOutput(Perceptron perceptron) {
        boolean case1 = perceptron.isFired(Arrays.asList(false, false));
        boolean case2 = perceptron.isFired(Arrays.asList(false, true));
        boolean case3 = perceptron.isFired(Arrays.asList(true, false));
        boolean case4 = perceptron.isFired(Arrays.asList(true, true));
        
        System.out.println("Case 0,0 " + case1);
        System.out.println("Case 0,1 " + case2);
        System.out.println("Case 1,0 " + case3);
        System.out.println("Case 1,1 " + case4);
        
    }
}
