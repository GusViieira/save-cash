package com.saveCash.adapters.controllers;

import com.saveCash.adapters.controllers.request.userRequest.CreateUserRequest;
import com.saveCash.adapters.controllers.request.userRequest.GetUserRequest;
import com.saveCash.adapters.controllers.request.userRequest.PasswordRequest;
import com.saveCash.adapters.controllers.request.userRequest.UpdateUserRequest;
import com.saveCash.adapters.mappers.UserMapper;
import com.saveCash.adapters.utils.ApiResponse;
import com.saveCash.domain.entities.User;
import com.saveCash.domain.usecases.UserUsecases.*;

import com.saveCash.exceptions.ErrorResponse;
import com.saveCash.exceptions.UserExceptions;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;


@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    CreateUserUsecase createUserUsecase;

    @Inject
    private UserMapper userMapper;

    @Inject
    private UpdateUserUsecase updateUserUsecase;

    @Inject
    private GetUserUseCase getUserUseCase;

    @Inject
    private RecoverPassUserUseCase recoverPassUserUseCase;

    @Inject
    private ChangePasswordUseCase changePasswordUseCase;

    @Path("/getUser")
    @GET
    @Authenticated
    public Response getUser(@QueryParam("idUser") BigInteger idUser) throws Exception {
        try{
            return Response.ok(new ApiResponse<>(getUserUseCase.getUserById(idUser))).build();
        }catch(Exception e){
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(new ApiResponse<>(error)).build();
        }
    }

    @Path("/register")
    @POST
    public Response registerUser(@Valid CreateUserRequest createUserRequest) throws Exception {
        try {
            return createUserUsecase.createUser(userMapper.toUserUseCase(createUserRequest));
        } catch (UserExceptions.DuplicateUserException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(new ApiResponse<>(error)).build();
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse("Erro interno do servidor");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponse<>(error)).build();
        }
    }

    @Path("/update")
    @PUT
    @Authenticated
    public Response updateUser(@Valid UpdateUserRequest updateUserRequest) throws Exception {
        try{
            User updatedUser = updateUserUsecase.updateUser(userMapper.toUserUseCase(updateUserRequest));
            return Response.ok(new ApiResponse<>(updatedUser)).build();
        }catch (Exception e){
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponse<>(error)).build();
        }
    }

    @Path("/recoverPassword")
    @POST
    public Response forgotPassword(@QueryParam("email") String email) throws Exception{
        try{
            recoverPassUserUseCase.createOtp(email);
            return Response.ok(new ApiResponse<>("E-mail enviado com sucesso.")).build();
        }catch(Exception e){
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponse<>(error)).build();
        }
    }

    @Path("/verify-otp")
    @GET
    public Response verifyOtp(@QueryParam("otp") String otp, @QueryParam("email") String email){
     try{
         Boolean response = recoverPassUserUseCase.verifyOtp(otp, email);
         if(response)
             return Response.ok().build();
         return Response.status(Response.Status.BAD_REQUEST).entity(new ApiResponse<>("Código inválido")).build();
     }catch (Exception e){
         ErrorResponse error = new ErrorResponse(e.getMessage());
         return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponse<>(error)).build();
        }
    }

    @Path("/changePassword")
    @POST
    public Response changePassword(@Valid PasswordRequest passwordRequest){
        try{
            boolean response = changePasswordUseCase.changePassword(passwordRequest.getEmail(), passwordRequest.getPassword());
            if(response){
                return Response.ok(new ApiResponse<>("Nova senha definida com sucesso.")).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(new ApiResponse<>("Não foi possível alterar a senha.")).build();
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponse<>(error)).build();
        }
    }
}