package cz.ucl.jee.mybank.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import cz.ucl.jee.mybank.accounts.Account;

public class PaymentOrder {
	
	private Account debitAccount;
	private Account creditAccount;
	
	private String currencyCode;
	private BigDecimal amount;
	
	private LocalDate dueDate;
	
	public Account getDebitAccount() {
		return debitAccount;
	}
	public void setDebitAccount(Account debitAccount) {
		this.debitAccount = debitAccount;
	}
	public Account getCreditAccount() {
		return creditAccount;
	}
	public void setCreditAccount(Account creditAccount) {
		this.creditAccount = creditAccount;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	

	
	
}
