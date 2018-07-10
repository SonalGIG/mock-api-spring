package com.hexa.service;

import com.github.tomakehurst.wiremock.admin.model.ListStubMappingsResult;
import com.github.tomakehurst.wiremock.admin.model.SingleStubMappingResult;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ServiceProviderImpl implements ServiceProvider {

    @Autowired
    ServiceRegistry serviceRegistry;

    @Value("${wiremock.default.port}")
    int wiremockPort;

    @Value("${wiremock.default.host}")
    String wiremockHost;


    public void createService(Service serviceRequest) {
        serviceRegistry.createService(serviceRequest);

    }

    public List<MockMapping> getServices() {
        WireMock wireMock = new WireMock(wiremockHost, wiremockPort);
        ListStubMappingsResult listStubMappingsResult = wireMock.allStubMappings();
        List<StubMapping> stubMappings = listStubMappingsResult.getMappings();
        return serviceRegistry.convertToMockMapping(stubMappings);
    }

    public void deleteService(String uuid) {
        WireMock wireMock = new WireMock(wiremockHost, wiremockPort);
        SingleStubMappingResult stubMapping = wireMock.getStubMapping(UUID.fromString(uuid));
        wireMock.removeStubMapping(stubMapping.getItem());
    }
}
