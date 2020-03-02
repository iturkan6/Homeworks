package hw07;

public class Fish extends Pet {
    public Fish(String nickname, int age, int TrickLevel, String[] habits) {
        super(nickname, age, TrickLevel, habits);
        this.species = Species.Fish;
    }


    @Override
    public void respond() {
        System.out.printf("I am %s\n", nickname);
    }

}
