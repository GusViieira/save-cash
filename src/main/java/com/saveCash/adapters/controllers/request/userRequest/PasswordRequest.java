package com.saveCash.adapters.controllers.request.userRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class PasswordRequest {

    @NotNull(message = "Email user is required")
    @Schema(description = "Email user")
    private String email;

    @NotBlank(message = "Password is required")
    @Schema(description = "New Password")
    private String password;

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
}
