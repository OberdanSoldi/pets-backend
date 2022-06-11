package br.com.adopt.petsbackend.exception;

import javax.persistence.EntityNotFoundException;

public class PetNotFoundException extends EntityNotFoundException {
    public PetNotFoundException() {
        super("Pet not found");
    }

    public PetNotFoundException(String message) {
        super(message);
    }
}
