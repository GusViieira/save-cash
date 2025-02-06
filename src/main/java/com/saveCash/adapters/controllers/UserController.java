package com.saveCash.adapters.controllers;

import com.saveCash.adapters.controllers.request.CreateUserRequest;
import com.saveCash.adapters.mappers.CreateUserMapper;
import com.saveCash.domain.usecases.UserUsecases.CreateUserUsecase;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    CreateUserUsecase createUserUsecase;

    @Inject
    private CreateUserMapper createUserMapper;

    @Path("/register")
    @POST
    public Response registerUser(@Valid CreateUserRequest createUserRequest) throws Exception{
       return createUserUsecase.createUser(createUserMapper.toUserUseCase(createUserRequest));
    }
}