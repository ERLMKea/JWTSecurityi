package com.example.jwtsecurityi.controller;

import com.example.jwtsecurityi.entity.User;
import com.example.jwtsecurityi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    //When calling from JavaScript frontend you need in fetchOptions:
    //method: "POST", or "GET"
    //body: payload,
    //headers:{'content-type': 'application/json',
    //        'Authorization': 'Bearer ' + inMemoryToken }


@GetMapping("/info")
    public User getUserDetails(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepo.findByEmail(email).get();
    }


}