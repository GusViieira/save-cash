package com.saveCash.adapters.mappers;

import com.saveCash.adapters.controllers.request.CreateUserRequest;
import com.saveCash.adapters.dtos.UserDTO;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-08T22:00:01+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Singleton
@Named
public class CreateUserMapperImpl implements CreateUserMapper {

    @Override
    public UserDTO toUserUseCase(CreateUserRequest request) {
        if ( request == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setName( request.getName() );
        userDTO.setSurname( request.getSurname() );
        userDTO.setEmail( request.getEmail() );
        userDTO.setPassword( request.getPassword() );
        userDTO.setPhoneNumber( request.getPhoneNumber() );
        userDTO.setBirthDate( request.getBirthDate() );
        userDTO.setCountry( request.getCountry() );

        return userDTO;
    }
}
