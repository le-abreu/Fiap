package br.com.fiap.ejb;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.ejb.Remote;

@Remote
public interface SegurancaSOA {

	//Dever� retornar um mapa com os campos do funcion�rio inclusive a CHAPA.
	public Map<String, String> testarFuncionalidade1(String nome, String sobrenome,String cargo,boolean isDesligado,Date dataNascimento, Date dataAdmissao, Date dataUltimaPromocao, String nomeUsuario, String chavePublica);
	
	//Dever� retornar um mapa com os campos do funcion�rio ap�s ser promovido.
	public Map<String, String> testarFuncionalidade2(long chapa);
	
	//Dever� retornar TRUE caso a assinatura esteja v�lida e FALSE caso contr�rio
	public boolean testarFuncionalidade3(long chapa, File file);
}
