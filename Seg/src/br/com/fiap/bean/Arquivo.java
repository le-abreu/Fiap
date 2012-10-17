package br.com.fiap.bean;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Arquivo{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String caminhoArquivo;
	
	@Column
	private String nomeArquivo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Funcionario funcionario;

	@Column
	private boolean possuiAssinaturaDigital;
	
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
		return possuiAssinaturaDigital;
	}

	public void setPossuiAssinaturaDigital(boolean possuiAssinaturaDigital) {
		this.possuiAssinaturaDigital = possuiAssinaturaDigital;
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
