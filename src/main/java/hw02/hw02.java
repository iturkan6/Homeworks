package hw02;

import java.util.Random;
import java.util.Scanner;

public class hw02 {
    public static void main(String[] args) {
        System.out.println("All set. Get ready to rumble!");
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int x;
        int y;
        int i = random.nextInt(4)+1;
        int j= random.nextInt(4)+1;
        boolean won = false;
        String[][] Matrix = {
                {"0", "1", "2", "3", "4", "5"},
                {"1", "-", "-", "-", "-", "-"},
                {"2", "-", "-", "-", "-", "-"},
                {"3", "-", "-", "-", "-", "-"},
                {"4", "-", "-", "-", "-", "-"},
                {"5", "-", "-", "-", "-", "-"},
        };

        while(true) {

            while (true) {
                System.out.println("Enter the number of string from 1 to 5");
                x = in.nextInt();
                if (x > 5 || x < 1) {
                    System.out.println("Your number is wrong");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.println("Enter the number of column from 1 to 5");
                y = in.nextInt();
                if (y > 5 || y < 1) {
                    System.out.println("Your number is wrong");
                } else {
                    break;
                }
            }

            for (int a = 0; a < 6; a++) {
                for (int b = 0; b < 6; b++) {
                    if (x != i || y != j) {
                        Matrix[x][y] = "*";
                        System.out.print(Matrix[a][b] + "\t");
                    } else if (x == i && y == j) {
                        Matrix[i][j] = "x";
                        System.out.print(Matrix[a][b] + "\t");
                        won = true;
                    }
                }
                System.out.println();
            }

            if(won) {
                System.out.println("You are won!");
                break;
            }

        }
    }
}