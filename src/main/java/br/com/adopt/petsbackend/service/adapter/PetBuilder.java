package br.com.adopt.petsbackend.service.adapter;

import br.com.adopt.petsbackend.domain.dto.PetRequestDto;
import br.com.adopt.petsbackend.domain.dto.PetResponseDto;
import br.com.adopt.petsbackend.domain.entity.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetBuilder {

    public PetResponseDto toPetResponseDto(final Pet pet) {
        return PetResponseDto.builder()
                .id(pet.getId())
                .name(pet.getName())
                .history(pet.getHistory())
                .photo(pet.getPhoto())
                .build();
    }

    public Pet toPet(final PetRequestDto petRequestDto) {
        return Pet.builder()
                .name(petRequestDto.getName())
                .history(petRequestDto.getHistory())
                .photo(petRequestDto.getPhoto())
                .build();
    }

}
