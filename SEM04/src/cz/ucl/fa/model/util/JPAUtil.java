package cz.ucl.fa.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
	private static EntityManagerFactory emf;

	public static EntityManager createEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("SEM04");
		}
		return emf.createEntityManager();
	}

}
