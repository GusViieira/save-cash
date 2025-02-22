package com.saveCash.adapters.producers.UserProduces;

import com.saveCash.domain.mappers.UserUseCaseMapper;
import com.saveCash.domain.repositories.UserRepository;
import com.saveCash.domain.usecases.UserUsecases.CreateUserUsecase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Validator;
import jakarta.ws.rs.Produces;

public class CreateUserProducer {

    @Inject
    UserRepository userRepository;
    @Inject
    UserUseCaseMapper userUseCaseMapper;
    @Inject
    Validator validator;


    @Produces
    @RequestScoped
    CreateUserUsecase createUserUsecase(){
        return new CreateUserUsecase(userRepository, userUseCaseMapper, validator);
    }
}
