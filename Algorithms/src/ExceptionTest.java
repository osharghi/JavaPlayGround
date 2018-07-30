import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionTest {

	DateFormat format = new SimpleDateFormat("MM, dd, yyyy");
	Date date;
	
	ExceptionTest()
	{
	
		String str = "Some String";
		
//		try {
//			date = format.parse(str);
//		}
//		catch (Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
		
		try
		{
			printDate(str);
		}
		catch(Exception e)
		{
			System.out.println("There was an exception");
		}
		
		
	}
	
	
	void printDate(String str) throws Exception
	{
		try {
			date = format.parse(str);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	
}
