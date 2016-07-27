package bp;

import java.security.acl.LastOwnerException;
import java.time.LocalDate;

public class Heap implements IHeap {
	// Declaring the root node and the size of the tree
	private Node root;
	private int sizeOfTree = 0;
	int SYSTEM_BASE = 2;
	private Node placeHolder;
	private LocalDate insertValue;

	public boolean isEmpty() {
		// If root isn't filled in, the tree is empty
		return root == null;
	}

	public int getSize() {
		return sizeOfTree;
		// Or, we can treverse the tree
		// placeholder that is called every time insert is called?
	}

	public void clear() {
		root = null;
		sizeOfTree = 0;
	}

	private void trickleDown(Node n) {
		// Setting the temporary value
		LocalDate temp;

		// check to see if there are any nulls
		if (n.getRightChild() == null) {
			if (n.getLeftChild() == null) {
				// Both are null? Then you are finished

				// If left is greater than parent?
			} else if (n.getLeftChild().getDate().isAfter(n.getDate())) {
				// then swap it!
				temp = n.getDate();
				n.setDate(n.getLeftChild().getDate());
				n.getLeftChild().setDate(temp);
				// Then you are done!
			}
			// Don't swap here..you are done
		}
		// What about if the right is bigger than the left?
		else if (n.getRightChild().getDate()
				.isAfter(n.getLeftChild().getDate())) {
			// If the right is bigger than the root?
			if (n.getRightChild().getDate().isAfter(n.getDate())) {
				// swap them!
				temp = n.getDate();
				n.setDate(n.getRightChild().getDate());
				n.getRightChild().setDate(temp);
				// recurrsion is beautiful
				trickleDown(n.getRightChild());
			}
		}
		// If right is NOT bigger than the root, then you are done
		else if (n.getLeftChild().getDate().isAfter(n.getDate())) {
			//swap them
			temp = n.getDate();
			n.setDate(n.getLeftChild().getDate());
			n.getLeftChild().setDate(temp);
			//recursion is beautiful
			trickleDown(n.getLeftChild());
		}
	}

	private Node trickleUp(Node n) {
		LocalDate tempDate = null;
		//calling function itself until node has reached the top
		if (n.getParent() != null) {
			if (insertValue.isAfter(n.getParent().getDate())) {
				n.setDate(n.getParent().getDate());
				//send the parent up again
				n = trickleUp(n.getParent());
			}
		}
		return n;
	}

	public int getCurrentRow() {
		return (int) Math
				.floor(Math.log(getSize() + 1) / Math.log(SYSTEM_BASE));
	}

	// Berkstresser code
	public int rowOnWhichToInsert() {
		return (int) Math
				.floor(Math.log(getSize() + 1) / Math.log(SYSTEM_BASE));
	}

	// Berkstresser code
	public int positionOnRowToInsertZeroBased() {
		return (int) ((getSize() + 1) - Math.pow(SYSTEM_BASE,
				rowOnWhichToInsert()));
	}

	public int getPositionToInsert() {
		return (int) ((getSize()) / Math.pow(2, getCurrentRow()));

	}

	public Node nodeToInsert() {
		Node n = root;

		int binarySearch = getSize() + 1;
		int path;
		while (binarySearch >= 1) {
			path = binarySearch % 2;
			if (path <= 0) {
				if (n.getLeftChild() != null) {
					n = n.getLeftChild();
				} else {
					return n;
				}
			} else {
				if (n.getRightChild() != null) {
					n = n.getRightChild();
				} else {
					return n;
				}
			}
			binarySearch = binarySearch / 2;
		}
		return null;

	}


	public void insert(LocalDate dateToInsert) {
		//Setting the insert value for the trickleDown method
		insertValue = dateToInsert;
		Node insertionNode = new Node(dateToInsert);
		if (isEmpty()) {
			root = new Node(dateToInsert);
			sizeOfTree++;
		} else {
			//Place the node at the last spot
			//Should the left child already be filled, fill the right one!
			if (nodeToInsert().getLeftChild() != null) {
				insertionNode.setParent(nodeToInsert());
				nodeToInsert().setRightChild(insertionNode);
				sizeOfTree++;
				//findLastNode().setParent(nodeToInsert());
				trickleUp(insertionNode);
				//Otherwise, fill the left one!
			} else {
				insertionNode.setParent(nodeToInsert());
				nodeToInsert().setLeftChild(insertionNode);
				sizeOfTree++;
				trickleUp(insertionNode);
			}
		}
		
	}
	
	public Node findLastNode () {
		Node n = root;

		int binarySearch = getSize();
		int path;
		while (binarySearch >= 1) {
			path = binarySearch % 2;
			if (path <= 0) {
				if (n.getLeftChild() != null) {
					n = n.getLeftChild();
				} 
			} else {
				if (n.getRightChild() != null) {
					n = n.getRightChild();
				} 
			}
			binarySearch = binarySearch / 2;
		}
		return n;
	}

	public LocalDate delete() {
		// Step 1: Blow away the root node
		//Step 2: Swap values of root with last node
		//Step 3: Tricke down
				LocalDate lastDate = null;
				if (isEmpty()) {
					System.out.println("Cannot delete an empty tree");
				} else if (getSize() == 1) {
					root = null;
					System.out.println("root deleted");
				} else {
					// 1) move last date to first spot
					lastDate = findLastNode().getDate();
					root.setDate(lastDate);
					// 2) remove the last node
					Node parent = findLastNode().getParent();
					if (parent.getLeftChild() == findLastNode()) {
						parent.setLeftChild(null);
					} else {
						parent.setRightChild(null);
					}
					// 3) trickle down
					trickleDown(root);
				}
				return lastDate;
		
		
		
		
		
		
		
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	private String toString(Node n) {
		if (n == null) {
			return "";
		} else {
			return (toString(n.getLeftChild()) + "," + n.getDate().toString()
					+ "," + toString(n.getRightChild())).replaceAll(",+", ",")
					.replaceAll("^,", "").replaceAll(",$", ""); // "^" is
																// beginning,
																// "$" is end,
																// "+" means one
																// or more
		}

	}

	public String toString() {
		return toString(root);
	}

	public int getMaxDepth(Node root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(getMaxDepth(root.getLeftChild()),
					getMaxDepth(root.getRightChild()));
		}
	}

	public Node getPlaceHolder() {
		return placeHolder;
	}

	public void setPlaceHolder(Node placeHolder) {
		this.placeHolder = placeHolder;
	}
}
