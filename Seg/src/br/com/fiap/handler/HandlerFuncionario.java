package br.com.fiap.handler;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Scanner;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.fiap.model.Funcionario;

public class HandlerFuncionario {

	private Funcionario funcionario;

	{
		funcionario =  new Funcionario();
		funcionario.setDataAdmissao(Calendar.getInstance());
		funcionario.setDataNascimento(Calendar.getInstance());
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String salvar() {
		return "sucesso";
	}

	public void uploadArquivo(UploadEvent event) throws IOException {
        UploadItem upload = event.getUploadItem();  
		if (upload.isTempFile()) {  
			Scanner scanner = new Scanner(upload.getFile());
			File file = new File("l:\\"+ funcionario.getNome() +"\\"+ funcionario.getSobrenome()+"\\");
			if (file.mkdir()) {
				file = new File("c:\\teste\\teste.txt");
				if (file.createNewFile()) {
		            PrintStream printStream = new PrintStream(file);           
		
		            while (scanner.hasNextLine()) {  
		            	String a= scanner.nextLine();
		            	System.out.println(a);
		            	printStream.println(a);
		            }  
		            printStream.close();
				};
			}  
		}
    }  
}
