
public class RedBlackTree {

	RedBlackTree.Node root; 
	RedBlackTree.Node nilNode;
	public long startTime;

	public class Node { //changed to static 
		
		  String key;  		  
		  Node parent;
		  Node leftChild;
		  Node rightChild;
		  boolean isRed;
		  int color;
		  
		  public Node(String data){
			  this.key = data;
		  }		
		  
		  public int compareTo(Node n){ 	
		 		return key.compareTo(n.key);
		  }
		  
		  public boolean isLeaf(){
			  if (this.equals(root) && this.leftChild == null && this.rightChild == null) return true;
			  if (this.equals(root)) return false;
			  if (this.leftChild == null && this.rightChild == null){
				  return true;
			  }
			  return false;
		  }
	}
	
	private void setRoot(String data)
	{
		nilNode = new Node("");
		changeToBlack(nilNode);
		
		root = new Node(data);
		changeToRed(root);
		
		root.parent = nilNode;
		root.leftChild = nilNode;
		root.rightChild = nilNode;
		
	}
	
	 public boolean isLeaf(RedBlackTree.Node n){
		  if (n.equals(root) && n.leftChild == null && n.rightChild == null) return true;
		  if (n.equals(root)) return false;
		  if (n.leftChild == null && n.rightChild == null){
			  return true;
		  }
		  return false;
	  }
	
	public interface Visitor{
		/**
		This method is called at each node.
		@param n the visited node
		*/
		void visit(Node n);  
	}
	
	public void visit(Node n){
		System.out.println(n.key);
	}
	
	public void printTree(){  //preorder: visit, go left, go right
		RedBlackTree.Node currentNode = root;
		System.out.println("");
		traverseTree(currentNode);
		System.out.println("");
	}
	
	private void traverseTree(RedBlackTree.Node currentNode)
	{
		if(currentNode.leftChild != nilNode)
		{
			traverseTree(currentNode.leftChild);
		}
		
//		System.out.println("Key: " + currentNode.key + " Parent: " + currentNode.parent.key + " Left: "+ currentNode.leftChild.key + " Right: " + currentNode.rightChild.key);
		
		System.out.print(currentNode.key);
		
		if(currentNode.rightChild != nilNode)
		{
			traverseTree(currentNode.rightChild);
		}
	}
	
	public void printTree(RedBlackTree.Node node){
		System.out.print(node.key);
		if (node.isLeaf()){
			return;
		}
		printTree(node.leftChild);
		printTree(node.rightChild);
	}	
	
	public void insert(String data){
		
		if(root == null)
		{
			setRoot(data);
		}
		else
		{	
			Node z = new Node(data);
			Node y = nilNode;
			Node x = root;
			while(x != nilNode)
			{
				y = x;
				if(z.key.compareTo(x.key)<0)
				{
					x = x.leftChild;
				}
				else
				{
					x = x.rightChild;
				}
			}
			
			z.parent = y;
			
			if(z.key.compareTo(y.key)<0)
			{
				y.leftChild = z;
			}
			else
			{
				y.rightChild = z;
			}
			
			z.leftChild = nilNode;
			z.rightChild = nilNode;
			changeToRed(z);
			fixTree(z);
		}
	}
	
	public RedBlackTree.Node lookup(String k){ 
			
		setStartTime();
		Node result = null;
		
		if(k.compareTo(root.key) > 0)
		{
			result =  search(k, root.rightChild);
		}
		else if(k.compareTo(root.key) < 0)
		{
			result = search(k, root.leftChild);
		}
		else if(k.equals(root.key))
		{
			result = root;
		}
					
		if(result == null)
		{
			duration();
			System.out.println("Unable to locate");
		}
		else
		{
			duration();
		}
		
		return result;
	}
	
	public RedBlackTree.Node lookupNoTimer(String k){ 
		
		Node result = null;
		
		if(k.compareTo(root.key) > 0)
		{
			result =  search(k, root.rightChild);
		}
		else if(k.compareTo(root.key) < 0)
		{
			result = search(k, root.leftChild);
		}
		else if(k.equals(root.key))
		{
			result = root;
		}
					
		if(result == null)
		{
			System.out.println("Unable to locate");
		}
		
		return result;
	}
	
