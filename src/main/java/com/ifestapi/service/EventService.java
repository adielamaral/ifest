package com.ifestapi.service;

import com.ifestapi.dto.event.EventResponseDTO;
import com.ifestapi.dto.event.EventRquestDTO;
import com.ifestapi.dto.useraccount.UserAccountRequestUpdateDTO;
import com.ifestapi.dto.useraccount.UserAccountResponseDTO;
import com.ifestapi.exception.UserNotFoundException;
import com.ifestapi.model.Event;
import com.ifestapi.model.UserAccount;
import com.ifestapi.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository repository;
    private final ModelMapper modelMapper;

    public EventResponseDTO create(EventRquestDTO eventRquestDTO) {
        Event event = modelMapper.map(eventRquestDTO, Event.class);

        event.setCreatedAt(LocalDateTime.now());
        event.setUpdatedAt(LocalDateTime.now());

        Event savedEvent = repository.save(event);

        return modelMapper.map(savedEvent, EventResponseDTO.class);

    }

    public List<EventResponseDTO> findAll() {
        List<Event> events = repository.findAll();
        return events.stream()
                .map(event -> modelMapper.map(event, EventResponseDTO.class))
                .toList();
    }


}
