package br.com.adopt.petsbackend.service;

import br.com.adopt.petsbackend.domain.dto.PetDto;
import br.com.adopt.petsbackend.domain.entity.Pet;
import br.com.adopt.petsbackend.repository.PetRepository;
import br.com.adopt.petsbackend.service.adapter.PetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    private final PetMapper petMapper;

    public List<PetDto> findAll() {
        final List<Pet> pets = petRepository.findAll();
        return pets.stream().map(petMapper::toPetDto).collect(Collectors.toList());
    }
}
