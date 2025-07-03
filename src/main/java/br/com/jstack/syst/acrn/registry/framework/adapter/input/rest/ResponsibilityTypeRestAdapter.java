package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest;

import java.util.List;

import br.com.jstack.syst.acrn.registry.api.ResponsibilityTypeApi;
import br.com.jstack.syst.acrn.registry.model.ResponsibilityTypeRequest;
import br.com.jstack.syst.acrn.registry.model.ResponsibilityTypeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponsibilityTypeRestAdapter implements ResponsibilityTypeApi {
    
    @Override
    public ResponseEntity<ResponsibilityTypeResponse> createResponsibilityType(ResponsibilityTypeRequest responsibilityTypeRequest) {
        return ResponsibilityTypeApi.super.createResponsibilityType(responsibilityTypeRequest);
    }
    
    @Override
    public ResponseEntity<Void> deleteResponsibilityType(Long id) {
        return ResponsibilityTypeApi.super.deleteResponsibilityType(id);
    }
    
    @Override
    public ResponseEntity<ResponsibilityTypeResponse> getResponsibilityType(Long id) {
        return ResponsibilityTypeApi.super.getResponsibilityType(id);
    }
    
    @Override
    public ResponseEntity<List<ResponsibilityTypeResponse>> listResponsibilityTypes() {
        return ResponsibilityTypeApi.super.listResponsibilityTypes();
    }
    
    @Override
    public ResponseEntity<ResponsibilityTypeResponse> updateResponsibilityType(Long id, ResponsibilityTypeRequest responsibilityTypeRequest) {
        return ResponsibilityTypeApi.super.updateResponsibilityType(id, responsibilityTypeRequest);
    }
}
