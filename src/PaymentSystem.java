
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


  public class PaymentSystem {

   
	  
	  
	  public static void main(String[] args){
    
		  
		  Dates d = new Dates();

		 Scanner kb = new Scanner(System.in);
	    
	     System.out.println("How many individuals should the system hold? (Please do not space the number.)");
	     int size;
	     size = kb.nextInt(); 
           
		 PersonalInformation[] arr = new PersonalInformation[size];  // Setting size of array in which individuals will be stored 
		 System.out.println("Size set.");
		  
		  
		  int age, option, classSize, sClassSize, courses, index = 0; 
		  String name,address,phoneNumber,type;
		  long ID;
		  double salary, hourlyRate, numHours, commission, salarySum;
		  int monthCounter = 0, quarterCounter = 0;

		  
		  System.out.println("\nWelcome to the Concordia Payment System.");
		  
		  
		  while(true) {   // Allows program to continue after completing one cycle
			  
			  
			  System.out.println("\nEnter 1 to add a new individual to the system.");
			  System.out.println("Enter 2 to search for an individual to view his/her information, update attributes or delete them.");
			  System.out.println("Enter 3 to view the total amount to be paid to all Concordia employees.");
			  System.out.println("Enter 4 to advance to the next month.");
			  
			  
			  option=kb.nextInt();
    
    
			  switch(option){
         
			    case 1:  // If user enters 1
        
                   System.out.println("\nPlease enter 1 to add a Student, 2 to add Faculty, or 3 to add Staff");
                   option=kb.nextInt();

                   
                  switch (option) { // Nesting switch statements to 
                  
                 
                  	 // Student information
                  
                     case 1:
                   
                      System.out.println("\nPress 1 for undergraduate, 2 for graduate.");
                      option=kb.nextInt();
                  
                
                      UndergradTA ugStudent=null;	// Creating null object from UndergradTA class
                      GradTA gStudent=null;			// Creating null object from GradTA class
                            
                      if (option == 1) {

                    	  ugStudent = new UndergradTA();	// Initializing the object if undergraduate student
                    	  ugStudent.setIsUnderGrad(true);		

                            } else if (option == 2) {

                                gStudent = new GradTA();	// Initializing the object if graduate student
                                gStudent.setIsGrad(true);		
                                
                            }       
                  
                       
                      // Undergraduate students
                      
                      if(ugStudent != null) {    
                    	  
                    	 
                    	  // Setting name
                    	  
                    	  System.out.println("\nEnter name: ");
                    	  kb.nextLine();          
                    	  ugStudent.setName(name = kb.nextLine());
                 
                    	  
                    	  // Setting age
                    	  
                    	  System.out.println("Enter age: ");
                         
                    	  do {  // Restricting unrealistic values
                    		  
                    		  ugStudent.setAge(age = kb.nextInt());
                    		  
                    	  } while (age<16 || age>100);
                   
                   
                    	  // Setting ID
                    	  
                    	  System.out.println("Enter ID: ");
	                   
                    	  do {	// Restricting unrealistic values
                    		  
                    		  ugStudent.setID(ID = kb.nextLong());
	                	   
                    	  } while (ID<1000000 || ID>9999999);
                                
                            
                    	  // Setting address
                                
                    	  System.out.println("Enter address: ");
                    	  kb.nextLine();
              
                    	  ugStudent.setAddress(address = kb.nextLine()); 
                    	  
                    	  // Setting phone number

                    	  System.out.println("Enter phone number. Please enter it in the form of xxx-xxx-xxxx.");
          
                    	  do {  // Restricting unrealistic values
                   
                    		  ugStudent.setPhoneNumber(phoneNumber = kb.next());
                                                     
                    	  } while(phoneNumber.length() != 12);
                   
                   
                    	  // Setting student status
                    	  
                    	  System.out.println("Press 1 if current student, 2 if not current student.");
                    	  option=kb.nextInt();
                    	  
                    	  if(option==1){
                    		  
                    		  ugStudent.setCurrentStudent(true);
                    		  
                    	  }
                    	  
                    	  else {
                    		  
                    		  ugStudent.setCurrentStudent(false);
                    	  }
                   
                    	  
                    	  System.out.println("Would you like to register this person as a TA?");
                    	  kb.nextLine();
                    	  type = kb.nextLine();
                  
                    	  
                    	  // Determining if student is qualified for TA position
                    	  
                    	  if (type.toLowerCase().equals("yes") && ugStudent.getCurrentStudent()==(true)){  

                    		  
                    		  // If they are qualified, set salary
                    		  
                    		  System.out.println("Enter the number of hours worked: ");
                    		  numHours = kb.nextDouble();
                    		  ugStudent.setNumHours(numHours);
                       
                    		  System.out.println("Enter the hourly rate: ");  
                    		  hourlyRate = kb.nextDouble();
                    		  ugStudent.setHourlyRate(hourlyRate);
                    		  
                    		  while (ugStudent.getHourlyRate() > 20/1.2) { //Hourly rate of UndergradTA must be < (20/1.2) of GradTA rate
                	  		
                    			  System.out.println("Sorry, the hourly rate is too high.");
                    			  System.out.println("Enter the hourly rate: ");
                    			  hourlyRate = kb.nextDouble();
                    			  ugStudent.setHourlyRate(hourlyRate);
                    		  }
                	  	
                    		  ugStudent.setSalary();
                    		  System.out.println("Salary set.");
                    	  }
                    	  
                    	  else if (type.toLowerCase().equals("yes") && ugStudent.getCurrentStudent()==(false)) {
                    		  
                    		  // If they are not qualified
           	  		
                    		  System.out.println("This person is not a current student and therefore not qualified for a TA position.");
                    		  System.out.println("Salary not set.");
                    	  }
           	  		
                    	  else if (type.toLowerCase().equals("no")) { // If user does not want student as TA
                    		  
                	  		System.out.println("Salary not set.");
                	  		
                	  	  }
                	  	
                  	  	  ugStudent.showInfo();  // Display the information of the student
                    	  
                  	  	  arr[index++]=ugStudent; // Storing object into the array
                  	  	  System.out.println("Succesfully added.");
            	   
                      }
                      
                      // Graduate students
                      
                      else if(gStudent!=null){
                    	  
                    	  // Setting name	  
                	   
                    	  System.out.println("Enter name: ");
                      
                    	  kb.nextLine();          
                    	  gStudent.setName(name = kb.nextLine());
                       
                    	  //Setting age
                     
                    	  System.out.println("Enter age: ");
                    
                                   
                    	  do { // Restricting unrealistic values
                    		  
                    		  gStudent.setAge(age = kb.nextInt());
                    		  
                    	  } while (age<16 || age>100);
                                    
                       
                    	  //Setting ID
                       
                    	  System.out.println("Enter ID: ");
                       
                    	  do {  // Restricting unrealistic values
                    		  
                    		  gStudent.setID(ID = kb.nextLong());
                    		  
                    	  } while (ID<1000000 || ID>9999999);
                       
                       
                    	  // Setting address
                                    
                    	  System.out.println("Enter address: ");
                    	  kb.nextLine();
                    	  gStudent.setAddress(address = kb.nextLine()); 
                    	  
                    	  // Setting phone number

                    	  System.out.println("Enter phone number. Please enter it in the form of xxx-xxx-xxxx.");
                      
                    	  do {  // Restricting unrealistic values
                    		  
                    		  gStudent.setPhoneNumber(phoneNumber = kb.next());
                                                         
                    	  } while(phoneNumber.length() != 12);
                       
                       
                    	  // Setting student status
                    	  
                    	  System.out.println("Press 1 if current student, 2 if not current student.");
                    	  option=kb.nextInt();
                    	  
                    	  if(option==1){
                    		  
                    		  gStudent.setCurrentStudent(true);
                    	  }
                    	  
                    	  else {
                    		  
                    	   gStudent.setCurrentStudent(false);
                    	   
                    	  }
                       
                    	  
                       		System.out.println("Would you like to register this person as a TA?");
                       		kb.nextLine();
                       		type = kb.nextLine();
                         
                       		
                       		// Determining if student qualified for TA position
                  	  	
                       		if (type.toLowerCase().equals("yes") && gStudent.getCurrentStudent()==(true)){  

                       		// If they are qualified
                       	  	
                  	  		System.out.println("Enter the number of hours worked: ");  // Setting salary
                  	  		numHours = kb.nextDouble();
                       	  	gStudent.setNumHours(numHours);
                            gStudent.setHourlyRate();
                            gStudent.setSalary();
                       	  	
                              
                       	  	System.out.println("Salary set.");
                       	  	
                  	  	 	}
                  	  	
                       		else if (type.toLowerCase().equals("yes") && gStudent.getCurrentStudent()==(false)) {
                       			
                       			// If they are not qualified
                  	  		
                       			System.out.println("This person is not a current student and therefore not qualified for a TA position.");
                       			System.out.println("Salary not set.");
                       		}
                  	  		
                       		else if (type.toLowerCase().equals("no")) {  // If user does not want student as TA
                      
                       	  		System.out.println("Salary not set.");
                       	  		
                       	 }
                       
                       		gStudent.showInfo();  // Displays student information
                       		
                       		arr[index++]=gStudent;  // Storing object into the array
                       		System.out.println("Succesfully added.");
                      }
                      
                      break;
                  
                           
                  // Faculty information    
                  
                  case 2:  
        	
                	  System.out.println("Please enter 1 for Full-time, 2 for Part-time.");
                	  option=kb.nextInt();
                	  FullTimeFaculty fFac = null; // Creating null object from FullTimeFaculty class
                	  PartTimeFaculty pFac = null; // Creating null object from PartTimeFaculty class
                  
                	  if (option == 1) {

                		  fFac = new FullTimeFaculty();  // Initializing object if full time faculty
                		  fFac.setIsFullTime(true);

                	  } 
                	  
                	  else if (option == 2) {

                		  pFac = new PartTimeFaculty();  // Initializing object if part time faculty
                		  pFac.setIsPartTime(true);
                	  }    
                
                	  
                	  // Full time faculty
                	  
                	  if(fFac != null) {  
                		  
                		  // Setting name
                
                		  kb.nextLine();      
                          System.out.println("Enter name: ");
                          fFac.setName(name = kb.nextLine());
                          
                                         
                          // Setting age
                          
                          System.out.println("Enter age: ");
                          
                          do {  // Restricting unrealistic values
                        	  
                        	  fFac.setAge(age = kb.nextInt());
                   
                          } while (age<16 || age>100);
                  
                          
                          // Setting ID
                  
                          System.out.println("Enter ID: ");
                  
                          do {  // Restricting unrealistic values
                        	  
                        	  fFac.setID(ID = kb.nextLong());
                        	  
                          } while (ID<1000000 || ID>9999999);
                                         
                          
                          // Setting address
                          
                          System.out.println("Enter address: ");
                          kb.nextLine();  
                          fFac.setAddress(address = kb.nextLine()); 
                          
                          
                          // Setting phone number

                          System.out.println("Enter phone number. Please enter it in the form of xxx-xxx-xxxx.");
                          
                          do {  // Restricting unrealistic values
                        	  
                        	  fFac.setPhoneNumber(phoneNumber = kb.next());
                        	  
                          } while(phoneNumber.length() != 12);
                          
                          // Setting salary
                  
                          System.out.println("Enter monthly salary: ");
                          salary=kb.nextInt();
                          fFac.setSalary(salary);
                       
                       
                          fFac.showInfo();  // Displaying info of full time faculty member
                          arr[index++]=fFac; // Storing object into the array
                          System.out.println("Succesfully added.");
          	   
                	  }
                	  
                	  // Part time faculty
                	  
                	  else if(pFac != null) {
            
                		  // Setting name
                		  
                		  kb.nextLine();      
                		  System.out.println("Enter name: ");
                		  pFac.setName(name = kb.nextLine());
                            
                		  
                		  // Setting age
                                   
                		  System.out.println("Enter age: ");
                		  
                		  do { // Restricting unrealistic values
                			  
                			  pFac.setAge(age = kb.nextInt());
             
                		  } while (age<16 || age>100);
            
            
                		  // Setting ID
           
                		  System.out.println("Enter ID: ");
            
                		  do {  // Restricting unrealistic values
                			  
                			  pFac.setID(ID = kb.nextLong());
                			  
                		  } while (ID<1000000 || ID>9999999);
                                   
                                   
                		  // Setting address
                		                        
                		  System.out.println("Enter address: ");
                		  kb.nextLine();
                		  pFac.setAddress(address = kb.nextLine()); 
                		  
                		  
                		  // Setting phone number

                		  System.out.println("Enter phone number. Please enter it in the form of xxx-xxx-xxxx.");
                		 
                		  do {  // Restricting unrealistic values
                			  
                			  pFac.setPhoneNumber(phoneNumber = kb.next());
                			  
                		  } while(phoneNumber.length() != 12);
            
            
                		  // Determining number of classes taught
                		  
                		  System.out.println("How many classes does this person teach?");
                		  courses = kb.nextInt();
                       
                		  while (courses >= 3 || courses <= 0) {  // Only allows 1 or 2 courses
                       	
                			  System.out.println("Sorry, Part-Time Faculty members cannot teach " + courses + " courses. Please try again.");
                			  System.out.println();
                			  System.out.println("How many classes does this person teach?");
                			  courses= kb.nextInt();
                       }
                       
                       
                       
                		  if (courses == 1) {  
                			  
                			  // Determining salary based on amount of courses taught and students in class
                       	
                			  System.out.println("How many students are in the class?");
                			  classSize = kb.nextInt();
                			  pFac.setFirstClassSize(classSize);
                       	
                       	
                       		  System.out.println("Please enter the number of hours worked: ");
                       		  numHours = kb.nextDouble();
                       		  pFac.setNumHours(numHours);
                       		
                       		
                       		  System.out.println("Please enter the hourly rate: ");
                       		  hourlyRate = kb.nextDouble();
                       		  pFac.setHourlyRate(hourlyRate);
                       		  pFac.setBaseSalary();
                       		
                       		  pFac.setSalary();
                       		  System.out.println(pFac.getSalary());
                       		  System.out.println("Salary set");
                       		
                       		}	
                       
                		  if (courses == 2) {
                			  
                			  // Determining salary based on amount of courses taught and students in class
                       	
                			  System.out.println("How many students are in the first class?");
                			  classSize = kb.nextInt();
                			  pFac.setFirstClassSize(classSize);
                       	
                			  System.out.println("How many students are in the second class?");
                			  sClassSize = kb.nextInt();
                			  pFac.setSecondClassSize(sClassSize);
                			  
                       	
                       		  System.out.println("Please enter the number of hours worked: ");
                       		  numHours = kb.nextDouble();
                       		  pFac.setNumHours(numHours);
                       		
                       		
                       		  System.out.println("Please enter the hourly rate: ");
                       		  hourlyRate = kb.nextDouble();
                       		  pFac.setHourlyRate(hourlyRate);
                       		  pFac.setBaseSalary();
                       		
                       		  pFac.setSalary();
                       		  System.out.println(pFac.getSalary());
                       		  System.out.println("Salary set");
                       
                		  }    

                		  pFac.showInfo();  // Displays information of part time faculty member
                		  arr[index++]=pFac; // Storing object into the array
                		  System.out.println("Succesfully added.");
    	   
                	
                	  }
                	  
                	  break;  
                   
                  //Staff information

                  case 3:
       
                	  System.out.println("Please enter 1 for Full-time, 2 for Part-time.");
                	  option=kb.nextInt();
                	  FullTimeStaff fStaff=null;  // Creating null object from FullTimeStaff class
                	  PartTimeStaff pStaff=null;  // Creating null object from PartTimeStaff class
                
                	  if (option == 1) {

                		  fStaff = new FullTimeStaff();   // Initializing object if full time staff
                		  fStaff.setIsFullTime(true);

                	  } 
                	  
                	  else if (option == 2) {

                		  pStaff = new PartTimeStaff();   // Initializing object if part time staff
                		  pStaff.setIsPartTime(true);
                	  }    
                	  
                	  
                	  // Full time staff
              
                	  if(fStaff != null) { 
                		  
                		  // Setting name
                		  
                		  System.out.println("Enter name: ");
                		  kb.nextLine();
                		  fStaff.setName(name = kb.nextLine());
                		  
                                       
                		  // Setting age                 
                
                		  System.out.println("Enter age: ");
                		 
                		  do {  // Restricting unrealistic values
                			  
                			  fStaff.setAge(age = kb.nextInt());
                 
                		  } while (age<16 || age>100);
                
                
                		  // Setting ID
                		  
                		  System.out.println("Enter ID: ");
                
                		  do { // Restricting unrealistic values
                			  
                			  fStaff.setID(ID = kb.nextLong());
                			  
                		  } while (ID<1000000 || ID>9999999);
                                       
                                       
                		  // Setting address
                		                        
                		  System.out.println("Enter address: ");
                		  kb.nextLine(); 
                		  fStaff.setAddress(address = kb.nextLine()); 

               
                		  // Setting phone number
                		  
                		  System.out.println("Enter phone number. Please enter it in the form of xxx-xxx-xxxx.");
                		  
                		  do { // Restricting unrealistic values
                			  
                			  fStaff.setPhoneNumber(phoneNumber = kb.next());
                			  
                		  } while(phoneNumber.length() != 12);
                
                
                		  // Setting salary
                		  
                		  System.out.println("Enter monthly salary: ");
                		  salary=kb.nextInt();
                		  fStaff.setSalary(salary);
            
               
                		  fStaff.showInfo();    // Displays information of full time staff member
                		  arr[index++]=fStaff;  // Storing object into the array
                		  System.out.println("Succesfully added.");
                	  }
              
                	  else if(pStaff != null) {
          
                		  // Setting name
                		  
                		  System.out.println("Enter name: ");
                		  kb.nextLine();
                		  pStaff.setName(name = kb.nextLine());
                                 
                          
                		  // Setting name
                		  
                		  System.out.println("Enter age: ");
                		 
                		  do {  // Restricting unrealistic values
                			  
                			  pStaff.setAge(age = kb.nextInt());
           
                		  } while (age<16 || age>100);
          
          
                		  // Setting ID
          
                		  System.out.println("Enter ID: ");
          
                		  do { // Restricting unrealistic values
                			  
                			  pStaff.setID(ID = kb.nextLong());
                			  
                		  } while (ID<1000000 || ID>9999999);
                                 
                                 
                		  // Setting address
                		  
                		  System.out.println("Enter address: ");
                		  kb.nextLine();
                		  pStaff.setAddress(address = kb.nextLine());
                		  
                		  // Setting phone number
                		  
                		  System.out.println("Enter phone number. Please enter it in the form of xxx-xxx-xxxx.");
                		  
                		  do { // Restricting unrealistic values
                			  
                			  pStaff.setPhoneNumber(phoneNumber = kb.next());
           
                		  } while(phoneNumber.length() != 12);
                		  
                		  
                		  // Determining salary
          
                		  System.out.println("Press 1 if Regular Part-Time employee, press 2 if Commissioned Part-Time Employee.");
                		  option=kb.nextInt();
          
                		  if(option==1) {  
                			  
                			  // Setting salary for regular part time staff
          
                			  System.out.println("Enter number of hours: ");
                			  numHours=kb.nextInt();
          
                			  pStaff.setNumHours(numHours);
          
                			  System.out.println("Enter hourly rate:");
                			  hourlyRate=kb.nextDouble();
          
                			  pStaff.setHourlyRate(hourlyRate);
                			  pStaff.setSalary();
          
                		  }
                		  
                		  else if(option==2) {
                			  
                			  // Setting salary for commissioned part time staff
          	
                			  System.out.println("Enter base salary: ");
                			  salary=kb.nextDouble();
                			  pStaff.setSalary(salary);
          	
                			  System.out.println("Enter commission %:");
                			  commission=kb.nextDouble();
                			  pStaff.setCommission(commission);
                		  }
               
                		  pStaff.showInfo();  // Displaying info for part time staff member
                		  arr[index++]=pStaff; // Storing object into the array
                		  System.out.println("Succesfully added.");
                	  } 
               
                  }             
         
                  
                  	break;


			case 2:  // case 2 from first switch, searching for individuals and updating attributes

				System.out.println("Enter 1 to search individuals by ID or 2 by category.");
				option=kb.nextInt();
				
				
				switch(option) {
				
					case 1:  // searching by ID number
					
						System.out.println("Enter ID:");
						ID=kb.nextLong();
					
					
						int i;
						for (i=0; i<size; i++) {   // Searching the array of objects
						
							PersonalInformation individual = arr[i];
						
							if(individual  != null && (ID == individual.getID())){  // ID match found
                  
								individual.showInfo();
								System.out.println("Enter 1 to modify attributes, enter 2 to go back to main menu or enter 3 to delete individual.");
								option=kb.nextInt();
								
								if(option==1) {  // Modifying attributes
					
									
									// Full time faculty
									
									if(individual instanceof FullTimeFaculty){ 
										System.out.println("What attribute would you like to modify?");
										System.out.println("List:");
										System.out.println("Name, age, ID, address, phone number, salary, status.");
								
										kb.nextLine();
										type=kb.nextLine();
								
										// Updating name
								
										if((type.toLowerCase()).equals("name")){
											
											System.out.println("Enter name: ");
											individual.setName(kb.nextLine());
											System.out.println("Change confirmed. Information updated.");
										}
								
										// Updating age
										
										else if((type.toLowerCase()).equals("age")){
											
											System.out.println("Enter age: ");
										
											do { // Restricting unrealistic values
									
												individual.setAge(age = kb.nextInt()); 
								
											} while (age < 17 || age > 100);	
								
											System.out.println("Change confirmed. Information updated.");
									
										}
										
								
										// Updating ID
								
										else if((type.toLowerCase()).equals("id")){
											
											System.out.println("Enter ID: ");
									
											do { // Restricting unrealistic values
									
												individual.setID(ID = kb.nextLong());
									
											} while (ID<1000000 || ID>9999999);
									
											System.out.println("Change confirmed. Information updated.");
										}
									
										// Updating address
								
										else if((type.toLowerCase()).equals("address")){
										
											System.out.println("Enter address: ");
											individual.setAddress(kb.nextLine());
											System.out.println("Change confirmed. Information updated.");
									
										}
								
										// Updating phone number
								
										else if((type.toLowerCase()).equals("phone number")){
										
											System.out.println("Enter phone number: ");
										
											do { // Restricting unrealistic values
										
												individual.setPhoneNumber(phoneNumber = kb.nextLine());
										
											} while(phoneNumber.length() != 12);
											
											System.out.println("Change confirmed. Information updated.");
									
										}
										
										// Updating salary
								
										else if((type.toLowerCase()).equals("salary")){
										
										
											System.out.println("Enter monthly salary: ");
											salary=kb.nextInt();
											individual.setSalary(salary);
											System.out.println("Change confirmed. Information updated.");
										}
										
										// Updating status
										
										else if((type.toLowerCase()).equals("status")){
										
										
											((Faculty) individual).setIsPartTime(true);  
											
											System.out.println("Status changed to part-time.");	
											
										}
									} 
									
									// Part time faculty
									
									else if(individual instanceof PartTimeFaculty){ 
								
										System.out.println("What attribute would you like to modify?");
										System.out.println("List:");
										System.out.println("Name, age, ID, address, phone number, salary, status.");
										
										kb.nextLine();
										type=kb.nextLine();
									
										// Updating name
										
										if((type.toLowerCase()).equals("name")){
											
											System.out.println("Enter name: ");
											individual.setName(kb.nextLine());
											System.out.println("Change confirmed. Information updated.");
										}
									
										// Updating age
									
										else if((type.toLowerCase()).equals("age")){
										
											System.out.println("Enter age: ");
										
											do {  // Restricting unrealistic values
										
												individual.setAge(age = kb.nextInt()); 
									
											} while (age < 17 || age > 100);	
									
											System.out.println("Change confirmed. Information updated.");
										
										}
										
										// Updating ID
									
										else if((type.toLowerCase()).equals("id")){
										
											System.out.println("Enter ID: ");
										
											do { // Restricting unrealistic values
										
												individual.setID(ID = kb.nextLong());
										
											} while (ID<1000000 || ID>9999999);
										
											System.out.println("Change confirmed. Information updated.");
										}
									
										// Updating address
										
										else if((type.toLowerCase()).equals("address")){
											
											System.out.println("Enter address: ");
											individual.setAddress(kb.nextLine());
											System.out.println("Change confirmed. Information updated.");
										}
									
									
										// Updating phone number
										
										else if((type.toLowerCase()).equals("phone number")){
										
											System.out.println("Enter phone number: ");
										
											do {  // Restricting unrealistic values	
										
												individual.setPhoneNumber(phoneNumber = kb.nextLine());
										
											} while(phoneNumber.length() != 12);
										
											System.out.println("Change confirmed. Information updated.");
										}
										
										
										// Updating salary
										
										else if((type.toLowerCase()).equals("salary")){
										
											System.out.println("How many classes does this person teach?");
					                        courses = kb.nextInt();
					                       
					                        while (courses >= 3 || courses <= 0) {  // Restricting unrealistic values
					                       	
					                       	System.out.println("Sorry, Part-Time Faculty members cannot teach " + courses + " courses. Please try again.");
					                       	System.out.println();
					                       	System.out.println("How many classes does this person teach?");
					                       	courses= kb.nextInt();
					                       }
					                       
					                       if (courses == 1) {
					                       	
					                       		System.out.println("How many students are in the class?");
					                       		classSize = kb.nextInt();
					                       		((PartTimeFaculty) individual).setFirstClassSize(classSize);
					                       	
					                       		System.out.println("Please enter the number of hours worked: ");
					                       		numHours = kb.nextDouble();
					                       		((PartTimeFaculty) individual).setNumHours(numHours);
					                       		
					                       		System.out.println("Please enter the hourly rate: ");
					                       		hourlyRate = kb.nextDouble();
					                       		((PartTimeFaculty) individual).setHourlyRate(hourlyRate);
					                       		((PartTimeFaculty) individual).setBaseSalary();
					                       		
					                       		((PartTimeFaculty) individual).setSalary();
					                       		System.out.println("Salary set");
					                       		
					                       	}	
					                       
					                       if (courses == 2) {
					                       	
					                       		System.out.println("How many students are in the first class?");
					                       		classSize = kb.nextInt();
					                       		((PartTimeFaculty) individual).setFirstClassSize(classSize);
					                       		
					                       		System.out.println("How many students are in the second class?");
					                       		sClassSize = kb.nextInt();
					                       		((PartTimeFaculty) individual).setSecondClassSize(sClassSize);
					                       	
					                       		System.out.println("Please enter the number of hours worked: ");
					                       		numHours = kb.nextDouble();
					                       		((PartTimeFaculty) individual).setNumHours(numHours);
					                       		
					                       		System.out.println("Please enter the hourly rate: ");
					                       		hourlyRate = kb.nextDouble();
					                       		((PartTimeFaculty) individual).setHourlyRate(hourlyRate);
					                       		((PartTimeFaculty) individual).setBaseSalary();
					                       		
					                       		((PartTimeFaculty) individual).setSalary();
					                       		System.out.println("Salary set");
					                       
					                       }    

					                       	System.out.println("Change confirmed. Information updated.");
										}
										                                      
									
										// Updating status
										
										else if((type.toLowerCase()).equals("status")){
											
											((Faculty) individual).setIsFullTime(true);
											System.out.println("Status changed to full-time.");	
											
											}
									
									} 

									// Full Time Staff
									
									else if(individual instanceof FullTimeStaff){
								
										System.out.println("What attribute would you like to modify?");
										System.out.println("List:");
										System.out.println("Name, age, ID, address, phone number, salary, status.");
								
										kb.nextLine();
										type=kb.nextLine();
								
										// Updating name
										
										if((type.toLowerCase()).equals("name")){
											
											System.out.println("Enter name: ");
											individual.setName(kb.nextLine());
											System.out.println("Change confirmed. Information updated.");
										}
								
										// Updating age
								
										else if((type.toLowerCase()).equals("age")){
									
											System.out.println("Enter age: ");
									
											do { // Restricting unrealistic values
									
												individual.setAge(age = kb.nextInt()); 
								
											} while (age < 17 || age > 100);	
								
											System.out.println("Change confirmed. Information updated.");
									
										}
									
								
										// Updating ID
										
										else if((type.toLowerCase()).equals("id")){
									
											System.out.println("Enter ID: ");
									
											do { // Restricting unrealistic values
									
												individual.setID(ID = kb.nextLong());
									
											} while (ID<1000000 || ID>9999999);
									
											System.out.println("Change confirmed. Information updated.");
										}
								
										
										// Updating address
										
										else if((type.toLowerCase()).equals("address")){
										
											System.out.println("Enter address: ");
											individual.setAddress(kb.nextLine());
											System.out.println("Change confirmed. Information updated.");
									}
								
								
										// Updating phone number
										
										else if((type.toLowerCase()).equals("phone number")){
										
											System.out.println("Enter phone number: ");
										
										do { // Restricting unrealistic values	
										
											individual.setPhoneNumber(phoneNumber = kb.nextLine());
										
										} while(phoneNumber.length() != 12);
										
											System.out.println("Change confirmed. Information updated.");
										}
										
										// Updating salary
								
										else if((type.toLowerCase()).equals("salary")){
										
											System.out.println("Enter monthly salary: ");
											salary=kb.nextInt();
											individual.setSalary(salary);
											System.out.println("Change confirmed. Information updated.");
									}
										
										// Updating status
								
										else if((type.toLowerCase()).equals("status")){
										
											((Staff) individual).setIsPartTime(true);
											System.out.println("Status changed to part-time.");	
										
										}
								
									} 
								
									// Part Time staff
									
									else if(individual instanceof PartTimeStaff){ 
								
										System.out.println("What attribute would you like to modify?");
										System.out.println("List:");
										System.out.println("Name, age, ID, address, phone number, salary, status.");
								
										kb.nextLine();
										type=kb.nextLine();
								
										
										// Updating name
										
										if((type.toLowerCase()).equals("name")){
											
											System.out.println("Enter name: ");
											individual.setName(kb.nextLine());
											System.out.println("Change confirmed. Information updated.");
										}
								
										
										// Updating age
										
										else if((type.toLowerCase()).equals("age")){
									
											System.out.println("Enter age: ");
									
											do { // Restricting unrealistic values
									
												individual.setAge(age = kb.nextInt()); 
								
											} while (age < 17 || age > 100);	
								
											System.out.println("Change confirmed. Information updated.");
										}
									
								
										// Updating ID
								
										else if((type.toLowerCase()).equals("id")){
											
											System.out.println("Enter ID: ");
									
											do { // Restricting unrealistic values
									
												individual.setID(ID = kb.nextLong());
									
											} while (ID<1000000 || ID>9999999);
									
											System.out.println("Change confirmed. Information updated.");
										}
								
								
										// Updating address
								
										else if((type.toLowerCase()).equals("address")){
										
										System.out.println("Enter address: ");
										individual.setAddress(kb.nextLine());
										System.out.println("Change confirmed. Information updated.");
									}
								
								
										// Updating phone number
								
										else if((type.toLowerCase()).equals("phone number")){
										
											System.out.println("Enter phone number: ");
										
											do { // Restricting unrealistic values	
										
												individual.setPhoneNumber(phoneNumber = kb.nextLine());
										
											} while(phoneNumber.length() != 12);
										
											System.out.println("Change confirmed. Information updated.");
										}
								
										
										// Updating salary
										
										else if((type.toLowerCase()).equals("salary")) {
											System.out.println("Press 1 if Regular Part-Time employee, press 2 if Commissioned Part-Time Employee.");
											option=kb.nextInt();
						          
											if(option==1) {
						          
												System.out.println("Enter number of hours: ");
												numHours=kb.nextInt();
												((PartTimeStaff)individual).setNumHours(numHours);
						          
												System.out.println("Enter hourly rate:");
												hourlyRate=kb.nextDouble();
												((PartTimeStaff)individual).setHourlyRate(hourlyRate);
												
												((PartTimeStaff)individual).setSalary();
						          
											}
											
											else if(option==2) {
						          	
												System.out.println("Enter base salary: ");
												salary=kb.nextDouble();
												((PartTimeStaff)individual).setSalary(salary);
						          	
												System.out.println("Enter commission %");
												commission=kb.nextDouble();
												((PartTimeStaff)individual).setCommission(commission);
						          	
											}
						          		
											System.out.println("Change confirmed. Information updated.");
						          		
										}
										
						          			else if((type.toLowerCase()).equals("status")){
										
						          				((Staff) individual).setIsFullTime(true);
						          				System.out.println("Status changed to full-time.");	
						          			}
								
								
									}
									
									
									// Undergraduate TA
								
									else if(individual instanceof UndergradTA){ 
							
										System.out.println("What attribute would you like to modify?");
										System.out.println("List:");
										System.out.println("Name, ID, age, address, phone number, salary, status, current student");
								
										kb.nextLine();
										type=kb.nextLine();
								
										// Updating name
								
										if((type.toLowerCase()).equals("name")){
											
											System.out.println("Enter name: ");
											individual.setName(kb.nextLine());
											System.out.println("Change confirmed. Information updated.");
										}
										
								
										// Updating age
										
										else if((type.toLowerCase()).equals("age")){
									
											System.out.println("Enter age: ");
									
											do { // Restricting unrealistic values
									
												individual.setAge(age = kb.nextInt()); 
								
											} while (age < 17 || age > 100);	
								
											System.out.println("Change confirmed. Information updated.");
									
										}
									
								
										// Updating ID
										
										else if((type.toLowerCase()).equals("id")) {
									
											System.out.println("Enter ID: ");
									
											do { // Restricting unrealistic values
									
												individual.setID(ID = kb.nextLong());
									
											} while (ID<1000000 || ID>9999999);
									
											System.out.println("Change confirmed. Information updated.");
										}
								
								
										// Updating address
										
										else if((type.toLowerCase()).equals("address")) {
											
											System.out.println("Enter address: ");
											individual.setAddress(kb.nextLine());
											System.out.println("Change confirmed. Information updated.");
										}
								
								
										// Updating phone number
										
										else if((type.toLowerCase()).equals("phone number")){
										
											System.out.println("Enter phone number: ");
										
											do {  // Restricting unrealistic values	
										
												individual.setPhoneNumber(phoneNumber = kb.nextLine());
										
											} while(phoneNumber.length() != 12);
										
											System.out.println("Change confirmed. Information updated.");
										}
								
										// Updating status
										
										else if((type.toLowerCase()).equals("status")){
										
											((Student) individual).setIsGrad(true);
											System.out.println("Status changed to graduate.");	
										}
								
										
										// Updating salary
										
										else if ((type.toLowerCase()).equals("salary")) {
										
										System.out.println("Would you like to register this person as a TA?");
						           	  	type = kb.nextLine();
						                  
						           	  		if (type.toLowerCase().equals("yes") && ((UndergradTA)individual).getCurrentStudent()==(true)){  

						           	  			System.out.println("Enter the number of hours worked: ");
						           	  			numHours = kb.nextDouble();
						           	  			((UndergradTA)individual).setNumHours(numHours);
						                       
						                	  	System.out.println("Enter the hourly rate: ");
						                	  	hourlyRate = kb.nextDouble();
						                	  	((UndergradTA)individual).setHourlyRate(hourlyRate);
						                       
						                	  	((UndergradTA)individual).setSalary();
						                       
						                	  	System.out.println("Salary set. Information updated.");
						                	  	
						           	  	 	}
						           	  		
						           	  		else if (type.toLowerCase().equals("yes") && ((UndergradTA)individual).getCurrentStudent()==(false)) {
						           	  		
						           	  			System.out.println("This person is not a current student and therefore not qualified for a TA position.");
						           	  			System.out.println("Salary not set.");
						           	  		}
						           	  		
						           	  		else if (type.toLowerCase().equals("no")) {
						                	  		
						           	  			System.out.println("Salary not set.");
						                	}
				                	  	
										}
										
										
										// Updating current/not current student 
								
										else if ((type.toLowerCase()).equals("current student")){
										
											if(((Student) individual).getCurrentStudent()==true){
												
												((Student) individual).setCurrentStudent(false);
												System.out.println("Status chenged to: not longer a current student.");
									
											}
											
											else if(((Student) individual).getCurrentStudent()==false){
											
											    	((Student) individual).setCurrentStudent(true);
											    	System.out.println("Status changed to current student.");
											    	
											}
									
										}
								
									}
							
								
									// Graduate TA
									
									else if(individual instanceof GradTA){ 
								
										System.out.println("What attribute would you like to modify?");
										System.out.println("List:");
										System.out.println("Name, ID, age, address, phone number, status, salary, current student, status.");
								
										kb.nextLine();
										type=kb.nextLine();
								
								
										// Updating name
										
										if((type.toLowerCase()).equals("name")) {
											
											System.out.println("Enter name: ");
											individual.setName(kb.nextLine());
											System.out.println("Change confirmed. Information updated.");
										}
								
								
										// Updating age
										
										else if((type.toLowerCase()).equals("age")){
									
											System.out.println("Enter age: ");
									
											do { // Restricting unrealistic values
									
												individual.setAge(age = kb.nextInt()); 
								
											} while (age < 17 || age > 100);	
								
									
											System.out.println("Change confirmed. Information updated.");
									
										}
									
								
										// Updating ID
										
										else if((type.toLowerCase()).equals("id")){
									
											System.out.println("Enter ID: ");
									
											do {
									
												individual.setID(ID = kb.nextLong());
									
											} while (ID<1000000 || ID>9999999);
									
											System.out.println("Change confirmed. Information updated.");
										}
								
										
										// Updating address
								
										else if((type.toLowerCase()).equals("address")){
										
											System.out.println("Enter address: ");
											individual.setAddress(kb.nextLine());
											System.out.println("Change confirmed. Information updated.");
										}
								
										// Updating phone number
								
										else if((type.toLowerCase()).equals("phone number")){
										
											System.out.println("Enter phone number: ");
										
											do { // Restricting unrealistic values
										 
												individual.setPhoneNumber(phoneNumber = kb.nextLine());
										
											} while(phoneNumber.length() != 12);
										
											System.out.println("Change confirmed. Information updated.");
									
										}
										
										//Updating salary
								
										else if ((type.toLowerCase()).equals("salary")){
										
											System.out.println("Would you like to register this person as a TA?");
				                  	  		type = kb.nextLine();
				                       
				                  	  	
				                  	  	
				                  	  		if (type.toLowerCase().equals("yes") && ((GradTA)individual).getCurrentStudent()==(true)){  

				                  	  			System.out.println("Enter the number of hours worked: ");
				                  	  			numHours = kb.nextDouble();
				                  	  			((GradTA)individual).setNumHours(numHours);
				                              
				                  	  			((GradTA)individual).setHourlyRate();
				                  	  			((GradTA)individual).setSalary();
				                       	  		
				                  	  			System.out.println("Salary set. Information updated.");
				                       	  	
				                  	  	 		}
				                  	  	
				                  	  		else if (type.toLowerCase().equals("yes") && ((GradTA)individual).getCurrentStudent()==(false)) {
				                  	  		
				                  	  			System.out.println("This person is not a current student and therefore not qualified for a TA position.");
				                  	  			System.out.println("Salary not set.");
				                  	  		}
				                  	  		
				                  	  		else if (type.toLowerCase().equals("no")) {
				                       	  		
				                  	  			System.out.println("Salary not set.");
				                       	  		
				                  	  		}
										
										}
										
											// Updating status
								
											else if((type.toLowerCase()).equals("status")){
										
												((Student)individual).setIsGrad(true);
												System.out.println("Status changed to undergraduate.");	
											}
								
										
											// Updating current/not current student
										
											else if ((type.toLowerCase()).equals("current student")){
										
										
												if(((Student) individual).getCurrentStudent()==true){
											
													((Student) individual).setCurrentStudent(false);
													System.out.println("Status changed to: no longer a current student.");
									
												}
												
												else if(((Student) individual).getCurrentStudent()==false){
											
											    	((Student) individual).setCurrentStudent(true);
											    	System.out.println("Status changed to: current student.");
											    }
											}
									}
								}
							
								else if(option==2){  // Returns to main menu
							    	
							    	System.out.println("Hi.");
							    	
							    }
										
							 else if(option==3){  // Deletes object (individual) from array
							
								 arr[i]=null;
								 System.out.println("Succesfully deleted.");
								 
							 }
						}
					
					}

					break;
				
					
				case 2:  // Searching by category

				System.out.println("Search “Full-Time Faculty, Part-Time Faculty, Full-Time Staff, Part-Time Staff, Undergraduate Student, Graduate Student”");
					
				kb.nextLine();
				type=kb.nextLine();		
				
				for (PersonalInformation  individual : arr)
				{
				
				if(individual != null && "Full-Time Faculty".equals(type) )
				
				{	
					
					
				if(individual instanceof FullTimeFaculty){ individual.showInfo();
				} 
				continue;
				
				}
				
				
				
				else if(individual != null && "Part-Time Faculty".equals(type))
				
				{	

				if(individual instanceof PartTimeFaculty){ individual.showInfo();
				}
				continue;
				
				
				
				}
					

					


				else if(type.equals("Full-Time Staff")){	

				if(individual instanceof FullTimeStaff){ individual.showInfo();
				} 
				continue;
				
				}






				else if(type.equals("Part-Time Staff")){	

				if(individual instanceof PartTimeStaff){ individual.showInfo();}
				continue;
				
				}

					

				else if(type.equals("Undergraduate Student")){	

				if(individual instanceof UndergradTA){ individual.showInfo();}
				continue;
				
					
				} 



				else if(type.equals("Graduate Student")){	

				if(individual instanceof GradTA){ individual.showInfo();}
				continue;
				
				}



				else{System.out.println("No individuals found.");
				}
				
				break;

				
				
				}
					
		}
				break;
     		
             
             case 3:
    			
    			salarySum=0;
    		
    			for (PersonalInformation individual : arr)
    			
    			{
    			if(individual != null){
    		    salarySum+=individual.getSalary();
    			}else{continue;}
    			}
    			
    			System.out.println("Total amount of money to be paid to all Concordia employees: $"+salarySum);
    				
    				break;
    				
    			
     		case 4:
     			
     			 d.advanceToNextMonth();
     			 monthCounter ++;
     			 quarterCounter ++;
     			 
     			 
     			 if (quarterCounter > 4) {
     				 
     				 quarterCounter = 0;
     				 
     				int i;
     				
    			     for (i=0;i<size;i++) {
    			    	 
    			    	PersonalInformation individual=arr[i];
    			    	
    			    	if(individual instanceof GradTA || individual instanceof UndergradTA) {
    			    		
    			    		arr[i] = null;
    			    		
    			    		
     			    		System.out.println("1 term has passed.");
     			    		System.out.println("All students have been removed.");
    			    		
    			    	}
     				 
     			 
    			     }
    			     
     			 }
     			 
     			 
     			 
     			 if (monthCounter > 12) {
     				 
     				 monthCounter = 0;
     				 
     				 int i;
     				
     			     for (i=0;i<size;i++) {
     			    	 
     			    	PersonalInformation individual=arr[i];
     			    	
     			    	if(individual instanceof PartTimeFaculty || individual instanceof PartTimeStaff) {
     			    		
     			    		arr[i] = null;
     			    		
     			    		System.out.println("12 months have passed.");
     			    		System.out.println("All part-time faculty and staff have been removed.");
     			    	}
     			    	
     			    	 
     			     }
     			     
     			     
     			     
     			 }
     				 
     			
     			 break;
    			
    				
	  
				
        		}
        			
        		
        
		
			}
			
				
				
		
				
	 
				
	 }
			
				
		
				
				
  } 
 


