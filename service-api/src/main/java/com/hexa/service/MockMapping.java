package com.hexa.service;

public class MockMapping {

    private String uuid;
    private String url;
    private String methodType;
    private Object responseBody;
    private int status;

    public MockMapping(String uuid, String url, String methodType, Object responseBody, int status) {
        this.uuid = uuid;
        this.url = url;
        this.methodType = methodType;
        this.responseBody = responseBody;
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public String getUrl() {
        return url;
    }

    public String getMethodType() {
        return methodType;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public int getStatus() {
        return status;
    }
}
