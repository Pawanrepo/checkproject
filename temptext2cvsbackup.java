import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
public class temptext2cvsbackup {
	private static PrintWriter csvfile;
	public static void main(String args[]) throws IOException	{
		
		BufferedReader patternfile = null;
		try {
			
			patternfile = new BufferedReader(new FileReader("C:/temp/patternfile.txt"));
			csvfile = new PrintWriter(new File("C:/temp/tempfilecsv.csv"));
			String line;
			String fullline;
			String firstsplitstringpattern = null;
			String secondsplitstringpattern = null;
		    while ((line = patternfile.readLine()) != null) {
		    	String[] linesplitpattern = line.split(",");
		    	firstsplitstringpattern = linesplitpattern[0];
	    		secondsplitstringpattern = linesplitpattern[1];
	    		System.out.println("patternmatch"+secondsplitstringpattern);
	    		Pattern p1 = Pattern.compile(secondsplitstringpattern);
	    		String[] linesplitheading = firstsplitstringpattern.split(":");
	    		String firstsplitstringheading = linesplitheading[0];
	    		String secondsplitstringheading = linesplitheading[1];
	    		String[] splitsubheading = secondsplitstringheading.split("%");
	    	      List<String> subHeadingList = new ArrayList<String>();
	    	      List<String> subHeadingListwithoutcomma = new ArrayList<String>();
	    	      for (String subheadingelement : splitsubheading) {
	    	    	  subHeadingListwithoutcomma.add(subheadingelement);
	    	    	  subHeadingList.add(subheadingelement+",");
	    	      }
	    	      String secondsplitstring = null;
	    	      StringBuilder firststring =new StringBuilder();
	    	      StringBuilder secondstring =new StringBuilder();
	    	      secondstring.append(firstsplitstringheading);
	    	      csvfile.write(secondstring.toString() +"\n");
	    	      for (String subheadingelm : subHeadingList) { 
	    			firststring.append(subheadingelm); 		
	    	      }
	    	      csvfile.write(firststring.toString() +"\n");
	    	      BufferedReader 	r = new BufferedReader(new FileReader("C:/temp/tempfileorg.txt"));
	    	      while ((fullline = r.readLine()) != null ) {
	    	    	  System.out.println("fullline"+fullline);
					Matcher m = p1.matcher(fullline);
					if(m.find()) {
			    	//	System.out.println("Insidefind");
			    		String[] linesplitcolon = fullline.split(":");
			    		secondsplitstring = linesplitcolon[1];
			    		String[] arraysecondsplitstring = secondsplitstring.split(",");
			    		List<String> splitheadinglistfromfile = new ArrayList<String>();
			    	    List<String> splitdatalistfromfile = new ArrayList<String>();
			    		for (String splitseperatedcomma : arraysecondsplitstring) {
			    			String[] columnsplitequal = splitseperatedcomma.split("=");
			    			splitheadinglistfromfile.add(columnsplitequal[0]);
			    			splitdatalistfromfile.add(columnsplitequal[1]);
			    		}
			    		int j=0;
			    		List<String> datalistfromfile = new ArrayList<String>();
			    		for(int i =0; i < subHeadingListwithoutcomma.size() && j < splitdatalistfromfile.size();) {
			    			if(splitheadinglistfromfile.get(j).equalsIgnoreCase(subHeadingListwithoutcomma.get(i)))	{
			    				datalistfromfile.add(splitdatalistfromfile.get(j) +",");
			    			}
			    			else {
			    			datalistfromfile.add("-"+",");
			    			j--;
			    			
			    			}
			    			i++;	
			    			j++;
			    		}
			    		 
				    		System.out.print("line"+datalistfromfile);
				    		System.out.println("\n"); 
			    		
			    		StringBuilder thirdstring = new StringBuilder();
			    		for (String datalistfromf : datalistfromfile) { 
				    		thirdstring.append(datalistfromf); 		
			    		}
			    		csvfile.write(thirdstring.toString() +"\n");
			    		
			    	}
				}
		    }
		}
		catch (Exception e) {
        	e.printStackTrace();
		}
		finally {
			//		r.close();
					csvfile.close();
					System.out.println("fileis created");
		}
	}
}