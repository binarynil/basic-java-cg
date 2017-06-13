/**
 * The game starts with an imaginary pile of objects, coins for example.
 * You and your opponent (the computer) alternately remove objects from the pile.
 * You specify in advance the minimum and maximum number of objects that can be taken
 * on each turn. You also specify in advance how winning is defined:
 * 1. To take the last object or
 * 2. To avoid taking the last onject
 * You may also determine wheather you or the computer go first. The stragegy
 * of this game is based on modulo arithmetic. If the maximum number of objects a
 * player may remove in a turn is M, then to gain a winning position, a player
 * at the end of his turn must leave the stack of 1 modulo (M+1) coins. If
 * you don't understand this, play the game 23 Matches first, then Batnum, and
 * have fun!
 * Batnum is a generalized version of a great number of manual remove-the-object
 * games. The original computer version was written by one of the two originators
 * of the BASIC language, John Kemeny of Darthmouth College.
 * This is the Java conversion of that code.
 */
import java.util.Scanner;
public class Batnum {

    public static void numWar() {
        Scanner keyboard = new Scanner(System.in);
        printIntro();
        int[] pileSize = new int[1];
        int winOption;
        int startOption;
        int total = 0;
        int[] minMax = new int[2];
        boolean[] gameOver = {false};
        boolean isOver = false;
        boolean myTurn;

        do {
            setPileSize(keyboard, pileSize);
            winOption = setOption(keyboard);
            setMinMax(minMax, keyboard);
            //System.out.println(minMax[0]);
            startOption = setStartOption(keyboard);
            myTurn = startingTurn(startOption);

            total = minMax[0] + minMax[1];

            do {
                if(myTurn) {
                    calcMyTurn(keyboard, winOption, pileSize, minMax[0], minMax[1], gameOver);
                    myTurn = false;
                }
                else {
                    cpuTurn(winOption, pileSize, minMax[0], minMax[1], total, gameOver);
                    myTurn = true;
                }

                isOver = gameOver[0];

            } while(!isOver);

        } while(!isOver);

    }

    private static void printIntro() {
        System.out.println("This program is a Battle of Numbers game where the computer is your opponent.");
        System.out.println("The game starts with an assumed pile of objects. You and your opponent");
        System.out.println("alternately remove objects from the pile. Winning is defined in advance");
        System.out.println("as taking the last object or not. You can also specify some other beginning");
        System.out.println("conditions. Don't use zero, however, in playing the game.");
    }

    private static boolean startingTurn(int startOption) {
        boolean myTurn = true;

        if(startOption == 1) {
            myTurn = false;
        }

        return myTurn;
    }

    private static void calcMyTurn(Scanner keyboard, int winOption, int[] pileSize, int min, int max, boolean[] gameOver) {
        int input;

        do {
            System.out.print("Your move: ");
            while(!keyboard.hasNextInt()) {
                System.out.println("Illegal move, reenter it");
                keyboard.next();
            }

            input = keyboard.nextInt();
            keyboard.nextLine();

            if(input == 0) {
                System.out.println("I told you not to use zero! Computer wins by forfeit.");
                gameOver[0] = true;
            }
            else if(input >= min) {
                if(input <= max) {
                    pileSize[0] = pileSize[0] - input;
                    checkPile(pileSize, gameOver, input);
                }
            }
            else if(input == pileSize[0]) {
                if(winOption == 1) {
                    System.out.println("Congratulations, you win.");
                    gameOver[0] = true;
                }
            }


        } while(input < 1 || input > max);
    }

    private static void checkPile(int[] pileSize, boolean[] gameOver, int input) {
        if(pileSize[0] >= 0) {
            gameOver[0] = false;
        }
        else {
            pileSize[0] = pileSize[0] + input;
        }
    }

    private static void calcP(int temp, int total, int min, int max, int[] pileSize, boolean[] gameOver) {
        int p = temp - total*(temp/total);

        if(p < min) {
            p = min;
        }
        if(p > max) {
            p = max;
        }
        pileSize[0] = pileSize[0] - p;
        System.out.printf("Computer takes %d and leaves %d\n", p, pileSize[0]);
        gameOver[0] = false;
    }

    private static void cpuTurn(int winOption, int[] pileSize, int min, int max, int total, boolean[] gameOver) {
        int temp = pileSize[0];
        int p;
        if(winOption == 1) {
            if(pileSize[0] > max) {
                calcP(temp, total, min, max, pileSize, gameOver);
            }
            else {
                gameOver[0] = true;
                System.out.printf("\nComputer takes %d and wins\n", pileSize[0]);
            }

        }
        else {
            temp = temp - 1;
            if(pileSize[0] > min) {
                calcP(temp, total, min, max, pileSize, gameOver);
            }
            else {
                gameOver[0] = true;
                System.out.printf("\nComputer takes %d and loses\n", pileSize[0]);
            }
        }
    }

    private static int setStartOption(Scanner keyboard) {
        int input;
        do {
            System.out.print("Enter start option [1] computer first. [2] you first: ");
            while(!keyboard.hasNextInt()) {
                System.out.print("Enter start option [1] computer first. [2] you first: ");
                keyboard.next();
            }

            input = keyboard.nextInt();
            keyboard.nextLine();

        } while(input < 1 || input > 2);

        return input;
    }

    private static void setMinMax(int[] minMax, Scanner keyboard) {
        do {
            System.out.print("Enter min and max (min,max): ");
            String input = keyboard.nextLine();
            Scanner scanInt = new Scanner(input).useDelimiter(",");
            minMax[0] = scanInt.nextInt();
            minMax[1] = scanInt.nextInt();
            scanInt.close();
        } while(minMax[0] > minMax[1] || minMax[0] < 1);
    }

    private static int setOption(Scanner keyboard) {
        int input;
        do {
            System.out.print("Enter win option [1] to take last. [2] to avoid last: ");
            while(!keyboard.hasNextInt()) {
                System.out.print("Enter win option [1] to take last. [2] to avoid last: ");
                keyboard.next();
            }

            input = keyboard.nextInt();
            keyboard.nextLine();

        } while(input < 1 || input > 2);

        return input;
    }

    private static void setPileSize(Scanner keyboard, int[] pileSize) {
        int input;
        System.out.println();

        do {
            System.out.printf("\nEnter pile size: ");
            while(!keyboard.hasNextInt()) {
                System.out.printf("\nEnter pile size: ");
                keyboard.next();
            }

            input = keyboard.nextInt();
            keyboard.nextLine();

        } while(input < 1);

        pileSize[0] = input;
    }
}
