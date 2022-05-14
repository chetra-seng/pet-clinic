package meow.springframework.petclinic.repositories;

import meow.springframework.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by chetra_seng on 14/5/22
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
