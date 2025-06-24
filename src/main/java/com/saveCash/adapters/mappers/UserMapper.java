package com.saveCash.adapters.mappers;

import com.saveCash.adapters.controllers.request.userRequest.CreateUserRequest;
import com.saveCash.adapters.controllers.request.userRequest.UpdateUserRequest;
import com.saveCash.adapters.dtos.UserDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta", injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {
    UserDTO toUserUseCase(CreateUserRequest request);

    UserDTO toUserUseCase(UpdateUserRequest request);
}
