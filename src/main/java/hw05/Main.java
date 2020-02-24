package hw05;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Human ch = new Human("Bob", "Smith", 2, 15,
                new String[][]{{"Sunday", "do homework"}, {"Monday", "go to course"}});
        Pet PET = new Pet("dog", "Lola", 2, 75, new String[]{"Sleep", "Eat"});
        ch.PET = PET;
        System.out.println(ch.toString());
        ch.describePet();
        PET.eat();
        PET.respond();
        PET.foul();
        System.out.println(PET.toString());

        Family family = new Family(new Human("Marry", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new Human[]{ch});

        family.addChild(new Human("Mark", "Smith", 1, 1));
        System.out.println(family.deleteChild());
        System.out.println(family.toString());

    }
}

