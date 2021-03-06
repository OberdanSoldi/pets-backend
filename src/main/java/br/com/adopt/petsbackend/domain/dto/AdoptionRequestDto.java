package br.com.adopt.petsbackend.domain.dto;

import br.com.adopt.petsbackend.validator.PetExistsById;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AdoptionRequestDto {

    @NotNull
    @Email
    @Size(max = 255)
    @NotEmpty
    private String email;

    @NotNull
    @Min(10)
    @Max(100)
    private BigDecimal value;

    @NotNull
    @Positive
    @PetExistsById
    private Long petId;
}
