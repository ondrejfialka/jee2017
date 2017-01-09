package cz.ucl.jee.mybank;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cz.ucl.jee.mybank.accounts.Account;
import cz.ucl.jee.mybank.entity.PaymentOrder;
import cz.ucl.jee.mybank.transfer.OrderSender;

@RequestScoped
@Named
public class MoneyTransfer {
	
	@Inject
	OrderSender orderSender;
	
	private int debitAccountPrefix;
	private long debitAccountNo;
	private int debitBankCode;
	
	private int creditAccountPrefix;
	private long creditAccountNo;
	private int creditBankCode;
	
	public void send(){
		PaymentOrder order = new PaymentOrder();
		Account debitAccount = new Account.Builder()
				.prefix(debitBankCode)
				.number(debitAccountNo)
				.bankCode(debitBankCode)
				.build();
		order.setDebitAccount(debitAccount);
		
		Account creditAccount = new Account.Builder()
				.prefix(creditAccountPrefix)
				.number(creditAccountNo)
				.bankCode(creditBankCode)
				.build();
		order.setCreditAccount(creditAccount);
				
		orderSender.sendPaymentOrder(order);
	}
	
	
	public int getDebitAccountPrefix() {
		return debitAccountPrefix;
	}
	public void setDebitAccountPrefix(int debitAccountPrefix) {
		this.debitAccountPrefix = debitAccountPrefix;
	}
	public long getDebitAccountNo() {
		return debitAccountNo;
	}
	public void setDebitAccountNo(long debitAccountNo) {
		this.debitAccountNo = debitAccountNo;
	}
	public int getDebitBankCode() {
		return debitBankCode;
	}
	public void setDebitBankCode(int debitBankCode) {
		this.debitBankCode = debitBankCode;
	}
	public int getCreditAccountPrefix() {
		return creditAccountPrefix;
	}
	public void setCreditAccountPrefix(int creditAccountPrefix) {
		this.creditAccountPrefix = creditAccountPrefix;
	}
	public long getCreditAccountNo() {
		return creditAccountNo;
	}
	public void setCreditAccountNo(long creditAccountNo) {
		this.creditAccountNo = creditAccountNo;
	}
	public int getCreditBankCode() {
		return creditBankCode;
	}
	public void setCreditBankCode(int creditBankCode) {
		this.creditBankCode = creditBankCode;
	}
	
	

}
