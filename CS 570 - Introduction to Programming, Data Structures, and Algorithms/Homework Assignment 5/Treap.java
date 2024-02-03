/***
 * Assignment : Homework Assigment 5
 * Name: Harsh Patel
 * Course: CS-570
 */

import java.util.Random;
import java.util.Stack;

public class Treap<E extends Comparable<E>> {
    private static class Node<E> {

		// Data fields
		public E data; // key for the search
		public int priority; // random heap priority
		public Node<E> left;
		public Node<E> right;

		// Constructors
		/**
		 * Constructor for Node of data of generic type E and priority of type int
		 * @param data data of type E for the Node to be constructed with
		 * @param priority ranks the priority of the Node for placement within the heap
		 */
		public Node(E data, int priority) {
			if (data == null) {
				throw new NullPointerException("Data field value is null");
			}

            this.data = data;
			this.priority = priority;
			this.left = null;
			this.right = null;
		}

		/**Method
		 * Performs Right rotation 
		 * @returns The root node of result tree
		 */
        public Node<E> rotateRight(){
			Node<E> rootNode = new Node<E>(data, priority);
			if(this.left!=null){
				rootNode.left = this.left.right;
				rootNode.right = this.right;
				this.priority = this.left.priority;
				this.data = this.left.data;			
				this.left = this.left.left;
				this.right = rootNode;
			}
			return this;
		}

		/**Method
		 * Performs Left Rotation
		 * @returns The root node of result tree
		 */
		public Node<E> rotateLeft(){
			Node<E> rootNode = new Node<E>(data, priority);
			if(this.right!=null)
			{
				rootNode.left = this.left;
				rootNode.right = this.right.left;
				this.priority = this.right.priority;
				this.data = this.right.data;				
				this.right = this.right.right;
				this.left = rootNode;
			}
			return this;
		}
        public String toString() {
            String result = "(key=" + data + ", priority=" + priority + ")";
            return result;
        }
    }
    
    private Random priorityGenerator;
	private Node<E> root;

	// Constructors
	/**
	 * Constructs empty Treap
	 */
	public Treap() {
		this.priorityGenerator = new Random();
		this.root = null;
	}

	/**
	 * Constructs empty treap with a seed
	 * @param seed
	 */
	public Treap(long seed) {
		this.priorityGenerator = new Random(seed);
		this.root = null;
	}

	/**Method
	* Performs add operation 
	* @returns true if it modifies the tree else false
	*/
    public boolean add(E key) {
		return add(key, priorityGenerator.nextInt());
	}

    public boolean add(E key, int priority)
	{
		Node<E > newNode = new Node<E>(key, priority);
		Node<E > tempRoot = root;
		Stack<Node> stack = new Stack<Node>();
		if(root==null)
		{
			root = new Node(key, priority);
			return true;
		}
		if(find(key)){
			return false;
		}
		while(tempRoot!=null)
		{
			stack.push(tempRoot);
			if((key.compareTo(tempRoot.data)) < 0)
				tempRoot = tempRoot.left;
			else
				tempRoot = tempRoot.right;
		}
		
		if((key.compareTo((E)stack.peek().data)) < 0)	
			stack.peek().left = newNode;
		else
		{		
			stack.peek().right = newNode;			
		}
		stack.push(newNode);
		reheap(stack);
		return true;
	}

	/**Method
	 * Helper function to arrange tree as per max-heap
	 * @param stack Arranging Stack of nodes
	 */
	private void reheap(Stack<Node> stack){
		// TODO Auto-generated method stub
		Node<E> child = stack.pop();
		Node<E> parent = stack.pop();
		while(parent!= null && child.priority > parent.priority)
		{
			if((child.data.compareTo(parent.data)) > 0)
				parent.rotateLeft();
			else
				parent.rotateRight();
			if(!stack.isEmpty())
				parent = stack.pop();
			else
				parent = null;
		}
	}
	
