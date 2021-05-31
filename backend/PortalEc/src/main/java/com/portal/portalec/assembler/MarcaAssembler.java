package com.portal.portalec.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portal.portalec.dto.MarcaResponse;
import com.portal.portalec.entities.Marca;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class MarcaAssembler {

	private ModelMapper modelMapper;
	
	
    public MarcaResponse toModel ( Marca marca) {
		return modelMapper.map( marca , MarcaResponse.class);
	}
	
	public List<MarcaResponse> toCollectionModel(List<Marca> marca){
		return marca.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
