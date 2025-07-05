package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessUnitOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import br.com.jstack.syst.acrn.registry.domain.specification.BusinessUnitUniqueNameSpec;
import br.com.jstack.syst.acrn.registry.domain.specification.Specification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessUnitCreatePolicy implements ValidationPolicy<BusinessUnit> {
	
	private final BusinessUnitOutputPort port;
	
	@Override
	public boolean supports(OperationType operation) {
		return operation == OperationType.UPDATE;
	}
	
	@Override
	public void validate(BusinessUnit domain) {
		Specification<BusinessUnit> spec = new BusinessUnitUniqueNameSpec(port);
		if (!spec.isSatisfiedBy(domain)) {
			throw new IllegalArgumentException("Domain Unit already exists");
		}
	}
	
	public BusinessUnit getValidBusinessUnit(Long id) {
		return port.findById(id);
	}
}