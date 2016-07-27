package bp;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Arrays;

public class UnsortedList implements IUnsortedList {
	public final int MAX_SIZE = 10000;
	public final int MAX_VALUE = 10;

	private int sizeOfList = 0;
	private boolean duplicatesAllowed = true;
	private int[] listItems = new int[MAX_SIZE];

	// private int[] foundItem = new int [MAX_SIZE];
	// private int foundItemSizeOfList = 0;
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
		// If duplicates are allowed, select random variable
		if (duplicatesAllowed) {
			// place the value in the last index and increment the size of list
			if (sizeOfList < MAX_SIZE) {
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
					listItems[sizeOfList++] = pValueToInsert;
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
		for (int x = positionToDelete; x < (sizeOfList - 1); x++) {
			listItems[x] = listItems[x + 1];
		}
		// decrementing the size of the list by one.
		sizeOfList = sizeOfList - 1;
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
		if (pSizeOfList > MAX_SIZE) {
			pSizeOfList = MAX_SIZE;
			System.out.println("List too long. Resized to accomodate");

		} else {
			sizeOfList = pSizeOfList;
		}
		//If duplicates are allowed, simply insert in random values to fill array
		if (duplicatesAllowed) {
			for (int i = 0; i < pSizeOfList; ++i) {
				listItems[i] = (int) (Math.random() * MAX_VALUE + 1);
			}
			//Should dups not be allowed, find unique value for entire array	
		} else {
			sizeOfList = pSizeOfList;
			for (int n = 0; n < pSizeOfList; ++n) {
				int newValue = (int) (Math.random() * MAX_VALUE + 1);
				while (find(newValue) > -1) {
					/* Preventing infinite loop should # of allocated slots be bigger than
					 the # of values available when dups are not allowed*/
					if (sizeOfList > MAX_VALUE) {
						newValue = (int) (Math.random() * pSizeOfList + 1);
					} else {
						newValue = (int) (Math.random() * MAX_VALUE + 1);	
					}
				}
				listItems[n] = newValue;
			}
		}
	}

	@Override
	public int find(int pValueToFind) {
		// iterating through to find first occurrence of item
		for (int x = 0; x < sizeOfList; x++) {
			if (pValueToFind == listItems[x]) {
				return x;
			}
		}
		// If the function cannot find value, return default value
		return -1;
	}

	@Override
	public int[] findAll(int pValueToFind) {
		int[] foundItem = new int[sizeOfList];
		if (duplicatesAllowed) {
			// Keeping track of location in array foundItem
			int j = 0;
			// iterating through to find all occurrence of item
			for (int i = 0; i < sizeOfList; i++) {
				if (listItems[i] == pValueToFind) {
					// Item found? Put into the foundItem array
					foundItem[j] = i;
					// incrementing variable as values are found to put into
					// array
					j++;
				}
			}
			if (j > 0) {
				// trimming the array to size
				return Arrays.copyOf(foundItem, j);
			} else {
				// no values were found...return an empty array
				return new int[0];
			}
			//Should duplicates not be allowed, call the find function to increase efficiency		
		} else {
			foundItem[0] = find(pValueToFind);
			return foundItem;
		}

	}

	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(listItems, 0, sizeOfList));
	}

	public void bubbleSort() {
		int temp = 0;
		for (int i = 0; i < sizeOfList; i++) {
			for(int j = 0; j < sizeOfList; j++) {
				if (listItems[j + 1] < listItems[j]) {
					temp = listItems[j + 1];
					listItems[j + 1] = listItems[j];
					listItems[j] = temp;
				}
			}
		}
	}


	public void selectionSort() {
		int temp = 0;

		//circulate through entire array
		for (int i = 0; i < sizeOfList; i++) { 
			int indexOfLargest = 0;
				for (int y = 0; y < (sizeOfList - i); y++) {
					if (listItems[y] > listItems[indexOfLargest]) {
						indexOfLargest = y;
				}
					
			}
				//Swap sizeofList-1-i with listItems[LargestIndex]
				temp = listItems[indexOfLargest];
				listItems[indexOfLargest] = listItems[sizeOfList -1 - i];
				listItems[sizeOfList - 1 - i] = temp;
		}
	}
}
