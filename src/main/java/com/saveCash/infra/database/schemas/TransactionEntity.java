package com.saveCash.infra.database.schemas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "transaction")
public class TransactionEntity {

    @Id
    @Column(name = "id_transaction")
    private int id;

    @Column(name = "transaction_type")
    private String type;

    @Column(name = "transaction_value")
    private String value;

    @Column(name = "transaction_description")
    private String description;

    private String responsible;

    @Column(name = "payment_date")
    private Date dtPayment;

    @Column(name = "registration_date")
    private Date dtRegistration;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public Date getDtPayment() {
        return dtPayment;
    }

    public void setDtPayment(Date dtPayment) {
        this.dtPayment = dtPayment;
    }

    public Date getDtRegistration() {
        return dtRegistration;
    }

    public void setDtRegistration(Date dtRegistration) {
        this.dtRegistration = dtRegistration;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
