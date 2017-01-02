package cz.ucl.jee.mybank;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cz.ucl.jee.mybank.entity.Account;
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
		Account debitAccount = new Account();
		order.setDebitAccount(debitAccount);
		debitAccount.setPrefix(debitBankCode);
		debitAccount.setNumber(debitAccountNo);
		debitAccount.setBankCode(debitBankCode);
		
		Account creditAccount = new Account();
		order.setCreditAccount(creditAccount);
		creditAccount.setPrefix(creditBankCode);
		creditAccount.setNumber(creditAccountNo);
		creditAccount.setBankCode(creditBankCode);
		
		orderSender.sendPaymentOrder(order);
	}
	
	public OrderSender getOrderSender() {
		return orderSender;
	}
	public void setOrderSender(OrderSender orderSender) {
		this.orderSender = orderSender;
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
