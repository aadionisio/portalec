package com.portal.portalec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.portalec.assembler.SecaoAssembler;
import com.portal.portalec.dto.SecaoResponse;
import com.portal.portalec.entities.Departamento;
import com.portal.portalec.entities.Secao;
import com.portal.portalec.exception.NegocioException;
import com.portal.portalec.repositories.DepartamentoRepository;
import com.portal.portalec.repositories.SecaoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SecaoService {

 	private SecaoRepository secaoRepository;
 	private SecaoAssembler secaoAssembler;
 	private DepartamentoRepository departamentoRepository;
	
	public List<SecaoResponse> findAll(){
		List<Secao> result = secaoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		// converte o resultado para o dto depatamento response
		return result.stream().map( x -> new SecaoResponse(x)).collect(Collectors.toList());
	}
	
	
	
	public ResponseEntity<SecaoResponse>  findById(Long secaoId){
		
		
		return secaoRepository.findById(secaoId)
				   .map(secao -> ResponseEntity.ok(secaoAssembler.toModel(secao)))
				   .orElse(ResponseEntity.notFound().build());
			
	}
	
	public List<SecaoResponse>  findByNome(String secao){
		return secaoAssembler.toCollectionModel(secaoRepository.findByNomeContainingIgnoreCase(secao));
	}
	
	@Transactional
	public SecaoResponse cadastrar(Long departamentoId, String descricao) {
		
		Departamento departamento = departamentoRepository.findById(departamentoId)
                .orElseThrow(() -> new NegocioException("Departamento não localizado! Verifique os dados e tente novamente!"));
		
		
		Secao secaoGravada = departamento.adicionarSecaoDescricao(descricao);
		return secaoAssembler.toModel(secaoGravada);
		
	}
	
	@Transactional
	public ResponseEntity<SecaoResponse> alterar(Long secaoId , String descricao) {
		
		Secao secao = secaoRepository.findById(secaoId)
				                     .orElseThrow(() -> new NegocioException("Secao não localizada! Verifique os dados e tente novamente!"));
		
//		Departamento departamento = departamentoRepository.findById(departamentoId)
//                .orElseThrow(() -> new NegocioException("Departamento não localizado! Verifique os dados e tente novamente!"));
//		
		secao.getDepartamento();
		secao.setNome(descricao);
		
		secaoRepository.save(secao);	
		
		return ResponseEntity.ok(secaoAssembler.toModel(secao));
		
	}
}
