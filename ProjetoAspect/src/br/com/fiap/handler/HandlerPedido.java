package br.com.fiap.handler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.ajax4jsf.model.KeepAlive;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bean.Item;
import br.com.fiap.bean.Pedido;
import br.com.fiap.bean.Produto;
import br.com.fiap.bean.TipoCliente;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.dao.ProdutoDAO;

@KeepAlive
public class HandlerPedido {

	private Item item = new Item();
	private Pedido pedido;
	private TipoCliente tipoCliente;
	private List<Cliente> listCliente;

	{
		this.pedido = new Pedido();
		this.pedido.setData(Calendar.getInstance());
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public List<Cliente> getListCliente() {
		return listCliente;
	}

	public void setListCliente(List<Cliente> listCliente) {
		this.listCliente = listCliente;
	}

	public SelectItem[] getClientes() {
		List<Cliente> clientes = new ClienteDAO().lista();
		SelectItem[] items = new SelectItem[listCliente.size()];
		int i = 0;
		for (Cliente c : listCliente) {
			items[i++] = new SelectItem(c, c.getNome());
		}
		return items;
	}

	public SelectItem[] getProdutos() {
		List<Produto> produtos = new ProdutoDAO().lista();
		SelectItem[] items = new SelectItem[produtos.size()];
		int i = 0;
		for (Produto p : produtos) {
			items[i++] = new SelectItem(p, p.getNome());
		}
		return items;
	}

	public SelectItem[] getTipoClientes() {
		SelectItem[] items = new SelectItem[TipoCliente.values().length];
		int i = 0;
		for (TipoCliente t : TipoCliente.values()) {
			items[i++] = new SelectItem(t, t.getTipoCliente());
		}
		return items;
	}

	public String adicionarProduto() {
		pedido.getItens().add(item);
		pedido.setTotal(somaTotal());
		item = new Item();
		item.setPedido(pedido);
		return null;
	}
	
	public void removerProduto(ActionEvent event) {
		UIParameter val = (UIParameter) event.getComponent().findComponent("idItem");
		int id = Integer.parseInt(val.getValue().toString());
		for(Item item : pedido.getItens()){
			if(item.getProduto().getId() == id ){
				pedido.getItens().remove(item);
			}
		}
	}

	public void tratarTipoCliente(ValueChangeEvent event) {
		if (event.getNewValue() != null) {
			this.tipoCliente = event.getNewValue().toString() == "FISICA" ? TipoCliente.FISICA
					: TipoCliente.JURIDICA;
			carregaClientes();
		}
	}

	private void carregaClientes() {
		listCliente = new ArrayList<Cliente>();
		for (Cliente cliente : new ClienteDAO().lista()) {
			if (cliente.getTipoCliente().getTipoCliente()
					.equals(tipoCliente.getTipoCliente())) {
				listCliente.add(cliente);
			}
		}
	}

	public String salvar() {
		new PedidoDAO().persist(this.pedido);
		this.pedido = new Pedido();
		this.pedido.setData(Calendar.getInstance());
		return "salvo";
	}
	
	public String carregar() {
		this.pedido = new PedidoDAO().find(this.pedido.getNumero());
		this.tipoCliente = this.pedido.getCliente().getTipoCliente();
		carregaClientes();
		return "salvo";
	}
	
	private double somaTotal() {
		double total = 0;
		for (Item item : pedido.getItens()) {
			if (item.getQuantidade() > 0) {
				total += item.getTotal();
			}
		}
		return total;
	}
}
