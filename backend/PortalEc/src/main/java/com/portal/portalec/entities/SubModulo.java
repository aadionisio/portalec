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
	
	
	@ManyToOne
	@JoinColumn(name = "modulo_id")
	private Modulo modulo;
	
	@OneToMany(mappedBy = "subModulo", cascade = CascadeType.ALL)
	private List<SubModuloItem> submoduloitens = new ArrayList<>();

	public SubModuloItem adicionarSubModuloItem(String descricao, String caminhorota, String icone) {
		
		SubModuloItem subModuloItem = new SubModuloItem();
		
		subModuloItem.setNome(descricao);
		subModuloItem.setCaminhorota(caminhorota);
		subModuloItem.setSubModulo(this);
		
		//campos opcionais
		if ( icone != null ) {
			subModuloItem.setIcone(icone);
		}
		
		this.getSubmoduloitens().add(subModuloItem);
		
		
		return subModuloItem; 
	}

}
