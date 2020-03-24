package hw09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {
    FamilyService familyService;

    @BeforeEach
    public void setUp(){
        this.familyService = new FamilyService();
    }

    @Test
    void createNewFamily() {
        familyService.createNewFamily(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100));
        String marina = familyService.getFamilyById(0).getMother().getName();
        assertEquals("Marina", marina);
    }

    @Test
    void displayAllFam() {
        Human mother = new Human("Marina", "Smith", 27, 100);
        Human father =  new Human("Rob", "Smith", 27, 100);
        familyService.createNewFamily(mother, father);
        List<Family> familyList1 = familyService.displayAllFam();
        List<Family> familyList2 = new ArrayList<>();
        familyList2.add(new Family(mother, father));
        assertEquals(familyList1, familyList2);
    }

    @Test
    void deleteFamilyByIndex() {
        Human mother = new Human("Marina", "Smith", 27, 100);
        Human father =  new Human("Rob", "Smith", 27, 100);
        Human mother2 = new Human("Mary", "Black", 27, 100);
        Human father2 = new Human("Bob", "Black", 27, 100);
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother2, father2);
        familyService.deleteFamilyByIndex(0);
        assertEquals(familyService.getFamilyById(0).getMother().getName(), "Mary");
    }



    @Test
    void adoptChild() {
        Human ch = new Human("Bob", "Smith", 2, 15, null);
        Human mother = new Human("Marina", "Smith", 27, 100);
        Human father = new Human("Rob", "Smith", 27, 100);
        familyService.createNewFamily(mother, father);
        familyService.adoptChild(familyService.getFamilyById(0), ch);
        assertEquals(familyService.getFamilyById(0).getChildren().get(0), ch);
    }

    @Test
    void count() {
        Human mother = new Human("Marina", "Smith", 27, 100);
        Human father = new Human("Rob", "Smith", 27, 100);
        familyService.createNewFamily(mother, father);
        int x = familyService.count();
        assertEquals(x, 1);
    }


    @Test
    void countFamiliesWithMemberNumber() {
        Human mother = new Human("Marina", "Smith", 27, 100);
        Human father = new Human("Rob", "Smith", 27, 100);
        familyService.createNewFamily(mother, father);
        int x = familyService.countFamiliesWithMemberNumber(2);
        assertEquals(1, x);

    }

    @Test
    void getFamilyById() {
        Human mother = new Human("Marina", "Smith", 27, 100);
        Human father = new Human("Rob", "Smith", 27, 100);
        familyService.createNewFamily(mother, father);
        String family = familyService.getFamilyById(0).getMother().getName();
        assertEquals(family, "Marina");
    }

    @Test
    void getPet() {
        Dog dog = new Dog("Mur", 2, 65, null);
        HashSet<Pet> pet = new HashSet<>();
        pet.add(dog);
        Human mother = new Human("Marina", "Smith", 27, 100);
        Human father = new Human("Rob", "Smith", 27, 100);
        familyService.createNewFamily(mother, father);
        familyService.addPet(0, dog);
        familyService.getPet(0).toArray();
        assertEquals(familyService.getPet(0), pet);
    }

    @Test
    void addPet() {
        Dog dog = new Dog("Mur", 2, 65, null);
        HashSet<Pet> pet = new HashSet<>();
        pet.add(dog);
        Human mother = new Human("Marina", "Smith", 27, 100);
        Human father = new Human("Rob", "Smith", 27, 100);
        familyService.createNewFamily(mother, father);
        familyService.addPet(0, dog);
        familyService.getPet(0);
        assertEquals(pet, familyService.getPet(0));
    }

    @Test
    void getPets() {
        Dog dog = new Dog("Mur", 2, 65, null);
        HashSet<Pet> pet = new HashSet<>();
        pet.add(dog);
        Human mother = new Human("Marina", "Smith", 27, 100);
        Human father = new Human("Rob", "Smith", 27, 100);
        familyService.createNewFamily(mother, father);
        familyService.addPet(0, dog);
        familyService.addPet(0, dog);
        assertEquals(familyService.getPets(0), pet);
    }

    @Test
    void deleteAllChildrenOlderThen() {
        Human ch = new Human("Bob", "Smith", 2, 15, null);
        Human ch1 = new Human("Kate", "Smith", 1, 15, null);
        Human mother = new Human("Marina", "Smith", 27, 100);
        Human father = new Human("Rob", "Smith", 27, 100);
        familyService.createNewFamily(mother, father);
        familyService.adoptChild(familyService.getFamilyById(0), ch);
        familyService.adoptChild(familyService.getFamilyById(0), ch1);
        familyService.deleteAllChildrenOlderThen(1);
        assertEquals(familyService.getFamilyById(0).getChildren().get(0), ch1);

    }
}