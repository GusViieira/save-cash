package com.saveCash.infra.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name ="login")
public class LoginEntity {

    @Id
    @Column(name = "id_login")
    private int idLogin;

    private String email;

    private String password;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "registration_date")
    private Date registrationDate;

}
