package com.saveCash.adapters.producers.UserProduces;

import com.saveCash.domain.mappers.UserUseCaseMapper;
import com.saveCash.domain.repositories.UserRepository;
import com.saveCash.domain.usecases.UserUsecases.UpdateUserUsecase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;

public class UpdateUserProducer {

    @Inject
    UserUseCaseMapper userUseCaseMapper;

    @Inject
    UserRepository userRepository;

    @Produces
    @RequestScoped
    UpdateUserUsecase updateUserUsecase(){
        return new UpdateUserUsecase(userUseCaseMapper, userRepository);
    }
}
