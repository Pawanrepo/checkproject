public class findos
{
	public static void main(String args[])
	{
		String os = System.getProperty("os.name");
		if(os.indexOf("win") >= 0)

	{
			System.out.println("window Operating system");
	}
		else {
			System.out.println("Other Operating system");	
			}
	
	
	}
}