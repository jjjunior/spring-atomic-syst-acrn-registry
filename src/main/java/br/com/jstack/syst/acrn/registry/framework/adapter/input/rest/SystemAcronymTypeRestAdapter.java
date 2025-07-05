package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest;

import java.util.List;

import br.com.jstack.syst.acrn.registry.api.SystemAcronymTypeApi;
import br.com.jstack.syst.acrn.registry.application.usecase.CreateUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.DeleteByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveAllUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.UpdateUseCase;
import br.com.jstack.syst.acrn.registry.domain.entity.SystemAcronymType;
import br.com.jstack.syst.acrn.registry.framework.mapper.SystemAcronymTypeMapper;
import br.com.jstack.syst.acrn.registry.model.SystemAcronymTypeRequest;
import br.com.jstack.syst.acrn.registry.model.SystemAcronymTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SystemAcronymTypeRestAdapter implements SystemAcronymTypeApi {
	
	private final SystemAcronymTypeMapper                      mapper;
	private final CreateUseCase<SystemAcronymType>             createUseCase;
	private final RetrieveByIdUseCase<SystemAcronymType, Long> retrieveByIdUseCase;
	private final RetrieveAllUseCase<SystemAcronymType>        retrieveAllUseCase;
	private final UpdateUseCase<SystemAcronymType, Long>       updateUseCase;
	private final DeleteByIdUseCase<SystemAcronymType, Long>   deleteUseCase;
	
	@Override
	public ResponseEntity<SystemAcronymTypeResponse> createAcronymType(SystemAcronymTypeRequest request) {
		SystemAcronymType         created  = createUseCase.create(mapper.toDomain(request));
		SystemAcronymTypeResponse response = mapper.toResponse(created);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@Override
	public ResponseEntity<Void> deleteSystemAcronymType(Long id) {
		deleteUseCase.deleteteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@Override
	public ResponseEntity<List<SystemAcronymTypeResponse>> listAcronymTypes() {
		List<SystemAcronymType>         systemAcronymTypes = retrieveAllUseCase.retrieveAll();
		List<SystemAcronymTypeResponse> responses          = systemAcronymTypes.stream().map(mapper::toResponse).toList();
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	@Override
	public ResponseEntity<SystemAcronymTypeResponse> retrieveSystemAcronymType(Long id) {
		SystemAcronymType         retrieveById = retrieveByIdUseCase.retrieveById(id);
		SystemAcronymTypeResponse response     = mapper.toResponse(retrieveById);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@Override
	public ResponseEntity<SystemAcronymTypeResponse> updateSystemAcronymType(Long id, SystemAcronymTypeRequest request) {
		SystemAcronymType systemAcronymType = mapper.toDomain(request);
		systemAcronymType.setId(id);
		SystemAcronymType         updated  = updateUseCase.update(systemAcronymType);
		SystemAcronymTypeResponse response = mapper.toResponse(updated);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
