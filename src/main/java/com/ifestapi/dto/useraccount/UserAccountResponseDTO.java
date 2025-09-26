package com.ifestapi.dto.useraccount;

import lombok.Data;

@Data
public class UserAccountResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String address;
}
