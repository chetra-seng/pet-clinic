package meow.springframework.petclinic.services;

import meow.springframework.petclinic.model.Owner;
import java.util.Set;

public interface OwnerService {
    public Owner findById(Long id);
    public Owner save(Owner owner);
    public Owner findByLastName(String lastName);
    public Set<Owner> findAll();
}
