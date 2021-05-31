package com.portal.portalec.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portal.portalec.dto.DepartamentoResponse;
import com.portal.portalec.entities.Departamento;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DepartamentoAssembler {
	private ModelMapper modelMapper;

	// esse metodo transforma um objeto do tipo departamento para objeto do tipo DepartamentoResponse retornando um unico registro
	public DepartamentoResponse toModel ( Departamento departamento) {
		return modelMapper.map( departamento , DepartamentoResponse.class);
	}
	
	// esse metodo retorna uma lista de departamentos transformando ela em uma lista de DepartamentoResponse
	public List<DepartamentoResponse> toCollectionModel(List<Departamento> departamento){
		return departamento.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
