package br.com.fiap.aspecto;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bean.Item;
import br.com.fiap.bean.Pedido;
import br.com.fiap.bean.Produto;

public aspect Auditoria {

	// Instancia do Log
	Logger log = Log.getInstance();

	// Point cut Cliente
	pointcut iniciarClasseCliente() : initialization(public br.com.fiap.handler.HandlerCliente.new(..));

	// Cria��o do Cliente
	before() : iniciarClasseCliente() {
		log.info("Cria��o da Classe do cliente ");
		
	}

	// Gravando Cliente
	before(Cliente c1) :
			call(void br.com.fiap.dao.Dao.persist(Cliente)) &&
			args(c1) {
		log.info("Iniciando grava��o do Cliente:");
		log.info("Id:" + c1.getId());
		log.info("Nome:" + c1.getNome());
		log.info("Tipo de Cliente:" + c1.getTipoCliente());
	}

	// Gravando Produto
	before(Produto p1) :
			call(void br.com.fiap.dao.Dao.persist(Produto)) &&
			args(p1) {
		log.info("Iniciando grava��o do Produto:");
		log.info("Id:" + p1.getId());
		log.info("Nome:" + p1.getNome());
		log.info("Valor:" + p1.getValor());
	}

	// Gravando Pedido
	before(Pedido pd1) :
					call(void br.com.fiap.dao.Dao.persist(Pedido)) &&
					args(pd1) {

		log.info("Iniciando grava��o do Pedido:");
		log.info("::::::::::::::::Informa��o do Cliente:::::::::::");
		log.info("Id:" + pd1.getCliente().getId());
		log.info("Nome:" + pd1.getCliente().getNome());
		log.info("Tipo de Cliente:" + pd1.getCliente().getTipoCliente());

		log.info("::::::::::::::::Informa��o do Produto:::::::::::");
		int i = 0;
		for (Item item : pd1.getItens()) {

			log.info("Quantidade de Produto:" + item.getQuantidade());
			log.info("Total de desconto:" + item.getDesconto());
			log.info("Total :" + item.getTotal());
			log.info(":::::::::::::::informa��o do Produto" + i++);
			log.info("Id do Produto" + item.getProduto().getId());
			log.info("Nome do Produto" + item.getProduto().getNome());

		}

	}
	

}
class Log {
	private static Logger logger = null;

	public static Logger getInstance() {
			if (logger == null) {
				PropertyConfigurator.configure(Loader
						.getResource("log4j.properties"));
				logger = Logger.getLogger(Auditoria.class);
			}
		return logger;
	}
}
