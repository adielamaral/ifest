package com.ifestapi.controller;

import com.ifestapi.dto.useraccount.UserAccountRequestDTO;
import com.ifestapi.dto.useraccount.UserAccountResponseDTO;
import com.ifestapi.service.UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserAccountController {

    private final UserAccountService service;

    @PostMapping("/register")
    public ResponseEntity<UserAccountResponseDTO> registerUser(@RequestBody UserAccountRequestDTO dto){

        UserAccountResponseDTO responseDTO = service.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserAccountResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
