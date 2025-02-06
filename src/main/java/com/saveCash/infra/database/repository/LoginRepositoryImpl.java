package com.saveCash.infra.database.repository;

import com.saveCash.domain.entities.User;
import com.saveCash.infra.database.schemas.LoginEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;

@RequestScoped
public class LoginRepositoryImpl implements PanacheRepository<LoginEntity> {

    @Transactional
    public void registerLogin(User user){
        LoginEntity entity = new LoginEntity();
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setRegistrationDate(user.getTsregistration());
        entity.setUpdateDate(user.getTsUpdate());
        persist(entity);
    }

    public LoginEntity getIdLogin(User user){
        return find("email", user.getEmail()).firstResult();
    }
}
