import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
public class txt2cvs {
	private static PrintWriter csvfile;
	public static void main(String args[])	{
		BufferedReader r = null;
		try {
			r = new BufferedReader(new FileReader("C:/temp/tempfileorg.txt"));
			csvfile = new PrintWriter(new File("C:/temp/tempfilecsv.csv"));
			String firstcheckvalue = "test";
			String firstsplitstring = null;
			String secondsplitstring = null;
			String fullline;
			int arraysecondsplitstringlenghttemp = 0;
		    while ((fullline = r.readLine()) != null ) {
		    	if(fullline.contains(":") && !fullline.contains("/*"))	{
		    		String[] linesplitcolon = fullline.split(":");
		    		firstsplitstring = linesplitcolon[0];
		    		secondsplitstring = linesplitcolon[1];
		    		StringBuilder firststring =new StringBuilder();
		    		StringBuilder secondstring = new StringBuilder();
		    		StringBuilder thirdstring = new StringBuilder();
		    		if(!firstcheckvalue.equals(firstsplitstring))	{
		    			firststring.append(firstsplitstring);
		    			csvfile.write("\n");
		    			csvfile.write("\n");
		    			csvfile.write(firststring.toString() +"\n");
		    		}
		    		String[] arraysecondsplitstring = secondsplitstring.split(",");
		    		for (String splitseperatedcomma : arraysecondsplitstring) {
		    			String[] columnsplitequal = splitseperatedcomma.split("=");
		    			secondstring.append(columnsplitequal[0]+",");
		    			thirdstring.append(columnsplitequal[1]+",");
		    		}
		    		if(!firstcheckvalue.equals(firstsplitstring) || arraysecondsplitstringlenghttemp != arraysecondsplitstring.length)	{
		    			csvfile.write("\n");
		    			csvfile.write(secondstring.toString() +"\n");
		    			firstcheckvalue = firstsplitstring;
		    			arraysecondsplitstringlenghttemp = arraysecondsplitstring.length;
		    		}
		    		csvfile.write(thirdstring.toString() +"\n");
		    	}
		    }
		} 
		catch (Exception e) {
        	e.printStackTrace();
        }
		finally {
			try {
				r.close();
				csvfile.close();
				System.out.println("fileis created");
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
