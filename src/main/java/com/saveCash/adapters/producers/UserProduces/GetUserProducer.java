package com.saveCash.adapters.producers.UserProduces;

import com.saveCash.domain.repositories.UserRepository;
import com.saveCash.domain.usecases.UserUsecases.GetUserUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;

public class GetUserProducer {

    @Inject
    UserRepository userRepository;

    @Produces
    @RequestScoped
    GetUserUseCase getUserUseCase(){
        return new GetUserUseCase(userRepository);
    }
}
