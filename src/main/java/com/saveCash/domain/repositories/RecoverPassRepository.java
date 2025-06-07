package com.saveCash.domain.repositories;

import com.saveCash.domain.entities.RecoverPass;

public interface RecoverPassRepository {
    void pesistOtpCode(RecoverPass recoverPass);
    RecoverPass getOtpCode(Long idUser);
}
