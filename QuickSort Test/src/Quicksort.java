
import java.util.Random;
import java.util.*;


public class Quicksort {
	
	long count;
	public long startTime;
	public long endTime;
	Random rand;
	
	public int [] qs1(int [] A, int p, int r)
	{
		if (p<r)
		{
			if(r-p>50)
			{
				int q = partition(A, p, r);
				qs1(A, p, q-1);
				qs1(A, q+1, r);
			}
			else
			{
				insertionSort(A, p, r);
			}
		}
		
		return A;
	}
	
	public int [] qs1NotOptimized(int [] A, int p, int r)
	{
		if (p<r)
		{
			int q = partition(A, p, r);
			qs1NotOptimized(A, p, q-1);
			qs1NotOptimized(A, q+1, r);
		}
		
		return A;
	}
	
	public int[] qs2(int [] A, int p, int r)
	{
		if (p<r)
		{
			int k = partitionSelect(A, p, r);
			swap(A, r, k);
			qs1(A, p, r);
		}
		
		return A;
	}
	
	public int [] insertionSort(int [] A, int p, int r)
	{
		for(int j = p+1; j<=r; j++)
		{
			int key = A[j];
			int i = j - 1;
			incrementCount();
			while(i>=0 && A[i]>key)
			{
				incrementCount();
				A[i+1] = A[i];
				i = i - 1;
			}
			A[i+1] = key;
		}
		
		return A;
	}
	
	private int partition(int [] A, int p, int r)
	{
		int x = A[r];
		int i = p - 1;
		for(int j = p; j <= r-1; j++)
		{
			incrementCount();
			if (A[j] <= x)
			{
				i = i + 1;
				swap(A, i, j);	
			}
		}
		swap(A, i+1, r);
		return i+1;
	}
	
	public int partitionSelect(int [] A, int p, int r)
	{
		int k = select(A, p, r, A.length/2);

		swap(A, r, k);
		int x = A[r];
		int i = p - 1;
		for(int j = p; j <= r-1; j++)
		{
			if (A[j] <= x)
			{
				i = i + 1;
				swap(A, i, j);	
			}
		}
		swap(A, i+1, r);
		return i+1;
	}
	
	public int select(int[] A, int p, int r, int i)
	{
		if (p==r)
		{
			return p;
		}
		
		int q = randomizedPartition(A, p, r);
		int k = q - p + 1;
		
		if (i==k)
		{
			return q;
		}
		else if(i<k)
		{
			return select(A, p, q-1, i);
		}
		else
		{
			return select(A, q+1, r, i-k);
		}
	}
	
	private int randomizedPartition(int [] A, int p, int r)
	{
		int i = random(p, r);
		swap(A, r, i);
		return partition(A, p, r);
	}
	
	private int random(int p, int r)
	{
		int x = rand.nextInt((r - p) + 1) + p;
		return x;
	}
	
	private void swap(int [] A, int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public int [] populate(int x)
	{
		int [] A = new int [x];
		
		for(int i = 0; i<x; i++)
		{
			A[i] = rand.nextInt(x) + 0;
		}
		return A;
	}
	
	public void setRand()
	{
		rand = new Random(System.currentTimeMillis());
	}
	
	private void incrementCount()
	{
		++count;
	}
	
	private void clearCount()
	{
		count = 0;
	}
	
	public long getPartCount()
	{
		return count;
	}
	
	private void clearTime()
	{
		this.startTime = 0;
		this.endTime = 0;
	}
	
	public void reset()
	{
		clearCount();
		clearTime();
	}
	
	public void setStartTime()
	{
		this.startTime = System.currentTimeMillis();
	}
	
	public long duration()
	{
		this.endTime = System.currentTimeMillis();
		return (endTime - startTime);
	}
	
	public int [] getCopy(int [] A)
	{
		return Arrays.copyOf(A, A.length);
	}
	
	public boolean arraysAreEqual(int []A, int [] B)
	{
		if(A.length == B.length)
		{
			for(int i = 0; i<A.length; i++)
			{
				if(A[i] != B[i])
				{
					return false;
				}
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	public boolean isSorted(int [] A)
	{
		for(int i = 1; i<A.length; i++)
		{	
			if(A[i] < A[i-1])
			{
				return false;
			}
		}
		
		return true;
	}
	
	public void initializeCounter()
	{
		count = 0;
	}
	

}
