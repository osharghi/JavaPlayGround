import java.util.Stack;

public class StackMin extends Stack<Integer> {

	Stack<Integer> stack2;
	
	StackMin()
	{
		stack2 = new Stack<>();
	}
	
	
	public void push(int i)
	{
		if(i<=min())
		{
			stack2.push(i);
		}
		
		super.push(i);
	}
	
	public Integer pop()
	{
		int value = super.pop();
		if(value == min())
		{
			stack2.pop();
		}
		
		return value;
	}
	
	
	
	public int min()
	{
		if(stack2.isEmpty())
		{
			return Integer.MAX_VALUE;
		}
		else return stack2.peek();
	}
	
}
