package com.ifestapi.service;

import com.ifestapi.dto.useraccount.UserAccountRequestDTO;
import com.ifestapi.dto.useraccount.UserAccountResponseDTO;
import com.ifestapi.model.UserAccount;
import com.ifestapi.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserAccountService {

    private final UserAccountRepository repository;
    private final ModelMapper modelMapper;

    public UserAccountResponseDTO create(UserAccountRequestDTO requestDTO) {
        UserAccount account = modelMapper.map(requestDTO, UserAccount.class);

        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());

        UserAccount savedAccount = repository.save(account);

        return modelMapper.map(savedAccount, UserAccountResponseDTO.class);
    }

}
