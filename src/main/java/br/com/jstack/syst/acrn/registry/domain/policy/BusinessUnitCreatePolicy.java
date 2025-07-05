package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessUnitOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import br.com.jstack.syst.acrn.registry.domain.specification.Specification;
import br.com.jstack.syst.acrn.registry.domain.specification.SpecificationFactory;
import br.com.jstack.syst.acrn.registry.domain.vo.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessUnitCreatePolicy implements ValidationPolicy<BusinessUnit> {
	
	private final SpecificationFactory   specFactory;
	private final BusinessUnitOutputPort outputPort;
	
	@Override
	public boolean supports(OperationType operation) {
		return operation == OperationType.CREATE;
	}
	
	@Override
	public void validate(BusinessUnit domain) {
		Specification<BusinessUnit> spec = specFactory.uniqueName(outputPort::existsByName, BusinessUnit::getName);
		if (!spec.isSatisfiedBy(domain)) {
			throw new IllegalArgumentException("Domain Unit already exists");
		}
	}
	
	@Override
	public Class<BusinessUnit> getTargetType() {
		return BusinessUnit.class;
	}
	
	public BusinessUnit getValidBusinessUnit(Long id) {
		return outputPort.findById(id);
	}
}