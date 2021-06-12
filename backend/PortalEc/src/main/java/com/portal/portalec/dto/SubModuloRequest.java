package com.portal.portalec.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubModuloRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String caminhorota;
	
	private String icone ;

	private String iconeAberto;
	
	private String iconeFechado ;	
}
