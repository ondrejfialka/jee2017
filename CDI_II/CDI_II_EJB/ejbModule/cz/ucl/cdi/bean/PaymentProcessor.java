package cz.ucl.cdi.bean;

public interface PaymentProcessor { 
	
  public void pay(Payment p, Double price) ;
  
}