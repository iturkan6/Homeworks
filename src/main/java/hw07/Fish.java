package hw07;

public class Fish extends Pet implements Foul{
    public Fish(String nickname, int age, int TrickLevel, String[] habits) {
        super(nickname, age, TrickLevel, habits);
        this.species = Species.Fish;
    }


    @Override
    public void respond() {
        System.out.printf("I am %s\n", nickname);
    }

    @Override
    public void foul() {

    }
}
