package com.ifestapi.controller;

import com.ifestapi.dto.event.EventResponseDTO;
import com.ifestapi.dto.event.EventRequestDTO;
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

    @PostMapping("/register")
    public ResponseEntity<EventResponseDTO> createEvent(
            @RequestBody EventRequestDTO dto) {

        EventResponseDTO responseDTO = service.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> findAll() {
        List<EventResponseDTO> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponseDTO> updateEvent(
            @PathVariable Long id,
            @RequestBody EventRequestDTO updateDTO) {
        EventResponseDTO updatedEvent = service.updateEvent(id, updateDTO);
        return ResponseEntity.ok(updatedEvent);
    }

}
