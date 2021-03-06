package com.portal.portalec.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portal.portalec.dto.LinhaProdutoResponse;
import com.portal.portalec.entities.LinhaProduto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class LinhaProdutoAssembler {

	private ModelMapper modelMapper;

	// esse metodo transforma um objeto do tipo departamento para objeto do tipo DepartamentoResponse retornando um unico registro
	public LinhaProdutoResponse toModel ( LinhaProduto linhaProduto) {
		return modelMapper.map( linhaProduto , LinhaProdutoResponse.class);
	}
	
	public List<LinhaProdutoResponse> toCollectionModel(List<LinhaProduto> linhaProduto){
		return linhaProduto.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
