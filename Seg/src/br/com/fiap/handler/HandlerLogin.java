package br.com.fiap.handler;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.fiap.bean.Arquivo;
import br.com.fiap.bean.CargoEnum;
import br.com.fiap.bean.Funcionario;
import br.com.fiap.dao.ArquivoDAO;
import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.util.ControllerArquivo;

public class HandlerLogin{
 
	private Funcionario funcionario = new Funcionario();
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private Arquivo arquivo = new Arquivo();
	private ArquivoDAO arquivoDAO = new ArquivoDAO();
	private String result;
	private String pathMenu;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPathMenu() {
		return pathMenu;
	}

	public void setPathMenu(String pathMenu) {
		this.pathMenu = pathMenu;
	}

	public String login() {
		
		result = "";
		funcionario = funcionarioDAO.getLoginFuncionario(funcionario.getUsuario(), funcionario.getSenha());
		
		if(funcionario == null){
			result = "Verifique login ou senha incorreto(s)!!!";
			return "falha";
		}

		if(funcionario.getCargo().equals(CargoEnum.ADMINISTRADOR)){
			pathMenu = "ADMINISTRADOR/menu.jsp";
//			return "administradorFuncionario";
		}
		
		if(funcionario.getCargo().equals(CargoEnum.GERENTE)){
			pathMenu = "GERENTE/menu.jsp";
//			return "gerenteFuncionario";
		}
	
		if(funcionario.getCargo().equals(CargoEnum.FUNCIONARIO)){
			pathMenu = "FUNCIONARIO/menu.jsp";
//			return "funcionario";
		}
		
		return "sucesso";
	}

	public String sair() {
		funcionario = new Funcionario();
		return "login";
	}
	
	public void uploadArquivo(UploadEvent event) throws IOException, Exception {
		UploadItem upload = event.getUploadItem();
		if (upload.isTempFile()) {

			String path = "c:\\seguranca\\" + funcionario.getNome() + "\\"+ funcionario.getSobrenome() + "\\";
			String nomeArquivo = upload.getFileName();
			ControllerArquivo.guardarArquivo(upload.getFile(), path, nomeArquivo, funcionario.getChavePrivate());
			
			this.arquivo.setCaminhoArquivo(path);
			this.arquivo.setDataInclusao(Calendar.getInstance());
			this.arquivo.setFuncionario(funcionario);
			this.arquivo.setNomeArquivo(nomeArquivo);
			this.arquivoDAO.persist(this.arquivo);
		}
	}

	
	public List<Arquivo> getArquivos() {
		return arquivoDAO.lista();
	}
	
	
}