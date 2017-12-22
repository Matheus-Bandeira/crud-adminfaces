package br.com.karanalpe.model;

public enum Status {

	ANDAMENTO("Em Andamento"), FINALIZADO("Finalizado");

	private String descricao;

	Status(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
