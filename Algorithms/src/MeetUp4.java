import java.util.HashSet;
import java.util.Set;

public class MeetUp4 {

	boolean[][] visited;
	
	MeetUp4()
	{
		//ArrayList of arrays. Find island quantity and biggest island size
		//Use a boolean list or switch 1's to 0 in original array
		//do recursive iterative
		//Turing completeness 
		int[][] matrix = {{1, 1, 0, 0, 1}, {1, 1, 1, 0, 0}, {1, 0, 0, 0, 1}};
		visited = new boolean[matrix.length][matrix[0].length];
		
	}
	
	class Island
	{
		int size;
		Set<int[]> points;
		
		Island(int i, int j)
		{
			size = 0; 
			points = new HashSet<>();
			int[] point = {i, j};
			points.add(point);
			visited[i][j] = true;
		}
	}
	
}
