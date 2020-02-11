package hw01;

import java.util.Random;
import java.util.Scanner;

public class hw01 {
    public static void main(String[] args) {

            System.out.println("What is your name?");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            System.out.println("Let's the game begin!");
        while (true) {
            Random random = new Random();
            int value = random.nextInt(101);
            System.out.println("Enter the number");
            int number = in.nextInt();
            if (number < value) {
                System.out.println("Your number is too small. Please, try again.");
            } else if (number > value) {
                System.out.println("Your number is too big. Please, try again.");
            } else {
                System.out.printf("Congratulations, %s\n", name);
                break;
            }
        }

    }
}
