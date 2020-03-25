package hw12;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FamilyService {
    FamilyDAO<Family> cf = new CollectionFamilyDAO();

    public void createNewFamily(Human mother, Human father){
        cf.saveFamily(new Family(mother, father));
    }

    public String getAllFamilies(){
        StringBuilder sb = new StringBuilder();
        for (Family family : cf.getAllFamilies()) {
            String prettyFormat = family.prettyFormat();
            sb.append(prettyFormat);
        }
        return sb.toString();
    }


    public void deleteFamilyByIndex(int index){
        cf.deleteFamily(index);
    }

    public void bornChild(Family family, String girlName, String boyName) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Random random = new Random();
        int c = random.nextInt(2);
        if (c == 0) {
            family.addChild(new Human(boyName, family.getFather().getSurname(), LocalDateTime.now().
                    toLocalDate().format(formatter), 0));
        } else if (c == 1) {
            family.addChild(new Human(girlName, family.getMother().getSurname(), LocalDateTime.now().
                    toLocalDate().format(formatter), 0));
        }
    }

    public void adoptChild(Family family, Human child) {
        cf.getFamilyByIndex(cf.getAllFamilies().indexOf(family)).addChild(child);
    }

    public int count (){
        return cf.getAllFamilies().size();
    }

    public List<Family> getFamiliesBiggerThan(int number) {
        List<Family> list = new ArrayList<>();
        for (Family c : cf.getAllFamilies()) {
            if (c.countFamily() > number) {
                list.add(c);
            }
        }
        return list;
    }
    public List<Family> getFamiliesLessThan(int number) {
        List<Family> list = new ArrayList<>();
        for (Family c : cf.getAllFamilies()) {
            if (c.countFamily() < number) {
                list.add(c);
            }
        }
        return list;
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
                (LocalDateTime.now().getYear() - Instant.ofEpochMilli(ch.getBirthDate())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime().getYear()) > number));
   }
}