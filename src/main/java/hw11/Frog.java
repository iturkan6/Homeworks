package hw11;




import java.util.HashSet;

public class Frog extends Pet implements Foul {
    public Frog(String nickname, int age, int TrickLevel, HashSet<String> habits) {
        super(nickname, age, TrickLevel, habits);
    }

    @Override
    public void respond() {

    }

    @Override
    public void foul() {

    }
}
