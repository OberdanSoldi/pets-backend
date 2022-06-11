package br.com.adopt.petsbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetRequestDto {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String history;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    @URL
    private String photo;
}
