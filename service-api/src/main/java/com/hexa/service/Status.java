package com.hexa.service;

public enum Status {

    OK(200, "OK"),
    NOT_FOUND(404, "Not Found"),
    BAD_REQUEST(400, "Bad Request"),
    BAD_GATEWAY(502, "Bad Gateway"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    UNAUTHORIZED(401, "Unauthorized"),
    CREATED(201, "Created");

    private final int value;
    private final String reasonPhrase;

    Status(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return this.value;
    }
}
