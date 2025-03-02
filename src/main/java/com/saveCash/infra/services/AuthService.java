package com.saveCash.infra.services;

import com.saveCash.adapters.controllers.response.LoginResponse;
import com.saveCash.domain.entities.User;
import com.saveCash.domain.usecases.UserUsecases.GetUserUseCase;
import com.saveCash.exceptions.UserExceptions;
import com.saveCash.infra.database.schemas.LoginEntity;
import com.saveCash.infra.securirty.TokenGenerator;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class AuthService {

    @Inject
    GetUserUseCase getUserUseCase;

    public LoginResponse authenticate(String username, String password){
        LoginEntity foundUser = LoginEntity.find("email = ?1", username).firstResult();

        if(foundUser == null){
            throw new UserExceptions.UserNotFoundException("Usuário inválido");
        }

        if(!BcryptUtil.matches(password, foundUser.getPassword())){
            throw new UserExceptions.InvalidPasswordException("Senha incorreta.");
        }

        LoginResponse loginResponse = new LoginResponse();
        User user = getUserUseCase.getUserByLoginId(foundUser.getIdLogin());
        loginResponse.setName(user.getName());
        loginResponse.setEmail(username);
        loginResponse.setJwt(TokenGenerator.generate(foundUser.getEmail()));

        return loginResponse;
    }
}
