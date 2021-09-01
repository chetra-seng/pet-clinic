package meow.springframework.petclinic.services.map;

import meow.springframework.petclinic.model.Owner;
import meow.springframework.petclinic.services.CrudService;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
    @Override
    public Set<Owner> findAll(){
        return super.findAll();
    }

    @Override
    public Owner findById(Long id){
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner){
        return super.save(owner.getId(), owner);
    }

    @Override
    public void delete(Owner owner){
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id){
        super.deleteById(id);
    }
}
