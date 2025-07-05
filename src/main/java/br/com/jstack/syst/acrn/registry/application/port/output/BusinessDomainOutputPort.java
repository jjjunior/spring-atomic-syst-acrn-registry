package br.com.jstack.syst.acrn.registry.application.port.output;

import br.com.jstack.syst.acrn.registry.application.usecase.PersistencePort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;

public interface BusinessDomainOutputPort extends PersistencePort<BusinessDomain, Long> {
	boolean existsByName(String name);
	boolean existsByNameAndIdNot(String name, Long id);
}
