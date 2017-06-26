/**
 * In this game, up to 20 players throw darts at a target with 10-, 20-, 30-, and 40-point zones.
 * Ths objective is to get 200 points. You have a choice of three methods of throwing:
 * Throw            Description             Probable Score
 *   1               Fast overarm            Bullseye or complete miss
 *   2               Controlled overarm      10, 20, or 30 points
 *   3               Underarm                Anything
 * You will find after playing a while that different players will swear by different strategies.
 * However, consider the expected score per throw by always using Throw 3 (program line 220):
 * Score (S)            Probabilitiy (P)            SxP
 *   40                  1.00-.95 = .05              2
 *   30                   .95-.75 = .20              6
 *   30                   .75-.45 = .30              6
 *   10                   .45-.05 = .40              4
 *    0                   .05-.00 = .05              0
 *    Expected Score per throw =                    18
 * Calculate the expected scores for the other throws and you may be surprised!
 * The program was written by David Ahl of Creative Computing.
 * This is the Java conversion of that code.
 */
import java.util.Random;
import java.util.Scanner;
public class Bullseye {

    public static void target() {
        Scanner keyboard = new Scanner(System.in);
        String[] players = new String[20];
        int[] scores = new int[20];
        printIntro();
        int maxPlayers = addPlayers(players, keyboard);
        playGame(players, scores, keyboard, maxPlayers);


    }

    private static void printIntro() {
        System.out.println("In this game, up to 20 players throw darts at a target");
        System.out.println("with 10, 20, 30, and 40 point zones. The objective is");
        System.out.println("to get 200 points.\n");
        System.out.println("Throw               Description             Probable Score");
        System.out.println(" 1                  Fast Overarm            Bullseye or Complete Miss");
        System.out.println(" 2                  Controlled Overarm      10, 20, or 30 Points");
        System.out.println(" 3                  Underarm                Anything\n");
    }

    private static int addPlayers(String[] players, Scanner keyboard) {
        int numPlayers;
        do {
            System.out.print("How many players? ");
            while(!keyboard.hasNextInt()) {
                System.out.println("Type in a number");
                keyboard.next();
            }
            numPlayers = keyboard.nextInt();
            keyboard.nextLine();
            if(numPlayers < 1 || numPlayers > 20) {
                System.out.println("Type in a number from 1 to 20");
            }

        } while(numPlayers < 1 || numPlayers > 20);

        for(int i = 0; i < numPlayers; i++) {
            System.out.printf("Name of player %d: ", i+1);
            players[i] = keyboard.nextLine();
        }

        return numPlayers;
    }

    private static void playGame(String[] players, int[] scores, Scanner keyboard, int maxPlayers) {
        int rounds = 1;
        boolean gameOver = false;
        do {
            System.out.printf("\nRound %d\n", rounds);
            playerThrow(players, scores, keyboard, maxPlayers);
            gameOver = checkWinner(players, scores, maxPlayers);
            rounds++;
        } while(!gameOver);
    }

    private static void playerThrow(String[] players, int[] scores, Scanner keyboard, int maxPlayers) {
        int input;
        double p1, p2, p3, p4;
        Random rand = new Random();
        for(int i = 0; i < maxPlayers; i++) {
            do {
                System.out.printf("\n%s's throw: ", players[i]);
                while(!keyboard.hasNextInt()) {
                    System.out.println("Input 1, 2, or 3!");
                    keyboard.next();
                }
                input = keyboard.nextInt();
                keyboard.nextLine();
                if(input < 1 || input > 3) {
                    System.out.println("Input 1, 2, or 3!");
                }
            } while(input < 1 || input > 3);

            if(input == 1) {
                p1 = .65; p2 = .55;
                p3 = .5;  p4 = .5;
            }
            else if(input == 2) {
                p1 = .99; p2 = .77;
                p3 = .43; p4 = .01;
            }
            else {
                p1 = .95; p2 = .75;
                p3 = .45; p4 = .05;
            }
            double randNum = rand.nextDouble();
            if(randNum >= p1) {
                System.out.println("Bullseye!! 40 points!");
                scores[i] += 40;
            }
            else if(randNum >= p2) {
                System.out.println("30-point Zone!");
                scores[i] += 30;
            }
            else if(randNum >= p3) {
                System.out.println("20-point Zone");
                scores[i] += 20;
            }
            else if(randNum >= p4) {
                System.out.println("Whew!");
                scores[i] += 10;
            }
            else {
                System.out.println("Missed the target! Too bad.");
            }

            System.out.printf("Total score = %d\n", scores[i]);
        }
    }

    private static boolean checkWinner(String[] players, int[] scores, int maxPlayers) {
        boolean win = false;

        for(int i = 0; i < maxPlayers; i++) {
            if(scores[i] >= 200) {
                System.out.println("\nWe have a winner!!\n");
                System.out.printf("%s scored %d points.\n\n", players[i], scores[i]);
                System.out.println("Thanks for the game.");
                win = true;
            }
        }

        return win;
    }
}