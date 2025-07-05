package br.com.jstack.syst.acrn.registry.framework.mapper;

import br.com.jstack.syst.acrn.registry.domain.entity.Team;
import br.com.jstack.syst.acrn.registry.model.TeamRequest;
import br.com.jstack.syst.acrn.registry.model.TeamResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "name", source = "name")
	@Mapping(target = "description", source = "description")
	Team toDomain(TeamRequest request);
	
	@Mapping(target = "id", source = "id")
	@Mapping(target = "name", source = "name")
	@Mapping(target = "description", source = "description")
	@Mapping(target = "createdBy", source = "audit.createdBy")
	@Mapping(target = "createdAt", source = "audit.createdAt")
	@Mapping(target = "updatedBy", source = "audit.updatedBy")
	@Mapping(target = "updatedAt", source = "audit.updatedAt")
	TeamResponse toResponse(Team domain);
}
