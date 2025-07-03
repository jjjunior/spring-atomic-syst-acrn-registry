package br.com.jstack.syst.acrn.registry.framework.mapper;

import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import br.com.jstack.syst.acrn.registry.model.BusinessUnitRequest;
import br.com.jstack.syst.acrn.registry.model.BusinessUnitResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BusinessUnitMapper {
	
	
	@Mapping(target = "name", source = "name")
	@Mapping(target = "description", source = "description")
	@Mapping(target = "active", source = "active")
	BusinessUnit toEntity(BusinessUnitRequest request);
	
	@Mapping(target = "id", source = "id")
	@Mapping(target = "name", source = "name")
	@Mapping(target = "description", source = "description")
	@Mapping(target = "active", source = "active")
	@Mapping(target = "createdBy", source = "audit.createdBy")
	@Mapping(target = "createdAt", source = "audit.createdAt")
	@Mapping(target = "updatedBy", source = "audit.updatedBy")
	@Mapping(target = "updatedAt", source = "audit.updatedAt")
	BusinessUnitResponse toResponse(BusinessUnit domain);
	
}
