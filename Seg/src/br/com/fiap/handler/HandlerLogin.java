package br.com.fiap.handler;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
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
		funcionario = funcionarioDAO.getLoginFuncionario(funcionario.getUsuario(), funcionario.getSenha());		
		return "sucesso";
	}
	
	public void uploadArquivo(UploadEvent event) throws IOException, Exception {
		UploadItem upload = event.getUploadItem();  
		if (upload.isTempFile()) {  
			
			Scanner scanner = new Scanner(upload.getFile());
			
			String path = "c:\\seguranca_SOA\\"+ funcionario.getNome() +"\\"+ funcionario.getSobrenome()+"\\";
			String arquivo = upload.getFileName();
			
			File file = new File(path);
			file.mkdirs();
			file = new File(path+arquivo);
			file.createNewFile();
			StringBuffer stringBuffer = new StringBuffer();
			
			PrintStream printStream = new PrintStream(file);           
	
	        while (scanner.hasNextLine()) {  
	        	String a = scanner.nextLine();
	        	printStream.println(a);
	        	stringBuffer.append(a);
	        }  
	        printStream.println("::FIM::");
        	printStream.println(assinarArquivo(stringBuffer));
	        printStream.close();
		}  
    }  
	

	private byte[] assinarArquivo(StringBuffer stringBuffer) {
        byte[] ba;
		try {
			ba = stringBuffer.toString().getBytes("UTF8");
	        Signature signature = Signature.getInstance("DAS");
	        signature.initSign(funcionario.getChavePrivate());
	        signature.update(ba);
	        return signature.sign();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void lerAssinatura() {
		try {
			Signature signature = Signature.getInstance("DAS");
			signature.initVerify(funcionario.getChavePublica());

			StringBuffer stringBuffer =  new StringBuffer();
			String path = "c:\\seguranca_SOA\\"+ funcionario.getNome() +"\\"+ funcionario.getSobrenome()+"\\";
			String arquivo = "";
			
			Scanner scanner = new Scanner(path+arquivo);
			while (scanner.hasNextLine()) {  
				String a = scanner.nextLine();
				stringBuffer.append(a);
			}  
			signature.update(stringBuffer.toString().getBytes());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}

	}
}