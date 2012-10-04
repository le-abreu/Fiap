package br.com.fiap.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraDatabase {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjecoAspect");

		EntityManager em = emf.createEntityManager();

		em.close();
		emf.close();
	}

	
}
