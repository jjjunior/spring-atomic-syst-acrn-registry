package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.application.port.output.ResponsibilityTypeOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import br.com.jstack.syst.acrn.registry.domain.entity.ResponsibilityType;
import br.com.jstack.syst.acrn.registry.domain.specification.Specification;
import br.com.jstack.syst.acrn.registry.domain.specification.SpecificationFactory;
import br.com.jstack.syst.acrn.registry.domain.vo.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResponsibilityTypePolicy implements ValidationPolicy<ResponsibilityType> {
	
	private final SpecificationFactory         specFactory;
	private final ResponsibilityTypeOutputPort outputPort;
	
	@Override
	public void validate(ResponsibilityType domain, OperationType operation) {
		
		if (operation == OperationType.CREATE) {
			Specification<ResponsibilityType> uniqueNameSpec = specFactory.uniqueName(outputPort::existsByName, ResponsibilityType::getName);
			if (!uniqueNameSpec.isSatisfiedBy(domain)) {
				throw new IllegalArgumentException("Responsibility Type Name must be unique.");
			}
		}
		
		if (operation == OperationType.UPDATE) {
			Specification<ResponsibilityType> uniqueNameExclIdSpec = specFactory.uniqueNameExcludingSelf(outputPort::existsByNameAndIdNot, ResponsibilityType::getName, ResponsibilityType::getId);
			if (!uniqueNameExclIdSpec.isSatisfiedBy(domain)) {
				throw new IllegalArgumentException("Responsibility Type Name must be unique (excluding self).");
			}
		}
	}
	
	@Override
	public boolean supports(OperationType operation) {
		return operation == OperationType.CREATE || operation == OperationType.UPDATE;
	}
	
	@Override
	public Class<ResponsibilityType> getTargetType() {
		return ResponsibilityType.class;
	}
}