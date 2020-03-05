package hw06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

private Family family;

    @BeforeEach
    void setUp(){
        this.family = new Family();
    }

    @Test
    void testToStringF() {
        Family t1 = new Family(new Human("Marry", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100),new Human[]{},
                new Pet(Species.Dog, "Lola", 2, 75, new String[]{"Sleep", "Eat"}));
        String t2 = "Family{mother = Human {name = Marry, year = 27, iq = 100, schedule = null }," +
                " father = Human {name = Rob, year = 27, iq = 100, schedule = null }, children = [], " +
                "pet = Dog{nickname =  Lola, age = 2, TrickLevel = 75, habits = [Sleep, Eat]}}";
        assertEquals(t1.toString(), t2);
    }
    @Test
    void testToStringH() {
        Human h1 = new Human("Marry", "Smith", 27, 100);
        String h2 = "Human {name = Marry, year = 27, iq = 100, schedule = null }";
        assertEquals(h1.toString(), h2);
    }

    @Test
    void testToStringP() {
        Pet p1 = new Pet(Species.Dog, "Lola", 2, 75, new String[]{"Sleep", "Eat"});
        String p2 = "Dog{nickname =  Lola, age = 2, TrickLevel = 75, habits = [Sleep, Eat]}";
        assertEquals(p1.toString(), p2);
    }

    @Test
    void addChild1() {
        int a = 2;
        family.addChild(new Human("ff", "fff", 2, 2));
        family.addChild(new Human("aa", "fff", 2, 2));
        int b = family.getChildren().length;
        assertEquals(a, b);
    }

    @Test
    void addChild2() {
        family.addChild(new Human("ff", "fff", 2, 2));
        family.addChild(new Human("aa", "fff", 2, 2));
        String name = family.getChildren()[1].getName();
        String name2 = "aa";
        assertEquals(name, name2);
    }

    @Test
    void deleteChild1() {
        family.addChild(new Human("sss", "ddd", 2, 12));
        boolean c1 = family.deleteChild(0);
        assertTrue(c1);
    }

    @Test
    void deleteChild2(){
        family.addChild(new Human("sss", "ddd", 2, 12));
        boolean c1 = family.deleteChild(1);
        assertFalse(c1);
    }

    @Test
    void countFamily() {
        int count = family.countFamily();
        int count2 = 2;
        assertEquals(count, count2);
    }
}