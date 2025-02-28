package com.saveCash.adapters.controllers;

import com.saveCash.adapters.controllers.request.CreateUserRequest;
import com.saveCash.adapters.mappers.CreateUserMapper;
import com.saveCash.adapters.utils.ApiResponse;
import com.saveCash.domain.usecases.UserUsecases.CreateUserUsecase;

import com.saveCash.exceptions.ErrorResponse;
import com.saveCash.exceptions.UserExceptions;
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
    public Response registerUser(@Valid CreateUserRequest createUserRequest) throws Exception {
        try {
            return createUserUsecase.createUser(createUserMapper.toUserUseCase(createUserRequest));
        } catch (UserExceptions.DuplicateUserException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(new ApiResponse<>(error)).build();
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponse<>(error)).build();
        }
    }
}