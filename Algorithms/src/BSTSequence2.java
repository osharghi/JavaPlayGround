import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequence2 {
	
	BSTSequence2()
	{
		int[] arr = {1, 3, 5, 7, 9, 11, 13 ,15, 17, 19};
		MinimalTree mt = new MinimalTree(arr);
		
		ArrayList<LinkedList<Integer>> results = buildSequence(mt.root);
		
		for(LinkedList<Integer> ll: results)
		{
			System.out.print("LL:");
			for(Integer i : ll)
			{
				System.out.print(" -> " + i);
			}
			System.out.println("");
		}
		
		
	}
	
	
	ArrayList<LinkedList<Integer>> buildSequence(TreeNode node)
	{
		ArrayList<LinkedList<Integer>> results = new ArrayList<>();
		
		if(node == null)
		{
			LinkedList<Integer> ll = new LinkedList<>();
			results.add(ll);
			return results;
		}
		
		ArrayList<LinkedList<Integer>> leftSeq = buildSequence(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = buildSequence(node.right);
		
		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.add(node.data);
		
		for(LinkedList<Integer> left: leftSeq)
		{
			for(LinkedList<Integer> right: rightSeq)
			{
				weave(left, right, prefix, results);
			}
		}
		
		return results;

	}
	
	void weave(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> results)
	{
		if(first.size() == 0 || second.size() == 0)
		{
			LinkedList<Integer> cloned = (LinkedList<Integer>) prefix.clone();
			cloned.addAll(first);
			cloned.addAll(second);
			results.add(cloned);
			return;
		}
		
		int firstVal = first.removeFirst();
		prefix.addLast(firstVal);
		weave(first, second, prefix, results);
		prefix.removeLast();
		first.addFirst(firstVal);
		
		
		int secondVal = second.removeFirst();
		prefix.addLast(secondVal);
		weave(first, second, prefix, results);
		prefix.removeLast();
		second.addFirst(secondVal);
		
	}
	
}
