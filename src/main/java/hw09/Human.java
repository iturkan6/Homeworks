package hw09;


import java.util.HashMap;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private HashMap<DayOfWeek, String> schedule;

    public Human(String name, String surname, int year, int iq){
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }
    public Human(String name, String surname, int year, int iq, HashMap <DayOfWeek, String> schedule){
        this.name = name;
        this.surname = surname;
        this.year = year;
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
        return String.format("Human {name = %s, year = %d, iq = %d, schedule = %s }",
                name, year, iq, schedule);
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
