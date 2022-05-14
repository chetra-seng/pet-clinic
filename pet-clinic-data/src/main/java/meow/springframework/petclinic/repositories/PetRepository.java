package meow.springframework.petclinic.repositories;

import meow.springframework.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by chetra_seng on 14/5/22
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}
