/*
 * Remember the game of rock paper scissors.
 * You and your opponent make a motion three times with your fists and then either show a flat hand
 * fist, or two fingers. Depending upon what is shown the game is a tie (both show the same) or one person wins.
 * Paper wraps up rock, so it wins. Scissors cut paper, so they win. Rock breaks scissors, so it wins.
 * In this computerized version of rock paper scissors, you can play up to ten games vs the computer.
 * Charles Lun wrote this game while at the American School in The Hague, Netherlands.
 * This is the Java conversion of that code.
 */
import java.util.Scanner;
public class RockPaperScissors {

    public static void shoot() {
        Scanner keyboard = new Scanner(System.in);

        int yourRPS;
        int gameNum;

        do {
            System.out.print("How many games? ");
            gameNum = keyboard.nextInt();

            if(gameNum > 10 || gameNum < 1) {
                System.out.println("Sorry, but we aren't allowed to play that many.");
            }
            System.out.println();

        } while(gameNum > 10 || gameNum < 1);

        int count = 1;

        boolean myWin;
        boolean isTie;
        int myWins = 0;
        int cpuWins = 0;
        int ties = 0;

        do {
            System.out.println("Game number " + count);
            int cpuRPS = (int)((Math.random() * 3) + 1);

            yourRPS = yourChoice(keyboard);
            System.out.println("This is my choice...");
            if(cpuRPS == 3) {
                System.out.println("...Rock");
            }
            else if(cpuRPS == 2) {
                System.out.println("...Paper");
            }
            else if(cpuRPS == 1) {
                System.out.println("...Scissors");
            }


            isTie = checkTie(cpuRPS, yourRPS);
            if(!isTie) {
                myWin = checkWinner(cpuRPS, yourRPS);
                if(myWin) {
                    System.out.println("You win!!!");
                    myWins++;
                }
                else {
                    System.out.println("Wow! I win!!!");
                    cpuWins++;
                }
            }
            else {
                System.out.println("Tie game. No winner.");
                ties++;
            }
            System.out.println();


            if(count == gameNum) {
                System.out.println("Here is the final game score:");
                System.out.println("I have won " + cpuWins + " game(s).");
                System.out.println("You have won " + myWins + " game(s).");
                System.out.println("And " + ties + " game(s) ended in a tie.");
            }

            count++;
        } while(count <= gameNum);
    }

    private static boolean checkTie(int cpuRPS, int yourRPS) {
        boolean isTie = false;
        if(cpuRPS == yourRPS) {
            isTie = true;
        }

        return isTie;
    }

    private static int yourChoice(Scanner keyboard) {
        int input;
        do {
            System.out.println("3 = Rock   2 = Paper   1 = Scissors");
            System.out.print("1...2...3...What's your choice? ");
            input = keyboard.nextInt();
            if(input > 3 || input < 0) {
                System.out.println("Invalid.");
            }
        } while(input > 3 || input < 0);

        return input;
    }

    private static boolean checkWinner(int cpuRPS, int yourRPS) {
        boolean myWin = true;
        if(cpuRPS == 3 && yourRPS == 1) {
            myWin = false;
        }
        else if(cpuRPS == 2 && yourRPS == 3) {
            myWin = false;
        }
        else if(cpuRPS == 1 && yourRPS == 2) {
            myWin = false;
        }
        else if(yourRPS == 3 && cpuRPS == 1) {
            myWin = true;
        }
        else if(yourRPS == 2 && cpuRPS == 3) {
            myWin = true;
        }
        else if(yourRPS == 1 && cpuRPS == 2) {
            myWin = true;
        }

        return myWin;
    }
}
