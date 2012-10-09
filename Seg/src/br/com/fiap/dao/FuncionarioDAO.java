package br.com.fiap.dao;

import javax.persistence.Query;

import br.com.fiap.bean.Funcionario;
import br.com.fiap.util.JPAUtil;

public class FuncionarioDAO extends DAO<Funcionario>{

	public FuncionarioDAO() {
		super(JPAUtil.getEntityManager(), Funcionario.class);
	}

	public Funcionario getLoginFuncionario(String usuario, String chaveAcessoa) {
		String nome = Funcionario.class.getName();
		Query query = JPAUtil.getEntityManager().createQuery("select t from " +
					nome.replace("br.com.fiap.model.", "") + 
					" t where usuario = :usuario and chavePublica = :chavePublica");
		query.setParameter("usuario", usuario);
		query.setParameter("chavePublica", chaveAcessoa);
		Funcionario funcionario = (Funcionario) query.getResultList().get(0);
		return funcionario;
	}
	
}
