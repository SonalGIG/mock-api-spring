package com.hexa.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;


@JsonIgnoreProperties
@JsonIgnoreType
public class Service {


    private String requestUrl;
    private String pathParam;
    private MethodType methodType;
    private String responseBody;
    private String payload;
    private Status status;
    private int responseDelay;

    public Service() {
    }

    public Service(String requestUrl, String pathParam, MethodType methodType, String responseBody, String payload, Status status, int responseDelay) {
        this.requestUrl = requestUrl;
        this.pathParam = pathParam;
        this.methodType = methodType;
        this.responseBody = responseBody;
        this.payload = payload;
        this.status = status;
        this.responseDelay = responseDelay;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public String getPathParam() {
        return pathParam;
    }


    public String getResponseBody() {
        return responseBody;
    }

    public MethodType getMethodType() {
        return methodType;
    }

    public String getPayload() {
        return payload;
    }

    public Status getStatus() {
        return status;
    }

    public int getResponseDelay() {
        return responseDelay;
    }
}


