package hw10;

import java.lang.management.GarbageCollectorMXBean;
import java.util.Date;
import java.util.GregorianCalendar;

public final class Man extends Human{
    public Man(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
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
