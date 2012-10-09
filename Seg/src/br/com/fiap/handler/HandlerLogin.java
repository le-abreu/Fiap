package br.com.fiap.handler;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.fiap.bean.Funcionario;
import br.com.fiap.dao.FuncionarioDAO;

public class HandlerLogin {

	private Funcionario funcionario = new Funcionario();
	private FuncionarioDAO funcionarioDAO =  new FuncionarioDAO();
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public String login() {
		funcionario = funcionarioDAO.getLoginFuncionario(funcionario.getUsuario(), funcionario.getChavePublica());		
		return "sucesso";
	}
	
	public void uploadArquivo(UploadEvent event) throws IOException {
		UploadItem upload = event.getUploadItem();  
		if (upload.isTempFile()) {  
			Scanner scanner = new Scanner(upload.getFile());
			String path = "c:\\seguranca\\"+ funcionario.getNome() +"\\"+ funcionario.getSobrenome()+"\\";
			String arquivo = upload.getFileName();
			File file = new File(path);
			file.mkdirs();
			file = new File(path+arquivo);
			file.createNewFile();
			PrintStream printStream = new PrintStream(file);           
	
	        while (scanner.hasNextLine()) {  
	        	String a= scanner.nextLine();
	        	System.out.println(a);
	        	printStream.println(a);
	        }  
	        printStream.close();
		}  
    }  

}