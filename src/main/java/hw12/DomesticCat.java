package hw12;



import java.util.HashSet;

public class DomesticCat extends Pet implements Foul {
    public DomesticCat(String nickname, int age, int TrickLevel, HashSet<String> habits) {
        super(nickname, age, TrickLevel, habits);
        this.species = Species.DomesticCat;
    }

    @Override
    public void respond() {
        System.out.printf("I am %s\n", nickname);
    }

    @Override
    public void foul() {

    }


}
