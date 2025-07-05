package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest;

import java.util.List;

import br.com.jstack.syst.acrn.registry.api.TeamApi;
import br.com.jstack.syst.acrn.registry.application.usecase.CreateUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.DeleteByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveAllUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.RetrieveByIdUseCase;
import br.com.jstack.syst.acrn.registry.application.usecase.UpdateUseCase;
import br.com.jstack.syst.acrn.registry.domain.entity.Team;
import br.com.jstack.syst.acrn.registry.framework.mapper.TeamMapper;
import br.com.jstack.syst.acrn.registry.model.TeamRequest;
import br.com.jstack.syst.acrn.registry.model.TeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TeamRestAdapter implements TeamApi {
	
	private final TeamMapper                      mapper;
	private final CreateUseCase<Team>             createUseCase;
	private final RetrieveByIdUseCase<Team, Long> retrieveByIdUseCase;
	private final RetrieveAllUseCase<Team>        retrieveAllUseCase;
	private final UpdateUseCase<Team, Long>       updateUseCase;
	private final DeleteByIdUseCase<Team, Long>   deleteUseCase;
	
	@Override
	public ResponseEntity<TeamResponse> createTeam(TeamRequest request) {
		Team         created  = createUseCase.create(mapper.toDomain(request));
		TeamResponse response = mapper.toResponse(created);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@Override
	public ResponseEntity<Void> deleteTeam(Long id) {
		deleteUseCase.deleteteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@Override
	public ResponseEntity<List<TeamResponse>> listTeams() {
		List<Team>         teams     = retrieveAllUseCase.retrieveAll();
		List<TeamResponse> responses = teams.stream().map(mapper::toResponse).toList();
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	@Override
	public ResponseEntity<TeamResponse> retrieveTeam(Long id) {
		Team         retrieveById = retrieveByIdUseCase.retrieveById(id);
		TeamResponse response     = mapper.toResponse(retrieveById);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@Override
	public ResponseEntity<TeamResponse> updateTeam(Long id, TeamRequest request) {
		Team team = mapper.toDomain(request);
		team.setId(id);
		Team         updated  = updateUseCase.update(team);
		TeamResponse response = mapper.toResponse(updated);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
