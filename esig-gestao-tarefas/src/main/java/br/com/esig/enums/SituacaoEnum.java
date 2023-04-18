package br.com.esig.enums;

public enum SituacaoEnum {
	EMANDAMENTO("Em andamento"),
	CONCLUIDA("Concluída");
	
	private String descricao;
	
	SituacaoEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
