package hw07;

public class DomesticCat extends Pet implements Foul {
    public DomesticCat(String nickname, int age, int TrickLevel, String[] habits) {
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