	private RedBlackTree.Node search(String k, Node currentNode)
	{
		if(k.compareTo(currentNode.key) > 0)
		{
			if(currentNode.rightChild != nilNode)
			{
				return search(k, currentNode.rightChild);
			}
			else
			{
				return null;
			}
		}
		else if(k.compareTo(currentNode.key) < 0)
		{
			if(currentNode.leftChild != nilNode)
			{
				return search(k, currentNode.leftChild);
			}
			else
			{
				return null;
			}
		}
		return currentNode;
	}
 	
	
	public RedBlackTree.Node getSibling(RedBlackTree.Node n){
		
		RedBlackTree.Node parent = n.parent;
		if(parent.leftChild == n)
		{
			return parent.rightChild;
		}
		
		return parent.leftChild;
		//
	}
	
	
	public RedBlackTree.Node getAunt(RedBlackTree.Node n){
		
		if(n.parent.parent != nilNode && n.parent.parent.leftChild == n.parent)
		{
			return n.parent.parent.rightChild;
		}
		else if(n.parent.parent != nilNode && n.parent.parent.rightChild == n.parent)
		{
			return n.parent.parent.leftChild;
		}
		
		return null;
	}
	
	public RedBlackTree.Node getGrandparent(RedBlackTree.Node n){
		
		if(n.parent.parent != nilNode)
		{
			return n.parent.parent;
		}
		return null;
	}
	
	public RedBlackTree.Node getParent(RedBlackTree.Node n){
		
		if(n.parent != nilNode)
		{
			return n.parent;
		}
		return null;
	}
	
	public void rotateLeft(RedBlackTree.Node x){
	
		Node y = x.rightChild;
		x.rightChild = y.leftChild;
		if(y.leftChild != nilNode)
		{
			y.leftChild.parent = x;
		}
		y.parent = x.parent;
		if(x.parent == nilNode)
		{
			root = y;
		}
		else if(x.parent == x.parent.leftChild)
		{
			x.parent.leftChild = y;
		}
		else
		{
			x.parent.rightChild = y;
		}
		
		y.leftChild = x;
		x.parent = y;
	}
	
	public void rotateRight(RedBlackTree.Node x){
		
		Node y = x.leftChild;
		x.leftChild = y.rightChild;
		if(y.rightChild != nilNode)
		{
			y.rightChild.parent = x;
		}
		y.parent = x.parent;
		if(x.parent == nilNode)
		{
			root = y;
		}
		else if(x.parent == x.parent.rightChild)
		{
			x.parent.rightChild = y;
		}
		else
		{
			x.parent.leftChild = y;
		}
		
		y.rightChild = x;
		x.parent = y;
	}
	
	public void fixTree(RedBlackTree.Node z) {
		while(z.parent.isRed)
		{
			if(z.parent == z.parent.parent.leftChild)
			{
				Node y = z.parent.parent.rightChild;
				if(y.isRed)
				{
					changeToBlack(z.parent);
					changeToBlack(y);
					changeToRed(z.parent.parent);
					z = z.parent.parent;
				}
				else if(z == z.parent.rightChild)
				{
					z = z.parent;
					rotateLeft(z);
				}
				else
				{
					changeToBlack(z.parent);
					changeToRed(z.parent.parent);
					rotateRight(z.parent.parent);
				}
			}
			else if(z.parent == z.parent.parent.rightChild)
			{
				Node y = z.parent.parent.leftChild;
				if(y.isRed)
				{
					changeToBlack(z.parent);
					changeToBlack(y);
					changeToRed(z.parent.parent);
					z = z.parent.parent;
				}
				else if(z == z.parent.leftChild)
				{
					z = z.parent;
					rotateRight(z);
				}
				else
				{
					changeToBlack(z.parent);
					changeToRed(z.parent.parent);
					rotateLeft(z.parent.parent);
				}
			}
			changeToBlack(root);
		}	
	}
	
	public void changeToBlack(RedBlackTree.Node n)
	{
		n.color = 1;
		n.isRed = false;
	}
	
	public void changeToRed(RedBlackTree.Node n)
	{
		n.color = 0;
		n.isRed = true;
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	public boolean isEmpty(RedBlackTree.Node n){
		if (n.key == null){
			return true;
		}
		return false;
	}
	 
	public boolean isLeftChild(RedBlackTree.Node parent, RedBlackTree.Node child)
	{
		if (child.compareTo(parent) < 0 ) {//child is less than parent
			return true;
		}
		return false;
	}

	public void preOrderVisit(Visitor v) {
	   	preOrderVisit(root, v);
	}
	 
	private static void preOrderVisit(RedBlackTree.Node n, Visitor v) {
	  	if (n == null) {
	  		return;
	  	}
	  	v.visit(n);
	  	preOrderVisit(n.leftChild, v);
	  	preOrderVisit(n.rightChild, v);
	}
	
	public void setStartTime()
	{
		this.startTime = System.currentTimeMillis();
	}
	
	public void duration()
	{
		System.out.println("Time to look up: " + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	
}
