package bp;

import bp.UnsortedList;
import bp.SortedList;

public class Stack implements IStack {

	// instantiating data types
	private final int MAX_VALUE = 10;
	private int MAX_SIZE = 10000;
	private int sizeOfList = 0;
	private Data[] listItems = new Data[MAX_SIZE];

	public Stack(int s) {
		MAX_SIZE = s;
	}

	public boolean isFull() {
		return false;
	}

	public int getSize() {
		return sizeOfList;
	}

	public int getCapacity() {
		return MAX_VALUE;
	}

	public void clear() {
		sizeOfList = 0;

	}

	public void push(Data dataItem) {
		if (isFull() == true) {
			System.out.println("Task cannot be completed. Stack is full");
		} else {
			listItems[sizeOfList++] = dataItem;
		}
	}

	public Data pop() {
		
		if (sizeOfList != 0) {
			return listItems[--sizeOfList];
		} else {
			System.out.println("There's nothing to delete here.");
		}
		
		return null;
	}

	public Data peek() {
		if (sizeOfList == 0) {
			return null;
		} else {			
			return listItems[sizeOfList - 1];	
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < sizeOfList; i++) {
				sb.append(listItems[i]);
				sb.append(",");
		}
		//remove trailing comma
		if (sb.length() > 0) {
				sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
