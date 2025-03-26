package com.saveCash.domain.repositories;

import com.saveCash.domain.entities.User;
import com.saveCash.infra.database.schemas.UserEntity;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface UserRepository {
    void createUser(User user);
    User getUserByIdLogin(int idLogin);
    User updateUser(UserEntity userEntity);
    User getUserById(BigInteger idUser);
    User getUserByEmailLogin(String email);
}
