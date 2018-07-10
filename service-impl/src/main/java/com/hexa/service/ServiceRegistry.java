package com.hexa.service;


import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class ServiceRegistry {

    public void createService(Service serviceRequest) {
        switch (serviceRequest.getMethodType()) {

            case GET:
                stubFor(get(urlEqualTo(serviceRequest.getRequestUrl()))
                        .willReturn(aResponse().withStatus(serviceRequest.getStatus().value()).withHeader("Content-Type", APPLICATION_JSON_VALUE)
                                .withFixedDelay(serviceRequest.getResponseDelay()).withBody(serviceRequest.getResponseBody() == null ? "" : serviceRequest.getResponseBody())));
                break;
            case POST:
                stubFor(post(urlEqualTo(serviceRequest.getRequestUrl())).withRequestBody(equalToJson(serviceRequest.getPayload()))
                        .willReturn(aResponse().withStatus(serviceRequest.getStatus().value()).withHeader("Content-Type", APPLICATION_JSON_VALUE)));

                break;
            default:
        }

        // assert using resttemplate
    }

    public List<MockMapping> convertToMockMapping(List<StubMapping> stubMappings) {
        List<MockMapping> mockMappings = new ArrayList<>();
        stubMappings.forEach((stubMapping ->
                mockMappings.add(new MockMapping(stubMapping.getUuid().toString(), stubMapping.getRequest().getUrl(), stubMapping.getRequest().getMethod().getName(), stubMapping.getResponse().getBody(), stubMapping.getResponse().getStatus()))));
        return mockMappings;
    }
}
