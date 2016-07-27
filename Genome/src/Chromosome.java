//what do I need to track
//what supporting methods do I need
//how do I display it to the user?
public class Chromosome {
    private int numberOfGenes = 0;
    private int rawValue = 0;
    private double maxValue = 0;
    private int numberOfChromosomes = 0;
    //add a fitness function to this class
    
    public Chromosome(int pNumberOfGenes, double pMaxValue, int pNumberOfChromsomes) {
        numberOfGenes = pNumberOfGenes;
        maxValue = pMaxValue;
        spawnChromosome();
        numberOfChromosomes = pNumberOfChromsomes;
    }

    public Chromosome(int pNumberOfGenes, double pMaxValue, String pGeneSequence, int pNumberOfChromosomes) {
        numberOfGenes = pNumberOfGenes;
        maxValue = pMaxValue;
        setBinaryValue(pGeneSequence);
        numberOfChromosomes = pNumberOfChromosomes;
    }

    public int getNumberOfGenes() {
        return numberOfGenes;
    }

    public void setNumberOfGenes(int pNumberOfGenes) {
         numberOfGenes = pNumberOfGenes;
    }

    public int getRawValue() {
        return rawValue;
    }

    public void setRawValue(int pRawValue) {
        rawValue = pRawValue;
    }
    
    public String getBinaryValue() {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(rawValue));
        while(sb.length() < numberOfGenes) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
    
    public void setBinaryValue(String pBinaryString) {
        rawValue = Integer.parseInt(pBinaryString, 2);
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double pMaxValue) {
        maxValue = pMaxValue;
    }
    
    public double getScaledValue() {
        double scaler = maxValue / (Math.pow(2, numberOfGenes) - 1);
        return rawValue * scaler;
    }
    
    public void spawnChromosome() {
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < numberOfGenes; ++n) {
            sb.append(Math.round(Math.random()));
        }
        setBinaryValue(sb.toString());
    }

    public Chromosome getChild(String pBitStringOfOtherParent) {
        int splitPoint = (int) (Math.random() * numberOfGenes) + 1;
        String leftDNA = getBinaryValue().substring(0, splitPoint);
        String rightDNA = getBinaryValue().substring(splitPoint);
        return new 
                Chromosome
            (numberOfGenes, maxValue, leftDNA + rightDNA, numberOfChromosomes);

    }
}
