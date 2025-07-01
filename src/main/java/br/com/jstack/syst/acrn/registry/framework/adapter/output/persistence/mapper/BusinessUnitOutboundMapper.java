package br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.mapper;

import java.util.List;

import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.outbound.BusinessUnitOutbound;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BusinessUnitOutboundMapper {
	
	@Mapping(target = "id", source = "id")
	@Mapping(target = "name", source = "name")
	@Mapping(target = "description", source = "description")
	@Mapping(target = "active", source = "active")
	@Mapping(target = "createdBy", source = "audit.createdBy")
	@Mapping(target = "createdAt", source = "audit.createdAt")
	@Mapping(target = "updatedBy", source = "audit.updatedBy")
	@Mapping(target = "updatedAt", source = "audit.updatedAt")
	BusinessUnitOutbound toOutbound(BusinessUnit businessUnit);
	
	List<BusinessUnitOutbound> toListOutbound(List<BusinessUnit> businessUnitList);
}