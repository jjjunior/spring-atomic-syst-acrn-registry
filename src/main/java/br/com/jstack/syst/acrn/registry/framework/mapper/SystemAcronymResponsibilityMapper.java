package br.com.jstack.syst.acrn.registry.framework.mapper;

import br.com.jstack.syst.acrn.registry.domain.entity.SystemAcronymResponsibility;
import br.com.jstack.syst.acrn.registry.model.SystemAcronymResponsibilityRequest;
import br.com.jstack.syst.acrn.registry.model.SystemAcronymResponsibilityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SystemAcronymResponsibilityMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "name", source = "name")
	@Mapping(target = "description", source = "description")
	@Mapping(target = "active", source = "active")
	SystemAcronymResponsibility toDomain(SystemAcronymResponsibilityRequest request);
	
	@Mapping(target = "id", source = "id")
	@Mapping(target = "name", source = "name")
	@Mapping(target = "description", source = "description")
	@Mapping(target = "active", source = "active")
	@Mapping(target = "createdBy", source = "audit.createdBy")
	@Mapping(target = "createdAt", source = "audit.createdAt")
	@Mapping(target = "updatedBy", source = "audit.updatedBy")
	@Mapping(target = "updatedAt", source = "audit.updatedAt")
	SystemAcronymResponsibilityResponse toResponse(SystemAcronymResponsibility domain);
}
