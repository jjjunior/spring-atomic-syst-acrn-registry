package br.com.jstack.syst.acrn.registry.application.port.output;

import br.com.jstack.syst.acrn.registry.application.usecase.PersistencePort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;

public interface BusinessUnitOutputPort extends PersistencePort<BusinessUnit, Long> {
	boolean existsByName(String name);
}
