package br.com.thiagocortes.entidades;

public class Cidade {
	
	private int idCidade;
	private String nomeCidade;
	private int cidadeIdEstado;
	
	public int getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public int getCidadeIdEstado() {
		return cidadeIdEstado;
	}
	public void setCidadeIdEstado(int cidadeIdEstado) {
		this.cidadeIdEstado = cidadeIdEstado;
	}

}
