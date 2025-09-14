package com.ifestapi.service;

import com.ifestapi.dto.owner.OwnerDTO;
import com.ifestapi.dto.owner.OwnerResponseDTO;
import com.ifestapi.model.Owner;
import com.ifestapi.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;

    public void create(OwnerDTO owner) {
        final Owner newOwner = new Owner();
        newOwner.setName(owner.getName());
        newOwner.setDocument(owner.getDocument());
        newOwner.setAddress(owner.getAddress());
        newOwner.setEmail(owner.getEmail());
        newOwner.setPhoneNumber(owner.getPhoneNumber());
        newOwner.setBirthDate(owner.getBirthDate());
        newOwner.setGender(owner.getGender());
        newOwner.setConsentAccepted(owner.getConsentAccepted());
        newOwner.setCreatedAt(LocalDateTime.now());

        ownerRepository.save(newOwner);
        log.info("Owner created. Name: {} ID: {} | Document: {}",
                owner.getName(), newOwner.getId(),  newOwner.getDocument());
    }

    public List<OwnerResponseDTO> findAll() {
        List<Owner> owners = ownerRepository.findAll();
        return owners.stream()
                .map(owner -> modelMapper.map(owner, OwnerResponseDTO.class))
                .toList();
    }
}
