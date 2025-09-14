package com.ifestapi.controller;

import com.ifestapi.dto.owner.OwnerDTO;
import com.ifestapi.dto.owner.OwnerResponseDTO;
import com.ifestapi.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody OwnerDTO owner) {
        service.create(owner);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<OwnerResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
