package com.saveCash.infra.services;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EmailService {

    @Inject
    public Mailer mailer;

    public void sendOtpEmail(String email, String otp) {
        String subject = "Save Cash - Recuperação de Senha";
        String body = "Seu código OTP para redefinir a senha é: " + otp + "\nEle expira em 10 minutos.";
        System.out.println(email + subject + body);
        mailer.send(Mail.withText(email, subject, body));
    }
}
