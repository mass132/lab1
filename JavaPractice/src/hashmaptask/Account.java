package hashmaptask;

public class Account {
	private String name;
	private int balance;
	private String acctype;
	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public Account(String name, int balance, String acctype) {
		super();
		this.name = name;
		this.balance = balance;
		this.acctype = acctype;
	}
	public boolean recharge(int amount)
	{
		if(amount < this.balance && amount > 0 )
		{
			this.balance += amount;
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		String details = " Name : "+this.name;
		details += ", Account Type : "+ this.acctype;
		details += ", Balance : "+ this.balance;
		return details;
	}
	
	

}
