
public class SingletonClass {

	private static SingletonClass instance = null;
	
	private SingletonClass()
	{
		System.out.println("Creating singleton");
	}
	
	public static SingletonClass getInstance()
	{
		if(instance == null) {
			System.out.println("Creating singleton");
			instance = new SingletonClass();
		}
		else {
			System.out.println("Instance already exisits");
		}
		
		return instance;
	}
	
}
