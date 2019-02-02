
//https://leetcode.com/problems/maximum-binary-tree/

public class MaximumTree {

	 	public TreeNode constructMaximumBinaryTree(int[] nums) {

	        if(nums.length == 0) return null;

	        TreeNode root = buildTree(nums, 0, nums.length-1);

	        return root;
	    }

	    TreeNode buildTree(int[] arr, int start, int end)
	    {
	        if(start>end) return null;

	        int maxIndex = getMax(arr, start, end);
	        int maxVal = arr[maxIndex];
	        TreeNode root = new TreeNode(maxVal);

	        root.left = buildTree(arr, start, maxIndex-1);
	        root.right = buildTree(arr, maxIndex+1, end);
	        return root;
	    }

	    int getMax(int[] arr, int start, int end)
	    {
	        int max = Integer.MIN_VALUE;
	        int maxIndex = -1;

	        for(int i = start; i<=end; i++)
	        {
	            if(arr[i]>max)
	            {
	                max = arr[i];
	                maxIndex= i;
	            }
	        }
	        return maxIndex;
	    }

	    public class TreeNode
	    {
	    	      int val;
	    	      TreeNode left;
	    	      TreeNode right;
	    	      TreeNode(int x) { val = x; }
	    	 }

}
