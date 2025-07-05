package br.com.jstack.syst.acrn.registry.application.port.input;

import java.util.List;
import java.util.stream.Collectors;

import br.com.jstack.syst.acrn.registry.application.port.output.TeamOutputPort;
import br.com.jstack.syst.acrn.registry.application.usecase.CreateUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.DeleteByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveAllUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.UpdateUseCase;
import br.com.jstack.syst.acrn.registry.domain.entity.Team;
import br.com.jstack.syst.acrn.registry.domain.vo.OperationType;
import br.com.jstack.syst.acrn.registry.domain.policy.PolicyResolver;
import br.com.jstack.syst.acrn.registry.domain.policy.ValidationPolicy;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamInputPort implements CreateUseCase<Team>,
	RetrieveByIdUseCase<Team, Long>,
	RetrieveAllUseCase<Team>,
	UpdateUseCase<Team, Long>,
	DeleteByIdUseCase<Team, Long> {
	
	private final TeamOutputPort       outputPort;
	private final PolicyResolver<Team> policyResolver;
	
	@Override
	public Team create(Team domain) {
		ValidationPolicy<Team> policy = policyResolver.resolve(OperationType.CREATE, Team.class);
		policy.validate(domain);
		return outputPort.save(domain);
	}
	
	@Override
	public Team retrieveById(Long id) {
		return outputPort.findById(id);
	}
	
	@Override
	public List<Team> retrieveAll() {
		return outputPort.findAll().stream().collect(Collectors.toList());
	}
	
	@Override
	public Team update(@Valid Team domain) {
		ValidationPolicy<Team> policy = policyResolver.resolve(OperationType.UPDATE,Team.class);
		policy.validate(domain);
		return outputPort.update(domain);
	}
	
	@Override
	public void deleteteById(Long id) {
		outputPort.deleteById(id);
	}
}
