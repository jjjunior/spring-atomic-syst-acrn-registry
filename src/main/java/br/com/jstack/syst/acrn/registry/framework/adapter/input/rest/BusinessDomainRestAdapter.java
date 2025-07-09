package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest;

import java.util.List;
import java.util.stream.Collectors;

import br.com.jstack.syst.acrn.registry.api.BusinessDomainApi;
import br.com.jstack.syst.acrn.registry.application.usecase.CreateUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.DeleteByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveAllUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.UpdateUseCase;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnitDomain;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnitDomainId;
import br.com.jstack.syst.acrn.registry.framework.mapper.BusinessDomainMapper;
import br.com.jstack.syst.acrn.registry.model.BusinessDomainRequest;
import br.com.jstack.syst.acrn.registry.model.BusinessDomainResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BusinessDomainRestAdapter implements BusinessDomainApi {
	
	private final BusinessDomainMapper                      mapper;
	private final CreateUseCase<BusinessDomain>             createUseCase;
	private final RetrieveByIdUseCase<BusinessDomain, Long> retrieveByIdUseCase;
	private final RetrieveAllUseCase<BusinessDomain>        retrieveAllUseCase;
	private final UpdateUseCase<BusinessDomain>             updateUseCase;
	private final DeleteByIdUseCase<BusinessDomain, Long>   deleteUseCase;
	private final RetrieveByIdUseCase<BusinessUnit, Long>   retrieveBusinessUnitByIdUseCase;
	
	@Override
	public ResponseEntity<BusinessDomainResponse> createBusinessDomain(BusinessDomainRequest request) {
		BusinessDomain domain = mapper.toDomain(request);
		populateBusinessUnitDomains(request, domain);
		BusinessDomain created = createUseCase.create(domain);
		BusinessDomainResponse response = mapper.toResponse(created);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@Override
	public ResponseEntity<Void> deleteBusinessDomain(Long id) {
		deleteUseCase.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@Override
	public ResponseEntity<List<BusinessDomainResponse>> listBusinessDomains() {
		List<BusinessDomain> domains = retrieveAllUseCase.retrieveAll();
		List<BusinessDomainResponse> responses = domains.stream()
			.map(mapper::toResponse)
			.toList();
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	@Override
	public ResponseEntity<BusinessDomainResponse> retrieveBusinessDomain(Long id) {
		BusinessDomain domain = retrieveByIdUseCase.retrieveById(id);
		BusinessDomainResponse response = mapper.toResponse(domain);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@Override
	public ResponseEntity<BusinessDomainResponse> updateBusinessDomain(Long id, BusinessDomainRequest request) {
		BusinessDomain domain = mapper.toDomain(request);
		domain.setId(id);
		populateBusinessUnitDomains(request, domain);
		BusinessDomain updated = updateUseCase.update(domain);
		BusinessDomainResponse response = mapper.toResponse(updated);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	private void populateBusinessUnitDomains(BusinessDomainRequest request, BusinessDomain domain) {
		if (request.getUnitIds() != null && !request.getUnitIds().isEmpty()) {
			List<BusinessUnitDomain> associations = request.getUnitIds().stream()
				.map(unitId -> {
					BusinessUnit businessUnit = retrieveBusinessUnitByIdUseCase.retrieveById(unitId);
					
					BusinessUnitDomainId id = new BusinessUnitDomainId(unitId, domain.getId());
					
					BusinessUnitDomain link = new BusinessUnitDomain();
					link.setId(id);
					link.setBusinessUnit(businessUnit);
					link.setBusinessDomain(domain);
					return link;
				})
				.toList();
			
			domain.setBusinessUnitDomains(associations);
		}
	}
}