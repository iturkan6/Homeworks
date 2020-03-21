package hw09;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionFamilyDAOTest {
    CollectionFamilyDAO collectionFamilyDAO;

    @BeforeEach
    public void setUp(){
        this.collectionFamilyDAO = new CollectionFamilyDAO();
    }

    @Test
    void getAllFamilies() {
        HashSet<Pet> PET = new HashSet<>();
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        collectionFamilyDAO.families.add(f1);
        List<Family> families2 = collectionFamilyDAO.getAllFamilies();
        List<Family> families1 = collectionFamilyDAO.families;
        assertEquals(families2, families1);
    }

    @Test
    void getFamilyByIndex() {
        HashSet<Pet> PET = new HashSet<>();
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        collectionFamilyDAO.families.add(f1);
        Family family = collectionFamilyDAO.getFamilyByIndex(0);
        assertEquals(family, f1);
    }

    @Test
    void deleteFamily() {
        HashSet<Pet> PET = new HashSet<>();
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        collectionFamilyDAO.families.add(f1);
        Boolean a = collectionFamilyDAO.deleteFamily(0);
        assertTrue(a);
    }

    @Test
    void testDeleteFamily() {
        HashSet<Pet> PET = new HashSet<>();
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        collectionFamilyDAO.families.add(f1);
        Boolean b = collectionFamilyDAO.deleteFamily(f1);
        assertTrue(b);

    }

    @Test
    void saveFamily() {
        HashSet<Pet> PET = new HashSet<>();
        Family f1 = new Family(new Human("Marina", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        collectionFamilyDAO.saveFamily(f1);
        Family family1 = collectionFamilyDAO.families.get(0);
        assertEquals(family1, f1);
    }
}