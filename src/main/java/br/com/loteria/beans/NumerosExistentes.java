package br.com.loteria.beans;

public class NumerosExistentes {

	private Integer id;
	private String valor;
	
	
	public NumerosExistentes(Integer id, String valor) {
		this.id = id;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
