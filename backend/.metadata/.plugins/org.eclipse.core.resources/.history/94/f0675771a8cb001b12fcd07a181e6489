package com.portal.portalec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.portalec.assembler.SubModuloAssembler;
import com.portal.portalec.dto.SubModuloResponse;
import com.portal.portalec.entities.Modulo;
import com.portal.portalec.entities.SubModulo;
import com.portal.portalec.exception.NegocioException;
import com.portal.portalec.repositories.ModuloRepository;
import com.portal.portalec.repositories.SubModuloRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SubModuloService {

 	private SubModuloRepository subModuloRepository;
 	private SubModuloAssembler subModuloAssembler;
 	private ModuloRepository moduloRepository;
 	
 	
	public List<SubModuloResponse> findByModulo(Long moduloId){
		
		Modulo modulo = moduloRepository.findById(moduloId)
										.orElseThrow(() -> new NegocioException("Modulo não localizado! Verifique os dados e tente novamente!"));
		
		
		List<SubModulo> result = subModuloRepository.findByModulo(modulo);
		// converte o resultado para o dto depatamento response
		return result.stream().map( x -> new SubModuloResponse(x)).collect(Collectors.toList());
	}
	
	
	@Transactional
	public SubModuloResponse cadastrar(Long moduloId, String descricao) {
		
		Modulo modulo = moduloRepository.findById(moduloId)
                .orElseThrow(() -> new NegocioException("Modulo não localizado! Verifique os dados e tente novamente!"));
		
		
		SubModulo subModuloGravado = modulo.adicionarSubModuloDescricao(descricao);
		return subModuloAssembler.toModel(subModuloGravado);
		
	}
	
	
	@Transactional
	public ResponseEntity<SubModuloResponse> alterar(Long subModuloId , String descricao) {
		
		SubModulo subModulo = subModuloRepository.findById(subModuloId)
				                     .orElseThrow(() -> new NegocioException("Sub-Modulo não localizada! Verifique os dados e tente novamente!"));
		
//		Departamento departamento = departamentoRepository.findById(departamentoId)
//                .orElseThrow(() -> new NegocioException("Departamento não localizado! Verifique os dados e tente novamente!"));
//		
		subModulo.getModulo();
		subModulo.setNome(descricao);
		
		subModuloRepository.save(subModulo);	
		
		return ResponseEntity.ok(subModuloAssembler.toModel(subModulo));
		
	}
}
