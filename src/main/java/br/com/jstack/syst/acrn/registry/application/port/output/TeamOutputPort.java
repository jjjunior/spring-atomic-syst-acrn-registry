package br.com.jstack.syst.acrn.registry.application.port.output;

import br.com.jstack.syst.acrn.registry.domain.entity.Team;

public interface TeamOutputPort extends PersistencePort<Team, Long> {
	boolean existsByName(String name);
	
	boolean existsByNameAndIdNot(String name, Long id);
}
