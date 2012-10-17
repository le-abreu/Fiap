package br.com.fiap.handler;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.fiap.bean.Arquivo;
import br.com.fiap.bean.Funcionario;
import br.com.fiap.dao.ArquivoDAO;
import br.com.fiap.dao.FuncionarioDAO;

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
			
			Scanner scanner = new Scanner(upload.getFile());

			String path = "c:\\seguranca\\" + funcionario.getNome() + "\\"
					+ funcionario.getSobrenome() + "\\";
			String arquivo = upload.getFileName();

			File file = new File(path);
			file.mkdirs();
			file = new File(path + arquivo);
			file.createNewFile();
			StringBuffer stringBuffer = new StringBuffer();
			
			PrintStream printStream = new PrintStream(file);

			while (scanner.hasNextLine()) {
				String a = scanner.nextLine();
				printStream.println(a);
				stringBuffer.append(a);
			}
			this.arquivo.setAssinaturaArquivo(assinarDigitalmente(stringBuffer.toString()));
			this.arquivo.setCaminhoArquivo(path);
			this.arquivo.setDataInclusao(Calendar.getInstance());
			this.arquivo.setFuncionario(funcionario);
			this.arquivo.setNomeArquivo(arquivo);
			this.arquivo.setPossuiAssinaturaDigital(true);
			this.arquivoDAO.persist(this.arquivo);
			printStream.close();
		}
	}

	private String assinarDigitalmente(String string) {
		Signature signature;
		try {
			signature = Signature.getInstance("DSA");
			signature.initSign(funcionario.getChavePrivate());
			signature.update(string.getBytes());
			string = new String(signature.sign());
		return string;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return string;
	}
	
	private boolean isAssinadoDigitalmente(String string, Arquivo arquivo){
		Signature signature;
		try {
			signature = Signature.getInstance("DSA");
			signature.initVerify(funcionario.getChavePublica());
			signature.update(string.getBytes());
			return signature.verify(arquivo.getAssinaturaArquivo().getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {

		String str = "Leandro";
		KeyPairGenerator keyPairGenerator;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("DSA");
			KeyPair keyPair = keyPairGenerator.generateKeyPair();

			byte[] ba = str.getBytes("UTF8");
			
			
			Signature signature = Signature.getInstance("DSA");
			signature.initSign(keyPair.getPrivate());
			signature.update(ba);
			byte[] signedData = signature.sign();
			
			
			Signature signature2 = Signature.getInstance("DSA");
			signature2.initVerify(keyPair.getPublic());
			signature2.update(ba);
			boolean isSignOk = signature2.verify(signedData);

			System.out.println(isSignOk);
			String s;
			
			s = new String(signedData);
			byte[] bb = s.getBytes();
			
			System.out.println(s);
			
			s = new String(ba);
			System.out.println(s);

			s = new String(bb);
			System.out.println(s);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}

	}
	
	public List<Arquivo> getArquivos() {
		return arquivoDAO.lista();
	}
}