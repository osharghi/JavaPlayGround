import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths2 {

	
	ListOfDepths2()
	{
		int[] arr = {1, 3, 5, 7, 9, 11, 13 ,15, 17, 19};
		MinimalTree mt = new MinimalTree(arr);
		ArrayList<LinkedList<TreeNode>> results = new ArrayList<>();
		traverse(mt.root, results, 0);
		
		mt.printTree(mt.root);
		
	
		
		for(LinkedList<TreeNode> ll: results)
		{
			System.out.print("LL ");
			for(TreeNode node: ll)
			{
				System.out.print(" -> " + node.data);
			}
			System.out.println("");
		}
	}
	
	void traverse(TreeNode node, ArrayList<LinkedList<TreeNode>> results, int index)
	{
		if(node == null) return;
		
		LinkedList<TreeNode> ll; 
		
		if(results.size() == index)
		{
			ll = new LinkedList<>();
			results.add(ll);
			
		}
		else
		{
			ll  = results.get(index);
		}
		
		ll.add(node);
		
		traverse(node.left, results, index+1);
		traverse(node.right, results, index+1);
		
	}
	
}
