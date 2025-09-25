package com.ifestapi.dto.useraccount;

import com.ifestapi.enums.Gender;
import lombok.Data;

@Data
public class UserAccountRequestUpdateDTO {

    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private Gender gender;
}
