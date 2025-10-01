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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserAccountRepository userAccountRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public EventResponseDTO create(EventRequestDTO dto) {
        UserAccount userAccount = userAccountRepository.findById(dto.getUserAccount())
                .orElseThrow(() -> new UserNotFoundException(dto.getUserAccount()));
        Event event = modelMapper.map(dto, Event.class);

        event.setUserAccount(userAccount);

        event.setCreatedAt(LocalDateTime.now());
        event.setUpdatedAt(LocalDateTime.now());

        Event savedEvent = eventRepository.save(event);

        return modelMapper.map(savedEvent, EventResponseDTO.class);
    }

    @Transactional
    public List<EventResponseDTO> findAll() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(event -> modelMapper.map(event, EventResponseDTO.class))
                .toList();
    }

    @Transactional
    public EventResponseDTO updateEvent(Long id, EventRequestDTO updateDTO) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        event.setTitle(updateDTO.getTitle());
        event.setDescription(updateDTO.getDescription());
        event.setAddress(updateDTO.getAddress());
        event.setPhoneNumber(updateDTO.getPhoneNumber());
        event.setEventDay(updateDTO.getEventDay());
        event.setStatus(updateDTO.getStatus());

//        if (updateDTO.getUserAccountId() != null &&
//                !event.getUserAccount().getId().equals(updateDTO.getUserAccountId())) {
//            UserAccount userAccount = userAccountRepository.findById(updateDTO.getUserAccountId())
//                    .orElseThrow(() -> new UserNotFoundException(updateDTO.getUserAccountId()));
//            event.setUserAccount(userAccount);
//        }

        event.setUpdatedAt(LocalDateTime.now());

        Event updatedEvent = eventRepository.save(event);

        return modelMapper.map(updatedEvent, EventResponseDTO.class);
    }

}
