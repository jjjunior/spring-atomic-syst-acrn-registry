package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest;

import java.util.List;

import br.com.jstack.syst.acrn.registry.api.UserAppApi;
import br.com.jstack.syst.acrn.registry.model.UserAppRequest;
import br.com.jstack.syst.acrn.registry.model.UserAppResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAppRestAdapter implements UserAppApi {
    
    @Override
    public ResponseEntity<UserAppResponse> createUserApp(UserAppRequest userAppRequest) {
        return UserAppApi.super.createUserApp(userAppRequest);
    }
    
    @Override
    public ResponseEntity<Void> deleteUserApp(Long id) {
        return UserAppApi.super.deleteUserApp(id);
    }
    
    @Override
    public ResponseEntity<List<UserAppResponse>> listUserApps() {
        return UserAppApi.super.listUserApps();
    }
    
    @Override
    public ResponseEntity<UserAppResponse> retrieveUserApp(Long id) {
        return UserAppApi.super.retrieveUserApp(id);
    }
    
    @Override
    public ResponseEntity<UserAppResponse> updateUserApp(Long id, UserAppRequest userAppRequest) {
        return UserAppApi.super.updateUserApp(id, userAppRequest);
    }
}
