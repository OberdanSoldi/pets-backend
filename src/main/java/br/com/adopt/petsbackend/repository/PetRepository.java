package br.com.adopt.petsbackend.repository;

import br.com.adopt.petsbackend.domain.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {


}
