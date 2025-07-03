package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest;

import java.util.List;

import br.com.jstack.syst.acrn.registry.api.BusinessDomainApi;
import br.com.jstack.syst.acrn.registry.model.BusinessDomainRequest;
import br.com.jstack.syst.acrn.registry.model.BusinessDomainResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessDomainRestAdapter implements BusinessDomainApi {
    
    
    @Override
    public ResponseEntity<BusinessDomainResponse> createBusinessDomain(BusinessDomainRequest businessDomainRequest) {
        return BusinessDomainApi.super.createBusinessDomain(businessDomainRequest);
    }
    
    @Override
    public ResponseEntity<Void> deleteBusinessDomain(Long id) {
        return BusinessDomainApi.super.deleteBusinessDomain(id);
    }
    
    @Override
    public ResponseEntity<BusinessDomainResponse> getBusinessDomain(Long id) {
        return BusinessDomainApi.super.getBusinessDomain(id);
    }
    
    @Override
    public ResponseEntity<List<BusinessDomainResponse>> listBusinessDomains() {
        return BusinessDomainApi.super.listBusinessDomains();
    }
    
    @Override
    public ResponseEntity<BusinessDomainResponse> updateBusinessDomain(Long id, BusinessDomainRequest businessDomainRequest) {
        return BusinessDomainApi.super.updateBusinessDomain(id, businessDomainRequest);
    }
}
