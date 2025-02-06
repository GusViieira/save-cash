package com.saveCash.infra.database.repository;

import com.saveCash.domain.entities.User;
import com.saveCash.domain.repositories.UserRepository;
import com.saveCash.infra.database.schemas.LoginEntity;
import com.saveCash.infra.database.schemas.UserEntity;
import com.saveCash.infra.mappers.UserInfraMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@RequestScoped
public class UserRepositoryImpl implements PanacheRepository<UserEntity>, UserRepository {

    @Inject
    LoginRepositoryImpl loginRepositoryImpl;

    @Inject
    UserInfraMapper userInfraMapper;

    @Transactional
    public void createUser(User user){
        UserEntity entity = userInfraMapper.toUserSchema(user);
        loginRepositoryImpl.registerLogin(user);
        LoginEntity loginEntity = loginRepositoryImpl.getIdLogin(user);

        entity.setTsUpdateDate(LocalDateTime.now().toString());
        entity.setLogin(loginEntity);
        persist(entity);
    }
}