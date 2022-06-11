package br.com.adopt.petsbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdoptionResponseDto {

    private Long id;
    private String email;
    private BigDecimal value;
    private PetResponseDto pet;

}
