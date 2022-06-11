package br.com.adopt.petsbackend.repository;

import br.com.adopt.petsbackend.domain.entity.Pet;
import br.com.adopt.petsbackend.exception.PetNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PetRepository extends JpaRepository<Pet, Long> {

    default Pet findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(PetNotFoundException::new);
    }
}
