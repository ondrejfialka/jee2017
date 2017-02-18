package cz.ucl.jee.storage;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cz.ucl.jee.storage.entities.Item;
import cz.ucl.jee.storage.entities.ItemFilter;

@ApplicationScoped
public class StorageDAO {
	
	public Item storeItem(Item item){
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
		em.close();
		return item;
	}
	
	public Item storeItem(Item item, Long code){
		EntityManager em = JPAUtil.createEntityManager();
		
		Item foundItem = em.find(Item.class, code);
		if (foundItem != null){
			foundItem.setName(item.getName());
			foundItem.setDescription(item.getDescription());
			foundItem.setWeight(item.getWeight());
			em.getTransaction().begin();
			em.persist(foundItem);
			em.getTransaction().commit();
			em.close();
			item.setCode(foundItem.getCode());
			return foundItem;
		}
		return null;
		
	}
	
	public Item getItem(long code){
		EntityManager em = JPAUtil.createEntityManager();
		Item item = em.find(Item.class, code);
		return item;
	}
	
	public List<Item> getItemsByFilter(ItemFilter filter){		
		EntityManager em = JPAUtil.createEntityManager();
		TypedQuery<Item> query = em.createNamedQuery(Item.FIND_BY_FILTER, Item.class);
		query.setParameter(Item.FILTER_WEIGHT_FROM, filter.getWeightFrom());
		query.setParameter(Item.FILTER_WEIGHT_TO, filter.getWeightTo());
		query.setParameter(Item.FILTER_NAME, filter.getName());
		List<Item> items = query.getResultList();
		return items;
	}
	
	public boolean removeItem(Long code){
		EntityManager em = JPAUtil.createEntityManager();
		
		Item foundItem = em.find(Item.class, code);
		if (foundItem != null){			
			em.getTransaction().begin();
			em.remove(foundItem);
			em.getTransaction().commit();
			em.close();		
			return true;
		}
		return false;
	}

}
