package com.wawansetiawan.machine.response;

public class ApiResponse {
    
    private final String status;
    private final Object data;
    private final String message;

    public ApiResponse(String status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}

