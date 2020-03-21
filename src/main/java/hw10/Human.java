package hw10;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private HashMap<DayOfWeek, String> schedule;
    long birthDate;

    public Human(String name, String surname, String birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(birthDate);
            this.birthDate = date.getTime();
        } catch (ParseException ex) {
            System.out.println("Wrong format");
        }
        this.iq = iq;
    }
    public Human(String name, String surname, String birthDate, int iq, HashMap <DayOfWeek, String> schedule){
        this.name = name;
        this.surname = surname;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(birthDate);
            this.birthDate = date.getTime();
        }catch (ParseException ex) {
            System.out.println("Wrong format");
        }
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human(){}



    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public void greetPet(){
            System.out.printf("Hello %s\n", family.getPet().iterator().next().getNickname());
        //System.out.println(Arrays.toString(schedule));
    }

    public void describePet(){
        String sly;
        if ( family.getPet().iterator().next().getTrickLevel() > 50 ) {
            sly = "very sly ";
        }else{
            sly = "almost not sly ";
        }
        System.out.printf("I have %s, he is %d years old, he is %s\n", family.getPet().iterator().next().getSpecies(),
                family.getPet().iterator().next().getAge(), sly);
    }

    public String toString() {
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String form = date.format(birthDate);
        return String.format("Human {name = %s, birth day = %s, iq = %d, schedule = %s }",
                name, form, iq, schedule);
    }

    public void describeAge(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year &&
                iq == human.iq &&
                name.equals(human.name) &&
                surname.equals(human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq);
    }
}
