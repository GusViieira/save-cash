package com.saveCash.adapters.mappers;

import com.saveCash.adapters.controllers.request.transactionsRequest.TransactionsRequest;
import com.saveCash.adapters.dtos.TransactionDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta", injectionStrategy = InjectionStrategy.FIELD)
public interface TransactionsAdaptersMapper {
    TransactionDTO toUseCase(TransactionsRequest transactionsRequest);
}
