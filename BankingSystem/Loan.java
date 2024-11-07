import java.util.Date;

public class Loan extends Account{
	
	double annualInterestRate;
	int  numberOfYears;
	Date loanDate = new Date();
	String name;
	
	public Loan(String name) {
		
		super();
		this.name = name;
		this.loanDate = new Date();
		
	}
	
	public Loan(long accountNumber, double accountBalance, double annualInterestRate, int numberOfYears, String name) {
		
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.name = name;
		this.loanDate = new Date();
		
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public int getNumberOfYears() {
		return numberOfYears;
	}
	
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}
	
	public Date getLoanDate() {
		return loanDate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public double getMonthlyPayment() {
		
		double AB = accountBalance;
		double AIR = annualInterestRate;
		int NY = numberOfYears;
		double MP; //monthly payment
		double MIR; //monthly interest rate
		
		
		MIR = AIR/1200;
		
		MP = (AB*MIR)/(1-(1/Math.pow((1+MIR),(NY*12))));
		return MP;
		
	}
	
	public double getTotalPayment() {
		
		int NY = numberOfYears;
		double MP = getMonthlyPayment();
		
		double TP = MP*NY*12; //total payment
		return TP;
	}

}
