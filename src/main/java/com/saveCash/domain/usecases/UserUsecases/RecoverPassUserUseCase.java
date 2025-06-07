package com.saveCash.domain.usecases.UserUsecases;

import com.saveCash.domain.entities.RecoverPass;
import com.saveCash.domain.entities.User;
import com.saveCash.domain.mappers.UserUseCaseMapper;
import com.saveCash.domain.repositories.RecoverPassRepository;
import com.saveCash.domain.repositories.UserRepository;
import com.saveCash.infra.services.EmailService;
import com.saveCash.infra.services.OTPGenerator;

import java.time.LocalDateTime;
import java.util.Objects;

public class RecoverPassUserUseCase {

    UpdateUserUsecase updateUserUsecase;
    UserUseCaseMapper userUseCaseMapper;
    UserRepository userRepository;
    EmailService emailService;
    RecoverPassRepository recoverPassRepository;

    public RecoverPassUserUseCase(UserUseCaseMapper userUseCaseMapper, UserRepository userRepository, EmailService emailService, RecoverPassRepository recoverPassRepository, UpdateUserUsecase updateUserUsecase) {
        this.userUseCaseMapper = userUseCaseMapper;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.recoverPassRepository = recoverPassRepository;
        this.updateUserUsecase = updateUserUsecase;
    }

    public String forgotPassword(String email) {
        String otp = OTPGenerator.generateOtp();
        RecoverPass recoverPass = new RecoverPass(
                updateUserUsecase.getUserByEmailLogin(email),
                otp,
                LocalDateTime.now().plusMinutes(5)
        );
        persistOtp(recoverPass);
        sendOtpEmail(email, otp);
        return otp;

    }

    public boolean verifyOtp(String otpRequest, String email) {
        User userResponse = updateUserUsecase.getUserByEmailLogin(email);
        if (Objects.isNull(userResponse)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        return Objects.equals(otpRequest, getOtpCode(userResponse));
    }

    public void sendOtpEmail(String email, String otp) {
        try{
            emailService.sendOtpEmail(email, otp);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void persistOtp(RecoverPass recoverPass){
        try{
            recoverPassRepository.pesistOtpCode(recoverPass);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getOtpCode(User user){
        try{
            return recoverPassRepository.getOtpCode(user.getIdUser());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
