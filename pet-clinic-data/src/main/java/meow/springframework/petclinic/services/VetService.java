package meow.springframework.petclinic.services;

import meow.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    public Vet findById(Long id);
    public Vet save(Vet vet);
    public Set<Vet> findAll();
}
