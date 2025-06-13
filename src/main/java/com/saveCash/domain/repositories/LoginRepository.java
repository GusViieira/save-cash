package com.saveCash.domain.repositories;

import java.math.BigInteger;

public interface LoginRepository {
    boolean changeUserPassword(String newPassword, String email);
}
