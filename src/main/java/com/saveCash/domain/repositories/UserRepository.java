package com.saveCash.domain.repositories;

import com.saveCash.domain.entities.User;

public interface UserRepository {
    void createUser(User user);
    User getUserByIdLogin(int idLogin);
}
