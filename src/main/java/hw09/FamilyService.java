package hw09;

import java.util.*;

public class FamilyService {
    FamilyDAO<Family> cf = new CollectionFamilyDAO();

    public void createNewFamily(Human mother, Human father){
        cf.saveFamily(new Family(mother, father));
    }
    public void displayAllFamilies(){
        System.out.println(cf.getAllFamilies());
    }
    public void deleteFamilyByIndex(int index){
        cf.deleteFamily(index);
    }

    public void bornChild(Family family, String girlName, String boyName) {
        Random random = new Random();
        int c = random.nextInt(2);
        if (c == 0) {
            family.addChild(new Human(boyName, family.getFather().getSurname(), 0, 0));
        } else if (c == 1) {
            family.addChild(new Human(girlName, family.getMother().getSurname(), 0, 0));
        }
    }

    public void adoptChild(Family family, Human child) {
        family.addChild(child);
    }

    public int count (){
        return cf.getAllFamilies().size();
    }

    public void getFamiliesBiggerThan(int number) {
        for (Family c : cf.getAllFamilies()) {
            if (c.getCount() > number) {
                System.out.println(c);
            }
        }
    }
    public void getFamiliesLessThan(int number) {
        for (Family c : cf.getAllFamilies()) {
            if (c.getCount() < number) {
                System.out.println(c);
            }
        }
    }
    public int countFamiliesWithMemberNumber(int number) {
        int s = 0;
        for (Family c : cf.getAllFamilies()) {
            if (c.countFamily() == number) {
                s++;
            }
        }
        return s;
    }
    public Family getFamilyById(int index){
        return cf.getFamilyByIndex(index);
    }
    public void getPet(int index){
        System.out.println(cf.getFamilyByIndex(index).getPet());
    }
    public void addPet(int index, Pet pet){
//        cf.families.get(index).addPet(pet);
        cf.getFamilyByIndex(index).addPet(pet);
    }
    public HashSet<Pet> getPets(int index){
//        return cf.families.get(index).getPET();
        return cf.getFamilyByIndex(index).getPet();
    }
    public void deleteAllChildrenOlderThen(int number){
        for (Family c : cf.getAllFamilies()) {
            for (Human b : c.getChildren())
            if (b.getYear() == number){
                c.deleteChild(b);
            }
        }
    }
}