package com.portal.portalec.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portal.portalec.dto.SubModuloResponse;
import com.portal.portalec.entities.SubModulo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class SubModuloAssembler {
	private ModelMapper modelMapper;

	public SubModuloResponse toModel ( SubModulo subModulo) {
		return modelMapper.map( subModulo , SubModuloResponse.class);
	}
	
	public List<SubModuloResponse> toCollectionModel(List<SubModulo> subModulo){
		return subModulo.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
}

