package com.example.workorderapi.viewmodels;

public class AuthVM {
    private int userId;
    private String username;
    private String role;
    private String token;

    public AuthVM(int userId, String username, String role, String token){
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return userId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
