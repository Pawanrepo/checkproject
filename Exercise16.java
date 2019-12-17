
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Exercise16 {
   public static void main(String[] args)
    {
     //two weeks
     int noOfDays = 14; 
     Calendar cal = Calendar.getInstance();
    String year = String.valueOf(cal.get(Calendar.YEAR));
   
    String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
    
   
     String datetemp = "26-"+month+"-"+year;
     Date date = null ; 
     DateFormat formatter ;
     formatter = new SimpleDateFormat("dd-MM-yy");
     try {
		date = (Date)formatter.parse(datetemp);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
     Calendar cal1=Calendar.getInstance();
     cal1.setTime(date);
    
     cal1.add(Calendar.DAY_OF_YEAR, noOfDays);
     Date dateind = cal1.getTime();
     System.out.println("dateind*********"+dateind);
     System.out.println("&&&&&&"+dateind.getDate());
     String finaldate = String.valueOf(cal1.getTime().getDate());
System.out.println(finaldate);
     
    }
}