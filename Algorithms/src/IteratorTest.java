import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class IteratorTest {

	IteratorTest()
	{
		Random r = new Random();
		ArrayList<Integer> aList = new ArrayList<>();
		aList.add(5);
		aList.add(2);
		aList.add(3);
		aList.add(7);
		printList(aList);
	}
	
	void printList(ArrayList<Integer> aList)
	{
		Iterator<Integer> itr = aList.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
	}	
}
