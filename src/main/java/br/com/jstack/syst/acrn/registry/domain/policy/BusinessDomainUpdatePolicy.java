package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessDomainOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
import br.com.jstack.syst.acrn.registry.domain.specification.Specification;
import br.com.jstack.syst.acrn.registry.domain.specification.BusinessDomainNotInNameSpec;
import br.com.jstack.syst.acrn.registry.domain.vo.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessDomainUpdatePolicy implements ValidationPolicy<BusinessDomain> {
	
	private final BusinessDomainOutputPort port;
	
	@Override
	public boolean supports(OperationType operation) {
		return operation == OperationType.UPDATE;
	}
	
	@Override
	public void validate(BusinessDomain domain) {
		Specification<BusinessDomain> spec = new BusinessDomainNotInNameSpec(port);
		if (!spec.isSatisfiedBy(domain)) {
			throw new IllegalArgumentException("Another domain with this name already exists.");
		}
	}
	
	@Override
	public Class<BusinessDomain> getTargetType() {
		return BusinessDomain.class;
	}
}