package br.com.jstack.syst.acrn.registry.application.port.input;

import java.util.List;
import java.util.stream.Collectors;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessUnitOutputPort;
import br.com.jstack.syst.acrn.registry.application.usecase.CreateUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.DeleteUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveAllUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.UpdateUseCase;
import br.com.jstack.syst.acrn.registry.domain.policy.ValidationPolicy;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessUnitInputPort implements CreateUseCase<BusinessUnit>,
	RetrieveByIdUseCase<BusinessUnit, Long>,
	RetrieveAllUseCase<BusinessUnit>,
	UpdateUseCase<BusinessUnit, Long>,
	DeleteUseCase<Long> {
	
	private final BusinessUnitOutputPort outputPort;
	private final ValidationPolicy<BusinessUnit> validationPolicy;
	
	@Override
	public BusinessUnit create(@Valid BusinessUnit entity) {
		validationPolicy.validate(entity);
		return outputPort.save(entity);
	}
	
	@Override
	public BusinessUnit retrieveById(Long id) {
		return outputPort.findById(id).get();
	}
	
	@Override
	public List<BusinessUnit> retrieveAll() {
		return outputPort.findAll().stream().collect(Collectors.toList());
	}
	
	@Override
	public BusinessUnit update(Long id, BusinessUnit entity) {
		return outputPort.update(id, entity);
	}
	
	@Override
	public void delete(Long id) {
		outputPort.deleteById(id);
	}
}
