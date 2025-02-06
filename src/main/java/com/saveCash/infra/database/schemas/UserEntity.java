package com.saveCash.infra.database.schemas;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity(name ="user")
public class UserEntity extends PanacheEntityBase {

    @Id()
    @Column(name = "id_user")
    private int idUser;

    private String name;

    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String country;

    @Column(name = "update_ts")
    private String tsUpdateDate;

    @OneToOne
    @JoinColumn(name = "id_login", nullable = false)
    private LoginEntity login;

    @OneToMany(mappedBy = "user")
    private List<TransactionEntity> transactions;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

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

    public String getTsUpdateDate() {
        return tsUpdateDate;
    }

    public void setTsUpdateDate(String tsUpdateDate) {
        this.tsUpdateDate = tsUpdateDate;
    }

    public LoginEntity getLogin() {
        return login;
    }

    public void setLogin(LoginEntity login) {
        this.login = login;
    }

    public List<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }
}
