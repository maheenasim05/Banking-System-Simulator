
public class Checking extends Account {
	
	double annualInterestRate;
	String name;
	
	public Checking(double annualInterestRate, String name) {
		
		super();
		this.annualInterestRate = annualInterestRate;
		this.name = name;
	}
	
	public Checking(double annualInterestRate, double accountBalance, long accountNumber, String name) {
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
	
		
	public void makeDeposit(double deposit) 
	{
		accountBalance+=deposit;
	}
	
	public void makeWithdrawal(double withdrawal) {
		
		if (accountBalance>=withdrawal+1) {
			
			accountBalance -= withdrawal+1;
		}
		
		else
		{
			try
			{
				throw new Exception("Overdraft");
			}
			
			catch(Exception e)
			{
				System.out.println("Overdraft!");
				
			}
			
		}
		
	}

}