	/**Method
	* Performs delete operation 
	* @returns true if it modifies the tree else false
	*/
    public boolean delete(E key){
		Node<E> nodeFound = null ;
		Node<E> lastParent = null;
		Node<E> tempRoot = null;
		if (find(key) == false || root==null)
			return false;
		else
		{
			while(root!= null)
			{
				if((key.compareTo(root.data)) > 0){
					tempRoot = root;
					root = root.right;
				}
				else if(key.compareTo(root.data) < 0){
					tempRoot = root;
					root = root.left;
				}
				else{
					nodeFound = root;
					break;
				}
			}
			while((nodeFound.right!=null)||(nodeFound.left!=null))
			{
				
				if(nodeFound.left == null)
				{
					lastParent = nodeFound.rotateLeft();
					nodeFound = lastParent.left;
				}
				else if(nodeFound.right==null )
				{
					lastParent = nodeFound.rotateRight();
					nodeFound = lastParent.right;
				}
				else if(nodeFound.left.priority > nodeFound.right.priority)
				{
					lastParent = nodeFound.rotateRight();
					nodeFound = lastParent.right;
				}
				else if (nodeFound.left.priority < nodeFound.right.priority)
				{
					lastParent = nodeFound.rotateLeft();
					nodeFound = lastParent.left;
				}
			}	
			if(lastParent == null)
				lastParent = root;
			if((lastParent.left!= null)&&(lastParent.left.data.compareTo(key))==0)
				lastParent.left = null;
			else
			{
				lastParent.right = null;
			}
			return true;
			}
        }

    public boolean find(E key) {
            if(key==null) {
                throw new NullPointerException("Key cannot be null");
            }
            return find(this.root, key);
            }
        
    /**
    * Recursive helper function for find
    * @param root
    * @param key
    * @return boolean on the success of the operation
    */
    private boolean find(Node<E> root, E key) {
        if(root != null) {
            if(root.data.compareTo(key) == 0) {
                return true;
                }
            if(root.data.compareTo(key) < 0) {
                return find(root.right, key);
                    }
            return find(root.left, key);
            } 
		else {
			return false;
            }
        }

    /**
	 * Returns string value of tree
	 * @return String value of the tree
	 */
	public String toString(){
		StringBuilder strbuild = new StringBuilder();
		return getPreOrderTraverse(root, 1, strbuild);
	}
	
	/**
	 * Gets the tree in pre-order form
	 * @param node Takes the root as a node
	 * @param depth Takes the level of the starting node/root
	 * @param sb StringBuilder object to build a string for the tree
	 * @return
	 */
	private String getPreOrderTraverse(Node<E>node, int depth, StringBuilder strbuild){
		// TODO Auto-generated method stub
		for(int i=1; i< depth; i++){
			strbuild.append("  ");
		}		
		if(node==null)
			strbuild.append("null\n");
		else{
			strbuild.append("(key="+node.data+",priority="+node.priority+")\n");
			getPreOrderTraverse(node.left, depth + 1,strbuild);
			getPreOrderTraverse(node.right, depth + 1,strbuild);
		}
		return strbuild.toString();
		}

	//Main class
    public static void main(String[] args) {
        System.out.println("TEST CASE 1\n");
		Treap<Integer> testTree = new Treap < Integer >();
		//Test Case already given
		testTree.add(4,19);
		testTree.add(2,31);
        testTree.add(6,70);
        testTree.add(1,84);
        testTree.add(3,12);
        testTree.add(5,83);
        testTree.add(7,26);
        System.out.println(testTree.toString());
        System.out.println("Find node with key '6'? "+ testTree.find(6));
        System.out.println("Find node with key '16'? "+ testTree.find(16));
        System.out.println("Delete when key '6' exists, so boolean result is: "+ testTree.delete(6));
        System.out.println("Delete when key '16' exists, so boolean result is: "+ testTree.delete(16));
        System.out.println("Find node with key '6' after deleting? "+ testTree.find(6));
        //System.out.println(testTree.toString());
        System.out.println("\n\n\nTEST CASE 2\n");
        Treap<Character> testTree2 = new Treap<Character>();
        //Test Case already given
        testTree2.add('p',99);
        testTree2.add('g',80);
        testTree2.add('u',75);
        testTree2.add('a',60);
        testTree2.add('j',65);
        testTree2.add('r',40);
        testTree2.add('z',47);
        testTree2.add('w',32);
        testTree2.add('v',21);
        testTree2.add('x',25);
        System.out.println(testTree2.toString());
        testTree2.add('i',93);
        System.out.println("Delete when key with 'z' exists and so the boolean result is: "+ testTree2.delete('z') +"\n");
        System.out.println(testTree2.toString());
	}
}
