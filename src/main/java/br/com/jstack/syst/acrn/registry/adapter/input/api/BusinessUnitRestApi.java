package br.com.jstack.syst.acrn.registry.adapter.input.api;

import br.com.jstack.syst.acrn.registry.api.BusinessUnitApi;
import br.com.jstack.syst.acrn.registry.model.BusinessUnitRequest;
import br.com.jstack.syst.acrn.registry.model.BusinessUnitResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusinessUnitRestApi implements BusinessUnitApi {
    @Override
    public ResponseEntity<Void> createBusinessUnit(BusinessUnitRequest businessUnitRequest) {
        return BusinessUnitApi.super.createBusinessUnit(businessUnitRequest);
    }

    @Override
    public ResponseEntity<Void> deleteBusinessUnit(Integer id) {
        return BusinessUnitApi.super.deleteBusinessUnit(id);
    }

    @Override
    public ResponseEntity<BusinessUnitResponse> getBusinessUnit(Integer id) {
        return BusinessUnitApi.super.getBusinessUnit(id);
    }

    @Override
    public ResponseEntity<List<BusinessUnitResponse>> listBusinessUnits() {
        return BusinessUnitApi.super.listBusinessUnits();
    }

    @Override
    public ResponseEntity<Void> updateBusinessUnit(Integer id, BusinessUnitRequest businessUnitRequest) {
        return BusinessUnitApi.super.updateBusinessUnit(id, businessUnitRequest);
    }
}
