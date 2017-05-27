/**
 * Not exactly a game, this program simulates rolling a pair of dice a large
 * number of times and prints out the frequency distribution. You simply input
 * the number of rolls. It is interesting to see how many rolls are necessary
 * to approach the theoretical distribution.
 * Daniel Freidus wrote this program while in the seventh grade at
 * Harrison Jr-Sr High School, Harrison, New York.
 * This is the Java conversion of that code.
 */
import java.util.Scanner;
public class Dice {

    public static void roll() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Dice");
        System.out.println("Creative Computing  Morristown, New Jersey");
        System.out.println();
        System.out.println();
        System.out.println("This program simulates the rolling of a pair of dice");
        System.out.println("You enter the number of times you want the computer");
        System.out.println("to roll the dice. Watch out, very large numbers take ");
        System.out.println("a long time. In particular, numbers over 5000.");
        System.out.println();
        int[] fArray = new int[12];

        for(int i = 0; i < fArray.length; i++) {
            fArray[i] = 0;
        }
        System.out.print("How many rolls? ");
        int input = keyboard.nextInt();

        for(int j = 0; j < input; j++) {
            int diceOne = (int)(Math.random() * 6);
            int diceTwo = (int)(Math.random() * 6);
            int index = diceOne + diceTwo;
            fArray[index] += 1;
        }

        System.out.println();
        System.out.println("Total Spots    Number of Times");
        for(int k = 0; k < fArray.length - 1; k++) {
            int spot = k+2;
            if(spot < 10) {
                System.out.println("  " + spot + "               " + fArray[k]);
            }
            else {
                System.out.println("  " + spot + "              " + fArray[k]);
            }
        }
    }
}
