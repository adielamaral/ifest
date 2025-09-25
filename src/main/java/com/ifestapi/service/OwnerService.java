package com.ifestapi.service;

import com.ifestapi.dto.owner.OwnerDTO;
import com.ifestapi.dto.owner.OwnerResponseDTO;
import com.ifestapi.model.Owner;
import com.ifestapi.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;

    public void create(OwnerDTO owner) {
        final Owner newOwner = modelMapper.map(owner, Owner.class);

        ownerRepository.save(newOwner);
        log.info("Owner created. Name: {} | ID: {} | Document: {}",
                owner.getName(), newOwner.getId(),  newOwner.getDocument());
    }

    public List<OwnerResponseDTO> findAll() {
        List<Owner> owners = ownerRepository.findAll();
        return owners.stream()
                .map(owner -> modelMapper.map(owner, OwnerResponseDTO.class))
                .toList();
    }
}
