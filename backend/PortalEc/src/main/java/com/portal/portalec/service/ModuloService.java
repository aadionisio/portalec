package com.portal.portalec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.portalec.assembler.ModuloAssembler;
import com.portal.portalec.dto.ModuloResponse;
import com.portal.portalec.entities.Modulo;
import com.portal.portalec.exception.NegocioException;
import com.portal.portalec.repositories.ModuloRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ModuloService {

	private ModuloRepository moduloRepository;
    private ModuloAssembler moduloAssembler;
    
	public List<ModuloResponse> findAll(){
		List<Modulo> result = moduloRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		// converte o resultado para o dto depatamento response
		return result.stream().map( x -> new ModuloResponse(x)).collect(Collectors.toList());
	}
	
	
	@Transactional
	public ModuloResponse cadastrar(String descricao) {
		
		Modulo modulo = new Modulo();
		
		modulo.setNome(descricao);
		
		moduloRepository.save(modulo);	
		
		return moduloAssembler.toModel(modulo);
		
	}
		
	@Transactional
	public ResponseEntity<ModuloResponse> alterar(Long moduloId , String descricao) {
		
		Modulo modulo = moduloRepository.findById(moduloId)
				                        .orElseThrow(() -> new NegocioException("Modulo não localizado! Verifique os dados e tente novamente!"));;
		
		modulo.setNome(descricao);
		
		moduloRepository.save(modulo);	
		
		return ResponseEntity.ok(moduloAssembler.toModel(modulo));
		
	}
	
}