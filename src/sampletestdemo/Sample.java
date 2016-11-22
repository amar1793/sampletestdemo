package sampletestdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

		String DATE_PATTERN = "MM/dd/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(DATE_PATTERN);

		sdf.setLenient(false);
		Date d1 = sdf.parse("09/29/2000");
		System.out.println(d1);
	}

}
