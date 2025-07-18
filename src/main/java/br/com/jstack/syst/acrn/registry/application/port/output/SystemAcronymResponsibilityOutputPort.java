package br.com.jstack.syst.acrn.registry.application.port.output;

import br.com.jstack.syst.acrn.registry.domain.entity.SystemAcronymResponsibility;

public interface SystemAcronymResponsibilityOutputPort extends PersistencePort<SystemAcronymResponsibility, Long> {
	boolean existsByName(String name);
	
	boolean existsByNameAndIdNot(String name, Long id);
}
