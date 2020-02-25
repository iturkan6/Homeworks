package hw04;

public class Human {
    String name;
    String surname;
    int year;
    int iq;
    //Pet pet;
    Human mother;
    Human father;
    String[][] schedule;
    Pet PET = new Pet();

    Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human() {
    }

    public Human( String name, String surname, int year, int iq, Human mother, Human father, String schedule[][]) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.mother = mother;
        this.father = father;
    }

    public void greetPet() {
        System.out.printf("Hello %s\n", PET.nickname);
    }

    public void describePet() {
        String sly;
        if (PET.trickLevel > 50) {
            sly = "very sly ";
        } else {
            sly = "almost not sly ";
        }
        System.out.printf("I have %s, he is %d years old, he is %s\n", PET.species, PET.age, sly);
    }

    public String toString() {
        return String.format("Human {name = %s, surname = %s, year = %d, iq = %d, mother = %s, father = %s, pet = %s}",
                name, surname, year, iq, mother, father, PET.toString());

    }
}
