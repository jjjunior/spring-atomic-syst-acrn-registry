package br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.repository;

import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnitDomain;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnitDomainId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessUnitDomainRepository extends JpaRepository<BusinessUnitDomain, BusinessUnitDomainId> {
}
