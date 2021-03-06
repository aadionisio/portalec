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

import com.portal.portalec.dto.MarcaRequest;
import com.portal.portalec.dto.MarcaResponse;
import com.portal.portalec.service.MarcaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/marcas")
public class MarcaController {
	
	private MarcaService marcaService;
	
    @GetMapping
    public ResponseEntity<List<MarcaResponse>> findAll() {
    	List<MarcaResponse> list = marcaService.findAll();
    	return ResponseEntity.ok(list);
    }
    
	@GetMapping("/{marcaId}")
	public ResponseEntity<MarcaResponse> buscar(@PathVariable Long marcaId){
		return marcaService.findById(marcaId);
	}

	@GetMapping("/consultapornome")
	public List<MarcaResponse> buscarPorNome(@RequestBody MarcaRequest marcaRequest){
		return marcaService.findByNome(marcaRequest.getNome());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MarcaResponse incluir(@RequestBody MarcaRequest marcaRequest ) {
			
		return  marcaService.cadastrar(marcaRequest.getNome());
	}
	
	@PutMapping("/{marcaId}")
	public ResponseEntity<MarcaResponse> alterar(@PathVariable Long marcaId,  @RequestBody MarcaRequest marcaRequest  ) {
			
		return   marcaService.alterar(marcaId, marcaRequest.getNome());
	}
}
