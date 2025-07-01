package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest.mapper;

import java.util.List;

import br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.outbound.BusinessUnitOutbound;
import br.com.jstack.syst.acrn.registry.model.BusinessUnitResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessUnitResponseMapper {
	
	BusinessUnitResponse toResponse(BusinessUnitOutbound businessUnitOutbound);
	
	List<BusinessUnitResponse> toResponse(List<BusinessUnitOutbound> businessUnits);
}
