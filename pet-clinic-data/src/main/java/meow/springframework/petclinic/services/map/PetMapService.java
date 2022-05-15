package meow.springframework.petclinic.services.map;

import meow.springframework.petclinic.model.Pet;
import meow.springframework.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Profile({"default", "map"})
@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll(){
        return super.findAll();
    }

    @Override
    public Pet findById(Long id){
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet){
        return super.save(pet);
    }

    @Override
    public void delete(Pet pet){
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id){
        super.deleteById(id);
    }
}
