import java.util.HashMap;

public class TreeSum {

	TreeSum()
	{
		BinaryTreeCreator3 btc = new BinaryTreeCreator3();
		HashMap<Integer, Integer> map = new HashMap<>();
		int total = getSum(btc.root, 0, 8, map);
		System.out.println(total);
	}
	
	int getSum(BinaryTreeNode root, int runningSum, int target, HashMap<Integer, Integer> map)
	{
		if(root == null)
		{
			return 0;
		}
		
		runningSum = runningSum + root.data;
		
		int sum = runningSum - target;
		int totalPaths = map.getOrDefault(sum, 0);
		
		if(runningSum == target)
		{
			++totalPaths;
		}
		
		incrementMap(map, runningSum, true);
		totalPaths += getSum(root.left, runningSum, target, map);
		totalPaths += getSum(root.right, runningSum, target, map);
		incrementMap(map, runningSum, false);

		return totalPaths;
	}
	
	void incrementMap(HashMap<Integer,Integer> map, int runningSum, boolean increase)
	{
		if(increase)
		{
			if(map.containsKey(runningSum))
			{
				int count = map.get(runningSum) + 1;
				map.put(runningSum, count);
			}
			else
			{
				map.put(runningSum, 1);
			}
		}
		else
		{
			int count = map.get(runningSum);
			count--;
			if(count == 0)
			{
				map.remove(runningSum);
			}
			else
			{
				map.put(runningSum, count);
			}
		}
	}
	
	
	
}
