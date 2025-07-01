package br.com.jstack.syst.acrn.registry.application.port.input;

import java.util.List;

import br.com.jstack.syst.acrn.registry.application.mapper.BusinessUnitMapper;
import br.com.jstack.syst.acrn.registry.application.port.output.BusinessUnitOutputPort;
import br.com.jstack.syst.acrn.registry.application.usecase.BusinessUnitUseCase;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import br.com.jstack.syst.acrn.registry.framework.adapter.input.rest.inbound.BusinessUnitInbound;
import br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.mapper.BusinessUnitOutboundMapper;
import br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.outbound.BusinessUnitOutbound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessUnitInputPort implements BusinessUnitUseCase {
	
	private final BusinessUnitOutputPort     businessUnitOutputPort;
	private final BusinessUnitMapper         businessUnitMapper;
	private final BusinessUnitOutboundMapper businessUnitOutboundMapper;
	
	@Override
	public void createBusinessUnit(BusinessUnitInbound businessUnitInbound) {
		BusinessUnit businessUnit = businessUnitMapper.toEntity(businessUnitInbound);
		businessUnitOutputPort.persistBusinessUnit(businessUnit);
	}
	
	@Override
	public void removeBusinessUnit(Long id) {
		businessUnitOutputPort.removeBusinessUnit(id);
	}
	
	@Override
	public BusinessUnitOutbound retrieveBusinessUnit(Long id) {
		BusinessUnit businessUnit = businessUnitOutputPort.retrieveBusinessUnit(id);
		return businessUnitOutboundMapper.toOutbound(businessUnit);
	}
	
	@Override
	public List<BusinessUnitOutbound> retrieveBusinessUnits() {
		List<BusinessUnit> businessUnits = businessUnitOutputPort.listBusinessUnits();
		return businessUnitOutboundMapper.toListOutbound(businessUnits);
	}
	
	@Override
	public void changeBusinessUnit(Long id, BusinessUnitInbound businessUnitInbound) {
		businessUnitOutputPort.changeBusinessUnit(id, businessUnitMapper.toEntity(businessUnitInbound));
	}
}
