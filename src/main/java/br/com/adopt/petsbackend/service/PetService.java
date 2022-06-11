package br.com.adopt.petsbackend.service;

import br.com.adopt.petsbackend.domain.dto.PetRequestDto;
import br.com.adopt.petsbackend.domain.dto.PetResponseDto;
import br.com.adopt.petsbackend.domain.entity.Pet;
import br.com.adopt.petsbackend.repository.PetRepository;
import br.com.adopt.petsbackend.service.adapter.PetBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    private final PetBuilder petBuilder;

    public List<PetResponseDto> findAll() {
        final List<Pet> pets = petRepository.findAll();
        return pets.stream().map(petBuilder::toPetResponseDto).collect(Collectors.toList());
    }

    public PetResponseDto create(PetRequestDto petRequestDto) {
        var petToCreate = petBuilder.toPet(petRequestDto);
        var createdPet = petRepository.save(petToCreate);
        return petBuilder.toPetResponseDto(createdPet);
    }
}
