package com.portal.portalec.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.portal.portalec.dto.ProdutoRequestCadastro;
import com.portal.portalec.dto.ProdutoResponseCadastro;
import com.portal.portalec.service.ProdutoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	private ProdutoService produtoService;
	
	
    @GetMapping
    public ResponseEntity<List<ProdutoResponseCadastro>> findAll() {
    	List<ProdutoResponseCadastro> list = produtoService.findAll();
    	return ResponseEntity.ok(list);
    }
    
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoResponseCadastro incluir(@RequestBody ProdutoRequestCadastro produtoRequest ) {
		
		return  produtoService.cadastrar(produtoRequest);
	}
}
