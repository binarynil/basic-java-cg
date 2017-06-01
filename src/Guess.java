/**
 * In program Guess, the computer chooses a random integer between 0 and any limit you set.
 * You must then try to guess the number the computer has chosen using the clues provided by the computer.
 * You should be able to guess the number in one less than the number of digits needed to
 * represent the number in binary notation (base 2). This out to give you a clue as to the optimum
 * search technique. Guess converted from the original program in FOCAL, which appeared in the book
 * "Computers in the Classroom" by Walt Koetke of Lexington High School, Lexinton, Massachusetts.
 * This is the Java conversion of that code.
 */
import java.util.Scanner;
public class Guess {

    public static void who() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("This is a number guessing game.");
        System.out.println("I'll think of a number between 1 and any limit you want.");
        System.out.println("Then you have to guess what it is.");
        System.out.println();
        System.out.print("What limit do you want? ");
        int limit = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println();

        int predictedTries = (int)((Math.log(limit) / Math.log(2))+1);
        //System.out.println(predictedTries);
        System.out.println("I'm thinking of a number between 1 and " + limit);
        System.out.println("Now you try to guess what it is.");
        int genNum = (int)((Math.random() * limit) + 1);
        int guess = 1;

        boolean gameOver = false;
        do {
            int myGuess;
            do {
                System.out.print("? ");
                myGuess = keyboard.nextInt();
                keyboard.nextLine();
                if(myGuess < 1) {
                    System.out.println("Guess a number greater than zero.");
                }
            } while(myGuess < 1);

            System.out.println();
            if(myGuess == genNum) {
                System.out.printf("That's it! You got it in %d tries.\n", guess);
                isVery(guess, predictedTries);
                gameOver = true;
            }
            else if(myGuess > genNum) {
                System.out.println("Too high. Try a smaller answer.");
            }
            else {
                System.out.println("Too low. Try a bigger answer.");
            }


            guess++;
        } while(!gameOver);
    }

    private static void isVery(int guess, int predictedTries) {
        if(guess <= predictedTries) {
            if(guess < predictedTries) {
                System.out.print("Very ");
            }
            System.out.println("Good.");
        }
    }
}