package bp;

public class LinkedList {
//Instantiating values
	private Link first;
	private Link last;
	private Data myData;
	
	public void Link(Data dataToInsert) {
		myData = dataToInsert;
	}

	public boolean isEmpty() {
		//Should first be null, last better be null
		//Hence, the list is indeed empty
		return first == null;
	}
	
	public void clear() {
		//clearing the pointers out
		//Thus, clearing the list
		first = null;
		last = null;
	}
	
	public int getSize() {
		int runningTotal = 0;
		if (isEmpty()) {
			return 0;
		} else {
			runningTotal = 1;
			Link myLink = first;
			while (myLink.getNext() != null) {
				runningTotal += 1;
				myLink = myLink.getNext();
			}
		}
		return runningTotal;
	}
	
	public Link getFirst() {
		return first;
	}

	public void setFirst(Link first) {
		this.first = first;
	}

	public Link getLast() {
		return last;
	}

	public void setLast(Link last) {
		this.last = last;
	}
	
	public void insertLeft(Link linkToInsert) {
		if (isEmpty()) {
			//put link into the first slot!
			first = linkToInsert;
			last = linkToInsert;
		} else {
			//insert into the next available link
			Link oldFirst = first;
			first = linkToInsert;
			first.setNext(oldFirst);
			oldFirst.setPrevious(first);
		}
	}
		
		public void insertLeft(Data dataToInsert) {
			Link linkToInsert = new Link(dataToInsert);
			insertLeft(linkToInsert);
		}
		
		public void insertRight(Data dataToInsert) {
			
		}
		
		public Data removeLeft() {
			if (isEmpty()) {
				return new Data(-1);
			}
			Data dataToReturn = first.getMyData();
			first = first.getNext();
			first.setPrevious(null);
			return dataToReturn;
		}
		
		public Data removeRight() {
			if (isEmpty()) {
				return new Data(-1);
			}
			if (getSize() == 1) {
				Data dataToReturn = last.getMyData();
				first = null;
				last = null;
				return dataToReturn;
			}
			Data dataToReturn = last.getMyData();
			last = last.getPrevious();
			last.setNext(null);
			return dataToReturn;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			if (isEmpty()) {
				return "";
			}
			Link myLink = first;
			sb.append(first.getMyData().value + ", ");
			while (myLink.getNext() != null) {
				myLink = myLink.getNext();
				sb.append(myLink.getMyData().value + ", ");
			}
			//remove trailing comma
			if (sb.length() > 0) {
				sb.deleteCharAt(sb.length() - 2);
			}
			return sb.toString();
		}
}
