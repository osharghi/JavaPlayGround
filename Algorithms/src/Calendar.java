import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Calendar {

	HashMap<Integer, ArrayList<Booking>> map; 
	
	Calendar()
	{
		map = new HashMap<>();
	}
	
	boolean add(int start, int end)
	{
		boolean canAdd = checkAdd(start, end);
		
		Booking b = new Booking(start, end);
		
		if(canAdd)
		{
			for(int i = start; i<end; i++)
			{
				if(map.containsKey(i))
				{
					ArrayList<Booking> bookings = map.get(i);
					bookings.add(b);
				}
				else
				{
					ArrayList<Booking> bookings = new ArrayList<>();
					bookings.add(b);
					map.put(i, bookings);
				}
			}
		}
		
		return canAdd;
	}
	
	boolean checkAdd(int start, int end)
	{
		boolean canAdd = true;
		
		HashSet<Booking> conflicts = new HashSet<>();
		
		for(int i = start; i<end; i++)
		{
			ArrayList<Booking> list = map.get(i);
			
			if(list != null && !list.isEmpty())
			{
				for(Booking booking: list)
				{
					if(i>=booking.start || i<=booking.end)
					{
						conflicts.add(booking);
						if(conflicts.size()>1) {
							canAdd= false;
							break;
						}
					}
				}
			}			
		}
		
		return canAdd;
	}
	
	class Booking
	{
		int start;
		int end;
		
		Booking(int s, int e)
		{
			start = s;
			end = e;
			
		}
	}
}
