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

import com.portal.portalec.dto.LinhaProdutoRequest;
import com.portal.portalec.dto.LinhaProdutoResponse;
import com.portal.portalec.service.LinhaProdutoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/linhaprodutos")
public class LinhaProdutoController {
	
	private LinhaProdutoService linhaProdutoService;
	
	
    @GetMapping
    public ResponseEntity<List<LinhaProdutoResponse>> findAll() {
    	List<LinhaProdutoResponse> list = linhaProdutoService.findAll();
    	return ResponseEntity.ok(list);
    }
    
	@GetMapping("/{linhaProdutoId}")
	public ResponseEntity<LinhaProdutoResponse> buscar(@PathVariable Long linhaProdutoId){
		return linhaProdutoService.findById(linhaProdutoId);
	}

	@GetMapping("/consultapornome")
	public List<LinhaProdutoResponse> buscarPorNome(@RequestBody LinhaProdutoRequest linhaProdutoRequest){
		return linhaProdutoService.findByNome(linhaProdutoRequest.getNome());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LinhaProdutoResponse incluir(@RequestBody LinhaProdutoRequest linhaProdutoRequest ) {
			
		return  linhaProdutoService.cadastrar(linhaProdutoRequest.getNome());
	}
	
	@PutMapping("/{linhaProdutoId}")
	public ResponseEntity<LinhaProdutoResponse> alterar(@PathVariable Long linhaProdutoId,  @RequestBody LinhaProdutoRequest linhaProdutoRequest  ) {
			
		return   linhaProdutoService.alterar(linhaProdutoId, linhaProdutoRequest.getNome());
	}

}
