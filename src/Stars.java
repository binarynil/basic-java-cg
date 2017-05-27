/*
In this game, the computer selects a random number from 1 to 100
(or any value you set). You try to guess the number and the computer
gives you clues to tell you how close you're getting. One star (*)
means you're far away from the number; seven stars (*******) means
you're really close. You get 7 guesses.
On the surface this game is very similar to GUESS; however, the guessing
strategy is quite different. See if you can come up with one or more
approaches to finding the mystery number. Bob Albrecht of People's
Computer created this game.
This is the Java conversion of that code.
 */
import java.util.Scanner;
public class Stars {

    private static int maxValue = 100;
    private static int maxTries = 7;

    public static void star() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("                   Stars");
        System.out.println("Creative Computing  Morristown, New Jersey");
        System.out.println();
        System.out.println();
        System.out.println("I am thinking of a whole number from 1 to " + maxValue);
        System.out.println("Try to guess my number. After you guess, I will");
        System.out.println("type one or more stars (*) The more stars I type,");
        System.out.println("the close you are to my number. One star (*) means");
        System.out.println("far away, seven stars (*******) means really close!");
        System.out.println("You get " + maxTries + " guesses.");
        System.out.println();

        int randNum = (int)((Math.random() * maxValue + 1));
        System.out.println("OK, I'm thinking of a number. Start guessing.");

        for(int i = 1; i <= maxTries; i++) {
            System.out.println();
            System.out.println("Your guess");
            int input = keyboard.nextInt();
            keyboard.nextLine();

            if(input == randNum) {
                gameWon(i);
                i = 7;
            }
            else if(input != randNum && i == maxTries) {
                System.out.println("Sorry, that's " + i + " guesses. Number was " + randNum);
            }
            else {
                int difference = Math.abs(input - randNum);
                /*
                  The original BASIC conditions for d were d >= num, but that didn't work.
                 */
                if(difference <= 64) {
                    System.out.print("*");
                }
                if(difference <= 32) {
                    System.out.print("*");
                }
                if(difference <= 16) {
                    System.out.print("*");
                }
                if(difference <= 8) {
                    System.out.print("*");
                }
                if(difference <= 4) {
                    System.out.print("*");
                }
                if(difference <= 2) {
                    System.out.print("*");
                }
                System.out.print("*");
                System.out.println();
            }
        }
    }

    public static void gameWon(int tries) {
        for(int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println("!!!");
        System.out.println("You got it in " + tries + " guesses!!!");
    }
}
