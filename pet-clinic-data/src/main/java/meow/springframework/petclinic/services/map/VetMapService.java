package meow.springframework.petclinic.services.map;

import meow.springframework.petclinic.model.Specialty;
import meow.springframework.petclinic.model.Vet;
import meow.springframework.petclinic.services.SpecialtiesService;
import meow.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtiesService specialtiesService;

    public VetMapService(SpecialtiesService specialtyService) {
        this.specialtiesService = specialtyService;
    }

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
        if(vet.getSpecialties().size() > 0){
            vet.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null){
                    Specialty savedSpecialty = specialtiesService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
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
