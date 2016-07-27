package bp;

import bp.SortedList;
import bp.UnsortedList;
import ui.Main;

import java.lang.reflect.Array;
import java.util.Arrays;




public class SortedList implements IUnsortedList {
	
	//Instantiate constants/variables/arrays
	public final int MAX_SIZE = 10000;
	public final int MAX_VALUE = 10;
	private int sizeOfList = 0;
	private boolean duplicatesAllowed = true;
	private int[] listItems = new int[MAX_SIZE];
	//SortedList sl = new SortedList();
	@Override
	public int getSizeOfList() {
		return sizeOfList;
	}

	@Override
	public boolean areDuplicatesAllowed() {
		return duplicatesAllowed;
	}

	@Override
	public void setDuplicatesAllowed(boolean pDuplicatesAllowed) {
		duplicatesAllowed = pDuplicatesAllowed;
		
	}

	@Override
	public void clear() {
		sizeOfList = 0;
		
	}

	@Override
	public void insert(int pValueToInsert) {
		boolean firstEntry = false;
		int insertionPoint = 0;
		boolean intoArray = false;
		// If duplicates are allowed, select random variable
		if (duplicatesAllowed) {
			// place the value in the last index and increment the size of list
			if (sizeOfList < MAX_SIZE) {
				if (sizeOfList == 0) {
					listItems[sizeOfList++] = pValueToInsert;
				}
				if (pValueToInsert < listItems[sizeOfList - 1]) {
				}
				listItems[sizeOfList++] = pValueToInsert;
			} else {
				System.out
						.println("I'm sorry, but you have reached the maximum size allotted for your list");
			}

			// Handling case of duplicates not allowed
		} else {
			// Should the value already exist in array, don't add it!
			if (find(pValueToInsert) > -1) {
				System.out
						.println("Sorry, duplicates are not allowed...so we cannot insert your value.");

				// Insert a randomized value into the array if the value is not
				// already existing
			} else {
				if (sizeOfList < MAX_SIZE) {
					if (sizeOfList == 0) {
						listItems[sizeOfList++] = pValueToInsert;
						firstEntry = true;
					}
					if (pValueToInsert < listItems[sizeOfList -1]) {
						for (int y = pValueToInsert; y > 0; y--) {
							int found = find(y);
							if (found > -1) {
								insertionPoint = y;
								break;
							}
						}
						/*for (int i = 0; i < sizeOfList; i++) {
							//TODO: Find a way to insert number into correct sorted order!
							int found = find(i);
							System.out.println("what?");
							if (found > pValueToInsert) {
								insertionPoint = i;
								break;
							}
							
						}*/
						for (int x = sizeOfList; x > insertionPoint; x--) {
							listItems[x] = listItems[x -1];
							intoArray = true;
						}
					}
					if (sizeOfList > 0) {
						if (firstEntry == true) {
							firstEntry = false;
						} else {
								if (listItems[9] > pValueToInsert) {
									//don't insert
									sizeOfList++;
								} else {
									listItems[sizeOfList++] = pValueToInsert;	
								}
							
						}
						if (intoArray == true) {
							listItems[insertionPoint] = pValueToInsert;
							intoArray = false;
						}
					}
				} else {
					System.out
							.println("I'm sorry, but you have reached the maximum size allotted for your list");
				}
			}
		}
	}

	@Override
	public void delete(int pValueToDelete) {
		// finding the first occurrence of the value.
		int positionToDelete = find(pValueToDelete);
		// shifting entire array down where item to delete occurs.
		if (positionToDelete == -1) {
			for (int x = pValueToDelete; x > 0; x-- ) {
				int temp = 0;
				temp = find(pValueToDelete);
				if (temp != -1) {
					positionToDelete = temp;
				}
			}
		} if (positionToDelete == -1) {
			positionToDelete = 0;
		}
		for (int x = positionToDelete; x < (sizeOfList - 1); x++) {
			if (x == (sizeOfList - 1)) {
				sizeOfList--;
			} else {
				listItems[x] = listItems[x + 1];
				// decrementing the size of the list by one.
			}
			if (x == (sizeOfList - 2)) {
				sizeOfList--;
			}
		}
	}

	@Override
	public void deleteAll(int pValueToDelete) {
		if (duplicatesAllowed) {

			// To keep track of amount of items deleted
			int deletionCounter = 0;
			for (int i = 0; i < sizeOfList; i++) {
				// Finding next position we need to delete
				int positionToFind = find(pValueToDelete);
				// Checking if the number we're finding has been detected
				if (positionToFind != -1) {
					// For the element in the array, shift to the left
					for (int g = positionToFind; g < sizeOfList; g++) {
						listItems[g] = listItems[g + 1];
					}
					// Keeping track of items deleted
					deletionCounter++;
				}
			}
			// deleting the additional zeros
			for (int i = 0; i < deletionCounter; i++) {
				--sizeOfList;
			}

			// If no duplicates are allowed, call the delete function to
			// increase efficiency
		} else {
			delete(pValueToDelete);
		}

	}

	@Override
	public void initializeWithRandomData(int pSizeOfList) {
		int randVal = 0;
		int temp = 0;
		int[] randomArray = new int[pSizeOfList * 2];
		int[] answer = new int[pSizeOfList * 2];
		if (duplicatesAllowed == false) {
			if (pSizeOfList == MAX_VALUE) {
				for (int i = 1; i < (pSizeOfList + 1); i++) {
					insert(i);
				}
			}
		} else {
			for (int x = 0; x < (pSizeOfList * 2); x++) {
				randomArray[x] = ((int) (Math.random() * MAX_VALUE + 1));
			}
			// sizeOfList = pSizeOfList;

			for (int x = 0; x < (pSizeOfList * 2); x++) {
				for (int y = x + 1; y < pSizeOfList; y++) {
					if (randomArray[x] > randomArray[y]) {
						temp = randomArray[y];
						randomArray[y] = randomArray[x];
						randomArray[x] = temp;
					}
				}
			}
			for (int j = 0; j < (pSizeOfList -1); j++) {
				int ans = (randomArray[j]);
				insert(ans);
			}
		}

	}

	@Override
	public int find(int pValueToFind) {
		int low = 0;
		int high = sizeOfList - 1;
		while (high >= low) {
			  int mid = (low + high) / 2;
			if (pValueToFind == listItems[mid]) {
				return mid;
			} if (pValueToFind > listItems[mid]) {
				low = mid + 1;
			} if ( pValueToFind < listItems[mid]) {
				high = mid - 1;
			}
		}
		return -1;
	}

	@Override
	public int[] findAll(int pValueToFind) {
		// TODO Auto-generated method stub
		return null;
	}
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(listItems, 0, sizeOfList));
	}
	
	public void bubbleSort() {
		int temp = 0;
		for (int i = 0; i <= sizeOfList; i++) {
			if(listItems[i] >= listItems[i + 1]) {
				temp = listItems[i + 1];
				listItems[i + 1] = listItems[i];
				listItems[i] = temp;
				/*
				 * 7, 2, 42, 5, 14
				 * 7, 2, 5, 42, 13
				 * 7, 2, 5, 13, 42
				 * 
				 * Then, do it again
				 * 
				 * 2, 7, 5, 13
				 * 2, 5, 7, 13
				 */
			}
		}
	}
	
	public void selectionSort() {
		/*
		 * 7, 42, 2, 5, 13
		 * 7, 13, 2, 5, 42
		 * 7, 5, 2, 13, 42
		 */
		
	}
}
