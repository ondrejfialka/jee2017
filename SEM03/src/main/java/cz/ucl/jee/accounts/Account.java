package cz.ucl.jee.accounts;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = -661132879019477425L;
	
	private Long prefix;
	private Long number;
	private BankCode bankCode;
	
	public Long getPrefix() {
		return prefix;
	}
	public void setPrefix(Long prefix) {
		this.prefix = prefix;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public BankCode getBankCode() {
		return bankCode;
	}
	public void setBankCode(BankCode bankCode) {
		this.bankCode = bankCode;
	}
	
}
