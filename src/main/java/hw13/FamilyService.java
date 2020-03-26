package hw13;




import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        cf.saveFamily(family);
    }

    public void adoptChild(Family family, Human child) {
        cf.getFamilyByIndex(cf.getAllFamilies().indexOf(family)).addChild(child);
        cf.saveFamily(family);
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
        cf.saveFamily(getFamilyById(index));
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
   public void read(){
        if(cf.getAllFamilies().size() == 0) {
            try {
                File file = new File("C:\\Users\\iturk\\Desktop\\IBA\\Homeworks\\Families.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] member = line.trim().split("~M~");
                    String[] parents = member[0].trim().split(":");
                    Human mother = new Human(parents[0], parents[1], parents[2], Integer.parseInt(parents[3]), null);
                    Human father = new Human(parents[5], parents[6], parents[7], Integer.parseInt(parents[8]), null);

                    ArrayList<Human> childrenList = new ArrayList<>();
                    if (member.length > 1) {
                        System.out.println("fffffffff");
                        String[] children = member[1].trim().split("~child~");
                        for (String child : children) {
                            String[] childData = child.split(":");
                            childrenList.add(new Human(childData[0], childData[1], childData[2],
                                    Integer.parseInt(childData[3]), null));
                        }
                        if(member.length > 2) {
                            String[] pets = member[2].trim().split("~P~");
                            HashSet<Pet> petsSet = new HashSet<>();
                            for (int i = 0; i < pets.length; i++) {
                                String[] petData = pets[i].split(":");
                                HashSet<String> habits = new HashSet<>();
                                String[] habit = petData[4].replaceAll("\\[", "")
                                        .replaceAll("]", "").trim().split(",");
                                for (int j = 0; j < habit.length; j++) {
                                    habits.add(habit[i]);
                                }
                                String species = petData[0];
                                switch (species) {
                                    case "Fish":
                                        petsSet.add(new Fish(petData[1], Integer.parseInt(petData[2]),
                                                Integer.parseInt(petData[3]), habits));
                                        break;
                                    case "Dog":
                                        petsSet.add(new Dog(petData[1], Integer.parseInt(petData[2]),
                                                Integer.parseInt(petData[3]), habits));
                                        break;
                                    case "RoboCat":
                                        petsSet.add(new RoboCat(petData[1], Integer.parseInt(petData[2]),
                                                Integer.parseInt(petData[3]), habits));
                                        break;
                                    case "DomesticCat":
                                        petsSet.add(new DomesticCat(petData[1], Integer.parseInt(petData[2]),
                                                Integer.parseInt(petData[3]), habits));
                                        break;
                                    default:
                                        System.out.println("Unknown species");
                                        break;
                                }
                            }
                            System.out.println(mother);
                            System.out.println(father);
                            System.out.println(childrenList);
                            System.out.println(petsSet);
                            cf.getAllFamilies().add(new Family(mother, father, childrenList, petsSet));
                        }else{
                            cf.getAllFamilies().add(new Family(mother, father, childrenList));
                        }
                    } else {
                        System.out.println(mother);
                        System.out.println(father);
                        cf.getAllFamilies().add(new Family(mother, father));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

   }
}