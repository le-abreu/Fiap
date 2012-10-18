package br.com.fiap.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.fiap.util.AssinaturaDigital;

@Entity
public class Arquivo{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String caminhoArquivo;
	
	@Column
	private String nomeArquivo;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Funcionario funcionario;

	@Column
	private Calendar dataInclusao;

	@Column
	private String assinaturaArquivo;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public boolean isPossuiAssinaturaDigital() {
		try {
			File file =  new File(this.caminhoArquivo+this.nomeArquivo);
			Scanner scanner = new Scanner(file);
			
			StringBuffer stringBuffer = new StringBuffer();
			while (scanner.hasNextLine()) { 
				String a = scanner.nextLine();
				stringBuffer.append(a);
			}
			return AssinaturaDigital.isAssinadoDigitalmente(stringBuffer.toString(),this.getAssinaturaArquivo(), funcionario.getChavePublica());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getAssinaturaArquivo() {
		return assinaturaArquivo;
	}

	public void setAssinaturaArquivo(String assinaturaArquivo) {
		this.assinaturaArquivo = assinaturaArquivo;
	}
	
}
