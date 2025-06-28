package br.com.jstack.syst.acrn.registry.adapter.input.api;

import br.com.jstack.syst.acrn.registry.api.ResponsibilityTypeApi;
import br.com.jstack.syst.acrn.registry.model.ResponsibilityTypeRequest;
import br.com.jstack.syst.acrn.registry.model.ResponsibilityTypeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
public class ResponsibilityTypeRestApi implements ResponsibilityTypeApi {
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ResponsibilityTypeApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> createResponsibilityType(ResponsibilityTypeRequest responsibilityTypeRequest) {
        return ResponsibilityTypeApi.super.createResponsibilityType(responsibilityTypeRequest);
    }

    @Override
    public ResponseEntity<Void> deleteResponsibilityType(Integer id) {
        return ResponsibilityTypeApi.super.deleteResponsibilityType(id);
    }

    @Override
    public ResponseEntity<ResponsibilityTypeResponse> getResponsibilityType(Integer id) {
        return ResponsibilityTypeApi.super.getResponsibilityType(id);
    }

    @Override
    public ResponseEntity<List<ResponsibilityTypeResponse>> listResponsibilityTypes() {
        return ResponsibilityTypeApi.super.listResponsibilityTypes();
    }

    @Override
    public ResponseEntity<Void> updateResponsibilityType(Integer id, ResponsibilityTypeRequest responsibilityTypeRequest) {
        return ResponsibilityTypeApi.super.updateResponsibilityType(id, responsibilityTypeRequest);
    }
}
