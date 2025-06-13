package com.saveCash.domain.usecases.UserUsecases;

import com.saveCash.adapters.dtos.UserDTO;
import com.saveCash.domain.entities.User;
import com.saveCash.domain.mappers.UserUseCaseMapper;
import com.saveCash.domain.repositories.LoginRepository;
import com.saveCash.domain.repositories.RecoverPassRepository;
import com.saveCash.domain.repositories.UserRepository;
import com.saveCash.infra.database.schemas.LoginEntity;
import com.saveCash.infra.services.EmailService;

import java.math.BigInteger;
import java.util.Objects;

public class UpdateUserUsecase {

    UserUseCaseMapper userUseCaseMapper;
    UserRepository userRepository;
    EmailService emailService;
    RecoverPassRepository recoverPassRepository;
    LoginRepository loginRepository;

    public UpdateUserUsecase(UserUseCaseMapper userUseCaseMapper, UserRepository userRepository, EmailService emailService, RecoverPassRepository recoverPassRepository, LoginRepository loginRepository) {
        this.userUseCaseMapper = userUseCaseMapper;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.recoverPassRepository = recoverPassRepository;
        this.loginRepository = loginRepository;
    }

    public User updateUser(UserDTO userRequest) {
        User userResponse = getUserByEmailLogin(userRequest.getEmail());
        userResponse.setName(userRequest.getName());
        userResponse.setSurname(userRequest.getSurname());
        userResponse.setPhoneNumber(userRequest.getPhoneNumber());
        userResponse.setCountry(userRequest.getCountry());
        userResponse.setBirthDate(userRequest.getBirthDate());
        User userUpdated = updateUser(userResponse);

        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setIdLogin(userUpdated.getLogin().getIdLogin());
        userUpdated.setLogin(loginEntity);

        return userUpdated;
    }

    public User getUserByEmailLogin(String email) {
        try {
            User user = userRepository.getUserByEmailLogin(email);
            if(Objects.isNull(user)){
                throw new RuntimeException("Usuário não encontrado");
            }
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public User updateUser(User user) {
        try {
            return userRepository.updateUser(userUseCaseMapper.toRepository(user));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean updateUserPassword(String email, String newPassword){
        try{
           return loginRepository.changeUserPassword(newPassword, email);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

