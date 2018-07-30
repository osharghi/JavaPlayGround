import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RBFileLoader {
	
	RedBlackTree RBTree;
	public long startTime;
	long dictCount = 0;
	
	public RBFileLoader(RedBlackTree RBTree)
	{
		this.RBTree = RBTree;
		createDictFromFile();
		duration();
	}
	
	public void createDictFromFile()
	{
		resetTime();
		setStartTime();
		File currentDir = new File(".");
	    File parentDir = currentDir.getParentFile();
	    File newFile = new File(parentDir,"dictionary.txt");
		
		try(BufferedReader br = new BufferedReader(new FileReader(newFile))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    RBTree.insert(line);
		    dictCount++;
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		        if(line != null)
		        {
		        		RBTree.insert(line);
		        		dictCount++;
		        }		        
		    }	    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}
	
	public void setStartTime()
	{
		this.startTime = System.currentTimeMillis();
	}
	
	public void duration()
	{
		System.out.println("Time to create dictionary: " + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	public void printDictCount()
	{
		System.out.println("Number of words in dictionary: " + dictCount);
	}
	
	private void resetTime()
	{
		this.startTime = 0;
	}

}
