package com.saveCash.domain.usecases.UserUsecases;

import com.saveCash.adapters.dtos.UserDTO;
import com.saveCash.domain.mappers.UserUseCaseMapper;
import com.saveCash.domain.repositories.UserRepository;
import jakarta.ws.rs.core.Response;

public class CreateUserUsecase {

    UserRepository userRepository;

    UserUseCaseMapper userUseCaseMapper;

    public CreateUserUsecase(UserRepository userRepository, UserUseCaseMapper userUseCaseMapper) {
        this.userRepository = userRepository;
        this.userUseCaseMapper = userUseCaseMapper;
    }

    public Response createUser(UserDTO userRequest) {
        userRepository.createUser(userUseCaseMapper.toRepository(userRequest));
        return Response.ok(Response.Status.CREATED).build();
    }
}
