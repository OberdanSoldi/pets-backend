package br.com.adopt.petsbackend.validator;

import br.com.adopt.petsbackend.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class PetExistByIdValidator implements ConstraintValidator<PetExistsById, Long> {

    private final PetRepository petRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value == null || petRepository.existsById(value);
    }

}
