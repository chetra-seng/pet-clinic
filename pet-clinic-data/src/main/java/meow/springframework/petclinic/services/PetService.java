package meow.springframework.petclinic.services;

import meow.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    public Pet findById(Long id);
    public Pet save(Pet pet);
    public Set<Pet> findAll();
}
