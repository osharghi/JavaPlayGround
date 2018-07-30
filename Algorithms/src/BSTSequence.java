import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequence {
	
	BSTSequence()
	{
		BinaryTreeCreator btc = new BinaryTreeCreator();
		ArrayList<LinkedList<BinaryTreeNode>> list = getSequence(btc.root);
		System.out.println(list.size());
		
		for(LinkedList<BinaryTreeNode> ll: list)
		{
			for(BinaryTreeNode node: ll)
			{
				System.out.print(node.data + " -> ");
			}
			
			System.out.println("");
		}
		
		System.out.println("DONE");
		
	
	}
	
	ArrayList<LinkedList<BinaryTreeNode>> getSequence(BinaryTreeNode root)
	{
		ArrayList<LinkedList<BinaryTreeNode>> results = recurse(root);
		return results;
	}
	
	ArrayList<LinkedList<BinaryTreeNode>> recurse(BinaryTreeNode root)
	{
		ArrayList<LinkedList<BinaryTreeNode>> aList = new ArrayList<>();
		
		if(root == null)
		{
			LinkedList<BinaryTreeNode> ll = new LinkedList<>();
			aList.add(ll);
			return aList;
		}
		
		ArrayList<LinkedList<BinaryTreeNode>> list1 = recurse(root.left);
		ArrayList<LinkedList<BinaryTreeNode>> list2 = recurse(root.right);
		
		LinkedList<BinaryTreeNode> prefix = new LinkedList<>();
		prefix.add(root);
		
		for(LinkedList<BinaryTreeNode> ll1:list1)
		{
			for(LinkedList<BinaryTreeNode> ll2: list2)
			{
				weave(ll1, ll2, prefix, aList);
			}
		}
		
		return aList;
		
	}
	
	void weave(LinkedList<BinaryTreeNode> list1, LinkedList<BinaryTreeNode> list2, LinkedList<BinaryTreeNode> prefix, ArrayList<LinkedList<BinaryTreeNode>> results)
	{
		if(list1.isEmpty() || list2.isEmpty())
		{
			LinkedList<BinaryTreeNode> result = (LinkedList<BinaryTreeNode>) prefix.clone();
			result.addAll(list1);
			result.addAll(list2);
			results.add(result);
			return;
		}
		
		BinaryTreeNode list1FirstNode = list1.removeFirst();
		prefix.addLast(list1FirstNode);
		weave(list1, list2, prefix, results);
		prefix.removeLast();
		list1.addFirst(list1FirstNode);
		
		BinaryTreeNode list2FirstNode = list2.removeFirst();
		prefix.addLast(list2FirstNode);
		weave(list1, list2, prefix, results);
		prefix.removeLast();
		list2.addFirst(list2FirstNode);
		
	}

}
