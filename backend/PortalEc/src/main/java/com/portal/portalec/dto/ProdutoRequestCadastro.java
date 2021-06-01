package com.portal.portalec.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequestCadastro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	
	private String unidade;

	private String embalagem;
	
	private	BigDecimal peso;
	
	private Long codfunccad;
	
	private String enderecoFoto;
	
	private Long departamentoId;
	
	private Long secaoId;
	
	private Long marcaId;
	
	private Long linhaProdutoId;
		
	
}
