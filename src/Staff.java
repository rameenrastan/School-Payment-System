
public class Staff extends PersonalInformation {

	  private boolean isFullTime;
	  private boolean isPartTime;
	  
	  public void setIsFullTime(boolean isFullTime){
			
			this.isFullTime=isFullTime;
			
			if(isFullTime == false){
				
				isPartTime=true;
				
			}else{ isPartTime=false;}
			
		}
	   
	   public void setIsPartTime(boolean isPartTime){
			
			this.isPartTime=isPartTime;
			
			if(isPartTime == false){
				
				isFullTime=true;
				
			}else{ isFullTime=false;}
			
		}
	   public boolean getIsFullTime(){
		   
		   return isFullTime;
	   }
	   
	   public boolean getIsPartTime(){
		   
		   return isPartTime;
	   }
	   public void showInfo(){
			  super.showInfo();
			  System.out.println("Monthly salary: $" + getSalary());
			  System.out.println("Full-time: "+getIsFullTime());
			  System.out.println("Part-time: "+getIsPartTime());
			  
			  
		  }
	
}
