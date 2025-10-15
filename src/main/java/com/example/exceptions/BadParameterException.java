package com.example.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class BadParameterException extends WebApplicationException {

    public BadParameterException(String message) {
        super(Response.status(Response.Status.BAD_REQUEST)
                .entity(message)
                .type("text/plain")
                .build());
    }
}