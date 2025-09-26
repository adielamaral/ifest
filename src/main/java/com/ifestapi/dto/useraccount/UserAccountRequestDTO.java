package com.ifestapi.dto.useraccount;

import com.ifestapi.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAccountRequestDTO {

    private String name;

    private String password;

    private String document;

    private String address;

    private String email;

    private String phoneNumber;

    private LocalDate birthDate;

    private Gender gender;

    private Boolean consentAccepted;

}
