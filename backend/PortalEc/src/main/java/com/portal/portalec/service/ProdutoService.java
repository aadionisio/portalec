package com.portal.portalec.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.portalec.assembler.ProdutoAssembler;
import com.portal.portalec.dto.ProdutoRequestCadastro;
import com.portal.portalec.dto.ProdutoResponseCadastro;
import com.portal.portalec.dto.ProdutoResponsePesquisaCompleta;
import com.portal.portalec.entities.Departamento;
import com.portal.portalec.entities.LinhaProduto;
import com.portal.portalec.entities.Marca;
import com.portal.portalec.entities.Produto;
import com.portal.portalec.entities.Secao;
import com.portal.portalec.exception.NegocioException;
import com.portal.portalec.repositories.DepartamentoRepository;
import com.portal.portalec.repositories.LinhaProdutoRepository;
import com.portal.portalec.repositories.MarcaRepository;
import com.portal.portalec.repositories.ProdutoRepository;
import com.portal.portalec.repositories.SecaoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProdutoService {

 	private ProdutoRepository produtoRepository;
 	private ProdutoAssembler produtoAssembler;
 	
 	
 	private DepartamentoRepository departamentoRepository;
 	private SecaoRepository secaoRepository;
 	private MarcaRepository marcaRepository;
 	private LinhaProdutoRepository linhaProdutoRepository;
 	
 	
	public List<ProdutoResponsePesquisaCompleta> findAll(){
		List<Produto> result = produtoRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
		// converte o resultado para o dto depatamento response
		return result.stream().map( x -> new ProdutoResponsePesquisaCompleta(x)).collect(Collectors.toList());
	}
	
	
	public ResponseEntity<ProdutoResponseCadastro>  findById(Long produtoId){
		
		
		return produtoRepository.findById(produtoId)
				   .map(produto -> ResponseEntity.ok(produtoAssembler.toModelProdutoCadastro(produto)))
				   .orElse(ResponseEntity.notFound().build());
			
	}
	
	@Transactional
	public ProdutoResponseCadastro cadastrar(ProdutoRequestCadastro produto) {
		
		Departamento departamento = departamentoRepository.findById(produto.getDepartamentoId())
                .orElseThrow(() -> new NegocioException("Departamento n??o localizado! Verifique os dados e tente novamente!"));

		Secao secao = secaoRepository.findById(produto.getSecaoId())
                .orElseThrow(() -> new NegocioException("Secao n??o localizada! Verifique os dados e tente novamente!"));
		
		Marca marca = marcaRepository.findById(produto.getMarcaId())
                .orElseThrow(() -> new NegocioException("Marca n??o localizada! Verifique os dados e tente novamente!"));
		
		LinhaProduto linhaProduto = linhaProdutoRepository.findById(produto.getLinhaProdutoId())
                .orElseThrow(() -> new NegocioException("Linha do produto n??o localizada! Verifique os dados e tente novamente!"));
		
		
		Produto novoProduto = new Produto();
		
		novoProduto.setDescricao(produto.getDescricao());
		novoProduto.setUnidade(produto.getUnidade());
		novoProduto.setEmbalagem(produto.getEmbalagem());
		novoProduto.setPeso(produto.getPeso());
		novoProduto.setDtcadastro(OffsetDateTime.now());
		novoProduto.setCodfunccad(produto.getCodfunccad());
		novoProduto.setEnderecofoto(produto.getEnderecoFoto());
		
		novoProduto.setDepartamento(departamento);
		novoProduto.setSecao(secao);
		novoProduto.setMarca(marca);
		novoProduto.setLinhaProduto(linhaProduto);
		
		
		
		return produtoAssembler.toModelProdutoCadastro(produtoRepository.save(novoProduto) );
		
	}
}
