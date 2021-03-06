package com.portal.portalec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.portalec.assembler.DepartamentoAssembler;
import com.portal.portalec.dto.DepartamentoResponse;
import com.portal.portalec.entities.Departamento;
import com.portal.portalec.exception.NegocioException;
import com.portal.portalec.repositories.DepartamentoRepository;


@Service
public class DepartamentoService {
    @Autowired 
	private DepartamentoRepository departamentoRepository;
    @Autowired
    private DepartamentoAssembler departamentoAssembler;
	
	public List<DepartamentoResponse> findAll(){
		List<Departamento> result = departamentoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		// converte o resultado para o dto depatamento response
		return result.stream().map( x -> new DepartamentoResponse(x)).collect(Collectors.toList());
	}
	
	
	public ResponseEntity<DepartamentoResponse>  findById(Long departamentoId){
		
		
		return departamentoRepository.findById(departamentoId)
				   .map(departamento -> ResponseEntity.ok(departamentoAssembler.toModel(departamento)))
				   .orElse(ResponseEntity.notFound().build());
			
	}
	
	public List<DepartamentoResponse>  findByNome(String departamento){
		return departamentoAssembler.toCollectionModel(departamentoRepository.findByNomeContainingIgnoreCase(departamento));
	}
	
	
	@Transactional
	public DepartamentoResponse cadastrar(String descricao) {
		
		Departamento departamento = new Departamento();
		
		departamento.setNome(descricao);
		
		departamentoRepository.save(departamento);	
		
		return departamentoAssembler.toModel(departamento);
		
	}
		
	@Transactional
	public ResponseEntity<DepartamentoResponse> alterar(Long departamentoId , String descricao) {
		
		Departamento departamento = departamentoRepository.findById(departamentoId)
				                                          .orElseThrow(() -> new NegocioException("Departamento n??o localizado! Verifique os dados e tente novamente!"));;
		
		departamento.setNome(descricao);
		
		departamentoRepository.save(departamento);	
		
		return ResponseEntity.ok(departamentoAssembler.toModel(departamento));
		
	}
		
	
}
