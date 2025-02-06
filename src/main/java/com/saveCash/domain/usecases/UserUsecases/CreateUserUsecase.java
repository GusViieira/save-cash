package com.saveCash.domain.usecases.UserUsecases;

import com.saveCash.adapters.dtos.UserDTO;
import com.saveCash.domain.entities.User;
import com.saveCash.domain.mappers.UserUseCaseMapper;
import com.saveCash.domain.repositories.UserRepository;
import com.saveCash.infra.database.repository.UserRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;

@ApplicationScoped
public class CreateUserUsecase {

    @Inject
    UserRepository userRepository;

    @Inject
    UserUseCaseMapper userUseCaseMapper;

    public Response createUser(UserDTO userRequest) {
        userRepository.createUser(userUseCaseMapper.toRepository(userRequest));
        return Response.ok(Response.Status.OK).build();
    }

}
