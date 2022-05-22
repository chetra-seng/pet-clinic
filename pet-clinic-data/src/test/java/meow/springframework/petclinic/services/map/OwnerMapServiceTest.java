package meow.springframework.petclinic.services.map;

import meow.springframework.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by chetra_seng on 22/5/22
 */
class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    Long id = 1L;
    String name = "Seng";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(1L).lastname(name).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(id);
        assertEquals(1L, owner.getId());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        ownerMapService.save(owner);
        assertEquals(id, owner.getId());
    }

    @Test
    void saveNoId(){
        Owner owner = ownerMapService.save(Owner.builder().build());
        assertNotNull(owner);
        assertNotNull(owner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(id));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(id);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(name);
        assertEquals("Seng", owner.getLastName());
    }

    @Test
    void findByLastNameNotFound(){
        Owner owner = ownerMapService.findByLastName("meow");
        assertNull(owner);
    }
}