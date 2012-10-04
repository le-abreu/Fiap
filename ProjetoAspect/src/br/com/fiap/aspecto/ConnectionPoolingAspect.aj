package br.com.fiap.aspecto;

import javax.persistence.EntityManager;

import br.com.fiap.dao.JPAUtil;

public aspect ConnectionPoolingAspect {

	pointcut pooling() : call(public static EntityManager JPAUtil.getEntityManager());

	private static EntityManager em = null;
	static int cont = 0;

	EntityManager around(): pooling() {
		if (em == null) {
			em = JPAUtil.getEmf().createEntityManager();
		}
		return em;
	}
}
