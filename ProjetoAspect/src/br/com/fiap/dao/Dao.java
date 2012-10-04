package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Dao<T> {

	public EntityManager em;
	private Class<?> persistentClass;

	public Dao(EntityManager em, Class<?> persistenClass) {
		this.em = em;
		this.persistentClass = persistenClass;

	}

	@SuppressWarnings("unchecked")
	public List<T> lista() {
		String nome = this.persistentClass.getName();

		try {

			String sql = "SELECT c FROM  "
					+ nome.replace("br.com.fiap.bean.", "") + " c";
			Query q = em.createQuery(sql);
			List<T> lista = q.getResultList();
			return lista;
		} catch (Exception e) {

			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public T find(int id) {
		return (T) em.find(persistentClass, id);
	}

	public void persist(T t) {
		em.merge(t);
	}

	public void update(T t) {
		em.merge(t);
	}

	public void delete(T t) {
		em.remove(t);
	}

}
