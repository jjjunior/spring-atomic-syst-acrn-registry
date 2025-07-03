package br.com.jstack.syst.acrn.registry.application.port.input;

import java.util.List;
import java.util.stream.Collectors;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessDomainOutputPort;
import br.com.jstack.syst.acrn.registry.application.usecase.CreateUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.DeleteByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveAllUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.UpdateUseCase;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
import br.com.jstack.syst.acrn.registry.domain.policy.ValidationPolicy;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessDomainInputPort implements CreateUseCase<BusinessDomain>,
	RetrieveByIdUseCase<BusinessDomain, Long>,
	RetrieveAllUseCase<BusinessDomain>,
	UpdateUseCase<BusinessDomain, Long>,
	DeleteByIdUseCase<BusinessDomain, Long> {
	
	private final BusinessDomainOutputPort         outputPort;
	private final ValidationPolicy<BusinessDomain> validationPolicy;
	
	@Override
	public BusinessDomain create(@Valid BusinessDomain entity) {
		validationPolicy.validate(entity);
		return outputPort.save(entity);
	}
	
	@Override
	public BusinessDomain retrieveById(Long id) {
		return outputPort.findById(id).get();
	}
	
	@Override
	public List<BusinessDomain> retrieveAll() {
		return outputPort.findAll().stream().collect(Collectors.toList());
	}
	
	@Override
	public BusinessDomain update(Long id, @Valid BusinessDomain entity) {
		validationPolicy.validate(entity);
		return outputPort.update(id, entity);
	}
	
	@Override
	public void deleteteById(Long id) {
		outputPort.deleteById(id);
	}
}
