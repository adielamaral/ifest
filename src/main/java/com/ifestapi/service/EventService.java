package com.ifestapi.service;

import com.ifestapi.dto.event.EventResponseDTO;
import com.ifestapi.dto.event.EventRquestDTO;
import com.ifestapi.exception.UserNotFoundException;
import com.ifestapi.model.Event;
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

        if(event.getConsentAccepted() == null) {
            event.setConsentAccepted(false);
        }

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

    public EventResponseDTO updateEvent(Long id, EventRquestDTO updateDTO) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        modelMapper.map(updateDTO, event);

        Event updatedEvent = repository.save(event);

        return modelMapper.map(updatedEvent, EventResponseDTO.class);
    }


}
