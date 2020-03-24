package hw09;


public class FamilyController {
    private FamilyService fs = new FamilyService();

    public void createNewFamily(Human mother, Human father){
        fs.createNewFamily(mother, father);
    }
    public void displayAllFamilies(){
        System.out.println(fs.displayAllFam());
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

    public void displayCountOfFamily(){
        System.out.println(fs.count());
    }

    public void displayFamiliesBiggerThan(int number) {
        System.out.println(fs.getFamiliesBiggerThan(number));
    }
    public void displayFamiliesLessThan(int number) {
        System.out.println(fs.getFamiliesLessThan(number));
    }
    public void displayCountFamiliesWithMemberNumber(int number) {
        System.out.println(fs.countFamiliesWithMemberNumber(number));
    }
    public void displayFamilyById(int index){
        System.out.println(fs.getFamilyById(index));
    }
    public Family getFamilyById(int index){
        return fs.getFamilyById(index);
    }
    public void displayPetByIndex(int index){
        System.out.println(fs.getPet(index));
    }
    public void addPet(int index, Pet pet){
        fs.addPet(index, pet);
    }
    public void displayPets(int index){
        System.out.println(fs.getPets(index));
    }
    public void deleteAllChildrenOlderThen(int number) {
        fs.deleteAllChildrenOlderThen(number);
    }
}
