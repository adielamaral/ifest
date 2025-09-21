package com.ifestapi.service;

import com.ifestapi.dto.useraccount.UserAccountRequestDTO;
import com.ifestapi.dto.useraccount.UserAccountResponseDTO;
import com.ifestapi.dto.useraccount.UserAccountUpdateDTO;
import com.ifestapi.exception.UserNotFoundException;
import com.ifestapi.model.UserAccount;
import com.ifestapi.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<UserAccountResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(user -> modelMapper.map(user, UserAccountResponseDTO.class))
                .toList();
    }

    public UserAccountResponseDTO updateUser(Long id, UserAccountUpdateDTO updateDTO) {
        UserAccount user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        modelMapper.map(updateDTO, user);

        UserAccount updated = repository.save(user);

        return modelMapper.map(updated, UserAccountResponseDTO.class);
    }

}
