package com.example;

import com.example.services.SimpleEchoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/echo")
@Tag(name = "Echo Endpoint", description = "Restituisce il testo ricevuto come parametro")
public class EchoResource {
    final SimpleEchoService echoService;

    public EchoResource(SimpleEchoService echoService) {
        this.echoService = echoService;
    }

    @GET
    @Operation(summary = "Echo del parametro", description = "Restituisce il parametro se non è vuoto, altrimenti un messaggio predefinito")
    @APIResponse(
            responseCode = "200",
            description = "Testo ricevuto correttamente"
    )
    @APIResponse(
            responseCode = "400",
            description = "Parametro mancante o vuoto"
    )
    public Response echo(@QueryParam("input") String input) {
        String result = echoService.doEcho(input);
        return Response.ok(result).build();
    }
}
