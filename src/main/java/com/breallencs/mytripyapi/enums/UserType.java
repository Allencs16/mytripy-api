package com.breallencs.mytripyapi.enums;

public enum UserType {
    VIAJANTE(0, "Viajante"),
    ORGANIZADOR(1, "Organizador");

    private String descricao;
	private Integer codigo;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private UserType(Integer codigo,String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
}
