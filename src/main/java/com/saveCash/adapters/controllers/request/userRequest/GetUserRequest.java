package com.saveCash.adapters.controllers.request.userRequest;

import jakarta.validation.constraints.NotBlank;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class GetUserRequest {
    @NotBlank(message = "Id user is required")
    @Schema(description = "Id user")
    private int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
