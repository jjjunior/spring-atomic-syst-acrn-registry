package br.com.jstack.syst.acrn.registry.application.port.output;

import br.com.jstack.syst.acrn.registry.domain.entity.ResponsibilityType;

public interface ResponsibilityTypeOutputPort extends PersistencePort<ResponsibilityType, Long> {
	boolean existsByName(String name);
	
	boolean existsByNameAndIdNot(String name, Long id);
}
