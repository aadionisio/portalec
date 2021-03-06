package com.portal.portalec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.portalec.entities.Modulo;
import com.portal.portalec.entities.SubModulo;

public interface SubModuloRepository extends JpaRepository<SubModulo, Long> {

	List<SubModulo> findByModulo(Modulo modulo);
}
