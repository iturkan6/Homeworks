package hw07;

public class RoboCat extends Pet {

    public RoboCat(String nickname, int age, int TrickLevel, String[] habits) {
        super(nickname, age, TrickLevel, habits);
        this.species = Species.RoboCat;
    }

    @Override
    public void respond() {
        System.out.printf("I am %s\n", nickname);
    }


}
