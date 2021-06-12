package com.portal.portalec.dto;

import java.io.Serializable;

import com.portal.portalec.entities.Modulo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModuloResponse implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	private String caminhorota;
	
	//construtor padrao
	public ModuloResponse() {
	}
	// construtor com campos
	public ModuloResponse(Long id, String nome, String caminhorota) {
		this.id = id;
		this.nome = nome;
		this.caminhorota = caminhorota;
		
	}
	
	//construtor com entidade
	public ModuloResponse(Modulo entity) {
		id = entity.getId();
		nome = entity.getNome();
		caminhorota = entity.getCaminhorota();
	}
}
