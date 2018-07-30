import java.util.Comparator;

public class Cat
{
	int age;
}

class CatComparator implements Comparator<Cat>
{
	@Override
	public int compare(Cat c1, Cat c2)
	{
		return c1.age - c2.age;
	}
}
