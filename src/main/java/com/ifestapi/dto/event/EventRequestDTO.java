package com.ifestapi.dto.event;

import com.ifestapi.enums.EventStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventRequestDTO {

    private String title;
    private String description;
    private String address;
    private String phoneNumber;
    private LocalDate eventDay;
    private EventStatus status;
    private Boolean consentAccepted;
    private Long userAccount;

}
