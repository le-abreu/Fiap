package br.com.fiap.handler;

import java.util.List;

import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import br.com.fiap.bean.CargoEnum;
import br.com.fiap.bean.Funcionario;
import br.com.fiap.dao.FuncionarioDAO;

public class HandlerFuncionario {

	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	{
		funcionario =  new Funcionario();
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String salvar() {
	        funcionarioDAO.persist(funcionario);
	        funcionario =  new Funcionario();
	        return "sucesso";
	}
	
	public SelectItem[] getCargos() {
		SelectItem[] items = new SelectItem[CargoEnum.values().length];
		int i = 0;
		for (CargoEnum c : CargoEnum.values()) {
			items[i++] = new SelectItem(c, c.getDescricao());
		}
		return items;
	}

	public List<Funcionario> getListFuncionarios() {
		return funcionarioDAO.listaCargoFuncionario();
	}

	public void promoverFuncionario(ActionEvent event) {
		UIParameter val = (UIParameter) event.getComponent().findComponent("chapa");
		int id = Integer.parseInt(val.getValue().toString());
		for(Funcionario funcionario : funcionarioDAO.listaCargoFuncionario()){
			if(funcionario.getChapa() == id ){
				funcionario.setCargo(CargoEnum.GERENTE);
				funcionarioDAO.update(funcionario);
			}
		}
	}


}
