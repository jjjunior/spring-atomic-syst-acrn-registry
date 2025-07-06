package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.application.port.output.SystemAcronymTypeOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.ResponsibilityType;
import br.com.jstack.syst.acrn.registry.domain.entity.SystemAcronymType;
import br.com.jstack.syst.acrn.registry.domain.specification.Specification;
import br.com.jstack.syst.acrn.registry.domain.specification.SpecificationFactory;
import br.com.jstack.syst.acrn.registry.domain.vo.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SystemAcronymTypePolicy implements ValidationPolicy<SystemAcronymType> {
	
	private final SpecificationFactory        specFactory;
	private final SystemAcronymTypeOutputPort outputPort;
	
	@Override
	public void validate(SystemAcronymType domain, OperationType operation) {
		
		if (operation == OperationType.CREATE) {
			Specification<SystemAcronymType> uniqueNameSpec = specFactory.uniqueName(outputPort::existsByName, SystemAcronymType::getName);
			if (!uniqueNameSpec.isSatisfiedBy(domain)) {
				throw new IllegalArgumentException("System Acronym Type must be unique.");
			}
		}
		
		if (operation == OperationType.UPDATE) {
			Specification<SystemAcronymType> uniqueNameExclIdSpec = specFactory.uniqueNameExcludingSelf(outputPort::existsByNameAndIdNot, SystemAcronymType::getName, SystemAcronymType::getId);
			if (!uniqueNameExclIdSpec.isSatisfiedBy(domain)) {
				throw new IllegalArgumentException("System Acronym Type must be unique (excluding self).");
			}
		}
	}
	
	@Override
	public boolean supports(OperationType operation) {
		return operation == OperationType.CREATE || operation == OperationType.UPDATE;
	}
	
	@Override
	public Class<SystemAcronymType> getTargetType() {
		return SystemAcronymType.class;
	}
}