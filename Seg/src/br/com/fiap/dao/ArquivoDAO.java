package br.com.fiap.dao;

import br.com.fiap.bean.Arquivo;
import br.com.fiap.util.JPAUtil;

public class ArquivoDAO extends DAO<Arquivo>{

	public ArquivoDAO() {
		super(JPAUtil.getEntityManager(), Arquivo.class);
	}

}
