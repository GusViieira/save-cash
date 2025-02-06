package com.saveCash.infra.securirty;

import io.smallrye.jwt.build.Jwt;

public class TokenGenerator {

    public static String generate(String email){
        return Jwt.issuer("savecash-app")
                .upn(email)
                .expiresIn(3600) // Token expira em uma hora
                .sign();
    }
}
