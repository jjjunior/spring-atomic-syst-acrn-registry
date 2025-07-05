package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.application.port.output.ResponsibilityTypeOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.ResponsibilityType;
import br.com.jstack.syst.acrn.registry.domain.specification.Specification;
import br.com.jstack.syst.acrn.registry.domain.specification.SpecificationFactory;
import br.com.jstack.syst.acrn.registry.domain.vo.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResponsibilityTypeCreatePolicy implements ValidationPolicy<ResponsibilityType> {
	
	private final SpecificationFactory         specFactory;
	private final ResponsibilityTypeOutputPort outputPort;
	
	@Override
	public boolean supports(OperationType operation) {
		return operation == OperationType.CREATE;
	}
	
	@Override
	public void validate(ResponsibilityType domain) {
		Specification<ResponsibilityType> spec = specFactory.uniqueName(outputPort::existsByName, ResponsibilityType::getName);
		if (!spec.isSatisfiedBy(domain)) {
			throw new IllegalArgumentException("Responsibility Type already exists");
		}
	}
	
	@Override
	public Class<ResponsibilityType> getTargetType() {
		return ResponsibilityType.class;
	}
}