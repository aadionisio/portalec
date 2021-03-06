package com.portal.portalec.entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codprod")
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	private String descricao;
	
	@NotNull
	private String unidade;
	@NotNull
	private String embalagem;
	@NotNull
	private	BigDecimal peso;
	@NotNull
	private OffsetDateTime dtcadastro;
	
	private OffsetDateTime dtultalt;
	
	private OffsetDateTime dtexclusao;
	@NotNull
	private Long codfunccad;
	
	private Long codfuncultalt;
	
	private Long codfuncexclusao;
	
	private String enderecofoto;
	
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name = "secao_id")
	private Secao secao;
	
	@ManyToOne
	@JoinColumn(name = "marca_id")	
  	private  Marca marca;
	
	@ManyToOne
	@JoinColumn(name = "linhaproduto_id")	
	private LinhaProduto linhaProduto;
	
	
	
	
	
	
	
	
}
