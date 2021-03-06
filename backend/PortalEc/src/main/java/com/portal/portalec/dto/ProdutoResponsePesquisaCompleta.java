package com.portal.portalec.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.portal.portalec.entities.Produto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoResponsePesquisaCompleta {

	private Long id;

	private String descricao;
	
	private String unidade;

	private String embalagem;

	private	BigDecimal peso;
	
	private OffsetDateTime dtcadastro;
	
	private OffsetDateTime dtultalt;
	
	private String enderecofoto;
	
	
	private DepartamentoResponse departamento;
	
	private SecaoResponse secao;

	private MarcaResponse marca;
		
	private LinhaProdutoResponse linhaProduto;
	
	
	//construtor padrao
	public ProdutoResponsePesquisaCompleta() {
	}


	
	public ProdutoResponsePesquisaCompleta(Produto entity) {
		id = entity.getId();
		descricao = entity.getDescricao();
		unidade = entity.getUnidade();
		embalagem = entity.getEmbalagem();
		peso = entity.getPeso();
		dtcadastro = entity.getDtcadastro();
		dtultalt = entity.getDtultalt();
		enderecofoto = entity.getEnderecofoto();
		departamento = new DepartamentoResponse(entity.getDepartamento());
		secao = new SecaoResponse(entity.getSecao());
		marca = new MarcaResponse(entity.getMarca());
		linhaProduto = new LinhaProdutoResponse(entity.getLinhaProduto());
	}



	public ProdutoResponsePesquisaCompleta(Long id, String descricao, String unidade, String embalagem, BigDecimal peso,
			OffsetDateTime dtcadastro, OffsetDateTime dtultalt, String enderecofoto, DepartamentoResponse departamento,
			SecaoResponse secao, MarcaResponse marca, LinhaProdutoResponse linhaProduto) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.unidade = unidade;
		this.embalagem = embalagem;
		this.peso = peso;
		this.dtcadastro = dtcadastro;
		this.dtultalt = dtultalt;
		this.enderecofoto = enderecofoto;
		this.departamento = departamento;
		this.secao = secao;
		this.marca = marca;
		this.linhaProduto = linhaProduto;
	}	
	
	
	
}
