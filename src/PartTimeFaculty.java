
public class PartTimeFaculty extends Faculty{
	
	private double numHours;
	 private double hourlyRate;
	 private int firstClassSize,secondClassSize;
	 private double baseSalary, totalSalary;
	
	 
	 public void setFirstClassSize (int firstClassSize) {
	  
	  this.firstClassSize = firstClassSize;
	  
	 }
	 
	 
	 public int getFirstClassSize () {
	  
	  
	  return firstClassSize;
	 }
	 
	 public void setSecondClassSize (int secondClassSize) {
		  
		  this.secondClassSize = secondClassSize;
		  
		 }
		 
		 
	 public int getSecondClassSize () {
		  
		  
		 return secondClassSize;
		 }
	 
	
		 
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
	 

	
	   
	 public void setBaseSalary() {
	  
	 
	  this.baseSalary = hourlyRate*numHours;
	  
	 }
	 
	 public double getBaseSalary() {
	  
	  return baseSalary;
	 }

	 
	
	 
	 public void setSalary(){
		 
		 if(firstClassSize < 40 && secondClassSize <40) {
		 
		 totalSalary=baseSalary;
		 }
		 
		 else if (firstClassSize >= 40 && firstClassSize <= 60 && secondClassSize <40) {
		 
		 totalSalary=baseSalary + 500;
		 
	 	}
		 
		 else if (firstClassSize > 60 && secondClassSize <40) {
			 
			 totalSalary=baseSalary + 1000;
		 }
		 
		 else if (firstClassSize < 40 && secondClassSize >=40 && secondClassSize <=60) {
			 
			 totalSalary=baseSalary + 500;
			 
		 	}
		 
		 else if (firstClassSize >= 40 && firstClassSize <=60 && secondClassSize >=40 && secondClassSize <=60) {
			 
			 totalSalary=baseSalary + 1000;
			 
		 	}
		 
		 else if (firstClassSize > 60 && secondClassSize >=40 && secondClassSize <=60) {
			 
			 totalSalary=baseSalary + 1500;
			 
		 	}
		 
		 else if (firstClassSize < 40 && secondClassSize > 60) {
			 
			 totalSalary=baseSalary + 1000;
			 
		 	}
		 
		 else if (firstClassSize >= 40 && firstClassSize <=60 && secondClassSize > 60) {
			 
			 totalSalary=baseSalary + 1500;
			 
		 	}

		 else if (firstClassSize > 60 && secondClassSize > 60) {
			 
			 totalSalary=baseSalary + 2000;
			 
		 	}
		 
		 
	 }
	 	
	 public double getSalary(){
		 
		 return totalSalary;
		 
	 }
	 
	
	 
}
