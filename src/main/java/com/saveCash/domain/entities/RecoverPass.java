package com.saveCash.domain.entities;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class RecoverPass {

    public User user;
    public String otp;
    public LocalDateTime expires;

    public RecoverPass(User user, String otp, LocalDateTime expires) {
        this.user = user;
        this.otp = otp;
        this.expires = expires;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getExpires() {
        return expires;
    }

    public void setExpires(LocalDateTime expires) {
        this.expires = expires;
    }
}
