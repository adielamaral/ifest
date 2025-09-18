package com.ifestapi.controller;

import com.ifestapi.enums.Role;
import com.ifestapi.model.UserAccount;
import com.ifestapi.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserAccountController {

    private final UserAccountRepository userAccountRepository;

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user){
        user.setRoles(Set.of(Role.USER));
        user.setCreatedAt(LocalDateTime.now());
        return userAccountRepository.save(user);

    }

}
