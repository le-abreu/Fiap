package br.com.fiap.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long chapa;

	@Enumerated(EnumType.STRING)
	@Column
	private CargoEnum cargo;

	@Column
	private String nome;

	@Column
	private String sobrenome;

	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataAdmissao;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataUltimaPromocao;
	
	@Column
	private String usuario;
	
	@Column
	private String chavePublica;

	@OneToMany
	private List<Arquivo> listaArquivos;

	public long getChapa() {
		return chapa;
	}

	public void setChapa(long chapa) {
		this.chapa = chapa;
	}

	public CargoEnum getCargo() {
		return cargo;
	}

	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Calendar getDataUltimaPromocao() {
		return dataUltimaPromocao;
	}

	public void setDataUltimaPromocao(Calendar dataUltimaPromocao) {
		this.dataUltimaPromocao = dataUltimaPromocao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getChavePublica() {
		return chavePublica;
	}

	public void setChavePublica(String chavePublica) {
		this.chavePublica = chavePublica;
	}

	public List<Arquivo> getListaArquivos() {
		return listaArquivos;
	}

	public void setListaArquivos(List<Arquivo> listaArquivos) {
		this.listaArquivos = listaArquivos;
	}
}
 