import java.util.ArrayList;
import java.util.List;

public class arraylistexample {
public static void main (String args[])

{
	List<String> alist = new ArrayList<String>();
	alist.add("apple");
	alist.add("banana");
	alist.add("orange");

	String value = alist.get(1);
	System.out.println(value);
	}
}
