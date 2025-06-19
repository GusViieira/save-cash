package com.saveCash.adapters.producers.UserProduces;

import com.saveCash.domain.usecases.UserUsecases.ChangePasswordUseCase;
import com.saveCash.domain.usecases.UserUsecases.UpdateUserUsecase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;

public class ChangePasswordProducer {

    @Inject
    UpdateUserUsecase updateUserUsecase;

    @Produces
    @RequestScoped
    ChangePasswordUseCase changePasswordUseCase(){
        return new ChangePasswordUseCase(updateUserUsecase);
    }
}
