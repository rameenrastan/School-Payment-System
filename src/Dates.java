import java.util.Calendar;
import java.util.GregorianCalendar;


public class Dates {
	
	private int monthIncr = 0;
	
	public void advanceToNextMonth() {
		
		
		
		Calendar cal = Calendar.getInstance();

	    String[] Months = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
	                                     "September", "October", "November", "December" };
	    
	   
	    
	    
	    cal.add(Calendar.MONTH, monthIncr++);
	    
	   
	    
	    System.out.println("Current month is : " + Months[cal.get(Calendar.MONTH)]);

	}
	    
}
