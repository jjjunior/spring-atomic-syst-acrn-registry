package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest;

import java.util.List;

import br.com.jstack.syst.acrn.registry.api.TeamApi;
import br.com.jstack.syst.acrn.registry.model.TeamRequest;
import br.com.jstack.syst.acrn.registry.model.TeamResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamRestAdapter implements TeamApi {
    @Override
    public ResponseEntity<Void> createTeam(TeamRequest teamRequest) {
        return TeamApi.super.createTeam(teamRequest);
    }

    @Override
    public ResponseEntity<Void> deleteTeam(Integer id) {
        return TeamApi.super.deleteTeam(id);
    }

    @Override
    public ResponseEntity<TeamResponse> getTeam(Integer id) {
        return TeamApi.super.getTeam(id);
    }

    @Override
    public ResponseEntity<List<TeamResponse>> listTeams() {
        return TeamApi.super.listTeams();
    }

    @Override
    public ResponseEntity<Void> updateTeam(Integer id, TeamRequest teamRequest) {
        return TeamApi.super.updateTeam(id, teamRequest);
    }
}
