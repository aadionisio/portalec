package com.portal.portalec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.portalec.assembler.LinhaProdutoAssembler;
import com.portal.portalec.dto.LinhaProdutoResponse;
import com.portal.portalec.entities.LinhaProduto;
import com.portal.portalec.exception.NegocioException;
import com.portal.portalec.repositories.LinhaProdutoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LinhaProdutoService {
	
	private LinhaProdutoRepository linhaProdutoRepository;
    private LinhaProdutoAssembler linhaProdutoAssembler;

	public List<LinhaProdutoResponse> findAll(){
		List<LinhaProduto> result = linhaProdutoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		// converte o resultado para o dto depatamento response
		return result.stream().map( x -> new LinhaProdutoResponse(x)).collect(Collectors.toList());
	}
	
	public ResponseEntity<LinhaProdutoResponse>  findById(Long linhaProdutoId){
		
		
		return linhaProdutoRepository.findById(linhaProdutoId)
				   .map(linhaProduto -> ResponseEntity.ok(linhaProdutoAssembler.toModel(linhaProduto)))
				   .orElse(ResponseEntity.notFound().build());
			
	}
	
	public List<LinhaProdutoResponse>  findByNome(String linhaProduto){
		return linhaProdutoAssembler.toCollectionModel(linhaProdutoRepository.findByNomeContainingIgnoreCase(linhaProduto));
	}
	
	@Transactional
	public LinhaProdutoResponse cadastrar(String descricao) {
		
		LinhaProduto linhaProduto = new LinhaProduto();
		
		linhaProduto.setNome(descricao);
		
		linhaProdutoRepository.save(linhaProduto);
		
		return linhaProdutoAssembler.toModel(linhaProduto);
		
	}
	
	@Transactional
	public ResponseEntity<LinhaProdutoResponse> alterar(Long linhaProdutoId, String descricao) {
		
		LinhaProduto linhaProduto = linhaProdutoRepository.findById(linhaProdutoId)
				                     .orElseThrow(() -> new NegocioException("Marca n??o localizada! Verifique os dados e tente novamente!"));
				                        
		linhaProduto.setNome(descricao);
		
		linhaProdutoRepository.save(linhaProduto);	
		
		return ResponseEntity.ok(linhaProdutoAssembler.toModel(linhaProduto));
		
	}
}
