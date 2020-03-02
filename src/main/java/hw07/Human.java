package hw07;


public class Human {

    private String name;
    private String surname;
    private int year;
    private int iq;

    public Human(String name, String surname, int year, int iq){
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }

    public void greetPet(){
        System.out.println("Hello pet");
    }
}
