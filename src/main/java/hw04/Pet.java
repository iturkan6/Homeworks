package hw04;

import java.util.Arrays;

public class Pet {
    String species;
    String nickname;
    int age;
    int trickLevel;
    String[] habits;

    public Pet(){}

    Pet(String species, String nickname){
        this.species = species;
        this.nickname = nickname;
    }

    Pet(String species, String nickname, int age, int trickLevel, String[] habits){
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I am eating!");
    }

    public void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!", nickname);
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }

    public String toString() {
        return String.format("%s{nickname =  %s, age = %d, TrickLevel = %d, habits = %s}",
                species, nickname, age, trickLevel, Arrays.toString(habits));
    }
}