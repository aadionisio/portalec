package com.portal.portalec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.portalec.entities.Departamento;


@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

	//Caso eu queira pesquisar por fragmentos de string ( like ) colocar o sufixo Containing
	List<Departamento> findByNomeContainingIgnoreCase(String nome);
}
