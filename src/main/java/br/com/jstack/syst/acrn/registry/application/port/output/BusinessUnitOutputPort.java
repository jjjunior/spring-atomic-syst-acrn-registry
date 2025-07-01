package br.com.jstack.syst.acrn.registry.application.port.output;

import java.util.List;

import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;

public interface BusinessUnitOutputPort {
	
	void persistBusinessUnit(BusinessUnit businessUnit);
	
	void removeBusinessUnit(Long id);
	
	BusinessUnit retrieveBusinessUnit(Long id);
	
	List<BusinessUnit> listBusinessUnits();
	
	void changeBusinessUnit(Long id, BusinessUnit businessUnit);
}
