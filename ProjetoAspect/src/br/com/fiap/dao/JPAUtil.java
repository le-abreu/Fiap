package br.com.fiap.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class JPAUtil {

	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("ProjecoAspect");
		try {
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

}
