package com.portal.portalec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_submoduloitem")
public class SubModuloItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descricao")
	@NotBlank
	@Size(max = 50)
	private String nome;
	
	@Column
	@NotBlank
	@Size(max = 100)
	private String caminhorota;	

	@Column
	@Size(max = 100)	
	private String icone = "AiIcons.AiFillHome";
	
	@ManyToOne
	@JoinColumn(name = "submodulo_id")
	private SubModulo subModulo;
}
