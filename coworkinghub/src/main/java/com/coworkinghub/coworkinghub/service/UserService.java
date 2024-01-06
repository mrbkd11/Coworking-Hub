package com.coworkinghub.coworkinghub.service;


import com.coworkinghub.coworkinghub.model.Compte;
import com.coworkinghub.coworkinghub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Compte createUser(Compte compte) {
        // Add any business logic here if needed
        return userRepository.save(compte);
    }
}
