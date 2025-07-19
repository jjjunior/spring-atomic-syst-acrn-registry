package br.com.jstack.syst.acrn.registry.application.port.input;

import java.util.List;
import java.util.stream.Collectors;

import br.com.jstack.syst.acrn.registry.application.port.output.SystemAcronymOutputPort;
import br.com.jstack.syst.acrn.registry.application.usecase.CreateUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.DeleteByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveAllUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.UpdateUseCase;
import br.com.jstack.syst.acrn.registry.domain.entity.SystemAcronym;
import br.com.jstack.syst.acrn.registry.domain.policy.PolicyResolver;
import br.com.jstack.syst.acrn.registry.domain.policy.ValidationPolicy;
import br.com.jstack.syst.acrn.registry.domain.vo.OperationType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SystemAcronymInputPort implements CreateUseCase<SystemAcronym>,
	RetrieveByIdUseCase<SystemAcronym, Long>,
	RetrieveAllUseCase<SystemAcronym>,
	UpdateUseCase<SystemAcronym>,
	DeleteByIdUseCase<SystemAcronym, Long> {
	
	private final SystemAcronymOutputPort       outputPort;
	private final PolicyResolver<SystemAcronym> policyResolver;
	
	@Override
	public SystemAcronym create(@Valid SystemAcronym domain) {
		ValidationPolicy<SystemAcronym> policy = policyResolver.resolve(OperationType.CREATE, SystemAcronym.class);
		policy.validate(domain, OperationType.CREATE);
		return outputPort.save(domain);
	}
	
	@Override
	public SystemAcronym retrieveById(Long id) {
		return outputPort.findById(id);
	}
	
	@Override
	public List<SystemAcronym> retrieveAll() {
		return outputPort.findAll().stream().collect(Collectors.toList());
	}
	
	@Override
	public SystemAcronym update(@Valid SystemAcronym domain) {
		ValidationPolicy<SystemAcronym> policy = policyResolver.resolve(OperationType.UPDATE, SystemAcronym.class);
		policy.validate(domain, OperationType.UPDATE);
		return outputPort.update(domain);
	}
	
	@Override
	public void deleteById(Long id) {
		outputPort.deleteById(id);
	}
}
