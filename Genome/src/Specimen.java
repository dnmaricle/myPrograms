import java.util.ArrayList;
import java.util.List;

//1st chromosome -- x
//2nd chromosome - y
public class Specimen implements Comparable<Specimen> {
    //public static final int NUMBER_OF_CHROMOSOMES = 2;
    public static int numberOfSpeciemen = 0;
    private List<Chromosome> chromosomes = new ArrayList<>();

    public Specimen(int pNumberOfGenes, double pMaxValue, int pNumberOfChromosomes) {
        for (int i = 0; i < pNumberOfChromosomes; ++i) {
            chromosomes.add(new Chromosome(pNumberOfGenes, pMaxValue, pNumberOfChromosomes));
        }
    }

    public Specimen(int pNumberOfGenes, double pMaxValue, List<Chromosome> pChromosomeValues, int pNumberOfChromosomes) {
        for (int i = 0; i < pNumberOfChromosomes; ++i) {
            chromosomes
            .add(new Chromosome(pNumberOfGenes, pMaxValue, 
                    pChromosomeValues.get(i).getBinaryValue(), pNumberOfChromosomes));
        }
    }

    public List<Chromosome> getChromosomes() {
        return chromosomes;
    }

    public void setChromosomes(List<Chromosome> pChromosomes) {
        chromosomes = pChromosomes;
    }

    public double getFitnessIndex() {
        return Math.sin(chromosomes.get(0).getScaledValue()) / 2 + .5;
    }

    @Override
    public int compareTo(Specimen p0) {
        if (getFitnessIndex() > p0.getFitnessIndex()) {
            return -1;
        } else {
            return 1;
        }
    }

    public String toString() {
        return "[Index: " + getFitnessIndex() + " : X-Value: "
                + chromosomes.get(0).getScaledValue() 
                        + " Y-Value: " + chromosomes.get(1).getScaledValue() + "]";
    }

    public int getNumberOfSpeciemen() {
        return numberOfSpeciemen;
    }

    public void setNumberOfSpeciemen(int pNumberOfSpeciemen) {
        numberOfSpeciemen = pNumberOfSpeciemen;
    }
}
