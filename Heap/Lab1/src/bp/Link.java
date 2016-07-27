package bp;

public class Link {
	//instantiating values
	private Data myData;
	private Link next;
	private Link previous;
	
	//TODO: insert link constructor
	public Link (Data dataToInsert) {
		myData = dataToInsert;
	}
	
	
	//assessor for myData
	public Data getMyData() {
		return myData;
	}
	//mutator for myData
	public void setMyData(Data myData) {
		this.myData = myData;
	}
	//assessor for next
	public Link getNext() {
		return next;
	}
	//mutator for next
	public void setNext(Link next) {
		this.next = next;
	}
	//assessor for previous
	public Link getPrevious() {
		return previous;
	}
	//mutator for previous
	public void setPrevious(Link previous) {
		this.previous = previous;
	}
}
