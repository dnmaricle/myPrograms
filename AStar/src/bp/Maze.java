package bp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze extends AbstractMaze {
boolean foundStartingPoint = false;
int lastClosedLocationIndexValue = 0;
int recentClosedValue = 0;
int currentRow = 0;
int currentColumn = 0;
int numberOfPotentialPaths = 0;
int david = 0;
private List<Integer> pathToConsider = new ArrayList<>();
	

	public Maze(int[][] pGrid) {
		super(pGrid);
	}

	/**
	 * Get the a-star path through the maze.
	 * 
	 * @return An ArrayList of integers (the unique position based on
	 *         numberedGrid) representing the path through the maze.
	 */
	public List<Integer> getAStarPath() {
		//Clearing all arrays that are used in this method
		pathToConsider.clear();
		closedList.clear();
		paths.clear();
		foundStartingPoint = false;
		david = 0;
		/*Find the first available spot to start at,
		 * starting at the top left hand corner and 
		 * searching through each row until we
		 * find an available spot!
		 * */

		//Iterating through each row
		for (int i = 0; i < columns; i++) {
			//If we've already found our starting point, let's get outta here!
			if (foundStartingPoint) {
				break;
			}
			//Iterating through each column
			for (int j = 0; j < rows; j++) {
				/*No wall here? Add the first point
				 * to the closed list and let's
				 * get outta here!
				 */
				if (grid[i][j] == 1) {
					//Adding integer value to the current row/columns we're on
					closedList.add(numberedGrid[i][j]);
					//Getting the current position of the starting point
					currentRow = getRow(numberedGrid[i][j]);
					currentColumn = getColumn(numberedGrid[i][j]);
					//Checking east from our starting point and adding it to potential paths if valid
					if ((currentColumn + 1 < columns && currentRow < rows && grid[currentRow][currentColumn + 1] != -1) && (!closedList.contains(numberedGrid[currentRow][currentColumn + 1]))) {
						pathToConsider.add(numberedGrid[i][j]);
						pathToConsider.add(numberedGrid[i][j + 1]);
						paths.add(new PotentialPath(new ArrayList<Integer>(pathToConsider), getFCost(pathToConsider)));
						numberOfPotentialPaths++;
						pathToConsider.clear();
						
					}
					//Checking south from our starting point and adding it to potential paths if valid
					if ((currentColumn < columns && currentRow + 1 < rows && grid[currentRow + 1][currentColumn] != -1) && (!closedList.contains(numberedGrid[currentRow + 1][currentColumn]))) {
						pathToConsider.add(numberedGrid[i][j]);
						pathToConsider.add(numberedGrid[i + 1][j]);
						paths.add(new PotentialPath(new ArrayList<Integer>(pathToConsider), getFCost(pathToConsider)));
						numberOfPotentialPaths++;
						pathToConsider.clear();
					}
					//Checking west from our starting point and adding it to potential paths if valid
					if ((currentColumn - 1 < columns && currentColumn - 1 >= 0 && currentRow < rows && currentRow >= 0 && grid[currentRow][currentColumn - 1] != -1) && (!closedList.contains(numberedGrid[currentRow][currentColumn - 1]))) {
						pathToConsider.add(numberedGrid[i][j]);
						pathToConsider.add(numberedGrid[i][j - 1]);
						paths.add(new PotentialPath(new ArrayList<Integer>(pathToConsider), getFCost(pathToConsider)));
						numberOfPotentialPaths++;
						pathToConsider.clear();
					}
					//Checking north from our starting point and adding it to potential paths if valid
					if ((currentColumn < columns && currentColumn >= 0 && currentRow - 1 < rows && currentRow - 1 >= 0 && grid[currentRow - 1][currentColumn] != -1) && (!closedList.contains(numberedGrid[currentRow - 1][currentColumn]))) {
						pathToConsider.add(numberedGrid[i][j]);
						pathToConsider.add(numberedGrid[i + 1][j]);
						paths.add(new PotentialPath(new ArrayList<Integer>(pathToConsider), getFCost(pathToConsider)));
						numberOfPotentialPaths++;
						pathToConsider.clear();
					}
					//Setting our "gateway" open/true
					foundStartingPoint = true;
					break;
				}
			}
		}
		/*If we couldn't find a starting point, 
		 * then we need to tell the user no path exists
		 */
		if (!foundStartingPoint) {
			System.out.println("No path found");
			return null;
		}
		//While we are not at our target, do the following...
		while (!isTarget(closedList.get(closedList.size() - 1)) || numberOfPotentialPaths == 0) {
			//get the path from position zero of paths to check
			//pathToConsider.clear();
			pathToConsider = paths.get(0).getPotentialPath();
			//If the last node is not already in the closed list, put it there!
			if (!closedList.contains(pathToConsider.get(pathToConsider.size() - 1))) {
				closedList.add(pathToConsider.get(pathToConsider.size() - 1));
			}
			//remove first path from potential paths
			paths.remove(0);
			numberOfPotentialPaths--;
			
			//Getting the position of the last node in our last best potential path
			currentRow = getRow(pathToConsider.get(pathToConsider.size() - 1));
			currentColumn = getColumn(pathToConsider.get(pathToConsider.size() - 1));

			//Check east--if valid position throw new path onto the paths list (not valid if it's out of bounds, on the closed list, or it's -1)
			if ((currentColumn + 1 < columns && currentRow < rows && grid[currentRow][currentColumn + 1] != -1) && (!closedList.contains(numberedGrid [currentRow][currentColumn + 1]))) {
				pathToConsider.add(numberedGrid[currentRow][currentColumn + 1]);
				//Check to see if this is the target!
				if (isTarget(numberedGrid[currentRow][currentColumn + 1])) {
					return pathToConsider;
				}
				paths.add(new PotentialPath(new ArrayList<Integer>(pathToConsider), getFCost(pathToConsider)));
				numberOfPotentialPaths++;
				pathToConsider.remove(pathToConsider.size() - 1);
			}
			//Check south--if valid position throw new path onto the paths list (not valid if it's out of bounds, on the closed list, or it's -1)
			if ((currentColumn < columns && currentRow + 1 < rows && grid[currentRow + 1][currentColumn] != -1) && (!closedList.contains(numberedGrid[currentRow + 1][currentColumn]))) {
				pathToConsider.add(numberedGrid[currentRow + 1][currentColumn]); 
				//Check to see if this is the target!
				if (isTarget(numberedGrid[currentRow + 1][currentColumn])) {
					return pathToConsider;
				}
				paths.add(new PotentialPath(new ArrayList<Integer>(pathToConsider), getFCost(pathToConsider)));
				numberOfPotentialPaths++;
				pathToConsider.remove(pathToConsider.size() - 1);
			}
			//Check west--if valid position throw new path onto the paths list (not valid if it's out of bounds, on the closed list, or it's -1)
			if ((currentColumn - 1 <= columns && currentColumn - 1 >= 0 && currentRow <= rows && currentRow >= 0 && grid[currentRow][currentColumn - 1] != -1) && (!closedList.contains(numberedGrid[currentRow][currentColumn - 1]))) {
				pathToConsider.add(numberedGrid[currentRow][currentColumn - 1]);
				//Check to see if this is the target!
				if (isTarget(numberedGrid[currentRow][currentColumn - 1])) {
					return pathToConsider;
				}
				paths.add(new PotentialPath(new ArrayList<Integer>(pathToConsider), getFCost(pathToConsider)));
				numberOfPotentialPaths++;
				pathToConsider.remove(pathToConsider.size() - 1);
			}
			//Check north--if valid position throw new path onto the paths list (not valid if it's out of bounds, on the closed list, or it's -1)
			if ((currentColumn <= columns && currentColumn >= 0 && currentRow - 1 <= rows && currentRow - 1 >= 0 && grid[currentRow - 1][currentColumn] != -1) && (!closedList.contains(numberedGrid[currentRow - 1][currentColumn]))) {
				pathToConsider.add(numberedGrid[currentRow - 1][currentColumn]);
				//Check to see if this is the target!
				if (isTarget(numberedGrid[currentRow - 1][currentColumn])) {
					return pathToConsider;
				}
				paths.add(new PotentialPath(new ArrayList<Integer>(pathToConsider), getFCost(pathToConsider)));
				numberOfPotentialPaths++;
				pathToConsider.remove(pathToConsider.size() - 1);
			}
		
			
			david++;
			if (david == 2800) {
				System.out.println("Hi!");
			}
			//sort the list of potential paths
			paths.sort(null);
		
			//path of most interest will on the top (position 0...aka...paths.get(0))
			pathToConsider.clear();
			if (numberOfPotentialPaths == 0) {
				System.out.println("No path is possible for this maze");
				return new ArrayList<Integer>(Arrays.asList(-1));
			} else {
			 pathToConsider = paths.get(0).getPotentialPath(); 
			 //Add last cell of the path of interest to the closed list (checking if it's not in there first)
			 if (!closedList.contains(pathToConsider.get(pathToConsider.size() - 1))) {
				 closedList.add(pathToConsider.get(pathToConsider.size() - 1));  
			 }
			}
		}
		if (numberOfPotentialPaths == 0) {
			System.out.println("No path is possbile for this maze");
			return new ArrayList<Integer>(Arrays.asList(-1));
		} else {
			System.out.println("If you're reading this, I'm probably fired");
			return new ArrayList<Integer>(Arrays.asList(-1));
		}
	}

	
}
