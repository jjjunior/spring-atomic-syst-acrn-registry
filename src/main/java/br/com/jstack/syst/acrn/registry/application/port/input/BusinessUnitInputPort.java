package br.com.jstack.syst.acrn.registry.application.port.input;

import java.util.List;
import java.util.stream.Collectors;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessUnitOutputPort;
import br.com.jstack.syst.acrn.registry.application.usecase.CreateUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.DeleteByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveAllUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.UpdateUseCase;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import br.com.jstack.syst.acrn.registry.domain.policy.OperationType;
import br.com.jstack.syst.acrn.registry.domain.policy.PolicyResolver;
import br.com.jstack.syst.acrn.registry.domain.policy.ValidationPolicy;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessUnitInputPort implements CreateUseCase<BusinessUnit>,
	RetrieveByIdUseCase<BusinessUnit, Long>,
	RetrieveAllUseCase<BusinessUnit>,
	UpdateUseCase<BusinessUnit,Long>,
	DeleteByIdUseCase<BusinessUnit, Long> {
	
	private final BusinessUnitOutputPort       outputPort;
	private final PolicyResolver<BusinessUnit> policyResolver;
	
	@Override
	public BusinessUnit create(@Valid BusinessUnit domain) {
		ValidationPolicy<BusinessUnit> policy = policyResolver.resolve(OperationType.CREATE);
		policy.validate(domain);
		return outputPort.save(domain);
	}
	
	@Override
	public BusinessUnit retrieveById(Long id) {
		return outputPort.findById(id);
	}
	
	@Override
	public List<BusinessUnit> retrieveAll() {
		return outputPort.findAll().stream().collect(Collectors.toList());
	}
	
	@Override
	public BusinessUnit update(@Valid BusinessUnit domain) {
		ValidationPolicy<BusinessUnit> policy = policyResolver.resolve(OperationType.UPDATE);
		policy.validate(domain);
		return outputPort.update(domain);
	}
	
	@Override
	public void deleteteById(Long id) {
		outputPort.deleteById(id);
	}
}
