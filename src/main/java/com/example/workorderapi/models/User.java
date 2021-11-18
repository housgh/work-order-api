package com.example.workorderapi.models;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String token;

    public User(int id,String username, String email, String password, String role, String token){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getToken() {
        return token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
