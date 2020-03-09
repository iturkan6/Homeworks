package hw09;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        HashMap<DayOfWeek, String> schedule = new HashMap<DayOfWeek, String>();
        schedule.put( DayOfWeek.Sunday, "do homework");
        schedule.put(DayOfWeek.Monday, "go to course");
        schedule.put(DayOfWeek.Tuesday, "go to academy");
        schedule.put(DayOfWeek.Wednesday, "watch a film");
        schedule.put(DayOfWeek.Thursday, "read a book");
        schedule.put(DayOfWeek.Friday, "go to gym");
        schedule.put(DayOfWeek.Saturday, "rest");

        HashSet<Pet> PET = new HashSet<>();
        PET.add(new Dog("Lola", 2, 75, new HashSet<String>(Arrays.asList("Sleep", "Eat"))));
        PET.add(new DomesticCat("f", 4, 4, new HashSet<String>(Arrays.asList("Sleep", "Eat"))));

        Human ch = new Human("Bob", "Smith", 2, 15, schedule);
        Family smith = new Family(new Human("Marry", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);
        Human Carl = new Human("Carl", "Ivanov", 13, 70);

        smith.addChild(ch);
        System.out.println(ch.toString());
        ch.describePet();
        ch.greetPet();
        smith.getPet().iterator().next().eat();
        smith.getPet().iterator().next().respond();
        smith.getPet().iterator().next().foul();
        System.out.println(smith.getPet().toString());

        smith.addChild(new Human("Mark", "Smith", 1, 1));
        System.out.println(smith.deleteChild(5));
        System.out.println(smith.toString());
        System.out.println(smith.countFamily());


        FamilyController fc = new FamilyController();
        fc.createNewFamily(new Human("Minie", "Mouse", 25, 80),
                new Human("Mickey", "Mouse", 25, 100));
        fc.bornChild(fc.getFamilyById(0), "Manie", "Michael");
        fc.addPet(0, new RoboCat("Spike", 5, 99, new HashSet<String>(Arrays.asList("Sleep", "Eat"))));
        System.out.println(fc.getFamilyById(0));
        fc.createNewFamily(new Human("Katya", "Ivanova", 30, 58),
                new Human("Petya", "Ivanov", 35, 70));
        fc.bornChild(fc.getFamilyById(1), "Ira", "Ivan");
        System.out.println(fc.getFamilyById(1));
        fc.adoptChild(fc.getFamilyById(1), Carl );
        System.out.println(fc.getFamilyById(1));
        System.out.println(fc.countFamiliesWithMemberNumber(3));
        fc.getFamiliesBiggerThan(3);
        fc.getFamiliesLessThan(4);
        fc.addPet(1, new DomesticCat("Murzik", 7, 30, null));
        System.out.println(fc.getFamilyById(1));
        System.out.println(fc.getPets(0));
       fc.deleteFamilyByIndex(1);
        fc.displayAllFamilies();
    }

}
