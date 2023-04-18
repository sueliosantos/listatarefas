package br.com.esig.enums;

public enum PrioridadaEnum {
	ALTA("Alta"),
	MEDIA("Média"), 
	BAIXA("Baixa");
	
	private String descricao;
	
	PrioridadaEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
