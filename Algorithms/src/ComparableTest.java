
public class ComparableTest {
	
	
	ComparableTest()
	{
		Dollar d1 = new Dollar(53);
		Dollar d2 = new Dollar(52);
		System.out.println("Comparable Test");
		System.out.println(d1.compareTo(d2));
	}
	
	class Dollar implements Comparable<Dollar>
	{
		int amount;
		Dollar(int d)
		{
			amount = d;
		}
		
		public int compareTo(Dollar d2)
		{
			return this.amount-d2.amount;

		}
		
	}

}
