package br.com.fiap.ejb;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.fiap.bean.CargoEnum;
import br.com.fiap.bean.Funcionario;
import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.ejb.SegurancaSOA;
import br.com.fiap.util.AssinaturaDigital;
import br.com.fiap.util.ControllerArquivo;

public @Stateless class SegurancaSOABean implements SegurancaSOA {

	FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	
	@Override
	public Map<String, String> testarFuncionalidade1(String nome,
			String sobrenome, String cargo, boolean isDesligado,
			Date dataNascimento, Date dataAdmissao, Date dataUltimaPromocao,
			String nomeUsuario, String chavePublica) {
		
		Map<String, String> mapResult = new HashMap<String, String>(); 
		Funcionario funcionario = new Funcionario(CargoEnum.valueOf(cargo), nome, sobrenome, dataNascimento, dataAdmissao, dataUltimaPromocao, nomeUsuario, chavePublica, isDesligado);
		funcionario = funcionarioDAO.getLoginFuncionario(nomeUsuario, chavePublica);
		return mapResult;
	}

	@Override
	public Map<String, String> testarFuncionalidade2(long chapa) {
		Map<String, String> mapResult = new HashMap<String, String>(); 
		Funcionario funcionario = funcionarioDAO.find(chapa);
		funcionario.setCargo(CargoEnum.GERENTE);
		funcionarioDAO.update(funcionario);
		mapResult = funcionario.mapFuncionario();
		return mapResult;
	}

	@Override
	public boolean testarFuncionalidade3(long chapa, File file) {
		Funcionario funcionario = funcionarioDAO.find(chapa);
		String path = "c:\\seguranca\\" + funcionario .getNome() + "\\"+ funcionario.getSobrenome() + "\\";
		String nomeArquivo = file.getName();
		ControllerArquivo.guardarArquivo(file, path, nomeArquivo, funcionario.getChavePrivate());
		
		String arquivo = ControllerArquivo.leituraArquivo(path , nomeArquivo);
		String sign = ControllerArquivo.retornaSign(path , nomeArquivo);
		return AssinaturaDigital.isAssinadoDigitalmente(arquivo ,sign, funcionario.getChavePublica());
	}

}
