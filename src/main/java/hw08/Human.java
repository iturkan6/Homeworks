package hw08;


import java.util.Arrays;
import java.util.HashMap;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
//    private String [] [] schedule;
    private Family family;
     HashMap<DayOfWeek, String> schedule;
    //private Pet PET = new Pet();


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
//       HashMap<String, String> schedule = new HashMap <String, String>();
//        schedule.put( DayOfWeek.Sunday.name(), "do homework");
//        schedule.put(DayOfWeek.Monday.name(), "go to course");
//        schedule.put(DayOfWeek.Tuesday.name(), "go to academy");
//        schedule.put(DayOfWeek.Wednesday.name(), "watch a film");
//        schedule.put(DayOfWeek.Thursday.name(), "read a book");
//        schedule.put(DayOfWeek.Friday.name(), "go to gym");
//        schedule.put(DayOfWeek.Saturday.name(), "rest");
//        System.out.println(schedule);
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
            System.out.printf("Hello %s", family.getPET().iterator().next().getNickname());
        //System.out.println(Arrays.toString(schedule));
    }

    public void describePet(){
        String sly;
        if ( family.getPET().iterator().next().getTrickLevel() > 50 ) {
            sly = "very sly ";
        }else{
            sly = "almost not sly ";
        }
        System.out.printf("I have %s, he is %d years old, he is %s\n", family.getPET().iterator().next().getSpecies(),
                family.getPET().iterator().next().getAge(), sly);
    }

    public String toString() {

        return String.format("Human {name = %s, year = %d, iq = %d, schedule = %s }",
                name, year, iq, schedule);
    }
}
