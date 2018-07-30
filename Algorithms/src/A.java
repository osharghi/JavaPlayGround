
public class A {

	private  A()
	{
		System.out.println("A created");
	}
	
	public static A test()
	{
		return new A();
	}
	
}
