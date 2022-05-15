package meow.springframework.petclinic.services.map;

import meow.springframework.petclinic.model.Owner;
import meow.springframework.petclinic.model.Pet;
import meow.springframework.petclinic.services.OwnerService;
import meow.springframework.petclinic.services.PetService;
import meow.springframework.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Profile({"default", "map"})
@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

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
        if(owner != null){
            if (owner.getPets() != null){
                owner.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else{
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(pet.getId() == null){
                        Pet savePet = petService.save(pet);
                        pet.setId(savePet.getId());
                    }
                });
            }

            return super.save(owner);
        }
        else{
            return null;
        }
    }

    @Override
    public void delete(Owner owner){
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id){
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
