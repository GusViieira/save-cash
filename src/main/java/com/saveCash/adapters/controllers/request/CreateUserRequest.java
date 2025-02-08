package com.saveCash.adapters.controllers.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;
import java.util.Date;

public class CreateUserRequest {

    @NotNull(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Schema(description = "User name")
    private String name;

    @NotNull(message = "Surname is required")
    @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters")
    @Schema(description = "The last name")
    private String surname;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    @Schema(description = "Email user")
    private String email;

    @NotNull(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Schema(description = "User password")
    private String password;

    @Schema(description = "Number phone")
    private String phoneNumber;

    @Schema(description = "Birth date in the format yyyy-MM-dd")
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate birthDate;

    @Schema(description = "Country")
    private String country;

    public @NotNull(message = "Name is required") @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Name is required") @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String name) {
        this.name = name;
    }

    public @NotNull(message = "Surname is required") @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters") String getSurname() {
        return surname;
    }

    public void setSurname(@NotNull(message = "Surname is required") @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters") String surname) {
        this.surname = surname;
    }

    public @NotNull(message = "Email is required") @Email(message = "Invalid email format") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "Email is required") @Email(message = "Invalid email format") String email) {
        this.email = email;
    }

    public @NotNull(message = "Password is required") @Size(min = 8, message = "Password must be at least 8 characters long") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(message = "Password is required") @Size(min = 8, message = "Password must be at least 8 characters long") String password) {
        this.password = password;
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
