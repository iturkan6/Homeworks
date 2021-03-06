package hw05;

import java.util.Arrays;

public class Human {

    private String name;
    private String surname;
    private int year;
    private int iq;
    private String [] [] schedule;
    private Family family;

    public Human(String name, String surname, int year, int iq){
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }
    public Human(String name, String surname, int year, int iq, String[][] schedule){
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
        System.out.printf("Hello %s\n", family.getPET().getNickname());
    }

    public void describePet(){
        String sly;
        if (family.getPET().getTrickLevel() > 50 ) {
            sly = "very sly ";
        }else{
            sly = "almost not sly ";
        }
        System.out.printf("I have %s, he is %d years old, he is %s\n", family.getPET().getSpecies(), family.getPET().getAge(), sly);
    }

    public String toString() {

        return String.format("Human {name = %s, year = %d, iq = %d, schedule = %s }",
                name, year, iq, Arrays.deepToString(schedule));
    }
}
