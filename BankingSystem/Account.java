import java.util.Random;

public abstract class Account {
	
	long accountNumber;
	double accountBalance;
	
	public Account() {
		Random random = new Random();
		this.accountNumber = random.nextLong() % 10000000000L;
        this.accountBalance = 0;
	}
	
	
	public Account(long accountNumber, double accountBalance) {
		
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	
	
	public double getAccountBalance() {
		
		return accountBalance;
	}
	
	
	public long getAccountNumber() {
		
		return accountNumber;
	}
	
	public abstract void setAccountBalance(double accountBalance);
		
}


