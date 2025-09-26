package com.ifestapi.controller;

import com.ifestapi.dto.event.EventRquestDTO;
import com.ifestapi.dto.event.EventResponseDTO;
import com.ifestapi.dto.useraccount.UserAccountRequestUpdateDTO;
import com.ifestapi.dto.useraccount.UserAccountResponseDTO;
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
            @RequestBody EventRquestDTO dto) {

        EventResponseDTO responseDTO = service.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserAccountResponseDTO>> findAll() {
        List<UserAccountResponseDTO> users = service.findAll();
        return ResponseEntity.ok(users);
    }

}
