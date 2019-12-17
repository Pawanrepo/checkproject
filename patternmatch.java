
public class patternmatch {
	public static void main(String args[])
	{
	String strin =" ABBOTT, BERENICE (1898-1991) [Trinity Churchyard]";
	String tex = strin.replace("[", "@");
	System.out.println(tex);
			if(strin.trim().matches(".*\\[.*\\]"))
			{
				System.out.println("&&&&&&&&&&&&&&");
				String[] splited = strin.trim().split("\\[");
            	
            	String secondpart = splited[1];
            	String finaltitle = secondpart.replace("]", "");
            	System.out.println("&&&&&&&&&&&&&&"+finaltitle);
				System.out.println("Hello");
			}
			else
			{
				System.out.println("india");
			}
	
	}
	
}
