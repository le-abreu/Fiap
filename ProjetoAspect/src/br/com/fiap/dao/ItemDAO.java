package br.com.fiap.dao;

import br.com.fiap.bean.Item;

public class ItemDAO extends Dao<Item>{

	public ItemDAO() {
		super(JPAUtil.getEntityManager(), Item.class);
	}
	
}
