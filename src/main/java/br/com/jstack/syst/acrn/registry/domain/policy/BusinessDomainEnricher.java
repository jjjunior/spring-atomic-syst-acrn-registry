package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessDomainEnricher {
	
	private final BusinessUnitPolicy businessUnitPolicy;
	
	public BusinessDomain enrichWithBusinessUnit(BusinessDomain domain) {
//		BusinessUnit unit = businessUnitPolicy.getValidBusinessUnit(domain.getBusinessUnit().getId());
//		domain.setBusinessUnit(unit);
		return domain;
	}
}
