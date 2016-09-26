package assignment2;

public class Customer {
	protected String custName;
	protected int custNum;
	protected String custAddress;
	protected CheckingAcct C;
	protected SavingsAcct S;
	protected SavingsAcct L;
	protected SavingsAcct A;
	
	public Customer(int num)
	{
		custNum = num;
	}
	public Customer(String name, int num, String address)
	{
		this.custName = name;
		this.custNum = num;
		this.custAddress = address;
	}
	
	public String getName()
	{
		return this.custName;
	}
	
	public int getNum()
	{
		return this.custNum;
	}
	
	public String getAddress()
	{
		return this.custAddress;
	}
	
	public void setName(String name)
	{
		this.custName = name;
	}
	
	public void setNum(int num)
	{
		this.custNum = num;
	}
	
	public void setAddress(String s)
	{
		this.custAddress = s;
	}
}
