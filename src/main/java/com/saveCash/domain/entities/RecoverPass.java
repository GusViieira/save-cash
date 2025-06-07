package com.saveCash.domain.entities;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class RecoverPass {

    public User user;
    public String otpCode;
    public LocalDateTime expires;

    public RecoverPass(User user, String otpCode, LocalDateTime expires) {
        this.user = user;
        this.otpCode = otpCode;
        this.expires = expires;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public LocalDateTime getExpires() {
        return expires;
    }

    public void setExpires(LocalDateTime expires) {
        this.expires = expires;
    }
}
