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

import com.portal.portalec.dto.SubModuloItemRequest;
import com.portal.portalec.dto.SubModuloItemResponse;
import com.portal.portalec.service.SubModuloItemService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/submodulo/{subModuloId}/submoduloitems")
public class SubModuloItemController {
	
	private SubModuloItemService subModuloItemService;

	@GetMapping
	public ResponseEntity<List<SubModuloItemResponse>> buscar(@PathVariable Long subModuloId ){
    	List<SubModuloItemResponse> list = subModuloItemService.findBySubModulo(subModuloId);
    	return ResponseEntity.ok(list);

	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SubModuloItemResponse incluir(@PathVariable Long subModuloId, @RequestBody SubModuloItemRequest subModuloItemRequest ) {
		
		return  subModuloItemService.cadastrar(subModuloId, subModuloItemRequest);
	}
	
	@PutMapping("/{subModuloItemId}")
	public ResponseEntity<SubModuloItemResponse> alterar(@PathVariable Long subModuloItemId,  @RequestBody SubModuloItemRequest subModuloItemRequest  ) {
			
		return   subModuloItemService.alterar(subModuloItemId, subModuloItemRequest);
	}
	
}
