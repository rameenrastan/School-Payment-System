
public class PartTimeStaff extends Staff{

		 
		 private double numHours;
		 private double hourlyRate;
		 private double salary;
		 private double commission;
		 
		 

		 public void setNumHours(double numHours){
		    
		    this.numHours = numHours;
		 }
		 
		 public double getNumHours(){
		    
		    return numHours;
		   }
		   
		 
		 
		 
		 public void setHourlyRate(double hourlyRate){
		    
		    this.hourlyRate = hourlyRate;
		    
		    
		   }
		   
		 public double getHourlyRate(){
		    
		    return hourlyRate;
		   }
		 
		 
		 
		 
		 public void setSalary() {
		  
		 
		  this.salary= hourlyRate*numHours;
		  }
		 
		   
		
		 
		 public void setCommission(double commission){
			 
			 this.commission=commission;
		 }
		 
		 public double getCommission(){
			 
			 return commission;
		 }
		 
		 
		 public void setSalary(double salary) {
		  
		  this.salary=salary;
		  
		 }
		 
		 public double getSalary() {
		  
		  return salary;
		 

		}
		   public void showInfo(){
			   
				  
				  super.showInfo();
			  System.out.println("Commission: "+ getCommission()+ " %");
			   
			   
			  }
		 
}


