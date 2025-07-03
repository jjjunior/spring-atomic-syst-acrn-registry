package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest;

import java.util.Optional;

import br.com.jstack.syst.acrn.registry.api.BusinessSystemAcronymResponsibilityApi;
import br.com.jstack.syst.acrn.registry.model.SystemAcronymResponsibilityRequest;
import br.com.jstack.syst.acrn.registry.model.SystemAcronymResponsibilityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

@RestController
public class BusinessSystemAcronymResponsibilityRestAdapter implements BusinessSystemAcronymResponsibilityApi {
    
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return BusinessSystemAcronymResponsibilityApi.super.getRequest();
    }
    
    @Override
    public ResponseEntity<Void> deleteSystemAcronymResponsibility(Long id) {
        return BusinessSystemAcronymResponsibilityApi.super.deleteSystemAcronymResponsibility(id);
    }
    
    @Override
    public ResponseEntity<SystemAcronymResponsibilityResponse> getSystemAcronymResponsibility(Long id) {
        return BusinessSystemAcronymResponsibilityApi.super.getSystemAcronymResponsibility(id);
    }
    
    @Override
    public ResponseEntity<SystemAcronymResponsibilityResponse> updateSystemAcronymResponsibility(Long id, SystemAcronymResponsibilityRequest systemAcronymResponsibilityRequest) {
        return BusinessSystemAcronymResponsibilityApi.super.updateSystemAcronymResponsibility(id, systemAcronymResponsibilityRequest);
    }
}
