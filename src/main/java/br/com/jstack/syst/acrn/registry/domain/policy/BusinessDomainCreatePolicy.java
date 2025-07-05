package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessDomainOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
import br.com.jstack.syst.acrn.registry.domain.specification.Specification;
import br.com.jstack.syst.acrn.registry.domain.specification.SpecificationFactory;
import br.com.jstack.syst.acrn.registry.domain.vo.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessDomainCreatePolicy implements ValidationPolicy<BusinessDomain> {
	
	private final SpecificationFactory     specFactory;
	private final BusinessDomainOutputPort outputPort;
	
	@Override
	public boolean supports(OperationType operation) {
		return operation == OperationType.CREATE;
	}
	
	@Override
	public void validate(BusinessDomain domain) {
		Specification<BusinessDomain> spec = specFactory.uniqueName(outputPort::existsByName, BusinessDomain::getName);
		if (!spec.isSatisfiedBy(domain)) {
			throw new IllegalArgumentException("BusinessDomain name must be unique.");
		}
	}
	
	@Override
	public Class<BusinessDomain> getTargetType() {
		return BusinessDomain.class;
	}
}