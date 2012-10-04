package br.com.fiap.handler;

import java.util.List;

import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bean.TipoCliente;
import br.com.fiap.dao.ClienteDAO;

public class HandlerCliente {

	private Cliente cliente = new Cliente();
	private List<Cliente> clientes = new ClienteDAO().lista();
	private String resultado;
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getclientes() {
		return clientes;
	}

	public void setclientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String salvar() {
		new ClienteDAO().persist(this.cliente);
		this.cliente = new Cliente();
		clientes = new ClienteDAO().lista();
		setResultado("Cadastrado com sucesso");
		return "salvo";
	}

	public void escolheCliente(ActionEvent event) {
		UIParameter val = (UIParameter) event.getComponent().findComponent("idCliente");
		int id = Integer.parseInt(val.getValue().toString());
		this.cliente = new ClienteDAO().find(id);
	}
	
	public SelectItem[] getTipoClientes() {
		SelectItem[] items = new SelectItem[TipoCliente.values().length];
		int i = 0;
		for (TipoCliente t : TipoCliente.values()) {
			items[i++] = new SelectItem(t, t.getTipoCliente());
		}
		return items;
	}
}
