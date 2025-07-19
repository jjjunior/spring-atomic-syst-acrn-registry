package br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.repository;

import java.util.Optional;

import br.com.jstack.syst.acrn.registry.domain.entity.SystemAcronym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAcronymRepository extends JpaRepository<SystemAcronym, Long> {
	Optional<SystemAcronym> findByName(String name);
	
	Optional<SystemAcronym> findByNameAndIdNot(String name, Long id);
}