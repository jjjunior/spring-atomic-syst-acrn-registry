package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessDomainEnricher {
	
	private final BusinessUnitCreatePolicy businessUnitCreatePolicy;
	
	public BusinessDomain enrichWithBusinessUnit(BusinessDomain domain) {
		BusinessUnit unit = businessUnitCreatePolicy.getValidBusinessUnit(domain.getBusinessUnit().getId());
		domain.setBusinessUnit(unit);
		return domain;
	}
}
