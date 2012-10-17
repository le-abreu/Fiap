package br.com.fiap.handler;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.faces.model.SelectItem;

import br.com.fiap.bean.CargoEnum;
import br.com.fiap.bean.Funcionario;
import br.com.fiap.dao.FuncionarioDAO;

public class HandlerFuncionario {

	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	{
		funcionario =  new Funcionario();
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String salvar() {
		KeyPair kp = gerarChaves();
        PrivateKey privateKey = kp.getPrivate();
        PublicKey publicKey = kp.getPublic();
        funcionario.setChavePublica(publicKey);
        funcionario.setChavePrivate(privateKey); 
		funcionarioDAO.persist(funcionario);
		funcionario =  new Funcionario();
		return "sucesso";
	}
	
	public SelectItem[] getCargos() {
		SelectItem[] items = new SelectItem[CargoEnum.values().length];
		int i = 0;
		for (CargoEnum c : CargoEnum.values()) {
			items[i++] = new SelectItem(c, c.getDescricao());
		}
		return items;
	}

    public static KeyPair gerarChaves() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("DAS");
            kpg.initialize(1024);
            KeyPair kp = kpg.generateKeyPair();
            return kp;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
