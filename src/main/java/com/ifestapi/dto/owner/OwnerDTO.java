package com.ifestapi.dto.owner;

import com.ifestapi.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OwnerDTO {

    private String name;
    private String document;
    private String address;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private Gender gender;
    private Boolean consentAccepted;
}
