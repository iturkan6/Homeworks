package hw07;


import java.util.Arrays;

public abstract class Pet {
    protected Species species;
    protected String nickname;
    protected int age;
    protected int TrickLevel;
    protected String[] habits;


    public Pet(String nickname, int age, int TrickLevel, String[] habits){
        this.species = Species.UNKNOWN;
        //this.species = Species.valueOf(this.getClass().getSimpleName());
        this.nickname = nickname;
        this.age = age;
        this.TrickLevel = TrickLevel;
        this.habits = habits;
    }

    public void eat(){
        System.out.println("I am eating");
    }
    public abstract void respond();

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
        TrickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }
}
