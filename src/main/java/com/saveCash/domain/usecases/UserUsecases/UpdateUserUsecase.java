package com.saveCash.domain.usecases.UserUsecases;

import com.saveCash.adapters.dtos.UserDTO;
import com.saveCash.domain.entities.User;
import com.saveCash.domain.mappers.UserUseCaseMapper;
import com.saveCash.domain.repositories.UserRepository;
import com.saveCash.infra.database.schemas.LoginEntity;
import com.saveCash.infra.services.EmailService;
import com.saveCash.infra.services.OTPGenerator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UpdateUserUsecase {

    private Map<Long, String> otpStorage = new ConcurrentHashMap<>();

    UserUseCaseMapper userUseCaseMapper;
    UserRepository userRepository;
    EmailService emailService;

    public UpdateUserUsecase(UserUseCaseMapper userUseCaseMapper, UserRepository userRepository, EmailService emailService){
        this.userUseCaseMapper = userUseCaseMapper;
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public User updateUser(UserDTO userRequest){
        try{
            User userResponse = userRepository.getUserByEmailLogin(userRequest.getEmail());
            userResponse.setName(userRequest.getName());
            userResponse.setSurname(userRequest.getSurname());
            userResponse.setPhoneNumber(userRequest.getPhoneNumber());
            userResponse.setCountry(userRequest.getCountry());
            userResponse.setBirthDate(userRequest.getBirthDate());
            User userUpdated = userRepository.updateUser(userUseCaseMapper.toRepository(userResponse));

            LoginEntity loginEntity = new LoginEntity();
            loginEntity.setIdLogin(userUpdated.getLogin().getIdLogin());
            userUpdated.setLogin(loginEntity);

            return userUpdated;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public String forgotPassword(String email){
        User userResponse = userRepository.getUserByEmailLogin(email);
        String otp = OTPGenerator.generateOtp();
        otpStorage.put(userResponse.getIdUser(), otp);

        emailService.sendOtpEmail(userResponse.getEmail(), otp);
        return otp;
    }
}
