package hw05;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Human humanF = new Human("Tom", "Smith", 1972);
////        Human humanM = new Human("Marry", "Smith", 1972);
////        Human humanC = new Human("Bob", "Smith", 1993);
        Human ch = new Human("Bob", "Smith", 2, 15,
                new String[][]{{"Sunday", "do homework"}, {"Monday", "go to course"}});
        Pet PET = new Pet("dog", "Lola", 2, 75, new String[]{"Sleep", "Eat"});
        System.out.println(ch.toString());
        //humanC.describePet();
        PET.eat();
        PET.respond();
        PET.foul();
        System.out.println(PET.toString());

        Family family = new Family(new Human("M", "n", 27, 100),
                new Human("P", "p", 27, 100), new Human[]{ch});

        System.out.println(family.toString());

        family.addChild(new Human("MArk", "smith", 1, 1));
    }
}

