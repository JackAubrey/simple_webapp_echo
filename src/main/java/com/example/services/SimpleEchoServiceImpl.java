package com.example.services;

import com.example.exceptions.BadParameterException;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SimpleEchoServiceImpl implements SimpleEchoService {
    @Override
    public String doEcho(String text) {
        if( text == null || text.isBlank() ) {
            throw new BadParameterException("Il parametro 'text' è obbligatorio");
        }

        return "Hai scritto: " + text;
    }
}
