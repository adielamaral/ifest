package com.ifestapi.service;

import com.ifestapi.dto.event.EventResponseDTO;
import com.ifestapi.dto.event.EventRquestDTO;
import com.ifestapi.model.Event;
import com.ifestapi.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    public void create(EventRquestDTO owner) {
        return;
    }

    public List<EventResponseDTO> findAll() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(event -> modelMapper.map(event, EventResponseDTO.class))
                .toList();
    }
}
