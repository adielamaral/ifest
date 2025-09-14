package com.ifestapi.dto.owner;

import com.ifestapi.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnerResponseDTO {

    private Long id;
    private String name;
    private String document;
    private String address;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private Gender gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
