
public class Student extends PersonalInformation {


	private boolean currentStudent;
	private double numHours;
	private double hourlyRate;
	private double salary;
	private boolean isUnderGrad;
	private boolean isGrad;
	
	public void setCurrentStudent(boolean currentStudent){
		
		this.currentStudent=currentStudent;
		
		
	}
	
	
	
	public boolean getCurrentStudent(){
		
		return currentStudent;
		
		
	}
	
   public void setIsUnderGrad(boolean isUnderGrad){
		
		this.isUnderGrad=isUnderGrad;
		
		if(isUnderGrad == false){
			
			isGrad=true;
			
		}else{ isGrad=false;}
		
	}
   
   public void setIsGrad(boolean isGrad){
		
		this.isGrad=isGrad;
		
		if(isGrad == false){
			
			isUnderGrad=true;
			
		}else{ isUnderGrad=false;}
		
	}
   public boolean getIsUnderGrad(){
	   
	   return isUnderGrad;
   }
   
   public boolean getIsGrad(){
	   
	   return isGrad;
   }
   
	
	public void setNumHours(double numHours){
		
		this.numHours=numHours;
		
		
	}
	
	public double getNumHours(){
		
		return numHours;
	}
	
	public void setHourlyRate(double hourlyRate){
		
		this.hourlyRate=hourlyRate;
		
		
	}
	
	public double getHourlyRate(){
		
		return hourlyRate;
	}
	
	
	public void setSalary(){
		
		salary= hourlyRate * numHours; 
	}
	
	public double getSalary(){
		
		return salary;
	}
	
	
	public void showInfo(){
		super.showInfo();
        System.out.println("Undergraduate: "+getIsUnderGrad());
    	System.out.println("Graduate: "+getIsGrad());
    	System.out.println("Current student: "+getCurrentStudent());
    	System.out.println("Monthly salary: $" + salary);
		
		
	}
	
	
	
	
}
