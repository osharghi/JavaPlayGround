import java.util.LinkedList;
import java.util.Queue;

public class BFSTreeRecur {
	
	TreeNode root;
	
	BFSTreeRecur()
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		MinimalTree mt = new MinimalTree(arr);
		root = mt.root;
		doBFS(root);
	}
	
	void doBFS(TreeNode n)
	{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(n);
		bfs(queue);
	}
	
	void bfs(Queue<TreeNode> queue)
	{
		if(!queue.isEmpty())
		{
			TreeNode n = queue.poll();
			System.out.println("Current: " + n.data);
			
			if(n.left!=null) queue.add(n.left);
			
			if(n.right!=null) queue.add(n.right);
			
			bfs(queue);
		}
	}

}
