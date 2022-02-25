package meow.springframework.petclinic.bootstrap;

import meow.springframework.petclinic.model.Owner;
import meow.springframework.petclinic.model.Pet;
import meow.springframework.petclinic.model.PetType;
import meow.springframework.petclinic.model.Vet;
import meow.springframework.petclinic.services.OwnerService;
import meow.springframework.petclinic.services.PetTypeService;
import meow.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Chetra");
        owner1.setLastName("Seng");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sreykin");
        owner2.setLastName("Seng");
        ownerService.save(owner2);

        System.out.println("Added Owners...");

        Vet vet1 = new Vet();
        vet1.setLastName("John");
        vet1.setFirstName("Lisa");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setLastName("Vose");
        vet2.setFirstName("Emma");
        vetService.save(vet2);

        System.out.println("Added Vets...");
    }
}
