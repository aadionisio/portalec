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

import com.portal.portalec.dto.DepartamentoRequest;
import com.portal.portalec.dto.DepartamentoResponse;
import com.portal.portalec.service.DepartamentoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoController {
	
	private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DepartamentoResponse>> findAll() {
    	List<DepartamentoResponse> list = departamentoService.findAll();
    	return ResponseEntity.ok(list);
    }
    
	//metodo para buscar um departamento especifico
	@GetMapping("/{departamentoId}")
	public ResponseEntity<DepartamentoResponse> buscar(@PathVariable Long departamentoId){
		return departamentoService.findById(departamentoId);
	}
	
	//metodo para buscar um departamento por nome (fragmento)
	@GetMapping("/consultapornome")
	public List<DepartamentoResponse> buscarPorNome(@RequestBody DepartamentoRequest departamentoRequest){
		return departamentoService.findByNome(departamentoRequest.getNome());
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DepartamentoResponse incluir(@RequestBody DepartamentoRequest departamentoRequest ) {
			
		return   departamentoService.cadastrar(departamentoRequest.getNome());
	}
	
	@PutMapping("/{departamentoId}")
	public ResponseEntity<DepartamentoResponse> alterar(@PathVariable Long departamentoId,  @RequestBody DepartamentoRequest departamentoRequest ) {
			
		return   departamentoService.alterar(departamentoId, departamentoRequest.getNome());
	}
	
}
