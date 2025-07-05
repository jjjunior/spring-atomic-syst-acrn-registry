package br.com.jstack.syst.acrn.registry.framework.mapper;

import br.com.jstack.syst.acrn.registry.domain.entity.ResponsibilityType;
import br.com.jstack.syst.acrn.registry.model.ResponsibilityTypeRequest;
import br.com.jstack.syst.acrn.registry.model.ResponsibilityTypeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResponsibilityMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "name", source = "name")
	@Mapping(target = "description", source = "description")
	@Mapping(target = "active", source = "active")
	ResponsibilityType toDomain(ResponsibilityTypeRequest request);
	
	@Mapping(target = "id", source = "id")
	@Mapping(target = "name", source = "name")
	@Mapping(target = "description", source = "description")
	@Mapping(target = "active", source = "active")
	@Mapping(target = "createdBy", source = "audit.createdBy")
	@Mapping(target = "createdAt", source = "audit.createdAt")
	@Mapping(target = "updatedBy", source = "audit.updatedBy")
	@Mapping(target = "updatedAt", source = "audit.updatedAt")
	ResponsibilityTypeResponse toResponse(ResponsibilityType domain);
	
}
