package br.com.fiap.bean;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
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
	private Date dataNascimento;
	
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;
	
	@Temporal(TemporalType.DATE)
	private Date dataUltimaPromocao;
	
	@Column
	private String usuario;

	@Column
	private String senha;
	
	@Column
	private PublicKey chavePublica;

	@Column
	private PrivateKey chavePrivate;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataUltimaPromocao() {
		return dataUltimaPromocao;
	}

	public void setDataUltimaPromocao(Date dataUltimaPromocao) {
		this.dataUltimaPromocao = dataUltimaPromocao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PublicKey getChavePublica() {
		return chavePublica;
	}

	public void setChavePublica(PublicKey publicKey) {
		this.chavePublica = publicKey;
	}

	public PrivateKey getChavePrivate() {
		return chavePrivate;
	}

	public void setChavePrivate(PrivateKey privateKey) {
		this.chavePrivate = privateKey;
	}

	public List<Arquivo> getListaArquivos() {
		return listaArquivos;
	}

	public void setListaArquivos(List<Arquivo> listaArquivos) {
		this.listaArquivos = listaArquivos;
	}

}
 