package br.com.jstack.syst.acrn.registry.framework.mapper;

import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
import br.com.jstack.syst.acrn.registry.model.BusinessDomainRequest;
import br.com.jstack.syst.acrn.registry.model.BusinessDomainResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BusinessDomainMapper {
	
	@Mapping(target = "businessUnit.id", source = "unitId")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "businessUnit", ignore = true)
	@Mapping(target = "audit", ignore = true)
	BusinessDomain toEntity(BusinessDomainRequest request);
	
	@Mapping(target = "updatedBy", source = "audit.updatedBy")
	@Mapping(target = "updatedAt", source = "audit.updatedAt")
	@Mapping(target = "unitId", source = "businessUnit.id")
	@Mapping(target = "createdBy", source = "audit.createdBy")
	@Mapping(target = "createdAt", source = "audit.createdAt")
	BusinessDomainResponse toResponse(BusinessDomain domain);
	
}
