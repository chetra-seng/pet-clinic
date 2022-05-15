package meow.springframework.petclinic.services;

import meow.springframework.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by chetra_seng on 15/5/22
 */
public interface VisitService extends CrudService<Visit, Long>{
}
