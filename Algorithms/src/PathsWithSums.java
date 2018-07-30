import java.util.ArrayList;

public class PathsWithSums {
	
	TreeNode root;

	PathsWithSums()
	{
		int[] arr = {10, 5, -3, 3, 2, 6, 11, 3, -2, 1};
		BinaryTreeCreatorAuto btc = new BinaryTreeCreatorAuto(arr);
		root = btc.root;
//		btc.printTree();
		int targetVal = 8;
		findPaths(targetVal);
	}
	
	void findPaths(int target)
	{
		System.out.println(findPath(root, target, 0, new ArrayList<Integer>()));
	}
	
	int findPath(TreeNode node, int target, int runningSum, ArrayList<Integer> currentVals)
	{
		if(node == null)
		{
			return 0;
		}
		
		
		int count = 0;
		
		if(node.data == target)
		{
			count++;
		}
		
		int newRunningSum = runningSum + node.data;
		int diff = newRunningSum - target;
		
		if(currentVals.contains(diff)) 
		{
			System.out.println("DIFF: " + diff + " NODE: " + node.data);
			count++;
		}
		
		currentVals.add(node.data);
		ArrayList<Integer> pastValues = (ArrayList<Integer>) currentVals.clone();
		
		int leftCount = findPath(node.left, target, newRunningSum, currentVals);
		int rightCount = findPath(node.right, target, newRunningSum, pastValues);
		
		return count + leftCount+rightCount;
	}
}
