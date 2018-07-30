import java.util.ArrayList;
import java.util.LinkedList;

import MInimalTree3;

public class ListsOfDepths3 {
	
	ListsOfDepths3()
	{
		MInimalTree3 tree = new MInimalTree3();
		getDepths(tree.root);
	}
	
	void getDepths(MInimalTree3.Node root)
	{
		ArrayList<LinkedList<Integer>> results = new ArrayList<>();
		traverse(root, 0, results);
		printList(results);
	}
	
	void printList(ArrayList<LinkedList<Integer>> results)
	{
		for(LinkedList<Integer> ll: results)
		{
			System.out.print("LL ");
			for(Integer i: ll)
			{
				System.out.print(" -> " + i );
			}
			System.out.println("");
		}
		
	}
	
	
	void traverse(MInimalTree3.Node node, int index, ArrayList<LinkedList<Integer>> results)
	{
		if(node == null) return;
		
		if(results.isEmpty() || index == results.size())
		{
			LinkedList<Integer> ll = new LinkedList<>();
			ll.add(node.val);
			results.add(ll);
		}
		else if(index<results.size())
		{
			LinkedList<Integer> ll = results.get(index);
			ll.addLast(node.val);
		}
		
		traverse(node.left, index+1, results);
		traverse(node.right, index+1, results);
		
	}

}
