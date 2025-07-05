package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest;

import java.util.List;

import br.com.jstack.syst.acrn.registry.api.ResponsibilityTypeApi;
import br.com.jstack.syst.acrn.registry.application.usecase.CreateUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.DeleteByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveAllUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.UpdateUseCase;
import br.com.jstack.syst.acrn.registry.domain.entity.ResponsibilityType;
import br.com.jstack.syst.acrn.registry.framework.mapper.ResponsibilityMapper;
import br.com.jstack.syst.acrn.registry.model.ResponsibilityTypeRequest;
import br.com.jstack.syst.acrn.registry.model.ResponsibilityTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ResponsibilityTypeRestAdapter implements ResponsibilityTypeApi {
	
	private final ResponsibilityMapper              mapper;
	private final CreateUseCase<ResponsibilityType> createUseCase;
	private final RetrieveByIdUseCase<ResponsibilityType, Long> retrieveByIdUseCase;
	private final RetrieveAllUseCase<ResponsibilityType>        retrieveAllUseCase;
	private final UpdateUseCase<ResponsibilityType, Long>       updateUseCase;
	private final DeleteByIdUseCase<ResponsibilityType, Long>   deleteUseCase;
	
	
	@Override
	public ResponseEntity<ResponsibilityTypeResponse> createResponsibilityType(ResponsibilityTypeRequest request) {
		ResponsibilityType         created  = createUseCase.create(mapper.toDomain(request));
		ResponsibilityTypeResponse response = mapper.toResponse(created);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@Override
	public ResponseEntity<Void> deleteResponsibilityType(Long id) {
		deleteUseCase.deleteteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@Override
	public ResponseEntity<List<ResponsibilityTypeResponse>> listResponsibilityTypes() {
		List<ResponsibilityType>         responsibilityTypes = retrieveAllUseCase.retrieveAll();
		List<ResponsibilityTypeResponse> responses           = responsibilityTypes.stream().map(mapper::toResponse).toList();
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	@Override
	public ResponseEntity<ResponsibilityTypeResponse> retrieveResponsibilityType(Long id) {
		ResponsibilityType         retrieveById = retrieveByIdUseCase.retrieveById(id);
		ResponsibilityTypeResponse response     = mapper.toResponse(retrieveById);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@Override
	public ResponseEntity<ResponsibilityTypeResponse> updateResponsibilityType(Long id, ResponsibilityTypeRequest request) {
		ResponsibilityType responsibilityType = mapper.toDomain(request);
		responsibilityType.setId(id);
		ResponsibilityType         updated  = updateUseCase.update(responsibilityType);
		ResponsibilityTypeResponse response = mapper.toResponse(updated);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
