package com.saveCash.adapters.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDTO {

    private int type;

    private BigDecimal value;

    private String description;

    private LocalDate date;

    private String idUser;

    private String idCategory;

    private String status;

    private String isRecurrent;

    public String getIsRecurrent() {
        return isRecurrent;
    }

    public void setIsRecurrent(String isRecurrent) {
        this.isRecurrent = isRecurrent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
