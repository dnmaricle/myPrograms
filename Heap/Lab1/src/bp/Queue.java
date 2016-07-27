package bp;

public class Queue implements IQueue {
	
	//instantiating values
	private int maxSize = 0;
	private int maxValue = 0;
	private int sizeOfList = 0;
	private Data[] queArray;
	private int nItems = 0;
	private boolean priority;
	//Constructor
	public Queue (int pValue) {
			maxSize = pValue;
			//sizeOfList = pValue;
			queArray = new Data[maxSize];

			nItems = 0;
	}
/*
 * For testing:
 * 	Check what happens when you remove from empty
 *  add when full
 *  	also make sure order is correct*/
	//Returns true is the queue is full
	public boolean isFull() {
		return (maxSize == sizeOfList);
	}

	
	public int getSize() {
		return sizeOfList;
	}

	
	public int getCapacity() {
		return maxSize;
	}

	
	public boolean isPriorityQueue() {
		return priority;
	}

	
	public void setPriorityQueue(boolean pIsPriorityQueue) {
		priority = pIsPriorityQueue;
		
	}

	
	public void clear() {
		sizeOfList = 0;
		
	}

	// insert
	public void enqueue(Data dataItem) {
		int i = 0;
		if (isFull()) {
			System.out.println("Cannot complete request. Stack is full.");
		} else {
			// check priority
			if (isPriorityQueue()) {
				if (sizeOfList == 0) {
					queArray[sizeOfList++] = dataItem;
				} else {
					for (i = sizeOfList - 1; i <= sizeOfList; i--) {
						if (dataItem.priority <= queArray[i].priority) {
							queArray[i + 1] = queArray[i];
						} else if (dataItem.priority == queArray[i].priority){
							queArray[i + 1]  = queArray[i];
						} else {
							break;
						}
					}
					//after moving all that fancy stuff, insert it
					queArray[i + 1] = dataItem;
					sizeOfList++;
				}
			} else {
				if (isFull()) {
					System.out.println("Cannot complete request. Stack is full.");
					
				} else {
				  queArray[sizeOfList++] = dataItem;
				}
				//check if full
				//rear = -1
				//pre-increment
			}
			// Check to make sure the list isn't full
			// Check the priority
			/*
			 * if it if it isn't priority, just add it
			 * 
			 * if it is priority check to see if list is empty, if empty fill it
			 */
		}
	}
	//Take item from front of queue
	public Data dequeue() {
		
		// if size of list does not == 0
		if (sizeOfList != 0) {
			Data temp = queArray[0];
			for (int i = 0; i < (sizeOfList - 1); i++) {
				queArray[i] = queArray[i + 1];
			}
			sizeOfList--;
			return temp;
		} else {
			return null;
		}
		//Get value and increment front
		// 
		
			//return temp;
		// else return null
		
	}

	
	public Data peek() {
		return queArray[sizeOfList -1];
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < sizeOfList; i++) {
			sb.append(queArray[i]);
			sb.append(",");
		}
		//remove trailing comma
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
