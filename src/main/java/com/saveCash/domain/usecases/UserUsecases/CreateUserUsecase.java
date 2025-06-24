package com.saveCash.domain.usecases.UserUsecases;

import com.saveCash.adapters.dtos.UserDTO;
import com.saveCash.domain.mappers.UserUseCaseMapper;
import com.saveCash.domain.repositories.UserRepository;
import com.saveCash.exceptions.UserExceptions;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.Set;

public class CreateUserUsecase {

    Validator validator;
    UserRepository userRepository;
    UserUseCaseMapper userUseCaseMapper;

    public CreateUserUsecase(UserRepository userRepository, UserUseCaseMapper userUseCaseMapper, Validator validator) {
        this.userRepository = userRepository;
        this.userUseCaseMapper = userUseCaseMapper;
        this.validator = validator;
    }

    public Response createUser(UserDTO userRequest) {
        try{
            Set<ConstraintViolation<UserDTO>> violations = validator.validate(userRequest);
            if(!violations.isEmpty()){
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

            userRepository.createUser(userUseCaseMapper.dtoToRepository(userRequest));
            return Response.ok(Response.Status.CREATED).build();
        }catch (Exception e){
            if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("email_unico")) {
                throw new UserExceptions.DuplicateUserException("Outro usuário já utiliza este email.");
            }
            throw e;
        }
    }
}
