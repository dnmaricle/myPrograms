
public class Main {
    public static final int NUMBER_OF_GENES = 10;
    public static final double MAXIMUM_VALUE = 3.14;
    public static final int NUMBER_OF_SPECIMENS = 30;
    public static final int NUMBER_OF_GENERATIONS = 30;
    public static final int NUMBER_OF_CHROMOSOMES = 2;

    public static void main(String[] args) {
        
        
        Population p = new Population(NUMBER_OF_GENES, 
                MAXIMUM_VALUE, 
                NUMBER_OF_SPECIMENS,
                NUMBER_OF_CHROMOSOMES);
        p.getBestSpecimensFitness();
       
        for (int n = 0; n < NUMBER_OF_GENERATIONS; ++n) {
            System.out.println(p.getBestSpecimensFitness());
            System.out.println(p);
            p.spawnNewGeneration();
        }
        System.out.println(p.getBestSpecimensFitness());
        System.out.println(p);
        
        
        
    }

}
