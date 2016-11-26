package cz.ucl.jee.sem03;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import cz.ucl.jee.accounts.BankCode;

@Named
@RequestScoped
public class Transfer {
	private String sourceAccountNumber;
	private String targetAccountNumber;
	private BankCode targetBankCode;
	
	public String getSourceAccountNumber(){
		return sourceAccountNumber;
	}
	
	public void setSourceAccountNumber(String sourceAccountNumber){
		this.sourceAccountNumber = sourceAccountNumber;	
	}
	
	public String getTargetAccountNumber() {
		return targetAccountNumber;
	}

	public void setTargetAccountNumber(String targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}

	public BankCode getTargetBankCode() {
		return targetBankCode;
	}

	public void setTargetBankCode(BankCode targetBankCode) {
		this.targetBankCode = targetBankCode;
	}

	public void doTransfer(){
		System.out.println("=================== Transfer =====================");
	}
	
	public BankCode[] getBankCodes() {
	    return BankCode.values();
	}
}
