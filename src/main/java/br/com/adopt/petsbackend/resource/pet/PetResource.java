package br.com.adopt.petsbackend.resource.pet;

import br.com.adopt.petsbackend.domain.dto.PetRequestDto;
import br.com.adopt.petsbackend.domain.dto.PetResponseDto;
import br.com.adopt.petsbackend.service.PetService;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pets")
public class PetResource {

    private final PetService petService;

    @GetMapping
    public ResponseEntity<List<PetResponseDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.findAll());
    }

    @PostMapping
    public ResponseEntity<PetResponseDto> create(@RequestBody @Valid final PetRequestDto petRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.create(petRequestDto));
    }

}
