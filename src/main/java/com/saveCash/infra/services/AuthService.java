package com.saveCash.infra.services;

import com.saveCash.exceptions.UserExceptions;
import com.saveCash.infra.database.schemas.LoginEntity;
import com.saveCash.infra.securirty.TokenGenerator;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class AuthService {
    public String authenticate(String username, String password){
        LoginEntity foundUser = LoginEntity.find("email = ?1", username).firstResult();

        if(foundUser == null){
            throw new UserExceptions.UserNotFoundException("Usuário inválido");
        }

        if(!BcryptUtil.matches(password, foundUser.getPassword())){
            throw new UserExceptions.InvalidPasswordException("Senha incorreta.");
        }

        return TokenGenerator.generate(foundUser.getEmail());
    }
}
