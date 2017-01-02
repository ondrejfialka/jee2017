package cz.ucl.jee.mybank.entity;

public class Account {
	
	private int bankCode;
	private long number;
	private int prefix;
	
	
	public int getBankCode() {
		return bankCode;
	}
	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public int getPrefix() {
		return prefix;
	}
	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}
	
	

}
