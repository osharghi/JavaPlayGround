
public class Cat2 implements Comparable<Cat2>
{
	int age;
	
	@Override
	public int compareTo(Cat2 c)
	{
		return this.age - c.age;
	}
}