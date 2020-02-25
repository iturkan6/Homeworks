package hw04;

public class Main {
    public static void main(String[] args) {
        Human humanF = new Human("Tom", "Smith", 27);
        Human humanM = new Human("Marry", "Smith", 1995);
        Human humanC = new Human("Bob", "Smith", 1993);
        Pet PET = new Pet("dog", "Lola", 2, 75, new String[]{"Sleep", "Eat"});
        humanC.mother = humanM;
        humanC.father = humanF;
        //PET.age = 2;
        //PET.TrickLevel = 75;
        humanC.PET = PET;
        System.out.println( humanC.toString());
        humanC.describePet();
        humanC.greetPet();
        PET.eat();
        PET.respond();
        PET.foul();
        System.out.println(PET.toString());
    }
}
