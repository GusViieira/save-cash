package com.saveCash.infra.services;

import com.saveCash.infra.database.schemas.LoginEntity;
import com.saveCash.infra.securirty.TokenGenerator;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class AuthService {
    public String authenticate(String username, String password){
        LoginEntity foundUser = LoginEntity.find("email = ?1", username).firstResult();

        if(foundUser == null){
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        if(!BcryptUtil.matches(password, foundUser.getPassword())){
            throw new IllegalArgumentException("Senha incorreta");
        }

        return TokenGenerator.generate(foundUser.getEmail());
    }
}
