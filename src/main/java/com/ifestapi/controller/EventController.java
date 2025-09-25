package com.ifestapi.controller;

import com.ifestapi.dto.event.EventRquestDTO;
import com.ifestapi.dto.event.EventResponseDTO;
import com.ifestapi.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EventRquestDTO event) {
        service.create(event);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
