package br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.repository;

import java.util.Optional;

import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessDomainRepository extends JpaRepository<BusinessDomain, Long> {
	Optional<BusinessDomain> findByName(String name);
	Optional<BusinessDomain> findByNameAndIdNot(String name, Long id);
}