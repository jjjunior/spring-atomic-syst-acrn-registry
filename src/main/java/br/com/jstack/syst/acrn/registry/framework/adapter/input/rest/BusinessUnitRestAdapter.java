package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest;

import java.util.List;

import br.com.jstack.syst.acrn.registry.api.BusinessUnitApi;
import br.com.jstack.syst.acrn.registry.application.usecase.BusinessUnitUseCase;
import br.com.jstack.syst.acrn.registry.framework.adapter.input.rest.inbound.BusinessUnitInbound;
import br.com.jstack.syst.acrn.registry.framework.adapter.input.rest.mapper.BusinessUnitInboundMapper;
import br.com.jstack.syst.acrn.registry.framework.adapter.input.rest.mapper.BusinessUnitResponseMapper;
import br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.outbound.BusinessUnitOutbound;
import br.com.jstack.syst.acrn.registry.model.BusinessUnitRequest;
import br.com.jstack.syst.acrn.registry.model.BusinessUnitResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BusinessUnitRestAdapter implements BusinessUnitApi {
    
    private final BusinessUnitInboundMapper  businessUnitInboundMapper;
    private final BusinessUnitResponseMapper businessUnitResponseMapper;
    private final BusinessUnitUseCase        businessUnitUseCase;
    
    @Override
    public ResponseEntity<Void> createBusinessUnit(BusinessUnitRequest businessUnitRequest) {
        BusinessUnitInbound businessUnitInbound = businessUnitInboundMapper.toInbound(businessUnitRequest);
        businessUnitUseCase.createBusinessUnit(businessUnitInbound);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteBusinessUnit(Integer id) {
        businessUnitUseCase.removeBusinessUnit(id.longValue());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BusinessUnitResponse> getBusinessUnit(Integer id) {
        BusinessUnitOutbound businessUnitOutbound = businessUnitUseCase.retrieveBusinessUnit(id.longValue());
        BusinessUnitResponse businessUnitResponse = businessUnitResponseMapper.toResponse(businessUnitOutbound);
        return new ResponseEntity<>(businessUnitResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BusinessUnitResponse>> listBusinessUnits() {
        List<BusinessUnitOutbound> businessUnitOutbounds = businessUnitUseCase.retrieveBusinessUnits();
        List<BusinessUnitResponse> businessUnitsResponse = businessUnitResponseMapper.toResponse(businessUnitOutbounds);
        return new ResponseEntity<>(businessUnitsResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateBusinessUnit(Integer id, BusinessUnitRequest businessUnitRequest) {
        BusinessUnitInbound businessUnitInbound = businessUnitInboundMapper.toInbound(businessUnitRequest);
        businessUnitUseCase.changeBusinessUnit(id.longValue(), businessUnitInbound);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
