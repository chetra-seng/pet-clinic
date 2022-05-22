package meow.springframework.petclinic.services.springdatajpa;

import meow.springframework.petclinic.model.Owner;
import meow.springframework.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by chetra_seng on 22/5/22
 */
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastname("Seng").build();
    }

    @Test
    void findAll() {
        Set<Owner> returnOwners = new HashSet<>();
        returnOwners.add(Owner.builder().build());
        returnOwners.add(Owner.builder().build());

        Mockito.when(ownerRepository.findAll()).thenReturn(returnOwners);

        Set<Owner> owners = ownerSDJpaService.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(1L).build();
        Mockito.when(ownerRepository.save(Mockito.any())).thenReturn(returnOwner);
        Owner savedOwner = ownerSDJpaService.save(owner);
        assertNotNull(savedOwner);
    }

    @Test
    void findById() {
        Mockito.when(ownerRepository.findById(Mockito.any())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerSDJpaService.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound(){
        Mockito.when(ownerRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Owner owner = ownerSDJpaService.findById(1L);
        assertNull(owner);
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);
        Mockito.verify(ownerRepository).delete(Mockito.any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(Mockito.any());
        Mockito.verify(ownerRepository).deleteById(Mockito.any());
    }

    @Test
    void findByLastName() {
        String name = "Seng";
        Mockito.when(ownerRepository.findByLastName(ArgumentMatchers.any())).thenReturn(returnOwner);
        Owner owner = ownerSDJpaService.findByLastName(name);
        assertEquals(name, owner.getLastName());
        Mockito.verify(ownerRepository).findByLastName(ArgumentMatchers.any());
    }
}