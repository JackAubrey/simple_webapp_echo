package com.example.services;

import com.example.exceptions.BadParameterException;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleEchoServiceImplTest {
    private final SimpleEchoService service = new SimpleEchoServiceImpl();

    @Test
    void testDoEchoWithValidText() {
        String result = service.doEcho("Ciao");
        assertEquals("Hai scritto: Ciao", result);
    }

    @Test
    void testDoEchoWithNullText() {
        BadParameterException exception = assertThrows(BadParameterException.class, () -> service.doEcho(null));
        Response response = exception.getResponse();
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
        assertEquals("Il parametro 'text' è obbligatorio", response.getEntity());
    }

    @Test
    void testDoEchoWithBlankText() {
        BadParameterException exception = assertThrows(BadParameterException.class, () -> service.doEcho("   "));
        Response response = exception.getResponse();
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
        assertEquals("Il parametro 'text' è obbligatorio", response.getEntity());
    }
}