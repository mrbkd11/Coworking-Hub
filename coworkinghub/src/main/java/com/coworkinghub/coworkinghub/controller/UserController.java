package com.coworkinghub.coworkinghub.controller;

import com.coworkinghub.coworkinghub.model.Compte;
import com.coworkinghub.coworkinghub.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Compte> createUser(@RequestBody Compte compte) {
        Compte createdUser = userService.createUser(compte);
        return ResponseEntity.ok(createdUser);
    }

    // Other endpoints as needed
}