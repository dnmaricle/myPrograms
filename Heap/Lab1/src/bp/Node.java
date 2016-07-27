package bp;

import java.time.LocalDate;

public class Node implements IBinaryTreeNode {
	private LocalDate date;
	private Node leftChild;			//this node's left child
	private Node rightChild; 		//this node's right child
	private Node parent;
	public Node(LocalDate dateToInsert) {
		date = dateToInsert;
	}

	public LocalDate getDate() {
		return date;
	}

	
	public void setDate(LocalDate pDate) {
		date = pDate;
		
	}

	
	public Node getLeftChild() {
		return leftChild;
	}

	
	public void setLeftChild(Node pLeftChild) {
		leftChild = pLeftChild;
		
	}

	
	public Node getRightChild() {
		return rightChild;
	}

	
	public void setRightChild(Node pRightChild) {
		rightChild = pRightChild;
		
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node pParent) {
		parent = pParent;
	}
}
