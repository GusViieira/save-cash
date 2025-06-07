package com.saveCash.infra.mappers;

import com.saveCash.domain.entities.RecoverPass;
import com.saveCash.infra.database.schemas.RecoverPassEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta", injectionStrategy = InjectionStrategy.FIELD)
public interface RecoverPassInfraMapper {
    RecoverPass toUseCase(RecoverPassEntity recoverPass);
}
