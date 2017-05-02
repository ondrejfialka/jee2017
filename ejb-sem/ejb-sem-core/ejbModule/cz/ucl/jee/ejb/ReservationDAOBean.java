package cz.ucl.jee.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.ucl.jee.model.Hotel;

@Stateless
public class ReservationDAOBean implements ReservationDAO{

	@PersistenceContext(unitName = "BlueResortsDS")
	private EntityManager em;
	
	@Override
	public List<Hotel> findHotels(String location) {
		List<Hotel> result = null;

		result = em.createNamedQuery("Hotel.findByLocation").setParameter(
				"location", location).getResultList();

		return result;
	}

}
