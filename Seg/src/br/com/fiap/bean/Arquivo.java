package br.com.fiap.bean;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.fiap.util.AssinaturaDigital;
import br.com.fiap.util.ControllerArquivo;

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
		String arquivo = ControllerArquivo.leituraArquivo(caminhoArquivo, nomeArquivo);
		String sign = ControllerArquivo.retornaSign(caminhoArquivo, nomeArquivo);
		return AssinaturaDigital.isAssinadoDigitalmente(arquivo ,sign, funcionario.getChavePublica());
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

}

//scanner = new Scanner(new InputStreamReader(new FileInputStream(file), "UTF8"));
//PrintWriter print = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8")); 
