package cz.ucl.transactions;

import javax.enterprise.inject.Model;

import cz.ucl.fa.model.Customer;

@Model
public class CustomerData {

	private Customer customer = new Customer();

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
