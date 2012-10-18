package br.com.fiap.bean;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.util.ControllerArquivo;

@Entity
public class Funcionario {

	{
		KeyPair keyPair;
		try {
			keyPair = KeyPairGenerator.getInstance("DSA").generateKeyPair();
			this.setChavePublica(keyPair.getPublic());
			this.setChavePrivate(keyPair.getPrivate()); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
		String path = "c:\\seguranca\\chavePublica\\";
		String nomeArquvio = this.getChapa()+".txt";
		return (PublicKey) ControllerArquivo.getObjetoSerializavel(path, nomeArquvio);
	}

	public void setChavePublica(PublicKey publicKey) {
		String path = "c:\\seguranca\\chavePublica\\";
		String nomeArquvio = this.getChapa()+".txt";
		ControllerArquivo.gravarObjetoSerializavel(path, nomeArquvio, publicKey);
	}

	public PrivateKey getChavePrivate() {
		String path = "c:\\seguranca\\chavePrivada\\";
		String nomeArquvio = this.getChapa()+".txt";
		return (PrivateKey) ControllerArquivo.getObjetoSerializavel(path, nomeArquvio);
	}

	public void setChavePrivate(PrivateKey privateKey) {
		String path = "c:\\seguranca\\chavePrivada\\";
		String nomeArquvio = this.getChapa()+".txt";
		ControllerArquivo.gravarObjetoSerializavel(path, nomeArquvio, privateKey);
			
	}

	public List<Arquivo> getListaArquivos() {
		return listaArquivos;
	}

	public void setListaArquivos(List<Arquivo> listaArquivos) {
		this.listaArquivos = listaArquivos;
	}

}
 