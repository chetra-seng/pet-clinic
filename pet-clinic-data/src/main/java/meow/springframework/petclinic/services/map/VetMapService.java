package meow.springframework.petclinic.services.map;

import meow.springframework.petclinic.model.Vet;
import meow.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll(){
        return super.findAll();
    }

    @Override
    public Vet findById(Long id){
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet){
        return super.save(vet);
    }

    @Override
    public void delete(Vet vet){
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id){
        super.deleteById(id);
    }
}
