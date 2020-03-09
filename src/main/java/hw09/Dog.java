package hw09;


import java.util.HashSet;

public class Dog extends Pet implements Foul {
    public Dog(String nickname, int age, int TrickLevel, HashSet<String> habits) {
        super(nickname, age, TrickLevel, habits);
        this.species = Species.Dog;

    }

    @Override
    public void respond() {
        System.out.printf("I am %s\n", nickname);
    }

    @Override
    public void foul() {

    }


}
