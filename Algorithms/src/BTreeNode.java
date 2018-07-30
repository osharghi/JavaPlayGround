
public class BTreeNode {

	int value;
	BTreeNode left;
	BTreeNode right;
	int ratio;
	
	BTreeNode(int i)
	{
		value = i;
		left = null;
		right = null;
		ratio = 0;
	}
	
}
