package br.com.thiagocortes.entidades;

public class Estado {
	private int idEstado;
	private String nomeEstado;
	private int estadoIdPais;
	
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getNomeEstado() {
		return nomeEstado;
	}
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	public int getEstadoIdPais() {
		return estadoIdPais;
	}
	public void setEstadoIdPais(int estadoIdPais) {
		this.estadoIdPais = estadoIdPais;
	}
	
}
