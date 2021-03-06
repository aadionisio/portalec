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

import com.portal.portalec.dto.ModuloRequest;
import com.portal.portalec.dto.ModuloResponse;
import com.portal.portalec.service.ModuloService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/modulos")
public class ModuloController {
	
	private ModuloService moduloService;
	
	
    @GetMapping
    public ResponseEntity<List<ModuloResponse>> findAll() {
    	List<ModuloResponse> list = moduloService.findAll();
    	return ResponseEntity.ok(list);
    }
    
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ModuloResponse incluir(@RequestBody ModuloRequest moduloRequest ) {
			
		return   moduloService.cadastrar(moduloRequest);
	}
	
	@PutMapping("/{moduloId}")
	public ResponseEntity<ModuloResponse> alterar(@PathVariable Long moduloId,  @RequestBody ModuloRequest moduloRequest ) {
			
		return   moduloService.alterar(moduloId, moduloRequest);
	}
}
