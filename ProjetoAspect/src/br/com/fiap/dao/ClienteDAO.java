package br.com.fiap.dao;

import br.com.fiap.bean.Cliente;

public class ClienteDAO extends Dao<Cliente>{

	public ClienteDAO() {
		super(JPAUtil.getEntityManager(), Cliente.class);
	}
	
}
