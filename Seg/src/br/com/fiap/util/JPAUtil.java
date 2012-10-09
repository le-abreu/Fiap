package br.com.fiap.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
	
	private static  EntityManager em;
	static{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SegJPA");
		em =  emf.createEntityManager();
	}

	public static EntityManager getEntityManager(){
		return  em;
	}
}
