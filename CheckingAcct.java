package assignment2;
import javax.swing.JOptionPane;

public class CheckingAcct extends BankAccount{

	public CheckingAcct(double initialBalance)
	{
		super(initialBalance);
	}
	
	public CheckingAcct(int acct, String owner, double initBalance)
	{
		super(acct, owner, initBalance);
	}
	
	public void enableOverdraft(double amount)//withdraws overdrawn amount from savings
	{
		double over = amount - this.balance;
		if(ownersName.S.balance >= (over + 20))
		{
			this.balance = 0;
			ownersName.S.balance -= over - 20;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Insufficient Funds, Overdraft Denied.", "Insufficient Funds, Overdraft Denied.", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void withdraw(double amount) //overloaded method, same as withdraw method from BankAccount, except with an added enableOverdraft function
    {  
        if (balance >=  amount)
            balance -= amount;
        else
        {
        	enableOverdraft(amount);
        }
        	
    }
}
