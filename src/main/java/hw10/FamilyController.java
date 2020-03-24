package hw10;

import java.util.HashSet;

public class FamilyController{
    private FamilyService fs = new FamilyService();

    public void createNewFamily(Human mother, Human father) {
        fs.createNewFamily(mother, father);
    }

    public void displayAllFamilies() {
        System.out.println(fs.displayAllFam());
    }

    public void deleteFamilyByIndex(int index) {
        fs.deleteFamilyByIndex(index);
    }

    public void bornChild(Family family, String girlName, String boyName) {
        fs.bornChild(family, girlName, boyName);
    }

    public void adoptChild(Family family, Human child) {
        fs.adoptChild(family, child);
    }

    public void displayCountOfFamily(){
        System.out.println(fs.count());
    }

    public void displayFamiliesBiggerThan(int number) {
        StringBuilder sb = new StringBuilder();
        for (Family c : fs.getFamiliesBiggerThan(number)){
            sb.append(c);
        }
        System.out.println(sb.toString());
    }

    public void displayFamiliesLessThan(int number) {
        StringBuilder sb = new StringBuilder();
        for (Family c : fs.getFamiliesLessThan(number)){
            sb.append(c);
        }
        System.out.println(sb.toString());
    }

    public void displayCountFamiliesWithMemberNumber(int number) {
        System.out.println(fs.countFamiliesWithMemberNumber(number));
    }

    public Family getFamilyById(int index) {
        return fs.getFamilyById(index);
    }

    public void displayFamilyById(int index){
        System.out.println(fs.getFamilyById(index));
    }

    public void displayPetByIndex(int index){
        System.out.println(fs.getPet(index));
    }

    public void addPet(int index, Pet pet) {
        fs.addPet(index, pet);
    }

    public void displayPets(int index){
        System.out.println(fs.getPets(index));
    }

    public void deleteAllChildrenOlderThen(int number) {
        fs.deleteAllChildrenOlderThen(number);
    }

}
