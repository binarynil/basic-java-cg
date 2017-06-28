import java.util.Scanner;

/**
 * In this game or puzzle, 48 checkers are placed on two outside spaces
 * of a standard 64-square checkerboard as shown. The object is to remove
 * as many checkers as possible by diagonal jumps (as in standard checkers).
 * It is easy to remove 30 to 39 checkers, a challenge to remove 40 to 44,
 * and a substantial feat to remove 45 to 47. This program was created and
 * written y David Ahl.
 * This is the Java conversion of that code.
 */
public class OneCheck {

    public static void er() {
        Scanner keyboard = new Scanner(System.in);
        int[] board = new int[64];
        printIntro();
        fillBoard(board);
        jumpFrom(board, keyboard);



    }

    private static void printIntro() {
        System.out.println("48 checkers are placed on the 2 outside spaces of a");
        System.out.println("standard 64-square checkerboard. The object is to");
        System.out.println("remove as many checkers as possible by diagonal jumps");
        System.out.println("(as in standard checkers). Use the numbered board to");
        System.out.println("indicate the square you wish to jump from and to. On");
        System.out.println("the board printed out on each turn '1' indicates a");
        System.out.println("checker and '0' an empty square. When you have no");
        System.out.println("possible jumps remaining, input a '0' in response to");
        System.out.println("question 'Jump from?'\n");
        System.out.println("Here is the numerical board:\n");
        System.out.println("1   2   3   4   5   6   7   8\n" +
                           "9   10  11  12  13  14  15  16\n" +
                           "17  18  19  20  21  22  23  24\n" +
                           "25  26  27  28  29  30  31  32\n" +
                           "33  34  35  36  37  38  39  40\n" +
                           "41  42  43  44  45  46  47  48\n" +
                           "49  50  51  52  53  54  55  56\n" +
                           "57  58  59  60  61  62  63  64\n");
        System.out.println("And here is the opening position of the checkers.\n");
    }

    private static void fillBoard(int[] board) {
        for(int i = 0; i < board.length; i++) {
            board[i] = 1;
        }

        for(int i = 18; i < 43; i+=8) {
            for(int j = i; j < i+4; j++) {
                board[j] = 0;
            }
        }

    }

    private static void printBoard(int[] board) {
        for(int i = 0; i < 57; i+=8) {
            for(int j = i; j < i+8; j++) {
                System.out.print("  " + board[j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void jumpFrom(int[] board, Scanner keyboard) {
        int from; int to;
        int jumps = 0;
        int pieces = 0;
        boolean isLegal = true;
        boolean gameOver = false;

        do {
            printBoard(board);

            System.out.printf("Jump from: ");
            from = keyboard.nextInt();
            if(from == 0) {
                for(int i = 0; i < 64; i++) {
                    pieces += board[i];
                }
                gameOver = true;
                System.out.printf("You made %d jumps and had %d pieces.", jumps, pieces);
            }
            else {
                System.out.print("Jump to: ");
                to = keyboard.nextInt();
                from -= 1;
                to -= 1;
                isLegal = checkLegal(from, to, board);

                if(isLegal) {
                    jumps++;
                    board[to] = 1;
                    board[from] = 0;
                    board[(to+from)/2] = 0;
                }
            }
            System.out.println();


        } while(!gameOver);

    }



    private static boolean checkLegal(int from, int to, int[] board) {
        boolean isLegal = true;
        int f1 = (int)(from/8);
        int f2 = from+1-8*f1;
        int t1 = (int)(to/8);
        int t2 = to+1-8*t1;
        int ft1 = Math.abs(f1-t1);
        int ft2 = Math.abs(f2-t2);
        if(f1 > 7 || f2 > 8 || t1 > 7 || t2 > 8 || ft1 != 2 || ft2 != 2 ||
                board[(to+from)/2] == 0 || board[from] == 0 || board[to] == 1) {
            System.out.println("Illegal move. Try again...");
            isLegal = false;
        }
        /*System.out.println("f1 " + f1);
        System.out.println("f2 " + f2);

        System.out.println("t1 " + t1);
        System.out.println("t2 " + t2);
        System.out.println("ft1 " + ft1);
        System.out.println("ft2 " + ft2);
        System.out.println("to+from: " + board[(to+from)/2]);
        System.out.println("from: " + board[from]);
        System.out.println("to: " + board[to]);*/

        return isLegal;
    }

}
