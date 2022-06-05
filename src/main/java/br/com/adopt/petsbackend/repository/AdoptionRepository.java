package br.com.adopt.petsbackend.repository;

import br.com.adopt.petsbackend.domain.entity.Adoption;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
}
