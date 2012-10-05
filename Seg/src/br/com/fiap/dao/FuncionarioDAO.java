package br.com.fiap.dao;

import br.com.fiap.model.Funcionario;
import br.com.fiap.util.JPAUtil;

public class FuncionarioDAO extends DAO<Funcionario>{

	public FuncionarioDAO() {
		super(JPAUtil.getEntityManager(), Funcionario.class);
	}

}
