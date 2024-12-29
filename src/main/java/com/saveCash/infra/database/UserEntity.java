package com.saveCash.infra.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name ="user")
@Getter
@Setter
public class UserEntity {

    @Id
    @Column(name = "id_user")
    private String idUser;

    private String name;

    private String surname;

    @Column(name = "phone_number")
    private String phone;

    private Date birth;

    private String country;

    private String updateDate;
}
