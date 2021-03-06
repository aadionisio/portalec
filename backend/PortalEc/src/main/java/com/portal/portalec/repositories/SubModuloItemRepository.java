package com.portal.portalec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.portalec.entities.SubModulo;
import com.portal.portalec.entities.SubModuloItem;

public interface SubModuloItemRepository extends JpaRepository<SubModuloItem, Long> {

	List<SubModuloItem> findBySubModulo(SubModulo subModulo);
}
