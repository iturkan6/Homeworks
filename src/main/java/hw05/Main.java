package hw05;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Human ch = new Human("Bob", "Smith", 2, 15,
                new String[][]{{"Sunday", "do homework"}, {"Monday", "go to course"}});
        //Pet PET = new Pet("dog", "Lola", 2, 75, new String[]{"Sleep", "Eat"});
        Family family = new Family(new Human("Marry", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100),
                new Pet("Dog", "Lola", 2, 75, new String[]{"Sleep", "Eat"}));
        family.addChild(ch);
        family.getChildren()[0].greetPet();
        System.out.println(ch.toString());
        ch.describePet();
        family.getPET().eat();
        family.getPET().respond();
        family.getPET().foul();
        System.out.println(family.getPET().toString());



        family.addChild(new Human("Mark", "Smith", 1, 1));
        System.out.println(family.deleteChild(1));
        System.out.println(family.toString());

    }
}

