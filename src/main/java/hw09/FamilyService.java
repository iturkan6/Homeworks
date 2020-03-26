package hw09;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FamilyService {
    private FamilyDAO<Family> cf = new CollectionFamilyDAO();

    public void createNewFamily(Human mother, Human father){
        cf.saveFamily(new Family(mother, father));
    }
    public List<Family> displayAllFam(){
        return cf.getAllFamilies();
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
        int index = cf.getAllFamilies().indexOf(family);
        cf.getFamilyByIndex(index).getChildren().add(child);
    }

    public int count (){
        return cf.getAllFamilies().size();
    }

    public List<Family> getFamiliesBiggerThan(int number) {
        List<Family> familyList = new ArrayList<>();
        for (Family c : cf.getAllFamilies()) {
            if (c.countFamily() > number) {
                familyList.add(c);
            }
        }
        return familyList;
    }
    public List<Family> getFamiliesLessThan(int number) {
        List<Family> familyList = new ArrayList<>();
        for (Family c : cf.getAllFamilies()) {
            if (c.countFamily() < number) {
                familyList.add(c);
            }
        }
        return familyList;
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
    public HashSet<Pet> getPet(int index){
       return cf.getFamilyByIndex(index).getPet();
    }
    public void addPet(int index, Pet pet){
        cf.getFamilyByIndex(index).addPet(pet);
    }
    public HashSet<Pet> getPets(int index){
        return cf.getFamilyByIndex(index).getPet();
    }
    public void deleteAllChildrenOlderThen(int number) {
        cf.getAllFamilies().forEach(family -> {
            List<Human> children = family.getChildren();
            children.removeIf(c -> c.getYear() > number);
            cf.saveFamily(family);
        });
    }
}