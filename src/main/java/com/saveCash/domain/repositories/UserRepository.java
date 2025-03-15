package com.saveCash.domain.repositories;

import com.saveCash.domain.entities.User;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface UserRepository {
    void createUser(User user);
    User getUserByIdLogin(int idLogin);
    User updateUser(User user);
    User getUserById(BigInteger idUser);
}
