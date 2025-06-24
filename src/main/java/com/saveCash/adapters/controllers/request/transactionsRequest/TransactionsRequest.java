package com.saveCash.adapters.controllers.request.transactionsRequest;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionsRequest {

    @NotNull(message = "Type is required")
    @Schema(description = "Transaction type")
    private int type;

    @NotNull(message = "Value is required")
    @Schema(description = "Transaction value")
    private BigDecimal value;

    @NotBlank(message = "Description is required")
    @Schema(description = "Transaction description")
    private String description;

    @NotNull(message = "Date is required")
    @Schema(description = "Transaction date")
    private LocalDate date;

    @NotNull(message = "Id user is required")
    @Schema(description = "Transaction id user")
    private String idUser;

    @NotNull(message = "Category is required")
    @Schema(description = "Transaction category")
    private String idCategory;

    @Schema(description = "Transaction status")
    private String status;

    @Schema(description = "Recurrent")
    private String isRecurrent;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsRecurrent() {
        return isRecurrent;
    }

    public void setIsRecurrent(String isRecurrent) {
        this.isRecurrent = isRecurrent;
    }
}
