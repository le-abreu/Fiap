package br.com.fiap.aspecto;

import javax.persistence.EntityTransaction;

import br.com.fiap.dao.Dao;
import br.com.fiap.dao.JPAUtil;

public aspect ControleTransactionAspectJ {

	pointcut transaction() : execution(public void Dao.*(..)) &&  !call (public Object Dao.*(int) ) ;

	EntityTransaction trans = JPAUtil.getEntityManager().getTransaction();

	before(): transaction() {
		trans.begin();
	}

	after(): transaction() {
		try {
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (trans.isActive())
				trans.rollback();
		}
	}

}