package br.com.fiap.dao;

import br.com.fiap.bean.Pedido;

public class PedidoDAO extends Dao<Pedido>{

	public PedidoDAO() {
		super(JPAUtil.getEntityManager(), Pedido.class);
	}

}
