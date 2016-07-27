package ui;

import java.util.ArrayList;
import java.util.Arrays;

import bp.Maze;
import bp.PotentialPath;

public class Main {

	public static void main(String[] args) {
		
		/*int[][] mazeToFindPath = new int[][] {
				{1, -1,  1,  1,  1, -1},
				{1, -1,  1, -1,  1,  1},
				{1, -1,  1, -1, -1,  1},
				{1, -1,  1, -1, -1,  1},
				{1,  1,  1, -1,  1,  1},
				{1, -1,  1, -1,  1,  1},
				{1, -1,  1,  1,  1,  1}
		}; */
		
		int[][] mazeToFindPath = new int[][] {
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
						1, -1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
						1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
						-1, -1, -1, 1, 1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
						1, 1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
						1, 1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, -1, -1, -1,
						-1, -1, -1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, -1, 1, 1, 1,
						1, 1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, -1, -1, -1, -1, -1, -1, -1, 1, 1, -1, 1,
						1, 1, 1, 1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, -1, -1, -1,
						-1, 1, 1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, -1,
						1, 1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, -1, -1, -1, 1, 1, -1, 1, 1, -1, 1, 1, 1, 1, 1,
						-1, 1, 1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, -1, -1, -1, -1, 1, 1,
						-1, 1, 1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1,
						1, 1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1,
						1, 1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
						-1, -1, -1, 1, 1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
						1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
						1, -1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
						-1, -1, -1, -1, -1, -1, -1, -1, -1 },
				{ -1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
						1, 1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
						1, 1, 1, 1, 1 }, }; 

		Maze myMaze = new Maze(mazeToFindPath);
		System.out.println("Raw Grid");
		for (int[] row: myMaze.getGrid()) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("H Costs");
		for (int[] row: myMaze.getHCost()) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("Numbered Grid");
		for (int[] row: myMaze.getNumberedGrid()) {
			System.out.println(Arrays.toString(row));
		}
		
		System.out.println("Total G-Cost from 0,1,3");
		myMaze.getGCost(new ArrayList<Integer>(Arrays.asList(0, 1,3)));
		
		System.out.println(myMaze.getRow(19));
		System.out.println(myMaze.getColumn(19));
		
		System.out.println("What is the A Star Path?");
		myMaze.getAStarPath();
		myMaze.showPath();
		System.out.println("Number of potential paths considered: "
				+ PotentialPath.getInstancesCreated());
	}

}
