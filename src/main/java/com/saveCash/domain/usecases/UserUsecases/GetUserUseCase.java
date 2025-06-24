package com.saveCash.domain.usecases.UserUsecases;

import com.saveCash.domain.entities.User;
import com.saveCash.domain.repositories.UserRepository;

import java.math.BigInteger;

public class GetUserUseCase {

    UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserByLoginId(int id){
        return userRepository.getUserByIdLogin(id);
    }

    public User getUserById(BigInteger id){
        return userRepository.getUserById(id);
    }
}
