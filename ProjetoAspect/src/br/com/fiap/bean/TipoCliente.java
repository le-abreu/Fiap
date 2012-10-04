package br.com.fiap.bean;


public enum TipoCliente {

	FISICA("fisica"), 
	JURIDICA("juridica");
	
	private String tipoCliente;
	
	private TipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	
}
