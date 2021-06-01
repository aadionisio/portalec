package com.portal.portalec.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portal.portalec.dto.ProdutoResponseCadastro;
import com.portal.portalec.entities.Produto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProdutoAssembler {

	private ModelMapper modelMapper;
	
    public ProdutoResponseCadastro toModelProdutoCadastro ( Produto produto) {
		return modelMapper.map( produto , ProdutoResponseCadastro.class);
	}
    
 
	public List<ProdutoResponseCadastro> toCollectionModelProdutoCadastro(List<Produto> produto){
		return produto.stream()
				.map(this::toModelProdutoCadastro)
				.collect(Collectors.toList());
	}
}
