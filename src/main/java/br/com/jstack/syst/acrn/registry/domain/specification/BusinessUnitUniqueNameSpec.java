package br.com.jstack.syst.acrn.registry.domain.specification;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessUnitOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BusinessUnitUniqueNameSpec implements Specification<BusinessUnit> {
	
	private final BusinessUnitOutputPort port;
	
	@Override
	public boolean isSatisfiedBy(BusinessUnit domain) {
		return !port.existsByName(domain.getName());
	}
}
