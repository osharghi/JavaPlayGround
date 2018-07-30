
public class EnumTest {

	public enum Level {
	    HIGH  (3),  //calls constructor with value 3
	    MEDIUM(2),  //calls constructor with value 2
	    LOW   (1)   //calls constructor with value 1
	    ; // semicolon needed when fields / methods follow


	    private final int levelCode;

	    private Level(int levelCode) {
	        this.levelCode = levelCode;
	    }
	}
	
	EnumTest()
	{
		Voltage v1 = new Voltage();
		Voltage v2 = new Voltage();
		Voltage v3 = new Voltage();

		v1.level = Level.HIGH;
		v2.level = Level.MEDIUM;
		v3.level = Level.LOW;
		
		
		System.out.println(v2.level.ordinal());
		System.out.println(v3.level.levelCode);


	}
	
	
	class Voltage
	{
		Level level;
		
	}
	
}
