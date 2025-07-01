package br.com.jstack.syst.acrn.registry.application.mapper;

import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import br.com.jstack.syst.acrn.registry.framework.adapter.input.rest.inbound.BusinessUnitInbound;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BusinessUnitMapper {
	
	@Mapping(target = "audit.createdBy", ignore = true)
	@Mapping(target = "audit.createdAt", ignore = true)
	@Mapping(target = "audit.updatedBy", ignore = true)
	@Mapping(target = "audit.updatedAt", ignore = true)
	BusinessUnit toEntity(BusinessUnitInbound businessUnitInbound);
	
}
