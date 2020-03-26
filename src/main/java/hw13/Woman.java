package hw13;


import java.text.ParseException;

public final class Woman extends Human {

    public Woman(String name, String surname, String birthDate, int iq) throws ParseException {
        super(name, surname, birthDate, iq);
    }

    public void makeup(){
        System.out.println("I am beautiful");
    }
}
