package br.com.jstack.syst.acrn.registry.adapter.input.api;

import br.com.jstack.syst.acrn.registry.api.BusinessDomainApi;
import br.com.jstack.syst.acrn.registry.model.BusinessDomainRequest;
import br.com.jstack.syst.acrn.registry.model.BusinessDomainResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusinessDomainRestApi implements BusinessDomainApi {

    @Override
    public ResponseEntity<Void> createBusinessDomain(BusinessDomainRequest businessDomainRequest) {
        return BusinessDomainApi.super.createBusinessDomain(businessDomainRequest);
    }

    @Override
    public ResponseEntity<Void> deleteBusinessDomain(Integer id) {
        return BusinessDomainApi.super.deleteBusinessDomain(id);
    }

    @Override
    public ResponseEntity<BusinessDomainResponse> getBusinessDomain(Integer id) {
        return BusinessDomainApi.super.getBusinessDomain(id);
    }

    @Override
    public ResponseEntity<List<BusinessDomainResponse>> listBusinessDomains() {
        return BusinessDomainApi.super.listBusinessDomains();
    }

    @Override
    public ResponseEntity<Void> updateBusinessDomain(Integer id, BusinessDomainRequest businessDomainRequest) {
        return BusinessDomainApi.super.updateBusinessDomain(id, businessDomainRequest);
    }
}
