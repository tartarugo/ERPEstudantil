package br.com.thiagocortes.entidades;

public class Endereco {
	
	private String cep;
	private String rua;
	private String bairro;
	private int enderecoIdCidade;
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getIdCidade() {
		return enderecoIdCidade;
	}
	public void setIdCidade(int idCidade) {
		this.enderecoIdCidade = idCidade;
	}

}
