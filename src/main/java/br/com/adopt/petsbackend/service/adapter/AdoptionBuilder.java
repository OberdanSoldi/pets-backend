package br.com.adopt.petsbackend.service.adapter;

import br.com.adopt.petsbackend.domain.dto.AdoptionRequestDto;
import br.com.adopt.petsbackend.domain.dto.AdoptionResponseDto;
import br.com.adopt.petsbackend.domain.entity.Adoption;
import br.com.adopt.petsbackend.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdoptionBuilder {

    private final PetRepository petRepository;
    private final PetBuilder petBuilder;

    public Adoption toAdoption(AdoptionRequestDto adoptionRequestDto) {

        return Adoption.builder()
                .email(adoptionRequestDto.getEmail())
                .value(adoptionRequestDto.getValue())
                .pet(petRepository.findByIdOrElseThrow(adoptionRequestDto.getPetId()))
                .build();
    }

    public AdoptionResponseDto toResponseDto(Adoption adoption) {

        return AdoptionResponseDto.builder()
                .id(adoption.getId())
                .email(adoption.getEmail())
                .value(adoption.getValue())
                .pet(petBuilder.toPetResponseDto(adoption.getPet()))
                .build();
    }
}