package hw03;

import java.util.Scanner;

public class hw03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] [] schedule = new String[7][2];
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "go to academy";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "watch a film";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "read a book";
        schedule[5][0] = "Friday";
        schedule[5][1] = "go to gym";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "rest";
        boolean a = false;

        while (true) {
            System.out.print("Please, input the day of the week: ");
            String DAY = scanner.nextLine();
            String Day = DAY.toLowerCase();
            String day = Day.trim();
            switch (day) {
                case "sunday":
                    System.out.printf("Your tasks for %s : %s \n", day, schedule[0][1]);
                    break;
                case "monday":
                    System.out.printf("Your tasks for %s : %s \n", day, schedule[1][1]);
                    break;
                case "tuesday":
                    System.out.printf("Your tasks for %s :%s \n", day, schedule[2][1]);
                    break;
                case "wednesday":
                    System.out.printf("Your tasks for %s :%s \n", day, schedule[3][1]);
                    break;
                case "thursday":
                    System.out.printf("Your tasks for %s :%s \n", day, schedule[4][1]);
                    break;
                case "friday":
                    System.out.printf("Your tasks for %s :%s \n", day, schedule[5][1]);
                    break;
                case "saturday":
                    System.out.printf("Your tasks for %s :%s \n", day, schedule[6][1]);
                    break;
                case "exit" :
                    a = true;
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
            }if (a){
                break;
            }
        }

    }
}
