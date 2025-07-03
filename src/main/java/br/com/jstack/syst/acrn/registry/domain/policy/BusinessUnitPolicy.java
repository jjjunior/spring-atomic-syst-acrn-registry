package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessUnitOutputPort;
import br.com.jstack.syst.acrn.registry.domain.specification.Specification;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import br.com.jstack.syst.acrn.registry.domain.specification.BusinessUnitUniqueNameSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessUnitPolicy implements ValidationPolicy<BusinessUnit> {
	
	private final BusinessUnitOutputPort port;
	
	@Override
	public void validate(BusinessUnit domain) {
		Specification<BusinessUnit> spec = new BusinessUnitUniqueNameSpec(port);
		if (!spec.isSatisfiedBy(domain)) {
			throw new IllegalArgumentException("Domain Unit already exists");
		}
	}
}