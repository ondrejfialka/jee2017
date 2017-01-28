package cz.ucl.jee.storage;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

import cz.ucl.jee.storage.entities.Item;

@ApplicationScoped
public class StorageDAO {
	
	public void storeItem(Item item){
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
		em.close();
	}

}
