package cz.ucl.jee.mybank.accounts;

/**
* Class representing bank account for money transfer
**/
public class Account {
	
	private String bankCode;
	private long number;
	private int prefix;		
	
	private Account(){
	}
	
	public static class Builder {
		private Account account = new Account();
		
		public Builder bankCode(String bankCode){
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
	
	public String getBankCode() {
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
		result = prime * result + bankCode.hashCode();
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
		if (bankCode.equals(other.bankCode))
			return false;
		if (number != other.number)
			return false;
		if (prefix != other.prefix)
			return false;
		return true;
	}
}
