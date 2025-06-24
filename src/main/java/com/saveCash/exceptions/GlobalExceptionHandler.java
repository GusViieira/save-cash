package com.saveCash.exceptions;

import com.saveCash.adapters.utils.ApiResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        ErrorResponse error = new ErrorResponse(exception.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponse<>(error)).build();
    }
}