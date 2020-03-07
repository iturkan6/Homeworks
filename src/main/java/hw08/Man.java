package hw08;

public final class Man extends Human {
    public Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }
    public void repairCar(){
        System.out.println("Repaired");
    }

}
