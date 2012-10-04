package br.com.fiap.dao;

import br.com.fiap.bean.Produto;

public class ProdutoDAO extends Dao<Produto> {

	public ProdutoDAO() {
		super(JPAUtil.getEntityManager(), Produto.class);
	}

}
