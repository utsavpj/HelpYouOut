package com.example.helpyouout;

public class LogInResponse {

    private String email,password;

    public LogInResponse(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
