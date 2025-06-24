package com.saveCash.adapters.controllers;


import com.saveCash.adapters.controllers.request.transactionsRequest.TransactionsRequest;
import com.saveCash.adapters.mappers.TransactionsAdaptersMapper;
import com.saveCash.adapters.utils.ApiResponse;
import com.saveCash.domain.usecases.TransactionsUseCases.TransactionsUseCase;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionsController {

    @Inject
    TransactionsUseCase transactionsUseCase;

    @Inject
    TransactionsAdaptersMapper mapper;

    @Path("/create-transaction")
    @POST
    @Authenticated
    public Response createTransaction(@Valid TransactionsRequest transactionsRequest){
        transactionsUseCase.newTransactions(mapper.toUseCase(transactionsRequest));
        return Response.ok(new ApiResponse<>("Sucesso")).build();
    }
}
