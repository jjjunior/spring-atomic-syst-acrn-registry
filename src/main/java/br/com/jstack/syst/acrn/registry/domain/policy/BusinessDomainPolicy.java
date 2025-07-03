package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessDomainOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
import br.com.jstack.syst.acrn.registry.domain.specification.BusinessDomainUniqueNameSpec;
import br.com.jstack.syst.acrn.registry.domain.specification.Specification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessDomainPolicy implements ValidationPolicy<BusinessDomain> {
	
	private final BusinessDomainOutputPort port;
	
	@Override
	public void validate(BusinessDomain domain) {
		Specification<BusinessDomain> spec = new BusinessDomainUniqueNameSpec(port);
		if (!spec.isSatisfiedBy(domain)) {
			throw new IllegalArgumentException("Domain Domain already exists");
		}
	}
}