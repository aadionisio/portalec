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
@Table(name = "tb_departamento")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descricao")
	@NotBlank
	@Size(max = 50)
	private String nome ;
	
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Secao> secoes = new ArrayList<>();
	
	
	public Secao adicionarSecaoDescricao(String descricao) {
		Secao secao = new Secao();
		
		secao.setNome(descricao);
		secao.setDepartamento(this);
		
		this.getSecoes().add(secao);
		
		
		return secao; 
	}
}
