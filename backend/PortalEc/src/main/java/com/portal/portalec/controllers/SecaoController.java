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

import com.portal.portalec.dto.SecaoRequest;
import com.portal.portalec.dto.SecaoResponse;
import com.portal.portalec.service.SecaoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/departamento/{departamentoId}/secoes")
public class SecaoController {

	private SecaoService secaoService;

    @GetMapping
    public ResponseEntity<List<SecaoResponse>> findAll() {
    	List<SecaoResponse> list = secaoService.findAll();
    	return ResponseEntity.ok(list);
    }
    
	@GetMapping("/{secaoId}")
	public ResponseEntity<SecaoResponse> buscar(@PathVariable Long secaoId){
		return secaoService.findById(secaoId);
	}
	
	@GetMapping("/consultapornome")
	public List<SecaoResponse> buscarPorNome(@RequestBody SecaoRequest secaoRequest){
		return secaoService.findByNome(secaoRequest.getNome());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SecaoResponse incluir(@PathVariable Long departamentoId, @RequestBody SecaoRequest secaoRequest ) {
		
		return  secaoService.cadastrar(departamentoId, secaoRequest.getNome());
	}
	
	@PutMapping("/{secaoId}")
	public ResponseEntity<SecaoResponse> alterar(@PathVariable Long secaoId,  @RequestBody SecaoRequest secaoRequest  ) {
			
		return   secaoService.alterar(secaoId, secaoRequest.getNome());
	}
}

