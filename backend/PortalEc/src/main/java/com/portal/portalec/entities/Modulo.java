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
	
	@Column
	@NotBlank
	@Size(max = 100)
	private String caminhorota;	

	@Column
	@Size(max = 100)	
	private String icone = "AiIcons.AiFillHome";
	
	@Column(name = "iconeaberto")
	@Size(max = 100)	
	private String iconeAberto = "RiIcons.RiArrowUpSFill";
	
	@Column(name = "iconefechado")
	@Size(max = 100)
	private String iconeFechado = "RiIcons.RiArrowDownSFill";
	
	@OneToMany(mappedBy = "modulo", cascade = CascadeType.ALL)
	private List<SubModulo> submodulos = new ArrayList<>();

	public SubModulo adicionarSubModulo(String descricao, String caminhorota, String icone, String iconeAberto, String iconeFechado  ) {
		SubModulo subModulo = new SubModulo();
		
		// campos obrigatorios
		subModulo.setNome(descricao);
		subModulo.setCaminhorota(caminhorota);
		subModulo.setModulo(this);
		
		//campos opcionais
		if ( icone != null ) {
			subModulo.setIcone(icone);
		}
		
		if ( iconeAberto != null ) {
			subModulo.setIconeAberto(iconeAberto);
		}
		
		if ( iconeFechado != null ) {
			subModulo.setIconeFechado(iconeFechado);
		}
		
		
		this.getSubmodulos().add(subModulo);
		
		
		return subModulo; 
	}

}
