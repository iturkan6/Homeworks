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
        HashSet<Pet> PET = new HashSet<>();
        familyService.createNewFamily(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100));
        String marina = familyService.cf.getFamilyByIndex(0).getMother().getName();
        assertEquals("Marina", marina);
    }

    @Test
    void displayAllFam() {
        HashSet<Pet> PET = new HashSet<>();
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        familyService.cf.getAllFamilies().add(f1);
        List<Family> familyList1 = familyService.displayAllFam();
        List<Family> familyList2 = familyService.cf.getAllFamilies();
        assertEquals(familyList1, familyList2);
    }

    @Test
    void deleteFamilyByIndex() {
        HashSet<Pet> PET = new HashSet<>();
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        Family f2 = new Family(new Human("Mary", "Black", 27, 100),
                new Human("Bob", "Black", 27, 100), new ArrayList<Human>(), PET);
        familyService.cf.getAllFamilies().add(f1);
        familyService.cf.getAllFamilies().add(f2);
        familyService.deleteFamilyByIndex(0);
        assertEquals(familyService.cf.getAllFamilies().get(0), f2);
    }



    @Test
    void adoptChild() {
        HashSet<Pet> PET = new HashSet<>();
        Human ch = new Human("Bob", "Smith", 2, 15, null);
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        familyService.cf.getAllFamilies().add(f1);
        familyService.adoptChild(f1, ch);
        assertEquals(familyService.cf.getAllFamilies().get(0).getChildren().get(0), ch);
    }

    @Test
    void count() {
        HashSet<Pet> PET = new HashSet<>();
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        Family f2 = new Family(new Human("Mary", "Black", 27, 100),
                new Human("Bob", "Black", 27, 100), new ArrayList<Human>(), PET);
        familyService.cf.getAllFamilies().add(f1);
        familyService.cf.getAllFamilies().add(f2);
        int x = familyService.count();
        assertEquals(x, 2);
    }


    @Test
    void countFamiliesWithMemberNumber() {
        HashSet<Pet> PET = new HashSet<>();
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        Family f2 = new Family(new Human("Mary", "Black", 27, 100),
                new Human("Bob", "Black", 27, 100), new ArrayList<Human>(), PET);
        familyService.cf.getAllFamilies().add(f1);
        familyService.cf.getAllFamilies().add(f2);
        int x = familyService.countFamiliesWithMemberNumber(2);
        assertEquals(2, x);

    }

    @Test
    void getFamilyById() {
        HashSet<Pet> PET = new HashSet<>();
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        familyService.cf.getAllFamilies().add(f1);
        Family family = familyService.getFamilyById(0);
        assertEquals(family, f1);
    }

    @Test
    void getPet() {
        HashSet<Pet> PET = new HashSet<>();
        Dog dog = new Dog("Mur", 2, 65, null);
        PET.add(dog);
        HashSet<Pet> dog1 = new HashSet<>();
        dog1.add(dog);
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        familyService.cf.getAllFamilies().add(f1);
        familyService.getPet(0).toArray();
        assertEquals(familyService.getPet(0), dog1);
    }

    @Test
    void addPet() {
        HashSet<Pet> PET = new HashSet<>();
        Dog dog = new Dog("Mur", 2, 65, null);
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        familyService.cf.getAllFamilies().add(f1);
        familyService.addPet(0, dog);
        familyService.getPet(0);
        assertEquals(PET, familyService.getPet(0));
    }

    @Test
    void getPets() {
        HashSet<Pet> PET = new HashSet<>();
        Dog dog = new Dog("Mur", 2, 65, null);
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        familyService.cf.getAllFamilies().add(f1);
        familyService.addPet(0, dog);
        assertEquals(familyService.getPets(0), PET);
    }

    @Test
    void deleteAllChildrenOlderThen() {
        HashSet<Pet> PET = new HashSet<>();
        Human ch = new Human("Bob", "Smith", 2, 15, null);
        Human ch1 = new Human("Kate", "Smith", 1, 15, null);
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        familyService.cf.getAllFamilies().add(f1);
        familyService.adoptChild(f1, ch);
        familyService.adoptChild(f1, ch1);
        familyService.deleteAllChildrenOlderThen(1);
        assertEquals(familyService.cf.getAllFamilies().get(0).getChildren().get(0), ch1);

    }
}