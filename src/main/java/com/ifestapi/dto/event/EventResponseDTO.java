package com.ifestapi.dto.event;

import com.ifestapi.enums.EventStatus;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EventResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String address;
    private String phoneNumber;
    private LocalDate eventDay;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private EventStatus status;
}
