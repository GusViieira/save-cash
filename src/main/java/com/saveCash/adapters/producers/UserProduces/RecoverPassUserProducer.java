package com.saveCash.adapters.producers.UserProduces;

import com.saveCash.domain.mappers.UserUseCaseMapper;
import com.saveCash.domain.repositories.RecoverPassRepository;
import com.saveCash.domain.repositories.UserRepository;
import com.saveCash.domain.usecases.UserUsecases.RecoverPassUserUseCase;
import com.saveCash.domain.usecases.UserUsecases.UpdateUserUsecase;
import com.saveCash.infra.services.EmailService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;

public class RecoverPassUserProducer {

    @Inject
    UpdateUserUsecase updateUserUsecase;

    @Inject
    UserUseCaseMapper userUseCaseMapper;

    @Inject
    UserRepository userRepository;

    @Inject
    EmailService emailService;

    @Inject
    RecoverPassRepository recoverPassRepository;

    @Produces
    @RequestScoped
    RecoverPassUserUseCase recoverPassUserUseCase(){
        return new RecoverPassUserUseCase(userUseCaseMapper, userRepository, emailService, recoverPassRepository, updateUserUsecase);
    }
}
