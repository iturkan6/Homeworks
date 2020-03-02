package hw07;

public class Main {
    public static void main(String[] args) {
        RoboCat c = new RoboCat("Fred", 4, 100, new String[]{"read", "dance"});
        System.out.println(c.species);
        Frog f = new Frog("Froggi", 1, 1, new String[]{"Nothing"});
        System.out.println(f.species);
    }
}
