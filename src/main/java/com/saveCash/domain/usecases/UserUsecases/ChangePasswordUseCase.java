package com.saveCash.domain.usecases.UserUsecases;

import io.quarkus.elytron.security.common.BcryptUtil;

public class ChangePasswordUseCase {

    UpdateUserUsecase updateUserUsecase;

    public ChangePasswordUseCase(UpdateUserUsecase updateUserUsecase){
        this.updateUserUsecase = updateUserUsecase;
    }

    public boolean changePassword(String email, String newPassword){
        String newPassCrypted = BcryptUtil.bcryptHash(newPassword);
        return updateUserUsecase.updateUserPassword(email, newPassCrypted);
    }
}
