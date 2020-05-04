package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetMapServiceTest {

    private PetMapService petMapService;
    private final Pet pet = Pet.builder().name("Nikky").build();

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(pet);
    }

    @Test
    void findAll() {
        Set<Pet> found = petMapService.findAll();
        assertEquals(1, found.size());
    }

    @Test
    void findById() {
        Long petId = pet.getId();
        Pet foundPet = petMapService.findById(petId);
        assertEquals(petId, foundPet.getId());
    }

    @Test
    void save() {
        Pet anotherPet = Pet.builder().name("Stark").build();
        Pet savedPet = petMapService.save(anotherPet);
        assertEquals(savedPet.getId(), anotherPet.getId());
    }

    @Test
    void delete() {
        petMapService.delete(pet);
        int foundedSize = petMapService.findAll().size();
        assertEquals(0,foundedSize);
    }

    @Test
    void deleteById() {
        Long petId = pet.getId();
        petMapService.deleteById(petId);
        int foundedSize = petMapService.findAll().size();
        assertEquals(0,foundedSize);
    }
}