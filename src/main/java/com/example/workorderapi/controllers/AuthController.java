package com.example.workorderapi.controllers;

import com.example.workorderapi.configuration.UserData;
import com.example.workorderapi.models.AuthModel;
import com.example.workorderapi.models.User;
import com.example.workorderapi.viewmodels.AuthVM;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {

    User[] users = UserData.Users;

    @PostMapping
    public ResponseEntity<AuthVM> Auth(@RequestBody AuthModel model){
        for(var user: users){
            if(user.getUsername().equals(model.getUsername()) && user.getPassword().equals(model.getPassword())){
                var authResult = new AuthVM(user.getId(), user.getUsername(), user.getRole(), user.getToken());
                return new ResponseEntity<>(authResult, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
