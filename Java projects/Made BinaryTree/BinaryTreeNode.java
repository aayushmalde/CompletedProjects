import javax.xml.soap.Node;

/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 * 
 * @author YOURID
 * @param <Comparable> The type of data this tree node stores
 */
public class BinaryTreeNode<T extends Comparable<T>> {

	/**
	 * Reference pointer to the left subtree
	 */
	private BinaryTreeNode<T> left;

	/**
	 * Reference pointer to the right subtree
	 */
	private BinaryTreeNode<T> right;

	/**
	 * Data stored at this node
	 */
	private T data;

	/**
	 * Default Constructor
	 * 
	 * Creates a binary tree node with null data and null children
	 */
	public BinaryTreeNode() {
		this(null, null, null);
	}

	/**
	 * Data-only Constructor
	 * 
	 * Creates a binary tree node with the given data and null children
	 * 
	 * @param theData The data to store at this node
	 */
	public BinaryTreeNode(T theData) {
		this(theData, null, null);
	}

	/**
	 * Full Constructor
	 * 
	 * Creates a binary tree node with the given data and child reference pointers
	 * 
	 * @param theData    The data to store at this node
	 * @param leftChild  A reference pointer to the left subtree
	 * @param rightChild A reference pointer to the right subtree
	 */
	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	/**
	 * Left Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the left subtree
	 */
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	/**
	 * Left Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new left subtree's root node
	 */
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	/**
	 * Right Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the right subtree
	 */
	public BinaryTreeNode<T> getRight() {
		return right;
	}

	/**
	 * Right Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new right subtree's root node
	 */
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	/**
	 * Get the data at this node
	 * 
	 * @return The data stored at this node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set the data at this node
	 * 
	 * @param data The data to be stored at this node
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return null;
	}

	public int size() {
		int size = 1;
		if (left != null) {
			size += left.size();
		}
		if (right != null) {
			size += right.size();
		}
		return size;
	}

	public int height() {

		if (this.data == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			if (this.getLeft() == null && this.getRight() == null) {
				return 1;
			}
			if (this.getLeft() == null && this.getRight() != null) {
				return right.height() + 1;
			}
			if (this.getRight() == null && this.getLeft() != null) {
				return left.height() + 1;
			}

			int lDepth = this.getLeft().height();
			int rDepth = this.getRight().height();

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	/**
	 * Main method
	 * 
	 * For main method testing, etc
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {

	}

	public boolean find(T value) {
		if (value.equals(data))
			return true;
		else if (value.compareTo(data) < 0) {
			if (left == null)
				return false;
			else
				return left.find(value);
		} else if (value.compareTo(data) > 0) {
			if (right == null)
				return false;
			else
				return right.find(value);
		}
		return false;
	}

	public boolean insert(T value) {

		if (this.data == null) {
			this.data = value;
			return true;
		} else {

			if (value.compareTo(this.data) < 0) {
				if (this.getLeft() == null) {
					this.left = new BinaryTreeNode<T>(value);
					return true;
				} else {
					return left.insert(value);
				}
			} else if (value.compareTo(this.data) > 0) {
				if (this.getRight() == null) {
					this.right = new BinaryTreeNode<T>(value);
					return true;
				} else {
					return right.insert(value);
				}
			}
		}

		return false;
	}

	public String inOrder() {
		String result = "";

		if (left != null) {
			result = result + left.inOrder();
		}
		if (this.data != null) {
			result = result + "(" + this.getData() + ")";
		}
		if (right != null) {
			result = result + right.inOrder();
		}

		return result;
	}

	public String postOrder() {
		String result = "";
		if (left != null) {
			result = result + left.postOrder();
		}

		if (right != null) {
			result = result + right.postOrder();
		}
		if (this.data != null) {
			result = result + "(" + this.getData() + ")";
		}

		return result;
	}

}
