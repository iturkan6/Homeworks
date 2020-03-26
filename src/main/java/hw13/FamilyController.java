package hw13;

import java.text.ParseException;
import java.util.HashSet;
import java.util.stream.Collectors;

public class FamilyController{
    FamilyService fs = new FamilyService();

    public void createNewFamily(Human mother, Human father){
        fs.createNewFamily(mother, father);
    }

    public void displayAllFamilies() {
        System.out.println(fs.getAllFamilies());
    }
    public void deleteFamilyByIndex(int index){
        fs.deleteFamilyByIndex(index);
    }

    public void bornChild(Family family, String girlName, String boyName) throws FamilyOverflowException, ParseException {
        if (family.countFamily() == 6) throw new FamilyOverflowException("Family has too many children", family.countFamily());
        fs.bornChild(family, girlName, boyName);
    }

    public void adoptChild(Family family, Human child) throws FamilyOverflowException {
        if (family.countFamily() == 6) throw new FamilyOverflowException("Family has too many children", family.countFamily());
        fs.adoptChild(family, child);
    }

    public int count(){
        return fs.count();
    }

    public void displayFamiliesBiggerThan(int number) {
        String sb = fs.getFamiliesBiggerThan(number).stream().map(Family::prettyFormat).collect(Collectors.joining());
        System.out.println(sb);
    }
    public void displayFamiliesLessThan(int number) {
        String sb = fs.getFamiliesLessThan(number).stream().map(Family::prettyFormat).collect(Collectors.joining());
        System.out.println(sb);
    }
    public void displayCountFamiliesWithMemberNumber(int number) {
        System.out.println(fs.countFamiliesWithMemberNumber(number));
    }
    public Family getFamilyById(int index){
        return fs.getFamilyById(index);
    }
    public void getPetByIndex(int index){
        System.out.println(fs.getPet(index));
    }
    public void addPet(int index, Pet pet){
        fs.addPet(index, pet);
    }
    public HashSet<Pet> getPets(int index){
        return fs.getPets(index);
    }
    public void deleteAllChildrenOlderThen(int number) {
       fs.deleteAllChildrenOlderThen(number);
        }
    public void read(){
        fs.read();
    }
}
