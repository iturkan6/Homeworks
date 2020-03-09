package hw09;

import java.util.*;

public class FamilyService {
    CollectionFamilyDAO cf = new CollectionFamilyDAO();
    FamilyDAO fd = new FamilyDAO<Family>() {

        @Override
        public List<Family> getAllFamilies() {
            return fd.getAllFamilies();
        }

        @Override
        public Optional<Family> getFamilyByIndex(int index) {
            return Optional.empty();
        }

        @Override
        public boolean deleteFamily(int index) {
            return false;
        }

        @Override
        public boolean deleteFamily(Family family) {
            return false;
        }

        @Override
        public void saveFamily(Family family) {

        }
    };
    public void createNewFamily(Human mother, Human father){
        fd.saveFamily(new Family(mother, father));
    }
    public void DisplayAllFamilies(){
        System.out.println(fd.getAllFamilies());
    }
    public void deleteFamilyByIndex(int index){
        fd.deleteFamily(index);
    }

    public void bornChild(Family family, String girlName, String boyName) {
        Random random = new Random();
        int c = random.nextInt(2);
        if (c == 0) {
            family.addChild(new Human(boyName, family.getFather().getSurname(), 0, 0));
        } else if (c == 1) {
            family.addChild(new Human(girlName, family.getFather().getSurname(), 0, 0));
        }
    }

    public void adoptChild(Family family, Human child) {
        family.addChild(child);
    }

    public int count (){
        return cf.families.size();
    }

    public void getFamiliesBiggerThan(int number) {
        for (Family c : cf.families) {
            if (c.getCount() > number) {
                System.out.println(c);
            }
        }
    }
    public void getFamiliesLessThan(int number) {
        for (Family c : cf.families) {
            if (c.getCount() < number) {
                System.out.println(c);
            }
        }
    }
    public int countFamiliesWithMemberNumber(int number) {
        int s = 0;
        for (Family c : cf.families) {
            if (c.getCount() == number) {
                s++;
            }
        }
        return s;
    }
    public Family getFamilyById(int index){
        return cf.families.get(index);
    }
    public void getPet(int index){
        System.out.println(cf.families.get(index).getPET());
    }
    public void addPet(int index, Pet pet){
        cf.families.get(index).addPet(pet);
    }
    public HashSet<Pet> getPets(int index){
        return cf.families.get(index).getPET();
    }
}