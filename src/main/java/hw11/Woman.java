package hw11;


public final class Woman extends Human {

    public Woman(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public void makeup(){
        System.out.println("I am beautiful");
    }
}
