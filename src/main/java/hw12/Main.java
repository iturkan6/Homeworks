package hw12;


import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        FamilyController fc = new FamilyController();
        Scanner scanner = new Scanner(System.in);

        boolean exit = true;
        while (exit){
            System.out.println("====Enter the number of function====\n1. Fill with test data\n" +
                    "2. Display all families\n" +
                    "3. Display all families where the number of people is greater than\n" +
                    "4. Display all families where the number of people is less than\n" +
                    "5. Calculate the number of families where the number of members is\n" +
                    "6. Create a new family\n" +
                    "7. Delete a family by its index\n" +
                    "8. Edit a family\n" +
                    "  - 1. Give birth to a baby\n" +
                    "  - 2. Adopt a child\n" +
                    "  - 3. Return to main menu\n" +
                    "9. Remove all children over the age");
            switch (scanner.nextLine().trim().toLowerCase()) {
                case "1":
                    Human bob = new Human("Bob", "Smith", "15/12/1992", 15, null);
                    fc.createNewFamily(new Human("Marry", "Smith", "15/05/1995", 100),
                            new Human("Rob", "Smith", "13/05/1998", 100));
                    fc.addPet(0, new DomesticCat("Murzik", 7, 30, null));
                    fc.createNewFamily(new Human("Minie", "Mouse", "12/01/1993", 80),
                            new Human("Mickey", "Mouse", "16/02/1992", 100));
                    fc.adoptChild(fc.getFamilyById(0), bob);
                    break;
                case "2":
                    fc.displayAllFamilies();
                    break;
                case "3":
                    System.out.println("Enter the number of people in the family");
                    fc.displayFamiliesBiggerThan(Integer.parseInt(scanner.nextLine().trim()));
                    break;
                case "4":
                    System.out.println("Enter the number of people in the family");
                    int i = Integer.parseInt(scanner.nextLine().trim());
                    fc.displayFamiliesLessThan(i);
                    break;
                case "5":
                    System.out.println("Enter the number of people in the family");
                    fc.displayCountFamiliesWithMemberNumber(Integer.parseInt(scanner.nextLine().trim()));
                    break;
                case "6":
                    System.out.println("Enter the mother's name");
                    String name = scanner.nextLine();
                    System.out.println("Enter the mother's last name");
                    String last_name = scanner.nextLine();

                    System.out.println("Enter the mother's iq");
                    int iq = Integer.parseInt(scanner.nextLine());
                    Human mother;
                    while (true) {
                        System.out.println("Enter the mother's birth date in a dd/mm/yyyy format");
                        String date = scanner.nextLine();
                        try {
                            mother = new Human(name, last_name, date, iq);
                            break;
                        }catch (Exception ex){
                            System.out.println("Invalid date format. Please enter in the appropriate format");
                        }
                    }
                    System.out.println("Enter the father's name");
                    String name1 = scanner.nextLine();
                    System.out.println("Enter the father's last name");
                    String last_name1 = scanner.nextLine();
                    System.out.println("Enter the father's iq");
                    int iq1 = Integer.parseInt(scanner.nextLine().trim());
                    Human father;
                    while (true) {
                        System.out.println("Enter the father's birth date in a dd/mm/yyyy format");;
                        String date1 = scanner.nextLine();
                        try {
                            father = new Human(name1, last_name1, date1, iq1);
                            break;
                        }catch (Exception ex){
                            System.out.println("Invalid date format. Please enter in the appropriate format");
                        }
                    }
                    fc.createNewFamily(mother, father);
                    break;
                case "7":
                    System.out.println("Enter the index of the family you want to delete");
                    fc.deleteFamilyByIndex(Integer.parseInt(scanner.nextLine().trim()));
                    break;
                case "8":
                    boolean b = true;
                    while (b) {
                        System.out.println("Enter the number of function\n" +
                                "- 1. Give birth to a baby\n"+
                                "- 2. Adopt a child\n" +
                                "- 3. Return to main menu");
                        switch (Integer.parseInt(scanner.nextLine().trim())) {
                            case 1:
                                System.out.println("Enter the id of family");
                                int id = Integer.parseInt(scanner.nextLine().trim());
                                System.out.println("Enter the girl's name");
                                String girlsName = scanner.nextLine();
                                System.out.println("Enter the boy's name");
                                String boysName = scanner.nextLine();
                                fc.bornChild(fc.getFamilyById(id), girlsName, boysName);
                                break;
                            case 2:
                                System.out.println("Enter the id of family");
                                int id1 = Integer.parseInt(scanner.nextLine());
                                System.out.println("Enter the child's name");
                                String nameC = scanner.nextLine();
                                System.out.println("Enter the child's last name");
                                String last_nameC = scanner.nextLine();
                                System.out.println("Enter the child's iq");
                                int iqC = Integer.parseInt(scanner.nextLine().trim());
                                Human child;
                                while (true) {
                                    System.out.println("Enter the child's birth date in a dd/mm/yyyy format");
                                    String dateC = scanner.nextLine();
                                    try {
                                        child = new Human(nameC, last_nameC, dateC, iqC);
                                        break;
                                    }catch (Exception ex){
                                        System.out.println("Invalid date format. Please enter in the appropriate format");
                                    }
                                }
                                fc.adoptChild(fc.getFamilyById(id1), child);
                                break;
                            case 3:
                                b = false;
                                break;
                            default:
                                System.out.println("Enter a NUMBER\n");
                        }
                    }
                    break;
                case "9":
                    System.out.println("Enter the age");
                    fc.deleteAllChildrenOlderThen(Integer.parseInt(scanner.nextLine().trim()));
                    break;
                case "exit":
                    exit = false;
                    break;
                default:
                    System.out.println("Enter a NUMBER or exit\n");
            }
        }
    }

}
