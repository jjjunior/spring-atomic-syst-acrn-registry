package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest.mapper;

import br.com.jstack.syst.acrn.registry.framework.adapter.input.rest.inbound.BusinessUnitInbound;
import br.com.jstack.syst.acrn.registry.model.BusinessUnitRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessUnitInboundMapper {
	
	BusinessUnitInbound toInbound(BusinessUnitRequest businessUnitRequest);
}
