import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Test;

public class RBTTester {
	
	private static RedBlackTree rbt;
	
	@BeforeClass 
	public static void setUp()
	{
		System.out.println("Set Up");
		rbt = new RedBlackTree();
        rbt.insert("D");
        rbt.insert("B");
        rbt.insert("A");
        rbt.insert("C");
        rbt.insert("F");
        rbt.insert("E");
        rbt.insert("H");
        rbt.insert("G");
        rbt.insert("I");
        rbt.insert("J");
	}
	
	@Test
	public void test(){
		System.out.println("Default Test");
        assertEquals("DBACFEHGIJ", makeString(rbt));
        String str=     
        		"Color: 1, Key:D Parent: \n"+
        		"Color: 1, Key:B Parent: D\n"+
			"Color: 1, Key:A Parent: B\n"+
			"Color: 1, Key:C Parent: B\n"+
			"Color: 1, Key:F Parent: D\n"+
			"Color: 1, Key:E Parent: F\n"+
			"Color: 0, Key:H Parent: F\n"+
			"Color: 1, Key:G Parent: H\n"+
			"Color: 1, Key:I Parent: H\n"+
			"Color: 0, Key:J Parent: I\n";
		assertEquals(str, makeStringDetails(rbt));    
    }
	
	@Test
	public void testLookUp()
	{
		System.out.println("Look Up Test");
		RedBlackTree.Node n = rbt.lookup("A");
		assertEquals(n.key, "A");
	}
	
	@Test
	public void testSibling()
	{
		System.out.println("Sibling Test");
		rbt.printTree();
		RedBlackTree.Node n = rbt.lookup("A");
		RedBlackTree.Node m  = rbt.getSibling(n);
		assertEquals(m.key, "C");
	}
	
	@Test
	public void testGetAunt()
	{
		System.out.println("Aunt Test");
		RedBlackTree.Node n = rbt.lookup("C");
		RedBlackTree.Node p = rbt.getAunt(n);
		assertEquals(p.key, "F");
	}
	
	@Test
	public void testGetParent()
	{
		System.out.println("Parent Test");
		RedBlackTree.Node n = rbt.lookup("A");
		RedBlackTree.Node p = rbt.getParent(n);
		assertEquals(p.key, "B");
	}
	
	@Test
	public void testGetGrandParent()
	{
		System.out.println("GrandParent Test");
		RedBlackTree.Node n = rbt.lookup("A");
		RedBlackTree.Node p = rbt.getGrandparent(n);
		assertEquals(p.key, "D");
	}
	
	@Test
	public void testChangeColor()
	{
		System.out.println("Change Color Test");
		RedBlackTree.Node root = rbt.getRoot();
		assertEquals(root.isRed, false);
		rbt.changeToRed(root);
		assertEquals(root.isRed, true);
		rbt.changeToBlack(root);
		assertEquals(root.isRed, false);
	}
	
	@Test
	public void testLeftRotation()
	{
		System.out.println("Left Rotation Test");
		RedBlackTree rbt1 = new RedBlackTree();
		rbt1.insert("P");
		rbt1.insert("N");
		rbt1.insert("Q");
		rbt1.insert("R");
		rbt1.insert("S");
		rbt1.insert("T");
		rbt1.insert("U");
		RedBlackTree.Node root = rbt1.getRoot();
		assertEquals(root.key, "P");
		rbt1.insert("V");
		root = rbt1.getRoot();
		assertEquals(root.key, "R");
	}
	
	@Test
	public void testRightRotation()
	{
		System.out.println("Right Rotation Test");
		RedBlackTree rbt1 = new RedBlackTree();
		rbt1.insert("N");
		rbt1.insert("M");
		rbt1.insert("O");
		rbt1.insert("L");
		rbt1.insert("K");
		rbt1.insert("J");
		rbt1.insert("I");
		RedBlackTree.Node root = rbt1.getRoot();
		assertEquals(root.key, "N");
		rbt1.insert("H");
		root = rbt1.getRoot();
		assertEquals(root.key, "L");
	}
	
	@Test
	public void testCase1ColorChange()
	{
		System.out.println("Case 1 Test");
		RedBlackTree rbt = new RedBlackTree();
		rbt.insert("C");
		rbt.insert("B");
		rbt.insert("D");
		RedBlackTree.Node root = rbt.getRoot();
		assertEquals(root.leftChild.isRed, true);
		assertEquals(root.rightChild.isRed, true);
		rbt.insert("A");
		assertEquals(root.leftChild.isRed, false);
		assertEquals(root.rightChild.isRed, false);
		assertEquals(root.isRed, false);
	}
	
	@Test 
	public void dictionaryTest1()
	{
		System.out.println("Dictionary Test 1");
		RedBlackTree RBTree = new RedBlackTree();			
		RBFileLoader rbtFileLoader = new RBFileLoader(RBTree);
		rbtFileLoader.createDictFromFile();
		rbtFileLoader.printDictCount();
		RedBlackTree.Node n = RBTree.lookup("glutoid"); //Word in dictionary
		assertEquals(n.key, "glutoid");
		n = RBTree.lookup("glyptography");
		assertEquals(n.key, "glyptography");
		n = RBTree.lookup("Omid"); //Word not in dictionary
		assertEquals(n, null);
	}
	
	@Test 
	public void dictionaryTest2()
	{
		System.out.println("Dictionary Test 2");
		RedBlackTree RBTree = new RedBlackTree();			
		RBFileLoader rbtFileLoader = new RBFileLoader(RBTree);
		rbtFileLoader.createDictFromFile();
		
		File currentDir = new File(".");
	    File parentDir = currentDir.getParentFile();
	    File newFile = new File(parentDir,"dictionary.txt");
	    
	    try(BufferedReader br = new BufferedReader(new FileReader(newFile))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    RedBlackTree.Node n = RBTree.lookupNoTimer(line);
		    assertEquals(n.key, line);
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		        if(line != null)
		        {
		        	 	n = RBTree.lookupNoTimer(line);
		        	 	assertEquals(n.key, line);	
		        }		        
		    }	    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	

	}

    public static String makeString(RedBlackTree t)
    {
       class MyVisitor implements RedBlackTree.Visitor {
          String result = "";
          public void visit(RedBlackTree.Node n)
          {
             result = result + n.key;
          }
       }
       MyVisitor v = new MyVisitor();
       t.preOrderVisit(v);
       return v.result;
    }

    public static String makeStringDetails(RedBlackTree t) {
    	{
    	       class MyVisitor implements RedBlackTree.Visitor {
    	          String result = "";
    	          public void visit(RedBlackTree.Node n)
    	          {
    	        	  if(!(n.key).equals(""))
    	        		  
    	        		  result = result +"Color: "+n.color+", Key:"+n.key+" Parent: "+n.parent.key+"\n";
    	          }
    	       };
    	       MyVisitor v = new MyVisitor();
    	       t.preOrderVisit(v);
    	       return v.result;
    	 }
    }

}
