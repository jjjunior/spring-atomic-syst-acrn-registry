package br.com.jstack.syst.acrn.registry.application.port.output;

import br.com.jstack.syst.acrn.registry.domain.entity.SystemAcronymType;

public interface SystemAcronymTypeOutputPort extends PersistencePort<SystemAcronymType, Long> {
	boolean existsByName(String name);
}
