package com.portal.portalec.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_modulo")
public class Modulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descricao")
	@NotBlank
	@Size(max = 50)
	private String nome;
	
	@OneToMany(mappedBy = "modulo", cascade = CascadeType.ALL)
	private List<SubModulo> submodulos = new ArrayList<>();

	public SubModulo adicionarSubModuloDescricao(String descricao) {
		SubModulo subModulo = new SubModulo();
		
		subModulo.setNome(descricao);
		subModulo.setModulo(this);
		
		this.getSubmodulos().add(subModulo);
		
		
		return subModulo; 
	}

}
