import java.util.Arrays;
import java.util.Comparator;

public class TestCompare {

	TestCompare()
	{
		TestNode1 A = new TestNode1("A", 1);
		TestNode1 B = new TestNode1("B", 2);
		TestNode1 C = new TestNode1("C", 3);
		TestNode1 D = new TestNode1("D", 4);
		
		TestNode1[] arr = new TestNode1[] {C, A, D, B};
		Arrays.sort(arr, new NodeComparator1());
		
		for(int i = 0; i<4; i++)
		{
			System.out.print("Node:" + arr[i].name + " value:" + arr[i].val + " ");
		}
		
	}
}

class NodeComparator1 implements Comparator<TestNode1>
{
	public int compare(TestNode1 n1, TestNode1 n2)
	{
		if(n1.val<n2.val)
		{
			return -1;
		}
		else if(n1.val == n2.val)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}

class TestNode1
{
	String name;
	int val;
	
	TestNode1(String s, int v)
	{
		name = s;
		val = v;
	}
}
