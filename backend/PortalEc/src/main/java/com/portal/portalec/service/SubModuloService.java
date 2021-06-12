package com.portal.portalec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.portalec.assembler.SubModuloAssembler;
import com.portal.portalec.dto.SubModuloRequest;
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
	public SubModuloResponse cadastrar(Long moduloId, SubModuloRequest subModuloRequest) {
		
		Modulo modulo = moduloRepository.findById(moduloId)
                .orElseThrow(() -> new NegocioException("Modulo não localizado! Verifique os dados e tente novamente!"));
		
		
		SubModulo subModuloGravado = modulo.adicionarSubModulo(subModuloRequest.getNome()
															 , subModuloRequest.getCaminhorota()
															 , subModuloRequest.getIcone()
															 , subModuloRequest.getIconeAberto()
															 , subModuloRequest.getIconeFechado());
		
		
		return subModuloAssembler.toModel(subModuloGravado);
		
	}
	
	
	@Transactional
	public ResponseEntity<SubModuloResponse> alterar(Long subModuloId , SubModuloRequest subModuloRequest) {
		
		SubModulo subModulo = subModuloRepository.findById(subModuloId)
				                     .orElseThrow(() -> new NegocioException("Sub-Modulo não localizada! Verifique os dados e tente novamente!"));
		
		//campos obrigatorios
		subModulo.getModulo();
		subModulo.setNome(subModuloRequest.getNome());
		subModulo.setCaminhorota(subModuloRequest.getCaminhorota());
		
		
		// campos opcionais
		
		if ( subModuloRequest.getIcone() != null ) {
			subModulo.setIcone(subModuloRequest.getIcone() );
		}
		
		if (subModuloRequest.getIconeAberto()  != null ) {
			subModulo.setIconeAberto(subModuloRequest.getIconeAberto() );
		}
		
		if ( subModuloRequest.getIconeFechado()  != null ) {
			subModulo.setIconeFechado(subModuloRequest.getIconeFechado() );
		}
		
		
		
		subModuloRepository.save(subModulo);	
		
		return ResponseEntity.ok(subModuloAssembler.toModel(subModulo));
		
	}
}
