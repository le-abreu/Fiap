package br.com.fiap.handler;

import java.util.List;

import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import br.com.fiap.bean.Produto;
import br.com.fiap.dao.ProdutoDAO;

public class HandlerProduto {

	private Produto produto = new Produto();
	 private List<Produto> produtos = new ProdutoDAO().lista();
//	private List<Produto> produtos = new ArrayList<Produto>();
	private String resultado;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getprodutos() {
		return produtos;
	}

	public void setprodutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String salvar() {
		new ProdutoDAO().persist(this.produto);
		this.produto = new Produto();
		produtos = new ProdutoDAO().lista();
		setResultado("Cadastrado com sucesso");
		return "salvo";
	}

	public void escolheProduto(ActionEvent event) {
		UIParameter val = (UIParameter) event.getComponent().findComponent("idProduto");
		int id = Integer.parseInt(val.getValue().toString());
		this.produto = new ProdutoDAO().find(id);
	}
}
