package com.portal.portalec.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portal.portalec.dto.SecaoResponse;
import com.portal.portalec.entities.Secao;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class SecaoAssembler {
	
	private ModelMapper modelMapper;
	
	
    public SecaoResponse toModel ( Secao secao) {
		return modelMapper.map( secao , SecaoResponse.class);
	}

	public List<SecaoResponse> toCollectionModel(List<Secao> secao){
		return secao.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
