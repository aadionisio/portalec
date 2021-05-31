package com.portal.portalec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.portalec.assembler.MarcaAssembler;
import com.portal.portalec.dto.MarcaResponse;
import com.portal.portalec.entities.Marca;
import com.portal.portalec.exception.NegocioException;
import com.portal.portalec.repositories.MarcaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MarcaService {
	

	private MarcaRepository marcaRepository;
    private MarcaAssembler marcaAssembler;

	public List<MarcaResponse> findAll(){
		List<Marca> result = marcaRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		// converte o resultado para o dto depatamento response
		return result.stream().map( x -> new MarcaResponse(x)).collect(Collectors.toList());
	}
	
	public ResponseEntity<MarcaResponse>  findById(Long marcaId){
		
		
		return marcaRepository.findById(marcaId)
				   .map(marca -> ResponseEntity.ok(marcaAssembler.toModel(marca)))
				   .orElse(ResponseEntity.notFound().build());
			
	}
	
	public List<MarcaResponse>  findByNome(String marca){
		return marcaAssembler.toCollectionModel(marcaRepository.findByNomeContainingIgnoreCase(marca));
	}
	
	@Transactional
	public MarcaResponse cadastrar(String descricao) {
		
		Marca marca = new Marca();
		
		marca.setNome(descricao);
		
		marcaRepository.save(marca);	
		
		return marcaAssembler.toModel(marca);
		
	}
	
	@Transactional
	public ResponseEntity<MarcaResponse> alterar(Long marcaId , String descricao) {
		
		Marca marca = marcaRepository.findById(marcaId)
				                     .orElseThrow(() -> new NegocioException("Marca não localizada! Verifique os dados e tente novamente!"));
				                        
		marca.setNome(descricao);
		
		marcaRepository.save(marca);	
		
		return ResponseEntity.ok(marcaAssembler.toModel(marca));
		
	}
	
	
}
