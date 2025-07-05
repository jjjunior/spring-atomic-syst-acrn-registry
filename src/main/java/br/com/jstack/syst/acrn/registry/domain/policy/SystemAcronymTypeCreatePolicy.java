package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.application.port.output.SystemAcronymTypeOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.SystemAcronymType;
import br.com.jstack.syst.acrn.registry.domain.specification.Specification;
import br.com.jstack.syst.acrn.registry.domain.specification.SpecificationFactory;
import br.com.jstack.syst.acrn.registry.domain.vo.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SystemAcronymTypeCreatePolicy implements ValidationPolicy<SystemAcronymType> {
	
	private final SpecificationFactory        specFactory;
	private final SystemAcronymTypeOutputPort outputPort;
	
	@Override
	public boolean supports(OperationType operation) {
		return operation == OperationType.CREATE;
	}
	
	@Override
	public void validate(SystemAcronymType domain) {
		Specification<SystemAcronymType> spec = specFactory.uniqueName(outputPort::existsByName, SystemAcronymType::getName);
		if (!spec.isSatisfiedBy(domain)) {
			throw new IllegalArgumentException("Responsibility Type already exists");
		}
	}
	
	@Override
	public Class<SystemAcronymType> getTargetType() {
		return SystemAcronymType.class;
	}
}