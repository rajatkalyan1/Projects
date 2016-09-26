package assignment2;
import java.util.Scanner;
import javax.swing.JOptionPane;
 
public class A2Driver 
{
	public static void main(String[] args) 
	{
		Customer[] customers = new Customer[10];
		for(int k = 0; k < customers.length; k++)//creates array of customers, each with 4 different bank accounts
		{
			customers[k] = new Customer(k);
			customers[k].C = new CheckingAcct(0);//checking account
			customers[k].S = new SavingsAcct(0);//primary savings
			customers[k].L = new SavingsAcct(0);//student loan
			customers[k].A = new SavingsAcct(0);//auto repayment
		}
		while(true)
		{
			String input = JOptionPane.showInputDialog("Enter Your Transaction");
			Scanner scan = new Scanner(input);//allows you to enter input
			int cust = scan.nextInt();//reads the customer number
			if(cust > 9)
				JOptionPane.showMessageDialog(null, "Invalid Customer Number.\nPlease try again.", "Invalid Customer Number.\nPlease try again.", JOptionPane.ERROR_MESSAGE);
			else
			{
				String transaction = scan.next();
				if(transaction.equals("D") )//deposits funds into account
				{
					double amount = scan.nextDouble();//amount to be deposited
					if(amount < 0)
					{
						JOptionPane.showMessageDialog(null, "Invalid Amount Entered.\nPlease enter an amount above 0.", "Invalid Amount Entered.\nPlease enter an amount above 0.", JOptionPane.ERROR_MESSAGE);
					}
					
					String bank = scan.next();//determines which account to perform transaction on
					if(bank.equals("C") )
					{
						customers[cust].C.deposit(amount);
						JOptionPane.showMessageDialog(null, String.format("You have deposited $%f into your Checking Account. Your new balance is $%f", amount, customers[cust].C.getBalance()));
					}
					else if(bank.equals("S") )
					{
						customers[cust].S.deposit(amount);
						JOptionPane.showMessageDialog(null, String.format("You have deposited $%f into your Primary Savings Account. Your new balance is $%f", amount, customers[cust].S.getBalance()));
					}
					else if(bank.equals("L") )
					{
						customers[cust].L.deposit(amount);
						JOptionPane.showMessageDialog(null, String.format("You have deposited $%f into your Student Loan Repayment Account. Your new balance is $%f", amount, customers[cust].L.getBalance()));
					}
					else if(bank.equals("A") )
					{
						customers[cust].A.deposit(amount);
						JOptionPane.showMessageDialog(null, String.format("You have deposited $%f into your Auto Loan Repayment Account. Your new balance is $%f", amount, customers[cust].A.getBalance()));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Account Type.\nPlease try again.", "Invalid Account Type.\nPlease try again.", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(transaction.equals("W") )//enables withdraw function
				{
					double amount = scan.nextDouble();//amount to be withdrawn
					if(amount < 0)
					{
						JOptionPane.showMessageDialog(null, "Invalid Amount Entered.\nPlease enter an amount above 0.", "Invalid Amount Entered.\nPlease enter an amount above 0.", JOptionPane.ERROR_MESSAGE);
					}
					String bank = scan.next();
					if(bank.equals("C") )
					{
						customers[cust].C.withdraw(amount);
						if(customers[cust].C.getBalance() == 0)
						{
							JOptionPane.showMessageDialog(null, String.format("You have overdrafted your Checking Account. Your Checking Account balance is 0, and your Primary Savings Account Balance is $%f", amount, customers[cust].S.getBalance()));
						} 
						else
						{
							JOptionPane.showMessageDialog(null, String.format("You have withdrawn $%f from your Checking Account. Your new balance is $%f", amount, customers[cust].C.getBalance()));
						}
					}
					else if(bank.equals("S") )
					{
						if(customers[cust].S.getBalance() < amount)
						{
							customers[cust].S.withdraw(amount);
							JOptionPane.showMessageDialog(null, "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", JOptionPane.ERROR_MESSAGE);
						} 
						else
						{
							JOptionPane.showMessageDialog(null, String.format("You have withdrawn $%f from your Primary Savings Account. Your new balance is %$f", amount, customers[cust].S.getBalance()));
						}
					}
					else if(bank.equals("L") )
					{
						if(customers[cust].L.getBalance() < amount)
						{
							customers[cust].L.withdraw(amount);
							JOptionPane.showMessageDialog(null, "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", JOptionPane.ERROR_MESSAGE);
						} 
						else
						{
							JOptionPane.showMessageDialog(null, String.format("You have withdrawn $%f from your Student Loan Repayment Account. Your new balance is %$f", amount, customers[cust].L.getBalance()));
						}
					}
					else if(bank.equals("A") )
					{
						if(customers[cust].A.getBalance() < amount)
						{
							customers[cust].A.withdraw(amount);
							JOptionPane.showMessageDialog(null, "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", JOptionPane.ERROR_MESSAGE);
						} 
						else
						{
							JOptionPane.showMessageDialog(null, String.format("You have withdrawn $%f from your Auto Loan Repayment Account. Your new balance is %$f", amount, customers[cust].A.getBalance()));
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Account Type.\nPlease try again.", "Invalid Account Type.\nPlease try again.", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(transaction.equals("I") )//enables interest
				{
					String bank = scan.next();
					if(bank.equals("C") )
					{
						JOptionPane.showMessageDialog(null, "Interest Only Valid For Savings Accounts.", "Interest Only Valid For Savings Accounts.", JOptionPane.ERROR_MESSAGE);
					}
					else if(bank.equals("S") )
					{
						customers[cust].S.getInterest();
						JOptionPane.showMessageDialog(null, String.format("Your Primary Savings Account has gained interest. Your new balance is $%f", customers[cust].S.getBalance()));
					}
					else if(bank.equals("L") )
					{
						customers[cust].L.getInterest();
						JOptionPane.showMessageDialog(null, String.format("Your Student Load Repayment Account has gained interest. Your new balance is $%f", customers[cust].L.getBalance()));
					}
					else if(bank.equals("A") )
					{
						customers[cust].A.getInterest();
						JOptionPane.showMessageDialog(null, String.format("Your Auto Loan Repayment Account has gained interest. Your new balance is $%f", customers[cust].A.getBalance()));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Account Type.\nPlease try again.", "Invalid Account Type.\nPlease try again.", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(transaction.equals("T") )//enables transferring funds from one account to another
				{
					double amount = scan.nextDouble();//determines amount to be transferred
					if(amount < 0)
					{
						JOptionPane.showMessageDialog(null, "Invalid Amount Entered.\nPlease enter an amount above 0.", "Invalid Amount Entered.\nPlease enter an amount above 0.", JOptionPane.ERROR_MESSAGE);
					}
					String transferFrom = scan.next();//account to be withdrawn from
					String transferTo = scan.next();//account to be deposited into
					if(transferFrom.equals("C") )
					{
						if(customers[cust].C.getBalance() < amount)
						{
							JOptionPane.showMessageDialog(null, "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							customers[cust].C.withdraw(amount);
							if(transferTo.equals("S") )
							{
								customers[cust].S.deposit(amount);
								JOptionPane.showMessageDialog(null, String.format("You have transferred funds from your Checking Account to your Primary Savings Account. Your Checking Account balance is $%f and your Primary Savings Account balance is $%f.", customers[cust].C.getBalance(), customers[cust].S.getBalance()));
							}
							else if(transferTo.equals("L") )
							{
								customers[cust].L.deposit(amount);
								JOptionPane.showMessageDialog(null, String.format("You have transferred funds from your Checking Account to your Student Loan Repayment Account. Your Checking Account balance is $%f and your Student Loan Repayment Account balance is $%f.", customers[cust].C.getBalance(), customers[cust].L.getBalance()));
							}
							else if(transferTo.equals("A") )
							{
								customers[cust].A.deposit(amount);
								JOptionPane.showMessageDialog(null, String.format("You have transferred funds from your Checking Account to your Auto Loan Repayment Account. Your Checking Account balance is $%f and your Auto Loan Repayment Account balance is $%f.", customers[cust].C.getBalance(), customers[cust].A.getBalance()));
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Invalid Account Type.\nPlease try again.", "Invalid Account Type.\nPlease try again.", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					else if(transferFrom.equals("S") )
					{
						if(customers[cust].S.getBalance() < amount)
						{
							JOptionPane.showMessageDialog(null, "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							customers[cust].S.withdraw(amount);
							if(transferTo.equals("C") )
							{
								customers[cust].C.deposit(amount);
								JOptionPane.showMessageDialog(null, String.format("You have transferred funds from your Primary Savings Account to your Checking Account. Your Primary Savings Account balance is $%f and your Checking Account balance is $%f.", customers[cust].S.getBalance(), customers[cust].C.getBalance()));
							}
							else if(transferTo.equals("L") )
							{
								customers[cust].L.deposit(amount);
								JOptionPane.showMessageDialog(null, String.format("You have transferred funds from your Primary Savings Account to your Student Loan Repayment Account. Your Primary Savings Account balance is $%f and your Student Loan Repayment Account balance is $%f.", customers[cust].S.getBalance(), customers[cust].L.getBalance()));
							}
							else if(transferTo.equals("A") )
							{
								customers[cust].A.deposit(amount);
								JOptionPane.showMessageDialog(null, String.format("You have transferred funds from your Primary Savings Account to your Auto Loan Repayment Account. Your Primary Savings Account balance is $%f and your Auto Loan Repayment Account balance is $%f.", customers[cust].S.getBalance(), customers[cust].A.getBalance()));
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Invalid Account Type.\nPlease try again.", "Invalid Account Type.\nPlease try again.", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					else if(transferFrom.equals("L") )
					{
						if(customers[cust].L.getBalance() < amount)
						{
							JOptionPane.showMessageDialog(null, "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							customers[cust].L.withdraw(amount);
							if(transferTo.equals("C") )
							{
								customers[cust].C.deposit(amount);
								JOptionPane.showMessageDialog(null, String.format("You have transferred funds from your Student Loan Repayment Account to your Checking Account. Your Student Loan Repayment Account balance is $%f and your Checking Account balance is $%f.", customers[cust].L.getBalance(), customers[cust].C.getBalance()));
							}
							else if(transferTo.equals("S") )
							{
								customers[cust].S.deposit(amount);
								JOptionPane.showMessageDialog(null, String.format("You have transferred funds from your Student Loan Repayment Account to your Primary Savings Account. Your Student Loan Repayment Account balance is $%f and your Student Loan Repayment Account balance is $%f.", customers[cust].L.getBalance(), customers[cust].S.getBalance()));
							}
							else if(transferTo.equals("A") )
							{
								customers[cust].A.deposit(amount);
								JOptionPane.showMessageDialog(null, String.format("You have transferred funds from your Student Loan Repayment Account to your Auto Loan Repayment Account. Your Student Loan Repayment Account balance is $%f and your Auto Loan Repayment Account balance is $%f.", customers[cust].L.getBalance(), customers[cust].A.getBalance()));
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Invalid Account Type.\nPlease try again.", "Invalid Account Type.\nPlease try again.", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					else if(transferFrom.equals("A") )
					{
						if(customers[cust].A.getBalance() < amount)
						{
							JOptionPane.showMessageDialog(null, "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", "Insufficient Funds.\nPlease enter a value less than or equal to your balance.", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							customers[cust].A.withdraw(amount);
							if(transferTo.equals("S") )
							{
								customers[cust].S.deposit(amount);
								JOptionPane.showMessageDialog(null, String.format("You have transferred funds from your Auto Loan Repayment Account to your Checking Account. Your Auto Loan Repayment Account balance is $%f and your Checking Account balance is $%f.", customers[cust].A.getBalance(), customers[cust].C.getBalance()));
							}
							else if(transferTo.equals("L") )
							{
								customers[cust].L.deposit(amount);
								JOptionPane.showMessageDialog(null, String.format("You have transferred funds from your Auto Loan Repayment Account to your Primary Savings Account. Your Auto Loan Repayment Account balance is $%f and your Primary Savings Account balance is $%f.", customers[cust].A.getBalance(), customers[cust].S.getBalance()));
							}
							else if(transferTo.equals("A") )
							{
								customers[cust].A.deposit(amount);
								JOptionPane.showMessageDialog(null, String.format("You have transferred funds from your Auto Loan Repayment Account to your Student Loan Repayment Account. Your Auto Loan Repayment Account balance is $%f and your Student Loan Repayment Account balance is $%f.", customers[cust].A.getBalance(), customers[cust].L.getBalance()));
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Invalid Account Type.\nPlease try again.", "Invalid Account Type.\nPlease try again.", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Account Type.\nPlease try again.", "Invalid Account Type.\nPlease try again.", JOptionPane.ERROR_MESSAGE);
					}
				}	
				else if(transaction.equals("G") )//retrieves current balance
				{
					String bank = scan.next();
					if(bank.equals("C") )
					{
						JOptionPane.showMessageDialog(null, String.format("Your Checking Account balance is: $%f", customers[cust].C.getBalance()));
					}
					else if(bank.equals("S") )
					{
						JOptionPane.showMessageDialog(null, String.format("Your Primary Savings Account balance is: $%f", customers[cust].S.getBalance()));
					}
					else if(bank.equals("L") )
					{
						JOptionPane.showMessageDialog(null, String.format("Your Student Loan Repayment Account balance is: $%f", customers[cust].L.getBalance()));
					}
					else if(bank.equals("A") )
					{
						JOptionPane.showMessageDialog(null, String.format("Your Auto Loan Repayment Account balance is: $%f", customers[cust].A.getBalance()));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Account Type.\nPlease try again.", "Invalid Account Type.\nPlease try again.", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Transaction.\nPlease try again", "Invalid Transaction.\nPlease try again", JOptionPane.ERROR_MESSAGE);
				}
			}
			scan.close();
			int nextTransaction = JOptionPane.showConfirmDialog(null, "Proceed with another transaction?", "Proceed with another transaction?", JOptionPane.YES_NO_OPTION);
			if(nextTransaction == JOptionPane.NO_OPTION)
			{
				break;
			}//ends transactions
		}
		for(int k = 0; k < customers.length; k++)//prints summary of balances
		{
			JOptionPane.showMessageDialog(null, String.format("Customer #%d Balances: C:$%f, S:$%f, L:$%f, A:$%f\n", customers[k].custNum, customers[k].C.balance, customers[k].S.balance, customers[k].L.balance, customers[k].A.balance));
		}
	}
}

