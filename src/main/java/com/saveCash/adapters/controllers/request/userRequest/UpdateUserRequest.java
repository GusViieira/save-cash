package com.saveCash.adapters.controllers.request.userRequest;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;

public class UpdateUserRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 2 and 50 characters")
    @Schema(description = "User name")
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(min = 3, max = 50, message = "Surname must be between 2 and 50 characters")
    @Schema(description = "The last name")
    private String surname;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Schema(description = "Email user")
    private String email;

    @Schema(description = "Number phone")
    private String phoneNumber;

    @Schema(description = "Birth date in the format yyyy-MM-dd")
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate birthDate;

    @Schema(description = "Country")
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
