package cz.ucl.transactions;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import cz.ucl.fa.model.Customer;

@SessionScoped
@Named
public class HolidayManager implements Serializable {

	@Produces
	@PersistenceContext(unitName="SEM04")
	private EntityManager entityManager;
	
	@Inject
	private CustomerData customerData;
		
	@Transactional(Transactional.TxType.REQUIRED)
	public void addCustomer() {
		addCustomer2();
		System.out.println(entityManager.getTransaction().isActive());
		
	// exception causes the transaction to rollback	
	//	throw new RuntimeException();
	}	
	
	@Transactional(Transactional.TxType.SUPPORTS)
	public void addCustomer2() {
		System.out.println(entityManager.getTransaction().isActive());
		Customer customer = customerData.getCustomer();
		entityManager.persist(customer);
	}	
}
