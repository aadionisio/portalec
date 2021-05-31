package com.portal.portalec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.portalec.entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository< Marca, Long> {

	//Caso eu queira pesquisar por fragmentos de string ( like ) colocar o sufixo Containing
	List<Marca> findByNomeContainingIgnoreCase(String nome);
}
