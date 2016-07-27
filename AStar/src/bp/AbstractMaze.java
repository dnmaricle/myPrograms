package bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class handles the maze functionality. Maze will be passed a rectangular
 * array of values. A value of -1 indicates a wall at that cell. A value of 1
 * indicates walkable path.
 * 
 * @author cberkstresser
 *
 */
public abstract class AbstractMaze {
	/** The grid of the maze itself. */
	protected int[][] grid;
	/** A grid of h-costs for each cell in grid */
	protected int[][] hCost;
	/** An array of size matching grid with unique cell numbers. */
	protected int[][] numberedGrid;
	/** A placeholder for the number of rows in the grid. */
	protected int rows;
	/** A placeholder for the number of columns in the grid. */
	protected int columns;
	/** A list of nodes that are no longer under consideration for path finding. */
	protected List<Integer> closedList = new ArrayList<>();
	/** A list of Potential Paths still being considered in path finding. */
	protected List<PotentialPath> paths = new ArrayList<>();
	protected int numberOfPotentialPathsConsidered;

	/**
	 * Constructor. Make sure to hand the grid setup. The value -1 in the array
	 * is a wall, and 1 is a walkable area. Player will start at the top left
	 * and end at the bottom right.
	 * 
	 * @param pGrid
	 *            The array with which to initialize the maze.
	 */
	public AbstractMaze(final int[][] pGrid) {
		/** Set the grid. */
		grid = pGrid.clone();
		/** Precompute the h costs for easy access and speed. */
		hCost = new int[grid.length][grid[0].length];
		/** Populate the numbered grid with unique cell numbers. */
		numberedGrid = new int[grid.length][grid[0].length];
		/** Calculate the rows and set to the placeholder. */
		rows = grid.length;
		/** Calculate the columns and set to the placeholder. */
		columns = grid[0].length;
		/** Create a number placeholder for uniquely numbering the cells. */
		int number = 0;
		/**
		 * Cycle through each row and column assigning a unique number to the
		 * numbered grid.
		 */
		for (int row = 0; row < rows; ++row) {
			for (int column = 0; column < columns; ++column) {
				hCost[row][column] = (rows - row) + (columns - column) - 2;
				numberedGrid[row][column] = number;
				number++;
			}
		}
	}

	/**
	 * Get the a-star path through the maze.
	 * 
	 * @return An ArrayList of integers (the unique position based on
	 *         numberedGrid) representing the path through the maze.
	 */
	public abstract List<Integer> getAStarPath();

	/**
	 * Get the column position of a particular cell number (zero based).
	 * 
	 * @param cellNumber
	 *            The cell number (based on numberedGrid) to get the column
	 *            position of.
	 * @return The column position of the given cell.
	 */
	public final int getColumn(final int cellNumber) {
		return cellNumber % columns;
	}

	/**
	 * Get the F-Cost (G-Cost + H-Cost) of any node to the destination.
	 * 
	 * @param path
	 *            The path on which to calculate the F-Cost.
	 * @return F-Cost (G-Cost + H-Cost) of any node to the destination.
	 */
	public final int getFCost(final List<Integer> path) {
		int currentPosition = path.get(path.size() - 1);
		return path.size()
				+ hCost[getRow(currentPosition)][getColumn(currentPosition)];
	}

	/**
	 * Get the G-Cost of any potential path. Since we are only moving laterally
	 * and since each move costs one, the total g-cost is just the number of
	 * nodes traversed.
	 * 
	 * @param path
	 *            The path on which to calculate the G-Cost.
	 * @return The actual cost of the path so far.
	 */
	public final int getGCost(final List<Integer> path) {
		return path.size() - 1;
	}

	/**
	 * Assessor for getting the grid array.
	 * 
	 * @return The grid array for the maze we are traversing.
	 */
	public final int[][] getGrid() {
		return grid;
	}

	/**
	 * Assessor for getting the h-cost array.
	 * 
	 * @return The grid array for the h-cost of the maze we are traversing.
	 * */
	public final int[][] getHCost() {
		return hCost;
	}

	/**
	 * Assessor for getting the numbered grid corresponding to the maze grid.
	 * 
	 * @return The grid array with unique cell numbers for the maze we are
	 *         traversing.
	 */
	public final int[][] getNumberedGrid() {
		return numberedGrid;
	}

	/**
	 * Get the row position of a particular cell number (zero based).
	 * 
	 * @param cellNumber
	 *            The cell number (based on numberedGrid) to get the row
	 *            position of.
	 * @return The row position of the given cell.
	 */
	public final int getRow(final int cellNumber) {
		return cellNumber / columns;
	}

	/**
	 * Is the position to check the target cell (lower right)?
	 * 
	 * @param pPositionToCheck
	 *            The position (based on numberedGrid) to check if is the final
	 *            destination.
	 * @return True if position to check is the final destination.
	 */
	protected final boolean isTarget(final int pPositionToCheck) {
		return getRow(pPositionToCheck) == rows - 1
				&& getColumn(pPositionToCheck) == columns - 1;
	}

	/**
	 * This doesn't belong in business logic, but wanted you to have a quick way
	 * to preview the grid that was passed to the program.
	 */
	public final void showMaze() {
		for (int[] row : grid) {
			System.out.println(Arrays.toString(row).replace("-1,", "X")
					.replaceAll("-*1[\\,,\\]]", " ")
					+ "]");
		}
	}

	/**
	 * This doesn't belong in business logic, but wanted you to have a quick way
	 * to preview the grid that was passed to the program as well as the a-star
	 * path through it.
	 */
	public final void showPath() {
		List<Integer> thePath = getAStarPath();
		char[][] mazeToShow = new char[rows][columns];
		for (int row = 0; row < rows; ++row) {
			for (int column = 0; column < columns; ++column) {
				switch (grid[row][column]) {
				case -1:
					mazeToShow[row][column] = 'X';
					break;
				case 1:
					if (thePath.contains(row * columns + column)) {
						mazeToShow[row][column] = '*';
					} else {
						mazeToShow[row][column] = ' ';
					}
					break;
				default:
					throw new IllegalArgumentException("Ahhhh!!!!!!!!!!!!!!!!");
				}
			}
		}
		for (char[] row : mazeToShow) {
			System.out.println(Arrays.toString(row).replace(",", ""));
		}
	}
}
