package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest;

import java.util.List;

import br.com.jstack.syst.acrn.registry.api.SystemAcronymApi;
import br.com.jstack.syst.acrn.registry.model.SystemAcronymRequest;
import br.com.jstack.syst.acrn.registry.model.SystemAcronymResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemAcronymRestAdapter implements SystemAcronymApi {
    @Override
    public ResponseEntity<Void> createSystemAcronym(SystemAcronymRequest systemAcronymRequest) {
        return SystemAcronymApi.super.createSystemAcronym(systemAcronymRequest);
    }

    @Override
    public ResponseEntity<Void> deleteSystemAcronym(Integer id) {
        return SystemAcronymApi.super.deleteSystemAcronym(id);
    }

    @Override
    public ResponseEntity<SystemAcronymResponse> getSystemAcronym(Integer id) {
        return SystemAcronymApi.super.getSystemAcronym(id);
    }

    @Override
    public ResponseEntity<List<SystemAcronymResponse>> listSystemAcronyms(Boolean active, Integer typeId, Integer domainId) {
        return SystemAcronymApi.super.listSystemAcronyms(active, typeId, domainId);
    }

    @Override
    public ResponseEntity<Void> updateSystemAcronym(Integer id, SystemAcronymRequest systemAcronymRequest) {
        return SystemAcronymApi.super.updateSystemAcronym(id, systemAcronymRequest);
    }
}
