package sampletestdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Sample {

	/*
	 * @Test 
	 * public void date(){ 
	 * 		Date date = new Date() ; 
	 * 		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy") ; 
	 * 		String str = dateFormat.format(date); System.out.println(str); 
	 * 	}
	 * 
	 * @Test 
	 * public void splitString(){ 
	 * 		String value = "29 September 2000";
	 * 		String[] w=value.split(" "); 
	 * 		System.out.println(w[0]);
	 * 		System.out.println(w[1]); 
	 * 		System.out.println(w[2]); 
	 * 	}
	 */

	public static void main(String[] args) throws ParseException {

		String DATE_PATTERN = "MMM/dd/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(DATE_PATTERN);

		sdf.setLenient(false);
		Date d1 = sdf.parse("October/29/2000");
		System.out.println(d1);
		String strDate = sdf.format(d1);
		System.out.println(strDate);
		String[] w=strDate.split("/"); 
		System.out.println(w[0]);
		System.out.println(w[1]); 
		System.out.println(w[2]); 
		
		
	}

	public static void main2(String [] args) throws ParseException{
		Date date = new SimpleDateFormat("MMM").parse("May");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    System.out.println("Month:"+cal.get(Calendar.MONTH));
		
	}
	
}
