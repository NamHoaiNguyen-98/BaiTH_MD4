package com.example.thmd4.dto.response;

import org.springframework.http.ResponseEntity;

public class DfResponse<T>{
    private Integer code;
    private String message;
    private T result;

    public DfResponse() {
        code = 0;
        message = "OK";
    }

    public DfResponse(String message) {
        this.code = 0;
        this.message = message;
    }

    public DfResponse(String message, T result) {
        this.code = 0;
        this.message = message;
        this.result = result;
    }

    public DfResponse(Integer code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public DfResponse(String message, Integer code) {
        this.code = code;
        this.message = message;
    }

    public static <T> ResponseEntity<DfResponse<T>> okEntity(T body) {
        return ResponseEntity.ok(ok(body));
    }

    public static <T> DfResponse<T> ok(T body) {
        DfResponse<T> response = new DfResponse<>();
        response.setResult(body);
        return response;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
