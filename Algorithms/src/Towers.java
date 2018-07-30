import java.util.Stack;

public class Towers {

	Stack<Integer> t1;
	Stack<Integer> t2; 
	Stack<Integer> t3;
	
	Towers()
	{
		t1 = new Stack<>();
		t2 = new Stack<>();
		t3 = new Stack<>();
		
		loadStack(3, t1);
		
		moveTowers(3, t1, t3, t2);
		
		confirmMove(t3);
		
	}
	
	void confirmMove(Stack<Integer> t)
	{
		while(!t.isEmpty())
		{
			System.out.println(t.pop());
		}
	}
	
	void loadStack(int n, Stack<Integer> t)
	{
		for(int i = n; i>0; i--)
		{
			t.push(i);
		}
	}
	
	void moveTowers(int n, Stack<Integer> origin, Stack<Integer> destination, Stack<Integer> buffer)
	{
		if(n>0)
		{
			moveTowers(n-1, origin, buffer, destination);
			moveTop(origin, destination);
			moveTowers(n-1, buffer, destination, origin);
		}
	}
	
	void moveTop(Stack<Integer> origin, Stack<Integer> destination)
	{
		Integer i = origin.pop();
		destination.push(i);
	}
	
	
}
