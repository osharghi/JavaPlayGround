import java.util.ArrayList;
import java.util.List;

//797. All Paths From Source to Target

public class AllPaths {

	 public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

	        List<List<Integer>> results = new ArrayList<>();

	        if(graph.length == 0 || graph[0].length == 0) return results;

	        traverse(graph, results, null, 0, graph.length-1);
	        return results;
	    }

	    void traverse(int[][] graph, List<List<Integer>> results, List<Integer> path, int start, int end)
	    {
	        List<Integer> clonedPath = null;

	        if(path == null)
	        {
	             clonedPath = new ArrayList<>();
	        }
	        else
	        {
	            clonedPath = new ArrayList<Integer>(path);
	        }

	        if(start == end)
	        {
	            clonedPath.add(end);
	            results.add(clonedPath);
	            return;
	        }

	        clonedPath.add(start);
	        int[] neighbors = graph[start];

	        for(Integer i: neighbors)
	        {
	            traverse(graph, results, clonedPath, i, end);
	        }
	    }

}
