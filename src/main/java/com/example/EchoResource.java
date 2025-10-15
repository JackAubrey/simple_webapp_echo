package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/echo")
@Tag(name = "Echo Endpoint", description = "Restituisce il testo ricevuto come parametro")
public class EchoResource {

    @GET
    @Operation(summary = "Echo del parametro", description = "Restituisce il parametro se non è vuoto, altrimenti un messaggio predefinito")
    public Response echo(@QueryParam("input") String input) {
        if (input == null || input.isBlank()) {
            return Response.ok("Non hai scritto nulla").build();
        }
        return Response.ok("Hai scritto: " + input).build();
    }
}
