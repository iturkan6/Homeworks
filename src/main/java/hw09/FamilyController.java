package hw09;

import java.util.HashSet;
import java.util.Random;

public class FamilyController extends FamilyService{
    FamilyService fs = new FamilyService();

    public void createNewFamily(Human mother, Human father){
        fs.createNewFamily(mother, father);
    }
    public void displayAllFamilies(){
        fs.displayAllFamilies();
    }
    public void deleteFamilyByIndex(int index){
        fs.deleteFamilyByIndex(index);
    }

    public void bornChild(Family family, String girlName, String boyName) {
        fs.bornChild(family, girlName, boyName);
    }

    public void adoptChild(Family family, Human child) {
        fs.adoptChild(family, child);
    }

    public int count (){
        return fs.count();
    }

    public void getFamiliesBiggerThan(int number) {
        fs.getFamiliesBiggerThan(number);
    }
    public void getFamiliesLessThan(int number) {
       fs.getFamiliesLessThan(number);
    }
    public int countFamiliesWithMemberNumber(int number) {
       return fs.countFamiliesWithMemberNumber(number);
    }
    public Family getFamilyById(int index){
        return fs.getFamilyById(index);
    }
    public void getPet(int index){
        fs.getPet(index);
    }
    public void addPet(int index, Pet pet){
        fs.addPet(index, pet);
    }
    public HashSet<Pet> getPets(int index){
        return fs.getPets(index);
    }


}
