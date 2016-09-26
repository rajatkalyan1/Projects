package assignment2;

import javax.swing.JOptionPane;

public class SavingsAcct extends BankAccount {

	
	public SavingsAcct(double initialBalance)
	{
		super(initialBalance);
	}
	
	public SavingsAcct(int acct, String owner, double initBalance)
	{
		super(acct, owner, initBalance);
	}
	
	public void getInterest()//adds interest to the account
	{
		if(this.getBalance() >= 1000)
			this.setBalance(this.getBalance() + (this.getBalance() * .04));
		else
			JOptionPane.showMessageDialog(null, "Balance Below Minimum. Interest Denied.", "Balance Below Minimum. Interest Denied.", JOptionPane.ERROR_MESSAGE);
	}
}
