package hw12;

import java.util.HashSet;

public abstract class Pet {
    protected Species species;
    protected String nickname;
    protected int age;
    protected int TrickLevel;
    protected HashSet<String> habits = new HashSet<String>();

    public Pet(){}
    public Pet(Species species, String nickname){
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String nickname, int age, int TrickLevel, HashSet <String> habits){
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
        this.age = age;
        this.TrickLevel = TrickLevel;
        this.habits = habits;

    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return TrickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.TrickLevel = trickLevel;
    }

    public HashSet<String> getHabits() {
        return habits;
    }

    public void setHabits(HashSet<String> habits) {
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I am eating!\n");
    }

    public void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!\n", nickname);
    }

    public void foul() {
        System.out.println("I need to cover it up\n");
    }

    public String toString() {
        return String.format("%s{nickname =  %s, age = %d, TrickLevel = %d, habits = %s}",
                species, nickname, age, TrickLevel, habits);
    }

}
