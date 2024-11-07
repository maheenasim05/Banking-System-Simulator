/*Name:                Maheen Asim
 * 
 *Project Description: This project involves defining classes for various banking entities such as customers, 
 *					   employees, and accounts, implementing methods for transactions and operations, and 
 *					   designing a program that interacts with these classes based on user input from a text 
 *					   file.
 *
 *Start Date: 		   5th April, 2024
 *End Date:            19th April, 2024
 *
 **/





import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Project2
{
	public static void main(String[] args)
	{
		try																		//try-catch block
		{
			File file = new File("input.txt");								//creating a File object
			PrintWriter writer = new PrintWriter("output.txt");					//creating a PrintWriter object
			Scanner scnr = new Scanner(file);									//creating a Scanner object
							
			while(scnr.hasNextLine())											//while the file has a next line to read
			{
				String objectType = scnr.nextLine();							//reading the file for user's objectType
				
				if (objectType.equals("0")) {

					writer.close();												//closing the writer object
					System.exit(0);												//Exiting the system
				}
				
				else 
				{
					switch(objectType)											//switch-case block
					{
				
					
					case "Customer":
					{															
						String constructor = scnr.nextLine();
						switch (constructor)
						{
						case "1":
						{
							String name = scnr.nextLine();								//read input file for name
							String address = scnr.nextLine();							//read input file for address
						
							String licenseNumber = scnr.nextLine();						//read input file for license number
							
							//checking if length of license number is 8 digit and starts with two letters 
							if(licenseNumber.length()== 8 && Character.isLetter(licenseNumber.charAt(0)) && Character.isLetter(licenseNumber.charAt(1)))
							{
								//checking if the two letters are in upper case
								if(Character.isUpperCase(licenseNumber.charAt(0)) && Character.isUpperCase(licenseNumber.charAt(1)))
								{
								
									for(int i=2; i<licenseNumber.length(); i++)
									{
									
										if(!Character.isDigit(licenseNumber.charAt(i)))
										{
											System.out.println("Error");
											writer.println("Error");
											writer.close();
											System.exit(0);
										}
									}
								}
								else
								{
									System.out.println("Error");
									writer.println("Error");
									writer.close();
									System.exit(0);
								}
							}
							else 
							{
								System.out.println("Error, incorrect license number");
								writer.println("Error, incorrect license number");
								writer.close();
								System.exit(0);
							}
						
							Customer cust = new Customer(name, address, licenseNumber);		//creating a Customer object
					
							String methodType = scnr.nextLine();							//read input file to get method number
							
							while(!methodType.equals("0")) {
								switch(methodType) {
								
								
								case "1":													 
									System.out.println(cust.getName()); 					//printing output to console
									writer.println(cust.getName());							//printing output to the output file
									methodType = scnr.nextLine();							//reading input file for next method
									break;
								
								case "2":
									System.out.println(cust.getAddress());					//printing output to console
									writer.println(cust.getAddress());						//printing output to the output file
									methodType = scnr.nextLine();							//reading input file for next method
									break;
								
								case "3":
									System.out.println(cust.getLicenseNumber());			//printing output to console
									writer.println(cust.getLicenseNumber());				//printing output to the output file
									methodType = scnr.nextLine();							//reading input file for next method
									break;
								
								case "4":
									name = scnr.nextLine();
									cust.setName(name);
									methodType = scnr.nextLine();							//reading input file for next method
									break;
									
								case "5":
									address = scnr.nextLine();
									cust.setAddress(address);
									methodType = scnr.nextLine();							//reading input file for next method
									break;
								
								case "6":
									licenseNumber = scnr.nextLine();
									cust.setLicenseNumber(licenseNumber);
									methodType = scnr.nextLine();							//reading input file for next method
									break;
						
								default:													//default error case
									System.out.println("Error");
									writer.println("Error");
									writer.close();
									System.exit(0);
								}
							}
						break;
						}
						}
					break;
					}
						
					
					//Employee object
					case "Employee":
					{
						String constructor = scnr.nextLine();
						
						switch (constructor)
						{
						
						case "1":
						{
							String name = scnr.nextLine();								//read input file for name
							String address = scnr.nextLine();							//read input file for address
							
							String licenseNumber = scnr.nextLine();						//read input file for license number
							String strEmployeeID = scnr.nextLine();						//read input file for employee ID
							int employeeID = Integer.parseInt(strEmployeeID);			//converting the string into integer
							
							if(strEmployeeID.length()>8) {
								System.out.println("Error");
								writer.println("Error");
								writer.close();
								System.exit(0);
							}
							
							if(licenseNumber.length()== 8 && Character.isLetter(licenseNumber.charAt(0)) && Character.isLetter(licenseNumber.charAt(1)))
							{
							
								if(Character.isUpperCase(licenseNumber.charAt(0)) && Character.isUpperCase(licenseNumber.charAt(1)))
								{
								
									for(int i=2; i<licenseNumber.length(); i++)
									{
									
										if(!Character.isDigit(licenseNumber.charAt(i)))
										{
											System.out.println("Error");
											writer.println("Error");
											writer.close();
											System.exit(0);
										}
									}
								}
								else
								{
									System.out.println("Error");
									writer.println("Error");
									writer.close();
									System.exit(0);
								}
							}
							else 
							{
								System.out.println("Error");
								writer.println("Error");
								writer.close();
								System.exit(0);
							}
							
							
							
							Employee employee = new Employee(name, address, licenseNumber, employeeID); 	//creating Employee object
						
							String methodType = scnr.nextLine();											//read input file to get method number
							
							while(!methodType.equals("0")) 
							{
								switch(methodType) 
								{
								
								
								case "1":
									System.out.println(employee.getName());					//printing output to console
									writer.println(employee.getName());						//printing output to the output file
									methodType = scnr.nextLine();							//reading input file for next method
									break; 
									
								case "2":
									System.out.println(employee.getAddress());				//printing output to console
									writer.println(employee.getAddress());					//printing output to the output file
									methodType = scnr.nextLine();							//reading input file for next method
									break;
									
								case "3":
									System.out.println(employee.getLicenseNumber());		//printing output to console
									writer.println(employee.getLicenseNumber());			//printing output to the output file
									methodType = scnr.nextLine();							//reading input file for next method
									break;
									
								case "4":
									System.out.println(String.format("%08d",employee.getEmployeeID()));			//printing output to console
									writer.println(String.format("%08d",employee.getEmployeeID()));				//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;
									
								case "5":
									name = scnr.nextLine();
									employee.setName(name);
									methodType = scnr.nextLine();							//reading input file for next method
									break;
									
								case "6":
									address = scnr.nextLine();
									employee.setAddress(address);
									methodType = scnr.nextLine();							//reading input file for next method
									break;
									
								case "7":
									licenseNumber = scnr.nextLine();
									employee.setLicenseNumber(licenseNumber);
									methodType = scnr.nextLine();							//reading input file for next method
									break;
									
								case "8":
									strEmployeeID = scnr.nextLine();
									
									if(strEmployeeID.length()>8) {
										System.out.println("Error");
										writer.println("Error");
										writer.close();
										System.exit(0);
									} 
									else {
										
									int newEmployeeID = Integer.parseInt(strEmployeeID);
									employee.setEmployeeID(newEmployeeID);
									methodType = scnr.nextLine();							//reading input file for next method
									
									}
									break;
									
								default:
									System.out.println("Error");
									writer.println("Error");
									writer.close();
									System.exit(0);
								}
							}
						break;
							}
						default:
							System.out.println("Error");
							writer.println("Error");
							writer.close();
							System.exit(0);
						}
					break;
					}
							
				
					//Loan object
					case "Loan":{
						String constructor = scnr.nextLine();
					
						switch(constructor)
						{
						//Loan object first constructor
						case "1":
						{
							String name = scnr.nextLine();
							Loan loan1 = new Loan(name);
							
							
							String methodType = scnr.nextLine(); 					//read input file to get method number
							
							while(!methodType.equals("0")) {
								switch (methodType)
								{
							
								
								case "1":
									System.out.println(String.format("%.2f",loan1.getAccountBalance()));		//printing output to console
									writer.println(String.format("%.2f",loan1.getAccountBalance()));			//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								case "2":
									String accno = String.valueOf(loan1.getAccountNumber());
									//checking if account number is 10 digits exactly
									if(accno.length()>10) {														
										System.out.println("Error");
										writer.println("Error");
										writer.close();
										System.exit(0);
									}
									else {
										System.out.println(String.format("%010d", loan1.getAccountNumber()));	//printing output to console
										writer.println(String.format("%010d", loan1.getAccountNumber()));		//printing output to the output file
										methodType = scnr.nextLine();											//reading input file for next method
										break;
									}
								
								case "3":
									System.out.println(loan1.getAnnualInterestRate());							//printing output to console
									writer.println(loan1.getAnnualInterestRate());								//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								case "4":
									System.out.println(loan1.getNumberOfYears());								//printing output to console
									writer.println(loan1.getNumberOfYears());									//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;	
								
								case "5":
									System.out.println(loan1.getLoanDate());									//printing output to console
									writer.println(loan1.getLoanDate());										//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								case "6":
									System.out.println(loan1.getName());										//printing output to console
									writer.println(loan1.getName());											//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								case "7":
									String strAccountBalance = scnr.nextLine();
									double newAccountBalance = Double.parseDouble(strAccountBalance);			//converting string to double
									loan1.setAccountBalance(newAccountBalance);
									methodType = scnr.nextLine();												//reading input file for next method
									break;
							
								case "8":
									String annInterestRate = scnr.nextLine();
									double newAnnualInterestRate = Double.parseDouble(annInterestRate);
									loan1.setAnnualInterestRate(newAnnualInterestRate);
									methodType = scnr.nextLine();												//reading input file for next method
									break;
							
								case "9":
									String strNumberOfYears = scnr.nextLine();
									int newNumberOfYears = Integer.parseInt(strNumberOfYears);
									loan1.setNumberOfYears(newNumberOfYears);
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								case "10":
									System.out.println(String.format("%.2f",loan1.getMonthlyPayment()));		//printing output to console
									writer.println(String.format("%.2f",loan1.getMonthlyPayment()));			//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								case "11":
									System.out.println(String.format("%.2f",loan1.getTotalPayment()));			//printing output to console
									writer.println(String.format("%.2f",loan1.getTotalPayment()));				//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;	
								
								
								default:
									System.out.println("Error");
									writer.println("Error");
									writer.close();
									System.exit(0);
								}
							}
						break;}
						
							//Loan object second constructor
						case "2":
						{
							String strAccountNumber = scnr.nextLine();
							long accountNumber = Long.parseLong(strAccountNumber);
							if(strAccountNumber.length()>10) {
								
									System.out.println("Error");
									writer.println("Error");
									writer.close();
									System.exit(0);
							}
						
							String strAccountBalance = scnr.nextLine();
							double accountBalance = Double.parseDouble(strAccountBalance);
						
						
							String strAnnualInterestRate = scnr.nextLine();
							double annualInterestRate = Double.parseDouble(strAnnualInterestRate); 
						
							String strNumberOfYears = scnr.nextLine();
							int numberOfYears = Integer.parseInt(strNumberOfYears);
						
							String name = scnr.nextLine();
						
							Loan loan2 = new Loan(accountNumber, accountBalance, annualInterestRate, numberOfYears, name);
						
							String methodType = scnr.nextLine();													//read input file to get method number
							
							while(!methodType.equals("0")) {
								switch (methodType)
								{
								
								case "1":
									System.out.println(String.format("%.2f",loan2.getAccountBalance()));			//printing output to console
									writer.println(String.format("%.2f",loan2.getAccountBalance()));				//printing output to the output file
									methodType = scnr.nextLine();													//reading input file for next method
									break;
								
								case "2":
									
									System.out.println(String.format("%010d",loan2.getAccountNumber()));		//printing output to console
									writer.println(String.format("%010d",loan2.getAccountNumber()));			//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								case "3":
									System.out.println(loan2.getAnnualInterestRate());							//printing output to console
									writer.println(loan2.getAnnualInterestRate());								//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								case "4":
									System.out.println(loan2.getNumberOfYears());								//printing output to console
									writer.println(loan2.getNumberOfYears());									//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								case "5":
									System.out.println(loan2.getLoanDate());									//printing output to console
									writer.println(loan2.getLoanDate());										//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;
									
								case "6":	
									System.out.println(loan2.getName());										//printing output to console
									writer.println(loan2.getName());											//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;	
								
								case "7":
									String strAccBalance = scnr.nextLine();
									double newAccountBalance = Double.parseDouble(strAccBalance);
									loan2.setAccountBalance(newAccountBalance);
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								case "8":
									String annInterestRate = scnr.nextLine();
									double newAnnualInterestRate = Double.parseDouble(annInterestRate);
									loan2.setAnnualInterestRate(newAnnualInterestRate);
									methodType = scnr.nextLine();												//reading input file for next method
									break;
							
								case "9":
									String strNOfYears = scnr.nextLine();
									int newNumberOfYears = Integer.parseInt(strNOfYears);
									loan2.setNumberOfYears(newNumberOfYears);
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								case "10":
									System.out.println(String.format("%.2f",loan2.getMonthlyPayment()));		//printing output to console
									writer.println(String.format("%.2f",loan2.getMonthlyPayment()));			//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								case "11":
									System.out.println(String.format("%.2f",loan2.getTotalPayment()));			//printing output to console
									writer.println(String.format("%.2f",loan2.getTotalPayment()));				//printing output to the output file
									methodType = scnr.nextLine();												//reading input file for next method
									break;
								
								
								default:
									System.out.println("Error");
									writer.println("Error");
									writer.close();
									System.exit(0);
								}
							
							}
						break;}
						default:
							System.out.println("Error");
							writer.println("Error");
							System.exit(0);
						}
					break;}
							
					
					
						//Checking object	
						case "Checking":{
					
							String constructor = scnr.nextLine();
					
							switch(constructor) {
					
							//Checking object first constructor
							case "1":
							{
								String strAnnualInterestRate1 = scnr.nextLine();
								double annualInterestRate1 = Double.parseDouble(strAnnualInterestRate1);
						
								String name = scnr.nextLine();
								
								Checking check1 = new Checking(annualInterestRate1, name);
						
								String methodType = scnr.nextLine();											//read input file to get method number
								
								while(!methodType.equals("0")) {
									switch(methodType) {
									
									
									case "1":
										System.out.println(String.format("%.2f",check1.getAccountBalance()));	//printing output to console
										writer.println(String.format("%.2f",check1.getAccountBalance()));		//printing output to the output file
										methodType = scnr.nextLine();											//reading input file for next method
										break;
								
									case "2":
										String accno = String.valueOf(check1.getAccountNumber());
										if(accno.length()>10) {
											System.out.println("Error");
											writer.println("Error");
											writer.close();
											System.exit(0);
										}
										else {
											System.out.println(String.format("%010d", check1.getAccountNumber()));	//printing output to console
											writer.println(String.format("%010d", check1.getAccountNumber()));								//printing output to the output file
											methodType = scnr.nextLine();											//reading input file for next method
											break;
										}
										
								
									case "3":
										String strAccBalance = scnr.nextLine();
										double newAccountBalance = Double.parseDouble(strAccBalance);
										check1.setAccountBalance(newAccountBalance);
										methodType = scnr.nextLine();												//reading input file for next method
										break;
								
									case "4":
										System.out.println(check1.getAnnualInterestRate());							//printing output to console
										writer.println(check1.getAnnualInterestRate());								//printing output to the output file
										methodType = scnr.nextLine();												//reading input file for next method
										break;		
								
									case "5":
										System.out.println(check1.getName());										//printing output to console
										writer.println(check1.getName());											//printing output to the output file
										methodType = scnr.nextLine();												//reading input file for next method
										break;
								
									case "6":
										strAnnualInterestRate1 = scnr.nextLine();
										double newAnnInterestRate = Double.parseDouble(strAnnualInterestRate1);
										check1.setAnnualInterestRate(newAnnInterestRate);
										methodType = scnr.nextLine();												//reading input file for next method
										break; 
								
									case "7":
										String strDeposit = scnr.nextLine();
										Double deposit = Double.parseDouble(strDeposit);
										check1.makeDeposit(deposit);
										methodType = scnr.nextLine();									//reading input file for next method
										break; 
								
									case "8":
										String strWithdrawal = scnr.nextLine();
										Double withdrawal = Double.parseDouble(strWithdrawal);
										//checking for overdraft error
										if(withdrawal>check1.getAccountBalance()+1) {
											System.out.println("Overdraft!");
											writer.println("Overdraft!");
											writer.close();
											System.exit(0);
										}
										else {
											
											check1.makeWithdrawal(withdrawal);
											
										}
										methodType = scnr.nextLine();									//reading input file for next method
										break;
								
									default:
										System.out.println("Error");
										writer.println("Error");
										writer.close();
										System.exit(0);
									}
								}
							break;}
					
								//Checking object second constructor	
							case "2":
							{
								String strAccountNumber = scnr.nextLine();
								long accountNumber = Long.parseLong(strAccountNumber);
								if(strAccountNumber.length()>10) {
									
									System.out.println("Error");
									writer.println("Error");
									writer.close();
									System.exit(0);
								}
								
								String strAccountBalance = scnr.nextLine();
								double accountBalance = Double.parseDouble(strAccountBalance);
								
								String strAnnualInterestRate1 = scnr.nextLine();
								double annInterestRate = Double.parseDouble(strAnnualInterestRate1);
						
								String name = scnr.nextLine();
						
								Checking check2 = new Checking(annInterestRate, accountBalance, accountNumber, name);
						
								String methodType = scnr.nextLine();						//read input file to get method number
						
								while(!methodType.equals("0")) {
									switch(methodType) {
									
									case "1":
										System.out.println(String.format("%.2f", check2.getAccountBalance()));	//printing output to console
										writer.println(String.format("%.2f", check2.getAccountBalance()));		//printing output to the output file
										methodType = scnr.nextLine();											//reading input file for next method
										break;
								
									case "2":
										System.out.println(String.format("%010d",check2.getAccountNumber()));	//printing output to console
										writer.println(String.format("%010d",check2.getAccountNumber()));		//printing output to the output file
										methodType = scnr.nextLine();											//reading input file for next method
										break;
								
									case "3":
										String strAccBalance = scnr.nextLine();
										double newAccountBalance = Double.parseDouble(strAccBalance);
										check2.setAccountBalance(newAccountBalance);
										methodType = scnr.nextLine();											//reading input file for next method
										break;
								
									case "4":
										System.out.println(check2.getAnnualInterestRate());						//printing output to console
										writer.println(check2.getAnnualInterestRate());							//printing output to the output file
										methodType = scnr.nextLine();											//reading input file for next method
										break;
								
									case "5":
										System.out.println(check2.getName());									//printing output to console
										writer.println(check2.getName());										//printing output to the output file
										methodType = scnr.nextLine();											//reading input file for next method
										break;
								
									case "6":
										strAnnualInterestRate1 = scnr.nextLine();
										double newAnnInterestRate = Double.parseDouble(strAnnualInterestRate1);
										check2.setAnnualInterestRate(newAnnInterestRate);
										methodType = scnr.nextLine();					//reading input file for next method
										break; 
								
									case "7":
										String strDeposit = scnr.nextLine();
										Double deposit = Double.parseDouble(strDeposit);
										check2.makeDeposit(deposit);
										methodType = scnr.nextLine();					//reading input file for next method
										break; 
								
									case "8":
										String strWithdrawal = scnr.nextLine();
										Double withdrawal = Double.parseDouble(strWithdrawal);
										if(withdrawal>check2.getAccountBalance()+1) {
											System.out.println("overdraft");
											writer.println("overdraft");
											writer.close();
											System.exit(0);
										}
										else {
											
											check2.makeWithdrawal(withdrawal);
											
										}
										
										methodType = scnr.nextLine();					//reading input file for next method
										break;
								
									default:
										System.out.println("Error");
										writer.println("Error");
										writer.close();
										System.exit(0);
									}
				
								}
								break;
							}
								
							default:
								System.out.println("Error");
								writer.println("Error");
								writer.close();
								System.exit(0);
							}
						break;}
								
					
					
					
					
							//Savings Object	
						case "Savings":{
					
							String constructor = scnr.nextLine();
							switch(constructor) {
					
							//Savings object first constructor
							case "1":{
								String strAnnualInterestRate2 = scnr.nextLine();
								double annualInterestRate = Double.parseDouble(strAnnualInterestRate2);
						
								String name = scnr.nextLine();
						
								Savings save1 = new Savings(annualInterestRate, name);
						
								String methodType = scnr.nextLine();						//read input file to get method number
						
								while(!methodType.equals("0")) {
									switch(methodType) {
									
									
									case "1":
										System.out.println(String.format("%.2f",save1.getAccountBalance()));	//printing output to console
										writer.println(String.format("%.2f",save1.getAccountBalance()));		//printing output to the output file
										methodType = scnr.nextLine();											//reading input file for next method
										break;
								
									case "2":
										String accno = String.valueOf(save1.getAccountNumber());
										if(accno.length()>10) {
											System.out.println("Error");
											writer.println("Error");
											writer.close();
											System.exit(0);
										}
										else {
											System.out.println(String.format("%010d", save1.getAccountNumber()));	//printing output to console
											writer.println(String.format("%010d", save1.getAccountNumber()));								//printing output to the output file
											methodType = scnr.nextLine();											//reading input file for next method
											break;
										}
										
								
									case "3":
										String strAccBalance = scnr.nextLine();
										double newAccountBalance = Double.parseDouble(strAccBalance);
										save1.setAccountBalance(newAccountBalance);
										methodType = scnr.nextLine();						//reading input file for next method
										break;
								
									case "4":
										System.out.println(save1.getAnnualInterestRate());	//printing output to console
										writer.println(save1.getAnnualInterestRate());		//printing output to the output file
										methodType = scnr.nextLine();						//reading input file for next method
										break;
								
									case "5":
										System.out.println(save1.getName());		//printing output to console
										writer.println(save1.getName());			//printing output to the output file
										methodType = scnr.nextLine();				//reading input file for next method
										break;
								
									case "6":
										String strAnnInterestRate2 = scnr.nextLine();
										double newAnnInterestRate = Double.parseDouble(strAnnInterestRate2);
										save1.setAnnualInterestRate(newAnnInterestRate);
										methodType = scnr.nextLine();				//reading input file for next method
										break; 
								
									case "7":
										String strDeposit = scnr.nextLine();
										Double deposit = Double.parseDouble(strDeposit);
										save1.makeDeposit(deposit);
										methodType = scnr.nextLine();				//reading input file for next method
										break; 
								
									case "8":
										String strWithdrawal = scnr.nextLine();
										Double withdrawal = Double.parseDouble(strWithdrawal);
										if(withdrawal>save1.getAccountBalance()+1) {
											System.out.println("Overdraft!");
											writer.println("Overdraft!");
											writer.close();
											System.exit(0);
										}
										else {
											
											save1.makeWithdrawal(withdrawal);
											
										}
										
										methodType = scnr.nextLine();				//reading input file for next method
										break;
								
									default:
										System.out.println("Error");
										writer.println("Error");
										writer.close();
										System.exit(0);
									}
								}
							break;}
					
								//Savings object second constructor	
							case "2":{
								
								String strAccountNumber = scnr.nextLine();
								long accountNumber = Long.parseLong(strAccountNumber);
								if(strAccountNumber.length()>10) {
									
									System.out.println("Error");
									writer.println("Error");
									writer.close();
									System.exit(0);
								}
								
								String strAccountBalance = scnr.nextLine();
								double accountBalance = Double.parseDouble(strAccountBalance);
								
								String strAnnualInterestRate2 = scnr.nextLine();
								double annualInterestRate2= Double.parseDouble(strAnnualInterestRate2);
						
								String name = scnr.nextLine();
						
								Savings save2 = new Savings(annualInterestRate2, accountBalance, accountNumber, name);
						
								String methodType = scnr.nextLine();						//read input file to get method number
						
								while(!methodType.equals("0")) {
									switch(methodType) {
									
									case "1":
										System.out.println(String.format("%.2f",save2.getAccountBalance()));	//printing output to console
										writer.println(String.format("%.2f",save2.getAccountBalance()));		//printing output to the output file
										methodType = scnr.nextLine();											//reading input file for next method
										break;
								
									case "2":
										System.out.println(String.format("%010d",save2.getAccountNumber()));	//printing output to console
										writer.println(String.format("%010d",save2.getAccountNumber()));		//printing output to the output file
										methodType = scnr.nextLine();											//reading input file for next method
										break;
								
									case "3":
										String strAccBalance = scnr.nextLine();
										double newAccountBalance = Double.parseDouble(strAccBalance);
										save2.setAccountBalance(newAccountBalance);
										methodType = scnr.nextLine();					//reading input file for next method
										break;
								
									case "4":
										System.out.println(save2.getAnnualInterestRate());	//printing output to console
										writer.println(save2.getAnnualInterestRate());		//printing output to the output file
										methodType = scnr.nextLine();						//reading input file for next method
										break;
								
									case "5":
										System.out.println(save2.getName());		//printing output to console
										writer.println(save2.getName());			//printing output to the output file
										methodType = scnr.nextLine();				//reading input file for next method
										break;
								
									case "6":
										strAnnualInterestRate2 = scnr.nextLine();
										double newAnnInterestRate2= Double.parseDouble(strAnnualInterestRate2);
										save2.setAnnualInterestRate(newAnnInterestRate2);
										methodType = scnr.nextLine();				//reading input file for next method
										break; 
								
									case "7":
										String strDeposit = scnr.nextLine();
										Double deposit = Double.parseDouble(strDeposit);
										save2.makeDeposit(deposit);
										methodType = scnr.nextLine();				//reading input file for next method
										break; 
								
									case "8":
										String strWithdrawal = scnr.nextLine();
										Double withdrawal = Double.parseDouble(strWithdrawal);
										if(withdrawal>save2.getAccountBalance()+1) {
											System.out.println("overdraft");
											writer.println("overdraft");
											writer.close();
											System.exit(0);
										}
										else {
											
											save2.makeWithdrawal(withdrawal);
											
										}
										methodType = scnr.nextLine();				//reading input file for next method
										break;
								
									default:
										System.out.println("Error");
										writer.println("Error");
										writer.close();
										System.exit(0);
									}
								}
								break;
							}
							default:
								System.out.println("Error");
								writer.println("Error");
								writer.close();
								System.exit(0);
							}
							break;}
								
					//break;
					default:
						System.out.println("Error");
						writer.println("Error");
						writer.close();
						System.exit(0);
					}
				}
			}
			
			
			scnr.close();
		}
		
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found!");
		}	
		
	}
}
