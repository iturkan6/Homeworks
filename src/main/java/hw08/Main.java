package hw08;

import java.util.*;

import static javax.swing.UIManager.put;

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
        Family family = new Family(new Human("Marry", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new ArrayList<Human>(), PET);

        family.addChild(ch);
        System.out.println(ch.toString());
        ch.describePet();
        ch.greetPet();
        family.getPET().iterator().next().eat();
        family.getPET().iterator().next().respond();
        family.getPET().iterator().next().foul();
        System.out.println(family.getPET().toString());

        family.addChild(new Human("Mark", "Smith", 1, 1));
        System.out.println(family.deleteChild(5));
        System.out.println(family.toString());
        System.out.println(family.countFamily());

    }
}
