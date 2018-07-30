import java.util.ArrayList;

public class SubSequence {

	SubSequence()
	{
		int[] sequence = {1, 3, 5, 2, 9};
		ArrayList<ArrayList<Integer>> results = getSubSequence(sequence);
		for(ArrayList<Integer> sub: results)
		{
			System.out.println(sub.toString());
		}
		
	}
	
	ArrayList<ArrayList<Integer>> getSubSequence(int[] arr)
	{		
			ArrayList<ArrayList<Integer>> results = new ArrayList<>();
			
			for(int i = 0; i<arr.length; i++)
			{
				ArrayList<Integer> seq = new ArrayList<>();
				seq.add(arr[i]);
				getSubSequence(arr, arr[i], seq, results, i+1);
			}
			
			return results;
	}
	
	void getSubSequence(int[] arr, int prev, ArrayList<Integer> currentSeq, ArrayList<ArrayList<Integer>> results, int index)
	{
		if(index>=arr.length)
		{
			return;
		}
		else
		{
			ArrayList<Integer> clonedSequence = null;
			
			if(arr[index]>prev)
			{
				clonedSequence = (ArrayList<Integer>) currentSeq.clone();
				clonedSequence.add(arr[index]);
				results.add(clonedSequence);
			}
			
			if(clonedSequence != null)
			{
				ArrayList<Integer> clonedSeq2 = (ArrayList<Integer>) clonedSequence.clone();
				getSubSequence(arr, arr[index], clonedSeq2, results, index+1);
			}
			
			getSubSequence(arr, prev, currentSeq, results, index+1);

		}
	}
	
}
