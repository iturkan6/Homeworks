package hw10;



import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

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
            family.addChild(new Human(boyName, family.getFather().getSurname(), "21/03/2020", 0));
        } else if (c == 1) {
            family.addChild(new Human(girlName, family.getMother().getSurname(), "21/03/2020", 0));
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
        cf.getAllFamilies().forEach(family -> family.getChildren().removeIf(ch ->
                (LocalDateTime.now().getYear() - Instant.ofEpochMilli(ch.birthDate)
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime().getYear()) > number));
        }
}