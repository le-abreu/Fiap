package br.com.fiap.ejb;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.ejb.Remote;

@Remote
public interface SegurancaSOA {

	//Deverá retornar um mapa com os campos do funcionário inclusive a CHAPA.
	public Map<String, String> testarFuncionalidade1(String nome, String sobrenome,String cargo,boolean isDesligado,Date dataNascimento, Date dataAdmissao, Date dataUltimaPromocao, String nomeUsuario, String chavePublica);
	
	//Deverá retornar um mapa com os campos do funcionário após ser promovido.
	public Map<String, String> testarFuncionalidade2(long chapa);
	
	//Deverá retornar TRUE caso a assinatura esteja válida e FALSE caso contrário
	public boolean testarFuncionalidade3(long chapa, File file);
}
