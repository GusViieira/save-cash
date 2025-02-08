package com.saveCash.adapters.mappers;

import com.saveCash.adapters.controllers.request.CreateUserRequest;
import com.saveCash.adapters.dtos.UserDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta", injectionStrategy = InjectionStrategy.FIELD)
public interface CreateUserMapper {
    UserDTO toUserUseCase(CreateUserRequest request);
}
