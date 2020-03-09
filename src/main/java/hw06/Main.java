package hw06;


public class Main {
    public static void main(String[] args) {
        Human ch = new Human("Bob", "Smith", 2, 15,
                new String[][]{{DayOfWeek.Sunday.name(), "do homework"}, {DayOfWeek.Monday.name(), "go to course"},
                        {DayOfWeek.Tuesday.name(), "go to academy"}, {DayOfWeek.Wednesday.name(), "watch a film"},
                        {DayOfWeek.Thursday.name(), "read a book"}, {DayOfWeek.Friday.name(), "go to gym"},
                        {DayOfWeek.Saturday.name(), "rest"}});
        Family family = new Family(new Human("Marry", "Smith", 27, 100),
                new Human("Rob", "Smith", 27, 100), new Human[]{},
                new Pet(Species.Dog, "Lola", 2, 75, new String[]{"Sleep", "Eat"}));

        family.addChild(ch);
        family.getChildren()[0].greetPet();
        System.out.println(ch.toString());
        ch.describePet();
        family.getPET().eat();
        family.getPET().respond();
        family.getPET().foul();
        System.out.println(family.getPET().toString());

        family.addChild(new Human("Mark", "Smith", 1, 1));
        System.out.println(family.deleteChild(new Human("Bob", "Smith", 2, 15)));
//        System.out.println(family.deleteChild(0));
        System.out.println(family.toString());
        System.out.println(family.countFamily());

//        for (int i = 0; i < 160000; i++) {
//            Human c = new Human();
//        }
    }
}
