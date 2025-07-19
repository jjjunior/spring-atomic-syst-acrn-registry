package br.com.jstack.syst.acrn.registry.application.port.output;

import br.com.jstack.syst.acrn.registry.domain.entity.SystemAcronym;

public interface SystemAcronymOutputPort extends PersistencePort<SystemAcronym, Long> {
	boolean existsByName(String name);
	
	boolean existsByNameAndIdNot(String name, Long id);
}
