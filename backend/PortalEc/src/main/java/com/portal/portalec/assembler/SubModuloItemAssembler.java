package com.portal.portalec.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portal.portalec.dto.SubModuloItemResponse;
import com.portal.portalec.entities.SubModuloItem;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class SubModuloItemAssembler {
	
	private ModelMapper modelMapper;
	
	public SubModuloItemResponse toModel ( SubModuloItem subModuloItem) {
		return modelMapper.map( subModuloItem , SubModuloItemResponse.class);
	}
	
	public List<SubModuloItemResponse> toCollectionModel(List<SubModuloItem> subModuloItem){
		return subModuloItem.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}

}
