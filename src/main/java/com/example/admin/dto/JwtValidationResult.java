package com.example.admin.dto;



public class JwtValidationResult {
    private boolean valid;
    private String message;

    // Constructors, getters, and setters
    public JwtValidationResult(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValid () {
        return valid;
    }

    public void setValid (boolean valid) {
        this.valid = valid;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }
}
