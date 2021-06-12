package com.portal.portalec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.portalec.assembler.SubModuloItemAssembler;
import com.portal.portalec.dto.SubModuloItemResponse;
import com.portal.portalec.entities.SubModulo;
import com.portal.portalec.entities.SubModuloItem;
import com.portal.portalec.exception.NegocioException;
import com.portal.portalec.repositories.SubModuloItemRepository;
import com.portal.portalec.repositories.SubModuloRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SubModuloItemService {

 	private SubModuloItemRepository subModuloItemRepository;
 	private SubModuloItemAssembler subModuloItemAssembler;
 	private SubModuloRepository subModuloRepository;
 	
 	
	public List<SubModuloItemResponse> findBySubModulo(Long subModuloId){
		
		SubModulo subModulo = subModuloRepository.findById(subModuloId)
										   .orElseThrow(() -> new NegocioException("Sub-Modulo não localizado! Verifique os dados e tente novamente!"));
		
		
		List<SubModuloItem> result = subModuloItemRepository.findBySubModulo(subModulo);
		// converte o resultado para o dto depatamento response
		return result.stream().map( x -> new SubModuloItemResponse(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public SubModuloItemResponse cadastrar(Long subModuloId, String descricao) {
		
		SubModulo subModulo = subModuloRepository.findById(subModuloId)
                .orElseThrow(() -> new NegocioException("Sub-Modulo não localizado! Verifique os dados e tente novamente!"));
		
		
		SubModuloItem subModuloItemGravado = subModulo.adicionarSubModuloItemDescricao(descricao);
		return subModuloItemAssembler.toModel(subModuloItemGravado);
		
	}
	
	
	@Transactional
	public ResponseEntity<SubModuloItemResponse> alterar(Long subModuloItemId , String descricao) {
		
		SubModuloItem subModuloItem = subModuloItemRepository.findById(subModuloItemId)
				                     .orElseThrow(() -> new NegocioException("Item do Sub-Modulo não localizado! Verifique os dados e tente novamente!"));
		
		subModuloItem.getSubModulo();
		subModuloItem.setNome(descricao);
		
		subModuloItemRepository.save(subModuloItem);	
		
		return ResponseEntity.ok(subModuloItemAssembler.toModel(subModuloItem));
		
	}
}
