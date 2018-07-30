import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest {
	
	ComparatorTest()
	{
		Dollar d1 = new Dollar(29,60);
		Dollar d2 = new Dollar(50, 30);
		
		ArrayList<Dollar> dList = new ArrayList<>();
		dList.add(d1);
		dList.add(d2);
		
		DollarComparator dc = new DollarComparator();
		
		Collections.sort(dList, dc);
		
		for(Dollar d: dList)
		{
			System.out.println(d.amount);
		}
	}
	
	class Dollar implements Comparable<Dollar>
	{	
		Integer amount;	
		Integer cents;
		Dollar(int d, int c)
		{
			amount = d;
			cents = c;
		}
		
		public int compareTo(Dollar d)
		{
			return this.amount - d.amount;
		}


	}
	
	class DollarComparator implements Comparator<Dollar>
	{
		public int compare(Dollar d1, Dollar d2)
		{
			return d1.amount - d2.amount;
		}
	}

}

