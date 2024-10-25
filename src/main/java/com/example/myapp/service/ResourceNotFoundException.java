package com.example.myapp.service; // Or exceptions package, if you prefer

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}