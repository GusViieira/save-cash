package com.saveCash.infra.database.repository;

import com.saveCash.domain.entities.User;
import com.saveCash.domain.mappers.UserUseCaseMapper;
import com.saveCash.domain.repositories.UserRepository;
import com.saveCash.infra.database.schemas.LoginEntity;
import com.saveCash.infra.database.schemas.UserEntity;
import com.saveCash.infra.mappers.UserInfraMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@RequestScoped
public class UserRepositoryImpl implements PanacheRepository<UserEntity>, UserRepository {

    @Inject
    LoginRepositoryImpl loginRepositoryImpl;

    @Inject
    UserUseCaseMapper userUseCaseMapper;

    @Inject
    UserInfraMapper userInfraMapper;

    @Transactional
    public void createUser(User user){
        UserEntity entity = userUseCaseMapper.toRepository(user);
        loginRepositoryImpl.registerLogin(user);
        LoginEntity loginEntity = loginRepositoryImpl.getIdLogin(user);

        entity.setTsUpdateDate(LocalDateTime.now().toString());
        entity.setLogin(loginEntity);
        persist(entity);
    }

    public User getUserById(BigInteger idUser){
        UserEntity userEntity = find("idUser", idUser).firstResult();
        return userInfraMapper.toUserUseCase(userEntity);
    }

    public User getUserByIdLogin(int idLogin){
        UserEntity userEntity = find("login.id", idLogin).firstResult();
        return userInfraMapper.toUserUseCase(userEntity);
    }

    public UserEntity getUserByEmailLogin(User user){
        return find("login.email", user.getEmail()).firstResult();
    }


    @Transactional
    public User updateUser(User user){
        UserEntity userResponse = getUserByEmailLogin(user);
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setCountry(user.getCountry());
        userResponse.setBirthDate(user.getBirthDate());
        persist(userResponse);

        UserEntity userUpdated = getUserByEmailLogin(user);
        return userInfraMapper.toUserUseCase(userUpdated);
    }
}