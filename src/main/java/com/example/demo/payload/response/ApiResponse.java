package com.example.demo.payload.response;

public class ApiResponse {
    private Object data;
    private Object error;

    public ApiResponse() {
    }

    public ApiResponse(Object error) {
        this.error = error;
    }

    public ApiResponse(Object data, Object error) {
        this.data = data;
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
