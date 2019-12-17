
public class stringadd {
	private static String xyz;
	public static void main(String args[])
	{
	
	String abc ="";
	String def ="Kaushik";
	String ghi = "";
	String jkl ="";
	String mno ="";
	
	if(!abc.equals(""))
		xyz = abc;
	else
		xyz ="";
	if(!def.equals(""))
		xyz = xyz+def;
	if(!ghi.equals(""))
		xyz = xyz+ghi;
	 if(!jkl.equals(""))
	xyz = xyz+jkl;
	 if(!mno.equals(""))
		xyz = xyz+mno;
	
	System.out.println(xyz);
	}
}
