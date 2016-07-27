import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//CNTRL + SHIFT + O
public class Population {
    private List<Specimen> specimens = new ArrayList<>();
    private int numberOfSpecimens = 0;
    private int numberOfGenes;
    private double maxValue;
    private int numberOfChromosomes = 0;

    public Population(int pNumberOfGenes, double pMaxValue,
            int pNumberOfSpecimens, int pNumberOfChromosomes) {
        numberOfSpecimens = pNumberOfSpecimens;
        numberOfGenes = pNumberOfGenes;
        maxValue = pMaxValue;
        numberOfChromosomes = pNumberOfChromosomes;
        for (int n = 0; n < numberOfSpecimens; ++n) {
            specimens.add(new Specimen(pNumberOfGenes, pMaxValue, pNumberOfChromosomes));
        }
    }

    public List<Specimen> getSpecimens() {
        return specimens;
    }

    public void setSpecimens(List<Specimen> pSpecimens) {
        specimens = pSpecimens;
    }

    public int getNumberOfSpecimens() {
        return numberOfSpecimens;
    }

    public void setNumberOfSpecimens(int pNumberOfSpecimens) {
        numberOfSpecimens = pNumberOfSpecimens;
    }

    public double getBestSpecimensFitness() {
        Collections.sort(specimens);
        return specimens.get(0).getFitnessIndex();

    }

    // Override the toString method
    public String toString() {
        return specimens.toString();
    }

    // TODO: Create this method
    public void spawnNewGeneration() {
        List<Specimen> tempSpecimen = new ArrayList<>();
        List<Chromosome> tempChromosomeValues = new ArrayList<>();
        // create a new gene pool based on fitness.

        // if chromosome 0 is twice as fit as chromosome 1
        // then it should have roughly twice as many entries in the gene pool

        // clone one copy of the best specimen into the new pool

        // for the remaining candidates choose two entries and
        // cross over from the pool
        // Chromosome c = new Chromosome(numberOfGenes, maxValue);
        // Chromosome c1 = c.getChild("11011");

        // replace the old chromosome with the new ones generated

        for (int n = 0; n < specimens.size(); ++n) {
            // Figuring how many specimen to create
            int numberOfSpecimenToCreate = (int) (specimens.get(n)
                    .getFitnessIndex() * 100);

            for (int i = 0; i < numberOfSpecimenToCreate; ++i) {

                for (int k = 0; k < numberOfChromosomes; ++k) {

                    int randomIndexValueOfOtherParent = (int) (Math.random() * specimens
                            .size());

                    

                    tempChromosomeValues.add(specimens
                            .get(n)
                            .getChromosomes()
                            .get(k)
                            .getChild(
                                    specimens
                                            .get(randomIndexValueOfOtherParent)
                                            .getChromosomes().get(k)
                                            .getBinaryValue()));
                }
                // clear out any extraneous tempchrom from previous
                // insertion
               /* if (i >= numberOfChromosomes) {
                    int numbertoremove = tempChromosomeValues.size() - 1;
                    for (int t = 0; t < numbertoremove; ++t) {
                        tempChromosomeValues.remove(t);
                    }
                }*/

                // set the species chromosome that were crossed...help from Cody
                tempSpecimen.add(new Specimen(numberOfGenes, maxValue,
                        tempChromosomeValues, numberOfChromosomes));
                tempChromosomeValues.clear();
            }
        }
        for (int j = 1; j < numberOfSpecimens; ++j) {
            int randomIndexForCreation = (int) (Math.random()
                    * tempSpecimen.size());
            specimens.set(j, tempSpecimen.get(randomIndexForCreation));
        }
    }

    public int getNumberOfChromosomes() {
        return numberOfChromosomes;
    }

    public void setNumberOfChromosomes(int pNumberOfChromosomes) {
        numberOfChromosomes = pNumberOfChromosomes;
    }
}
