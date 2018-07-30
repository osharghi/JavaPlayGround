
public class RedBlackDemo {

	public static void main(String[] args) {
		
		RedBlackTree RBTree = new RedBlackTree();			
		RBFileLoader rbtFileLoader = new RBFileLoader(RBTree);
		rbtFileLoader.createDictFromFile();
		rbtFileLoader.printDictCount();
		RedBlackTree.Node n = RBTree.lookup("glutoid"); //Word in dictionary
		if(n!=null)
		{
			System.out.println(n.key);
		}
		n = RBTree.lookup("Omid"); //Word not in dictionary
		if(n!=null)
		{
			System.out.println(n.key);
		}
	}
}
