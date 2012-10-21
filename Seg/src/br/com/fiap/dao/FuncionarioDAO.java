package br.com.fiap.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.fiap.bean.CargoEnum;
import br.com.fiap.bean.Funcionario;
import br.com.fiap.util.JPAUtil;

public class FuncionarioDAO extends DAO<Funcionario>{

	public FuncionarioDAO() {
		super(JPAUtil.getEntityManager(), Funcionario.class);
	}

	public Funcionario getLoginFuncionario(String usuario, String senha) {
		String nome = Funcionario.class.getName();
		Query query = JPAUtil.getEntityManager().createQuery("select t from " +
					nome.replace("br.com.fiap.bean.", "") + 
					" t where usuario = :usuario and senha = :senha");
		query.setParameter("usuario", usuario);
		query.setParameter("senha", senha);
		Funcionario funcionario = (Funcionario) query.getResultList().get(0);
		return funcionario;
	}

	public List<Funcionario> listaCargoFuncionario() {
		String nome = Funcionario.class.getName();
		String sql = "SELECT f FROM  " + nome.replace("br.com.fiap.bean.", "") + " f" +
				" where cargo = :cargo";
		Query q = getEm().createQuery(sql).setParameter("cargo", CargoEnum.FUNCIONARIO);
		List<Funcionario> lista = q.getResultList();
		return lista;
	}

}
