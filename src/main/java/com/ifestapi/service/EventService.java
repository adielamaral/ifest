package com.ifestapi.service;

import com.ifestapi.dto.event.EventResponseDTO;
import com.ifestapi.dto.event.EventRequestDTO;
import com.ifestapi.exception.UserNotFoundException;
import com.ifestapi.model.Event;
import com.ifestapi.model.UserAccount;
import com.ifestapi.repository.EventRepository;
import com.ifestapi.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserAccountRepository userAccountRepository;
    private final ModelMapper modelMapper;

    public EventResponseDTO create(EventRequestDTO eventRequestDTO) {
        Event event = modelMapper.map(eventRequestDTO, Event.class);

        UserAccount userAccount = userAccountRepository.findById(eventRequestDTO.getUserAccountId())
                .orElseThrow(() -> new UserNotFoundException(eventRequestDTO.getUserAccountId()));

        //associa o usuário encontrado ao evento, assim estabelecendo o relacionamento entre as entidades
        event.setUserAccount(userAccount);

        if (event.getConsentAccepted() == null) {
            event.setConsentAccepted(false);
        }

        event.setCreatedAt(LocalDateTime.now());
        event.setUpdatedAt(LocalDateTime.now());

        Event savedEvent = eventRepository.save(event);

        return modelMapper.map(savedEvent, EventResponseDTO.class);

    }

    public List<EventResponseDTO> findAll() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(event -> modelMapper.map(event, EventResponseDTO.class))
                .toList();
    }

    public EventResponseDTO updateEvent(Long id, EventRequestDTO updateDTO) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        modelMapper.map(updateDTO, event);

        Event updatedEvent = eventRepository.save(event);

        return modelMapper.map(updatedEvent, EventResponseDTO.class);
    }


}
