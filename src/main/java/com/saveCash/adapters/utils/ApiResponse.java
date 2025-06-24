package com.saveCash.adapters.utils;

import com.saveCash.exceptions.ErrorResponse;

import java.util.ArrayList;

public class ApiResponse<T> {

    private T content;
    private ArrayList<ErrorResponse> errors = new ArrayList<>();

    public ApiResponse(T content) {
        this.content = content;
        this.errors = new ArrayList<>(); // Sem erro
    }

    public ApiResponse(ErrorResponse error) {
        this.content = null; // Sem dados
        this.errors.add(error);
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public ArrayList<ErrorResponse> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<ErrorResponse> errors) {
        this.errors = errors;
    }
}
