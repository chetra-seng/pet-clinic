package meow.springframework.petclinic.services.springdatajpa;

import meow.springframework.petclinic.model.Specialty;
import meow.springframework.petclinic.repositories.SpecialtyRepository;
import meow.springframework.petclinic.services.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chetra_seng on 14/5/22
 */
@Profile("springdatajpa")
@Service
public class SpecialtySDJpaService implements SpecialtiesService {
    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
