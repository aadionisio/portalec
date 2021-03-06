package com.portal.portalec.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.portal.portalec.dto.SubModuloRequest;
import com.portal.portalec.dto.SubModuloResponse;
import com.portal.portalec.service.SubModuloService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/modulo/{moduloId}/submodulos")
public class SubModuloController {
	
	private SubModuloService subModuloService;

	@GetMapping
	public ResponseEntity<List<SubModuloResponse>> buscar(@PathVariable Long moduloId){
    	List<SubModuloResponse> list = subModuloService.findByModulo(moduloId);
    	return ResponseEntity.ok(list);

	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SubModuloResponse incluir(@PathVariable Long moduloId, @RequestBody SubModuloRequest subModuloRequest ) {
		
		return  subModuloService.cadastrar(moduloId, subModuloRequest);
	}
	
	@PutMapping("/{subModuloId}")
	public ResponseEntity<SubModuloResponse> alterar(@PathVariable Long subModuloId,  @RequestBody SubModuloRequest subModuloRequest  ) {
			
		return   subModuloService.alterar(subModuloId, subModuloRequest);
	}
}
