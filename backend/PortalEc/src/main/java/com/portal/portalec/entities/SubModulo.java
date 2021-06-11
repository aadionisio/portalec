package com.portal.portalec.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_submodulo")
public class SubModulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descricao")
	@NotBlank
	@Size(max = 50)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "modulo_id")
	private Modulo modulo;
	
	@OneToMany(mappedBy = "subModulo", cascade = CascadeType.ALL)
	private List<SubModuloItem> submoduloitens = new ArrayList<>();

	public SubModuloItem adicionarSubModuloItemDescricao(String descricao) {
		
		SubModuloItem subModuloItem = new SubModuloItem();
		
		subModuloItem.setNome(descricao);
		subModuloItem.setSubModulo(this);
		
		
		this.getSubmoduloitens().add(subModuloItem);
		
		
		return subModuloItem; 
	}

}
