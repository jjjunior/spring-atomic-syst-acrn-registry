package br.com.jstack.syst.acrn.registry.application.usecase;

import java.util.List;

import br.com.jstack.syst.acrn.registry.framework.adapter.input.rest.inbound.BusinessUnitInbound;
import br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.outbound.BusinessUnitOutbound;

public interface BusinessUnitUseCase {
	
	void createBusinessUnit(BusinessUnitInbound businessUnitInbound);
	
	void removeBusinessUnit(Long id);
	
	BusinessUnitOutbound retrieveBusinessUnit(Long id);
	
	List<BusinessUnitOutbound> retrieveBusinessUnits();
	
	void changeBusinessUnit(Long id, BusinessUnitInbound businessUnitInbound);
}
