package hw09;

public final class Man extends Human {
    public Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }


//    public Man(String name, String surname, int year, int iq) {
//        name = this.getName();
//        surname = this.getSurname();
//        year = 0;
//
//    }

    public void repairCar(){
        System.out.println("Repaired");
    }

}
