package br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.repository;

import java.util.Optional;

import br.com.jstack.syst.acrn.registry.domain.entity.SystemAcronymType;
import br.com.jstack.syst.acrn.registry.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAcronymTypeRepository extends JpaRepository<SystemAcronymType, Long> {
	Optional<SystemAcronymType> findByName(String name);
}