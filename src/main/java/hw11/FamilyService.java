package hw11;




import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FamilyService {
    FamilyDAO<Family> cf = new CollectionFamilyDAO();

    public void createNewFamily(Human mother, Human father){
        cf.saveFamily(new Family(mother, father));
    }

    public String displayAllFam(){
        return cf.getAllFamilies().stream().map(String::valueOf).collect(Collectors.joining());
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
//        cf.getAllFamilies().iterator().next().addChild(child);
        int index = cf.getAllFamilies().indexOf(family);
        cf.getFamilyByIndex(index).getChildren().add(child);
    }

    public int count (){
        return cf.getAllFamilies().size();
    }

    public List<Family> getFamiliesBiggerThan(int number) {
        return cf.getAllFamilies().stream().filter(c -> c.getCount() > number).collect(Collectors.toList());
    }
    public List<Family> getFamiliesLessThan(int number) {
        return cf.getAllFamilies().stream().filter(c -> c.getCount() < number).collect(Collectors.toList());
    }
    public int countFamiliesWithMemberNumber(int number) {
        return (int) cf.getAllFamilies().stream().filter(c -> c.countFamily() == number).count();
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