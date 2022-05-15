package meow.springframework.petclinic.services.map;

import meow.springframework.petclinic.model.Visit;
import meow.springframework.petclinic.services.VisitService;

import java.util.Set;

/**
 * Created by chetra_seng on 15/5/22
 */
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        return super.save(visit);
    }
}
