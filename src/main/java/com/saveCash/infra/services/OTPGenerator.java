package com.saveCash.infra.services;

import jakarta.enterprise.context.RequestScoped;

import java.security.SecureRandom;

@RequestScoped
public class OTPGenerator {

    private static final SecureRandom random = new SecureRandom();

    public static String generateOtp(){
        return String.valueOf(random.nextInt(900000) + 100000);
    }
}
