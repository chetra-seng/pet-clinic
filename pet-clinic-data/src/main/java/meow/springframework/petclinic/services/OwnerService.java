package meow.springframework.petclinic.services;

import meow.springframework.petclinic.model.Owner;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
