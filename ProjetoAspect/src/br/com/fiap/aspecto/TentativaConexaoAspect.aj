package br.com.fiap.aspecto;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.JPAUtil;

public aspect TentativaConexaoAspect {

	pointcut conexao() : call(public static EntityManagerFactory JPAUtil.getEmf());

	static int MAX_ = 5;

	private static EntityManagerFactory emf;
	
	EntityManagerFactory around() : conexao() {
		int cont = 0;
		while (true) {
				emf = Persistence.createEntityManagerFactory("ProjecoAspect");
			if (emf != null) {
				return emf;
			}
			if (++cont > MAX_) {
				try {
					throw new SQLException( "Conexaõ com o banco falho total de tentivas sem sucesso: " + cont);
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					return null;
				}
			}
		}
	}
}
