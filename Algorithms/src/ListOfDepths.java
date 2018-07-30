import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {

	ListOfDepths()
	{
		BinaryTreeCreator btc = new BinaryTreeCreator();
		BinaryTreeNode root = btc.root;
		ArrayList<LinkedList<BinaryTreeNode>> results = getlistsOfDepth(root);
		printResults(results);
	}
	
	ArrayList<LinkedList<BinaryTreeNode>> getlistsOfDepth(BinaryTreeNode root)
	{
		if(root == null)
		{
			return null;
		}
		
		ArrayList<LinkedList<BinaryTreeNode>> results = new ArrayList<>();
		getDepth(results, root, 0);
		return results;
		
	}
	
	void getDepth(ArrayList<LinkedList<BinaryTreeNode>> results, BinaryTreeNode node, int count)
	{
		if(node == null)
		{
			return;
		}
		
		if(results.isEmpty())
		{
			LinkedList<BinaryTreeNode> ll = new LinkedList<>();
			ll.add(node);
			results.add(ll);
		}
		else if(results.size() == count)
		{
			LinkedList<BinaryTreeNode> ll = new LinkedList<>();
			ll.add(node);
			results.add(ll);
		}
		else if(count <results.size())
		{
			LinkedList<BinaryTreeNode> ll = results.get(count);
			ll.add(node);
		}
		
		getDepth(results, node.left,  count+1);
		getDepth(results, node.right,  count+1);
	}
	
	void printResults(ArrayList<LinkedList<BinaryTreeNode>> results)
	{
		for(LinkedList<BinaryTreeNode> ll: results)
		{
			System.out.println("List");
			for(BinaryTreeNode node: ll) 
			{
				System.out.println(" -> " + node.data);
			}
		}
	}
}
