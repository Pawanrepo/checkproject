import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class calendardate {

	public static void main(String args[])
	{
		Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int finalmonth = month+1;

   		DecimalFormat mFormat= new DecimalFormat("00");
   		mFormat.setRoundingMode(RoundingMode.DOWN);
   		 String Dates =  mFormat.format(Double.valueOf(year)) +  mFormat.format(Double.valueOf(finalmonth)) + mFormat.format(Double.valueOf(day));
      System.out.println("dates"+Dates);
   		 //  String Datescell = mFormat.format(Double.valueOf(day)) +"-"+ mFormat.format(Double.valueOf(finalmonth)) +"-"+ mFormat.format(Double.valueOf(year));
        String DateMonth = mFormat.format(Double.valueOf(year)) + mFormat.format(Double.valueOf(finalmonth)) ;
        System.out.println(DateMonth);
        String dateind="07-2018";
        DateFormat format = new SimpleDateFormat("MM-yyyy");
	     Date date =null;
	try {
		date = format.parse(dateind);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
        
        System.out.println("dateindindindind"+date);
        
        
        
        DateFormat format1 = new SimpleDateFormat("yyyy-MM");
	     Date date1 =null;
	try {
		date1 = format1.parse("2018-07-01");
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	 SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy");

	    String strDate = sdf.format(date1);
	    Date dateorg = null;
	    System.out.println("formatted date in mm/dd/yy : " + strDate);
	   
		try {
			dateorg = new SimpleDateFormat("MM-yyyy").parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    System.out.println("ateorg"+dateorg);
	
	System.out.println("date11111111111111111"+date1);
        
        
        
	}
}
