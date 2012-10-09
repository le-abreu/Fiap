package br.com.fiap.model;

public enum CargoEnum {
	
	GERENTE("Gerente"),
	ADMINISTRADOR("Administrador"),
	FUNCIONARIO("Funcionario");
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	CargoEnum(String descricao){
		this.descricao = descricao;
	}
	
}
