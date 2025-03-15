package com.saveCash.domain.usecases.UserUsecases;

import com.saveCash.adapters.dtos.UserDTO;
import com.saveCash.domain.entities.User;
import com.saveCash.domain.mappers.UserUseCaseMapper;
import com.saveCash.domain.repositories.UserRepository;


public class UpdateUserUsecase {

    UserUseCaseMapper userUseCaseMapper;
    UserRepository userRepository;

    public UpdateUserUsecase(UserUseCaseMapper userUseCaseMapper, UserRepository userRepository){
        this.userUseCaseMapper = userUseCaseMapper;
        this.userRepository = userRepository;
    }

    public User updateUser(UserDTO userRequest){
        try{
            return userRepository.updateUser(userUseCaseMapper.toRepository(userRequest));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
