import java.util.LinkedList;
import java.util.Queue;

public class BFSTreeIter {
	
	BFSTreeIter()
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		MinimalTree mt = new MinimalTree(arr);
		bfs(mt.root);
	}
	
	void bfs(TreeNode root)
	{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			TreeNode n = queue.poll();
			System.out.println("Current: " + n.data);
			
			if(n.left!= null) queue.add(n.left);
			
			if(n.right!=null) queue.add(n.right);
		}
		
	}
	
}
