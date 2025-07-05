package br.com.jstack.syst.acrn.registry.domain.specification;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessDomainOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BusinessDomainNotInNameSpec implements Specification<BusinessDomain> {
	
	private final BusinessDomainOutputPort port;
	
	@Override
	public boolean isSatisfiedBy(BusinessDomain domain) {
		return  !port.existsByNameAndIdNot(domain.getName(), domain.getId());
	}
}
