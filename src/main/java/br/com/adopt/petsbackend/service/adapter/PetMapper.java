package br.com.adopt.petsbackend.service.adapter;

import br.com.adopt.petsbackend.domain.dto.PetResponseDto;
import br.com.adopt.petsbackend.domain.entity.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    public PetResponseDto toPetResponseDto(final Pet pet) {
        var petDto = new PetResponseDto();
        petDto.setId(pet.getId());
        petDto.setName(pet.getName());
        petDto.setHistory(pet.getHistory());
        petDto.setPhoto(pet.getPhoto());
        return petDto;
    }

}
