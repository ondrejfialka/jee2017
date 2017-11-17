package cz.ucl.jee.mybank.accounts;

public class Account {
	//different comment
	private int bankCode;
	private long number;
	private int prefix;		
	
	private int unused;
		
	private Account(){
	}
	
	//this is an example of builder pattern
	public static class Builder {
		private Account account = new Account();
		
		public Builder bankCode(int bankCode){
			account.bankCode = bankCode;
			return this;
		}
		
		public Builder number(long number){
			account.number = number;
			return this;
		}
		
		public Builder prefix(int prefix){
			account.prefix = prefix;
			return this;
		}
						
		public Account build(){
			return account;
		}
	}
	
	public int getBankCode() {
		return bankCode;
	}
	
	public long getNumber() {
		return number;
	}
	
	public int getPrefix() {
		return prefix;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bankCode;
		result = prime * result + (int) (number ^ (number >>> 32));
		result = prime * result + prefix;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (bankCode != other.bankCode)
			return false;
		if (number != other.number)
			return false;
		if (prefix != other.prefix)
			return false;
		return true;
	}
	
	

}
