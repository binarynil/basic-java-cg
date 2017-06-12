/**
 * The object of this game is to change a row of ten X's
 * X X X X X X X X X X
 * to a row of then O's
 * O O O O O O O O O O
 * by typing in a number corresponding to the position of an "X" in the line.
 * On some numbers, one position will change while on other numbers, two will change.
 * For example, inputting a 3 may reverse the X and O in position 3, but it might
 * possibly reverse some other position too! You ought to be able to change
 * all 10 in 12 or fewer moves. Can you figure out a good winning strategy?
 * To reset the line to all X's (same game), type 0 (zero). To start a new game
 * at any point, type 11. The original author of this game was Michael Kass of
 * New Hyde Park, New York.
 * This is the Java conversion of that code.
 */
import java.util.Scanner;
import java.util.Random;
public class FlipFlop {

    public static void sequence() {
        Scanner keyboard = new Scanner(System.in);
        printIntro();
        Random rnd = new Random();
        char[] xoArray = new char[10];
        fillXO(xoArray);
        int input;
        int guesses = 1;
        //double num = Math.random();
        double num = rnd.nextDouble();
        int m = 13;
        boolean isM;
        boolean allO = false;

        do {
            input = inputNum(keyboard);
            if(input == 0) {
                fillXO(xoArray);
            }
            else if(input == 11) {
                fillXO(xoArray);
                num = rnd.nextDouble();
                guesses = 0;
            }
            if(input > 0 && input < 11) {
                isM = checkM(m, input);
                if(isM) {
                    setX(xoArray, input-1, num, isM);
                    printXO(xoArray);
                }
                else {
                    m = input;
                    setO(xoArray, input-1, num, isM);
                    printXO(xoArray);
                }
                guesses++;
            }


            allO = checkOver(xoArray);
            if(allO) {
                if(guesses > 12) {
                    System.out.println("Try harder next time. It took you "+guesses+" guesses.");
                }
                else {
                    System.out.println("Very good. You guessed it in only "+guesses+" guesses.");
                }
            }

        } while(!allO);

    }

    private static boolean checkOver(char[] xoArray) {
        boolean allO = false;
        if(xoArray[0] == 'O' && xoArray[1] == 'O' && xoArray[2] == 'O' && xoArray[3] == 'O' && xoArray[4] == 'O' && xoArray[5] == 'O' &&
                xoArray[6] == 'O' && xoArray[7] == 'O' && xoArray[8] == 'O' && xoArray[9] == 'O') {
            allO = true;
        }

        return allO;
    }

    private static void printXO(char[] xoArray) {
        System.out.println("1 2 3 4 5 6 7 8 9 10");
        for(char c : xoArray) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private static void setO(char[] xoArray, int i, double num, boolean isM) {
        if(xoArray[i] == 'O') {
            xoArray[i] = 'X';
            if(isM) {
                double r = Math.tan(num+i/num-i) - Math.sin(num/i) + 336*Math.sin(8*i);
                double rN = r - (int)r;
                int j = (int)(Math.abs(10*rN));
                checkXO(xoArray, j);
            }
        }
        else {
            xoArray[i] = 'O';
            double r = Math.tan(num+i/num-i) - Math.sin(num/i) + 336*Math.sin(8*i);
            double rN = r - (int)r;
            int j = (int)(Math.abs(10*rN));
            checkXO(xoArray, j);
        }
    }

    private static boolean checkM(int m, int input) {
        boolean isM = false;
        if(m == input) {
            isM = true;
        }

        return isM;
    }

    private static void setX(char[] xoArray, int i, double num, boolean isM) {
        if(xoArray[i] == 'O') {
            xoArray[i] = 'X';
            if(isM) {
                double r = .592*(1/Math.tan(num/i+num) / Math.sin(i*2+num) - Math.cos(i));
                double rN = r - (int)r;
                int j = (int)(Math.abs(10*rN));
                checkXO(xoArray, j);
            }
        }
        else {
            xoArray[i] = 'O';
            double r = .592*(1/Math.tan(num/i+num) / Math.sin(i*2+num) - Math.cos(i));
            double rN = r - (int)r;
            int j = (int)(Math.abs(10*rN));
            checkXO(xoArray, j);
        }
    }

    private static void checkXO(char[] xoArray, int j) {

        if(xoArray[j] == 'X') {
            xoArray[j] = 'O';
        }
        else {
            xoArray[j] = 'X';
        }
    }

    private static void printIntro() {
        System.out.println("The object of this puzzle is to change this:");
        System.out.println("X X X X X X X X X X\n");
        System.out.println("to this:");
        System.out.println("O O O O O O O O O O\n");
        System.out.println("By typing the number corresponding to the position of the");
        System.out.println("letter on some numbers, one position will change, on others,");
        System.out.println("two will change. To reset line to all X's, type 0 (zero),");
        System.out.println("and to start over in the middle of a game, type 11 (eleven).\n");
        System.out.println("Here is the starting line of X's.");
    }

    private static void fillXO(char[] xo) {
        System.out.println("1 2 3 4 5 6 7 8 9 10");
        System.out.println("X X X X X X X X X X");
        for(int i = 0; i < xo.length; i++) {
            xo[i] = 'X';
        }
    }

    private static int inputNum(Scanner keyboard) {
        int input;

        System.out.print("\nInput the number? ");
        while(!keyboard.hasNextInt() || keyboard.nextInt() > 11) {
            System.out.println("Illegal entry--Try again.");
            keyboard.nextLine();
            System.out.print("\nInput the number? ");
        }
        input = keyboard.nextInt();

        return input;
    }
}
