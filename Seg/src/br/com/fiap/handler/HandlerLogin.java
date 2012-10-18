package br.com.fiap.handler;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.fiap.bean.Arquivo;
import br.com.fiap.bean.Funcionario;
import br.com.fiap.dao.ArquivoDAO;
import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.util.ControllerArquivo;

public class HandlerLogin {

	private Funcionario funcionario = new Funcionario();
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private Arquivo arquivo = new Arquivo();
	private ArquivoDAO arquivoDAO = new ArquivoDAO();

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String login() {
		funcionario = funcionarioDAO.getLoginFuncionario(
				funcionario.getUsuario(), funcionario.getSenha());
		return "sucesso";
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