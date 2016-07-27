package bp;

import java.util.ArrayList;
import java.util.List;

public class PotentialPath implements Comparable {
	private static int instancesCreated = 0;
	private List<Integer> potentialPath = new ArrayList<>();
	private int fCost;

	@Override
	public int compareTo(Object pO) {
		if (fCost < ((PotentialPath) pO).fCost) {
			return -1;
		} else if (fCost > ((PotentialPath) pO).fCost) {
			return 1;
		} else {
			return 0;
		}
	}

	public PotentialPath(List<Integer> pPotentialPath, int pFCost) {
		potentialPath = pPotentialPath;
		fCost = pFCost;
		instancesCreated++;
	}

	public List<Integer> getPotentialPath() {
		return potentialPath;
	}

	public static int getInstancesCreated() {
		return instancesCreated;
	}
}
