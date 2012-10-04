package br.com.fiap.bean.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.fiap.bean.Cliente;
import br.com.fiap.dao.ClienteDAO;

public class ClienteConverte implements Converter {

	public final static String CONVERTER_ID = "br.com.fiap.bean.Cliente"; //path dos beans da classe Cliente
	
	public Cliente getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		for (Cliente cliente : new ClienteDAO().lista()) {
			if (cliente.getNome().equals(valor)) {
				return cliente;
			}
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		Cliente cliente = (Cliente) obj;
		return cliente.getNome();
	}

}
