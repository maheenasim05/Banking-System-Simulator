
public class Savings extends Account {
	
	double annualInterestRate;
	String name;
	
	public Savings(double annualInterestRate, String name) {
		
		super();
		this.annualInterestRate = annualInterestRate;
		this.name = name;
	}
	
	public Savings(double annualInterestRate, double accountBalance, long accountNumber, String name) {
		this.annualInterestRate = annualInterestRate;
		this.accountBalance = accountBalance;
		this.accountNumber = accountNumber;
		this.name = name;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public void makeDeposit(double deposit) {
		
		if (deposit>10000) {
			
			accountBalance += deposit+5;
		}
		
		else {
			
			accountBalance += deposit;
		}
		
	}
	
	public void makeWithdrawal(double withdrawal) {
		
		if (withdrawal>accountBalance) {
			
			try {
				throw new Exception("Overdraft");
			}
			
			catch(Exception e) {
				System.out.println("Overdraft!");
				
			}
		}
		
		else {
			
			accountBalance -= withdrawal;
		}
		
		
	}

}
