package com.saveCash.domain.mappers;

import com.saveCash.adapters.dtos.UserDTO;
import com.saveCash.domain.entities.User;
import com.saveCash.infra.database.schemas.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta", injectionStrategy = InjectionStrategy.FIELD)
public interface UserUseCaseMapper {
    User toRepository(UserDTO userDTO);
    UserEntity toRepository(User user);
}
