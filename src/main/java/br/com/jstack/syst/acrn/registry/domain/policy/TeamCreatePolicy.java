package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.application.port.output.TeamOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.Team;
import br.com.jstack.syst.acrn.registry.domain.specification.Specification;
import br.com.jstack.syst.acrn.registry.domain.specification.SpecificationFactory;
import br.com.jstack.syst.acrn.registry.domain.vo.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamCreatePolicy implements ValidationPolicy<Team> {
	
	private final SpecificationFactory specFactory;
	private final TeamOutputPort       outputPort;
	
	@Override
	public boolean supports(OperationType operation) {
		return operation == OperationType.CREATE;
	}
	
	@Override
	public void validate(Team domain) {
		Specification<Team> spec = specFactory.uniqueName(outputPort::existsByName, Team::getName);
		if (!spec.isSatisfiedBy(domain)) {
			throw new IllegalArgumentException("Team already exists");
		}
	}
	
	@Override
	public Class<Team> getTargetType() {
		return Team.class;
	}
}