package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest;

import java.util.List;

import br.com.jstack.syst.acrn.registry.api.BusinessDomainApi;
import br.com.jstack.syst.acrn.registry.application.usecase.CreateUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.DeleteByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveAllUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.UpdateUseCase;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
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
	private final UpdateUseCase<BusinessDomain>       updateUseCase;
	private final DeleteByIdUseCase<BusinessDomain, Long>   deleteUseCase;
	
	
	@Override
	public ResponseEntity<BusinessDomainResponse> createBusinessDomain(BusinessDomainRequest request) {
		BusinessDomain         created  = createUseCase.create(mapper.toDomain(request));
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
		List<BusinessDomain>         businessUnits = retrieveAllUseCase.retrieveAll();
		List<BusinessDomainResponse> responses     = businessUnits.stream().map(mapper::toResponse).toList();
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	@Override
	public ResponseEntity<BusinessDomainResponse> retrieveBusinessDomain(Long id) {
		BusinessDomain         retrieveById = retrieveByIdUseCase.retrieveById(id);
		BusinessDomainResponse response     = mapper.toResponse(retrieveById);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@Override
	public ResponseEntity<BusinessDomainResponse> updateBusinessDomain(Long id, BusinessDomainRequest request) {
		BusinessDomain businessUnit = mapper.toDomain(request);
		businessUnit.setId(id);
		BusinessDomain         updated  = updateUseCase.update(businessUnit);
		BusinessDomainResponse response = mapper.toResponse(updated);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
