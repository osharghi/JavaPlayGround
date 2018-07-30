
public class TripleStep {

	TripleStep()
	{
		int n = 10;
		System.out.println(beginStep(n));
	}
	
	int beginStep(int end)
	{
		int[] mem = new int[end+1];
		int steps = 0;
		mem[steps] = step(steps+1, mem, end) + step(steps+2, mem, end) + step(steps+3, mem, end);
		return mem[steps];
	}
	
	int step(int steps, int[] mem, int goal)
	{
		if(steps > goal) {
			return 0;
		}
		else if(mem[steps] != 0)
		{
			return mem[steps];
		}
		else if(steps == goal)
		{
			return 1;
		}
		else
		{
			return mem[steps] = step(steps+1, mem, goal) + step(steps+2, mem, goal) + step(steps+3, mem, goal);
		}
	}
	
	
	
}
