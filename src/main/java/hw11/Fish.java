package hw11;


import java.util.HashSet;

public class Fish extends Pet implements Foul {
    public Fish(String nickname, int age, int TrickLevel, HashSet <String> habits) {
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
