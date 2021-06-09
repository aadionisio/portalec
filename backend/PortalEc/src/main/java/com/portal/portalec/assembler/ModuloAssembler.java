package com.portal.portalec.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portal.portalec.dto.ModuloResponse;
import com.portal.portalec.entities.Modulo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ModuloAssembler {
	private ModelMapper modelMapper;

	public ModuloResponse toModel ( Modulo modulo) {
		return modelMapper.map( modulo , ModuloResponse.class);
	}
	
	public List<ModuloResponse> toCollectionModel(List<Modulo> modulo){
		return modulo.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
}
