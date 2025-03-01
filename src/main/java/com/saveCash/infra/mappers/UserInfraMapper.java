package com.saveCash.infra.mappers;

import com.saveCash.domain.entities.User;
import com.saveCash.infra.database.schemas.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta", injectionStrategy = InjectionStrategy.FIELD)
public interface UserInfraMapper {
    User toUserUseCase(UserEntity userEntity);
}
