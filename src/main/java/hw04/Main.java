package hw04;

public class Main {
    public static void main(String[] args) {
        Human humanf = new Human("Tom", "Smith", 27);
        Human humanm = new Human("Marry", "Smith", 1995);
        Human humanc = new Human("Bob", "Smith", 1993);
        humanc.mother = humanm;
        humanc.father = humanf;
        Pet PET = new Pet("dog", "Lola");
        PET.age = 2;
        PET.TrickLevel = 75;
        humanc.PET = PET;
        humanc.describePet();
        System.out.println( humanc.toString());

    }
}
