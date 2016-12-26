package cz.ucl.lec09.bean;

public interface PaymentProcessor { 
	
  public void pay(Payment p, Double price) ;
  
}