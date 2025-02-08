package com.saveCash.adapters.controllers;

import com.saveCash.adapters.controllers.request.LoginRequest;
import com.saveCash.infra.services.AuthService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("")
public class AuthResource {

    @Inject
    AuthService authService;

    @POST
    @Path("/login")
    public Response login(LoginRequest loginRequest){
        String jwt = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        if(jwt != null){
            return Response.ok(jwt).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciais inválidas").build();
    }
}
