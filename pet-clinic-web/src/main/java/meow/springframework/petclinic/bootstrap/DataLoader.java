package meow.springframework.petclinic.bootstrap;

import meow.springframework.petclinic.model.*;
import meow.springframework.petclinic.services.OwnerService;
import meow.springframework.petclinic.services.PetTypeService;
import meow.springframework.petclinic.services.SpecialtiesService;
import meow.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtiesService specialtiesService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Chetra");
        owner1.setLastName("Seng");
        owner1.setCity("Battambang");
        owner1.setAddress("523 Chamkar Somroang");
        owner1.setTelephone("092823836");

        Pet chetraPet = new Pet();
        chetraPet.setPetType(savedDogType);
        chetraPet.setName("Tony");
        chetraPet.setBirthDate(LocalDate.now());
        chetraPet.setOwner(owner1);
        owner1.getPets().add(chetraPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sreykin");
        owner2.setLastName("Seng");
        owner2.setCity("Batambang");
        owner2.setTelephone("012345689");
        owner2.setAddress("523 Chamkar Somroang");

        Pet sreykinPet = new Pet();
        sreykinPet.setPetType(savedCatType);
        sreykinPet.setOwner(owner2);
        sreykinPet.setBirthDate(LocalDate.now());
        sreykinPet.setName("Meow");
        owner2.getPets().add(sreykinPet);
        ownerService.save(owner2);

        System.out.println("Added Owners...");

        Vet vet1 = new Vet();
        vet1.setLastName("John");
        vet1.setFirstName("Lisa");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setLastName("Vose");
        vet2.setFirstName("Emma");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Added Vets...");
    }
}
