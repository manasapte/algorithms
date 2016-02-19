package trees;

public class Node {
	int data;
	public Node left;
	public Node right;
	
	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
