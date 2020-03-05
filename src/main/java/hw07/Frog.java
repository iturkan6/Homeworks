package hw07;

public class Frog extends Pet implements Foul{
    public Frog(String nickname, int age, int TrickLevel, String[] habits) {
        super(nickname, age, TrickLevel, habits);
    }

    @Override
    public void respond() {

    }

    @Override
    public void foul() {

    }
}
