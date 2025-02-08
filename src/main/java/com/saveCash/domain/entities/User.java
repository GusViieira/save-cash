package com.saveCash.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate birthDate;
    private String country;
    private LocalDateTime tsUpdate;
    private LocalDateTime tsregistration;

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

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getTsUpdate() {
        return tsUpdate;
    }

    public void setTsUpdate(LocalDateTime tsUpdate) {
        this.tsUpdate = tsUpdate;
    }

    public LocalDateTime getTsregistration() {
        return tsregistration;
    }

    public void setTsregistration(LocalDateTime tsregistration) {
        this.tsregistration = tsregistration;
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
