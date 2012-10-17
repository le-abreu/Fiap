package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class DAO<T> {

	private EntityManager em;
	private Class<?> persistentClass;
	private EntityTransaction trans;

	public DAO(EntityManager em, Class<?> persistenClass) {
		this.em = em;
		this.persistentClass = persistenClass;
		this.trans = getEm().getTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<T> lista() {
		String nome = this.persistentClass.getName();
		String sql = "SELECT t FROM  " + nome.replace("br.com.fiap.bean.", "") + " t";
		Query q = getEm().createQuery(sql);
		List<T> lista = q.getResultList();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public T find(int id) {
		return (T) getEm().find(persistentClass, id);
	}

	public void persist(T t) {
		try {
			trans.begin();
			getEm().merge(t);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (trans.isActive())
				trans.rollback();
		}

	}

	public void update(T t) {
		try {
			trans.begin();
			getEm().merge(t);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (trans.isActive())
				trans.rollback();
		}
		
	}

	public void delete(T t) {
		try {
			trans.begin();
			getEm().remove(t);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public EntityManager getEm() {
		return em;
	}

}
