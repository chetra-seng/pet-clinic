package meow.springframework.petclinic.bootstrap;

import meow.springframework.petclinic.model.Owner;
import meow.springframework.petclinic.model.Vet;
import meow.springframework.petclinic.services.OwnerService;
import meow.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Chetra");
        owner1.setLastName("Seng");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Sreykin");
        owner2.setLastName("Seng");
        ownerService.save(owner2);

        System.out.println("Added Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setLastName("John");
        vet1.setFirstName("Lisa");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setLastName("Vose");
        vet2.setFirstName("Emma");
        vetService.save(vet2);

        System.out.println("Added Vets...");
    }
}
