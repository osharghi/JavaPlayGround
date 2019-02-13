import java.util.ArrayList;

//https://leetcode.com/problems/interval-list-intersections/

public class IntervalIntersection {
	
public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        
        ArrayList<Interval> list = new ArrayList<>();
        
        if(A.length == 0 || B.length == 0 ) 
        {
            Interval[] arr = new Interval[list.size()];
            arr = list.toArray(arr);
            return arr;
        }
        
        int i = 0;
        int j = 0;
        
        while(i<A.length && j<B.length)
        {
            Interval i1 = A[i];
            Interval i2 = B[j];
            
            int low = Math.max(i1.start, i2.start);
            int high = Math.min(i1.end, i2.end);
            
            if(low<=high)
            {
                list.add(new Interval(low, high));
            }
        
            if(i2.end>i1.end)
            {
                i++;
            }
            else if(i1.end>i2.end)
            {
                j++;
            }
            else
            {
                i++;
                j++;
            }
        }
        
        
        Interval[] arr = new Interval[list.size()];
        arr = list.toArray(arr);
        return arr;
    }

	class Interval
	{
		int start;
		int end;
		
		Interval(int s, int e)
		{
			start = s;
			end = e;
		}
	}

}
