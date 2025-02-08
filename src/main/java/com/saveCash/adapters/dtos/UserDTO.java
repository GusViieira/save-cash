package com.saveCash.adapters.dtos;

import io.quarkus.elytron.security.common.BcryptUtil;

import java.time.LocalDate;

public class UserDTO {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate birthDate;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    // CRIPTOGRAFA A SENHA DO USUARIO CADASTRADA
    public void setPassword(String password) {
        this.password = BcryptUtil.bcryptHash(password);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
