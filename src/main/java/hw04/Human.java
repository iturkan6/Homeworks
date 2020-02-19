package hw04;

public class Human {
    String name;
    String surname;
    int year;
    int iq;
    //Pet pet;
    Human mother;
    Human father;
    String [] [] schedule;
    Pet PET = new Pet();

    Human(String name, String surname, int year){
        this.name = name;
        this.surname = surname;
        this.year = year;
    }
    Human(String name, String surname, int year, Human mother, Human father){
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }
    public Human(){}

    public Human(int year, int iq, Human mother, Human father, String schedule[][]){
       this.year = year;
       this.iq = iq;
       this.mother = mother;
       this.father = father;
    }

    public void greetPet(String kitty){
        System.out.printf("Hello %s", PET.nickname);
    }
    public void describePet(){
        String sly;
        if (PET.TrickLevel > 50 ) {
            sly = "very sly ";
        }else{
                sly = "almost not sly ";
            }
        System.out.printf("I have %s, he is %d years old, he is %s", PET.species, PET.age, sly);
    }
    public String toString() {
        return String.format("Human {name = " +  name + " year =" + year + " iq = "+ iq + " mother =" + mother +
                " father =" + father + " pet =" + PET.toString() + "}");
    }
}
