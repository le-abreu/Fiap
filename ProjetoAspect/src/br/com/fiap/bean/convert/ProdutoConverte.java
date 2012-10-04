package br.com.fiap.bean.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.fiap.bean.Produto;
import br.com.fiap.dao.ProdutoDAO;

public class ProdutoConverte implements Converter{
	
	public final static String CONVERTER_ID = "br.com.fiap.bean.Produto"; //path dos beans da classe Produto

	public Produto getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		for (Produto produto : new ProdutoDAO().lista()) {
			if (produto.getNome().equals(valor)) {
				return produto;
			}
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		Produto produto =  (Produto) obj;
		return produto.getNome();
	}

}
