package com.ifestapi.controller;

import com.ifestapi.dto.useraccount.UserAccountRequestDTO;
import com.ifestapi.dto.useraccount.UserAccountResponseDTO;
import com.ifestapi.dto.useraccount.UserAccountUpdateDTO;
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
    public ResponseEntity<UserAccountResponseDTO> registerUser(
            @RequestBody UserAccountRequestDTO dto) {

        UserAccountResponseDTO responseDTO = service.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserAccountResponseDTO>> findAll() {
        List<UserAccountResponseDTO> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAccountResponseDTO> updateUser(
            @PathVariable Long id,
            @RequestBody UserAccountUpdateDTO updateDTO) {
        UserAccountResponseDTO updatedUser = service.updateUser(id, updateDTO);
        return ResponseEntity.ok(updatedUser);
    }

}
