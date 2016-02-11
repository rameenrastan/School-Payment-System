public class PersonalInformation {
	
	
	private String name;
	private int age;
	private String address;
    private String phoneNumber;
    private long ID;
    private double salary;
     
    
    
    
    
    
    
    
	
	
    
    
    
    
    //ID
    
    public void setID(long ID){
    	
    	this.ID = ID;
    	
    	if (ID <1000000 || ID>9999999) {
			
			System.out.println("Invalid ID. Please enter again.");
		}
		
		else { 
			
			this.ID = ID;
		}
    	
    	
   }
    
    
    public long getID(){
    	
    	
    	return ID;
    	
    }
    
    //Name 
    
    
    public void setName(String name){
		
		this.name=name;
		
	}
	
	public String getName(){
		
		return name;
	}
	
	
	
	// Age
	
	public void setAge(int age){
		this.age=age;
		
		if (age<16 || age>100) {
			
			System.out.println("Invalid age. Please enter again.");
		}
		
		else { 
			
			this.age=age;
		}
		
		
	}
	
	public int getAge(){
		
		return age;
	}
	
	
	
	
	// Address
	
	public void setAddress(String address){
		
		this.address=address;
		
	}
	
	public String getAddress(){
		
		return address;
	}
	
	
	
	

	
	// Phone Number
	
	public void setPhoneNumber(String phoneNumber){
		if(phoneNumber.length() != 12){
			
			System.out.println("Invalid phone number, please enter it in the form xxx-xxx-xxxx");
		}
		
		else{
		this.phoneNumber=phoneNumber;
		}
	}
	
	public String getPhoneNumber(){
		
		return phoneNumber; 
	}
	
	 public void setSalary (double salary) {
		   
		   this.salary= salary; 
		   
		   
		  }
		  
		  
		  public double getSalary () {
		   
		   return salary; 
		  }
	
	

    public void showInfo(){
    	System.out.println("\nName: " + name);
    	System.out.println("Age: " + age);
    	System.out.println("ID: " + ID);
    	System.out.println("Address: " + address);
    	System.out.println("Phone Number: " + phoneNumber);
    	
    	
    }

}




