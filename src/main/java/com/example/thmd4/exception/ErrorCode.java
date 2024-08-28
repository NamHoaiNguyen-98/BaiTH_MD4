package com.example.thmd4.exception;



public enum ErrorCode {
    EMAIL_EXISTED(500, "Email existed"),
    NAME_INVALID(400, "Name must be at least 2 characters");

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
