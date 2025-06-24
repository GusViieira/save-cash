package com.saveCash.adapters.producers.TransactionsProducers;

import com.saveCash.domain.usecases.TransactionsUseCases.TransactionsUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

public class TransactionsProducers {

    @Produces
    @ApplicationScoped
    TransactionsUseCase transactionsUseCase(){
        return null;
    }
}
