package cz.ucl.jee.sem02;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Transfer {
	private String sourceAccountNumber;
	
	public String getSourceAccountNumber(){
		return sourceAccountNumber;
	}
	
	public void setSourceAccountNumber(String sourceAccountNumber){
		this.sourceAccountNumber = sourceAccountNumber;	
	}
	
	public void doTransfer(){
		System.out.println("=================== Transfer =====================");
	}
}
