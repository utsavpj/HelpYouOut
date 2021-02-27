package com.example.helpyouout;

public class RegisterUser {
    private String name,email,password,mobile;
    private int verified;

    public RegisterUser(String name, String email, String password, String mobile, int verified) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public int getVerified() {
        return verified;
    }
}
