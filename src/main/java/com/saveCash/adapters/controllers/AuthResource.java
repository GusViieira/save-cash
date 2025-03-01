package com.saveCash.adapters.controllers;

import com.saveCash.adapters.controllers.request.LoginRequest;
import com.saveCash.adapters.controllers.response.LoginResponse;
import com.saveCash.adapters.utils.ApiResponse;
import com.saveCash.exceptions.ErrorResponse;
import com.saveCash.exceptions.UserExceptions;
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
    public Response login(LoginRequest loginRequest) {
        try {
            LoginResponse response = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
            if (response != null) {
               return Response.ok(new ApiResponse<>(response)).build();
            }
        } catch (UserExceptions.UserNotFoundException | UserExceptions.InvalidPasswordException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponse<>(error)).build();
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponse<>(error)).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity(new ErrorResponse("Credenciais inválidas")).build();
    }
}