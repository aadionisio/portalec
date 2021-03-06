package com.portal.portalec.dto;

import java.io.Serializable;
import com.portal.portalec.entities.Produto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoResponseCadastro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private String enderecofoto;

	
	//construtor padrao
	public ProdutoResponseCadastro() {
	}
	// construtor com campos
	public ProdutoResponseCadastro(Long id, String nome,String enderecoFoto) {
		this.id = id;
		this.descricao = nome;
		this.enderecofoto = enderecoFoto;
	}
	
	//construtor com entidade
	public ProdutoResponseCadastro(Produto entity) {
		id = entity.getId();
		descricao = entity.getDescricao();
		enderecofoto = entity.getEnderecofoto();
	}	
	
}
