package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest.api;

import br.com.jstack.syst.acrn.registry.api.BusinessSystemAcronymResponsibilityApi;
import br.com.jstack.syst.acrn.registry.model.SystemAcronymResponsibilityRequest;
import br.com.jstack.syst.acrn.registry.model.SystemAcronymResponsibilityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
public class BusinessSystemAcronymResponsibilityRestApi implements BusinessSystemAcronymResponsibilityApi {
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return BusinessSystemAcronymResponsibilityApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> deleteSystemAcronymResponsibility(Integer id) {
        return BusinessSystemAcronymResponsibilityApi.super.deleteSystemAcronymResponsibility(id);
    }

    @Override
    public ResponseEntity<SystemAcronymResponsibilityResponse> getSystemAcronymResponsibility(Integer id) {
        return BusinessSystemAcronymResponsibilityApi.super.getSystemAcronymResponsibility(id);
    }

    @Override
    public ResponseEntity<Void> updateSystemAcronymResponsibility(Integer id, SystemAcronymResponsibilityRequest systemAcronymResponsibilityRequest) {
        return BusinessSystemAcronymResponsibilityApi.super.updateSystemAcronymResponsibility(id, systemAcronymResponsibilityRequest);
    }
}
