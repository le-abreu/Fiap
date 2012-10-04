package br.com.fiap.aspecto;

import br.com.fiap.bean.Item;
import br.com.fiap.bean.Pedido;

public aspect PedidoAspect {

	pointcut atualizar(Pedido pedido) : execution(* Item.setPedido(..)) && args(pedido);

	pointcut atualizarB(Pedido pedido) : atualizar(pedido)&& !cflowbelow(atualizar(Pedido));

	pointcut atualizarC(Pedido pedido) : atualizarB(pedido)&& !cflowbelow(atualizarB(Pedido));

	pointcut atualizarD(Pedido pedido) : atualizarC(pedido)&& !cflowbelow(atualizarC(Pedido));

	void around(Pedido pedido) : atualizar(pedido) {

		double total = 0;
		for (Item i : pedido.getItens()) {
			if (i.getQuantidade() > 0) {
				total += i.getProduto().getValor() * i.getQuantidade();
			}
		}

		if (total > 1000) {
			total = 0;
			for (Item i : pedido.getItens()) {
				i.setDesconto(5);
				total += i.getTotal();
			}
			pedido.setTotal(total);
		}

	}

	after(Pedido pedido) : atualizarB(pedido) {
		int totalUnidade = 0;
		double totalValor = 0;

		for (Item i : pedido.getItens()) {
			totalUnidade += i.getQuantidade();
		}

		if (totalUnidade > 10) {
			for (Item i : pedido.getItens()) {
				i.setDesconto(5);
				totalValor += i.getTotal();
			}
			pedido.setTotal(totalValor);
		}

	}

	//
	after(Pedido pedido) : atualizarC(pedido) {
		String meses[] = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio",
				"Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro",
				"Dezembro" };
		double juros = 0;
		System.out.println(pedido.getData().MONTH);
		System.out.println(meses[pedido.getData().MONTH]);
		if (("Agosto".equals(meses[pedido.getData().MONTH])) || ("Setembro".equals(meses[ pedido.getData().MONTH]))) {
			juros = ((pedido.getTotal() / 100) * 10);
			pedido.setTotal(pedido.getTotal() + juros);
		}

	}

	//
	after(Pedido pedido) : atualizarC(pedido) {
		String LIVRO = "AspectJ – a arte de Pensar Diferente";
		double totalValor = 0;
		System.out.println(pedido.getData().DAY_OF_WEEK);
		if (pedido.getData().DAY_OF_WEEK == 1) {
			for (Item i : pedido.getItens()) {
				if (i.getProduto().getNome().equals(LIVRO)) {
					i.setDesconto(5);
					totalValor += i.getTotal();
				}
				pedido.setTotal(totalValor);
			}
		}
	}

}
