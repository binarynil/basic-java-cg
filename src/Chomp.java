import java.util.Scanner;

/**
 * This program is an adaptation of a mathematical game originally described by Martin Gardner
 * in the January 1973 issue of Scientific American. Up to a 9x9 grid is set up by you with the
 * upper left square a poison square. This grid is the cookie. Players alternately chomp away at
 * the cookie from the lower right. To take a chomp, input a row and column number of one of the
 * sqaures below and to the right of that square, including that square, disappear.
 * Any number of people can play -- the computer is only the moderator; it is not a player.
 * Two-person strategies are interesting to work out but strategies when three or more people
 * are playing are a real challenge. The computer version of the game was written by Peter
 * Session of People's Computer Company.
 * This is the Java conversion of that code.
 */
public class Chomp {

    public static void nom() {
        Scanner keyboard = new Scanner(System.in);
        printIntro();
        int players = setPlayers(keyboard);
        char[][] cookie = setGrid(keyboard);
        boolean gameOver = false;
        do {
            gameOver = crumb(cookie, players, keyboard);
            if(gameOver) {
                gameOver = playAgain(keyboard);
            }
        } while(!gameOver);
    }

    private static void printIntro() {
        System.out.println("This is the game of Chomp (Scientific American, Jan 1973)");
        System.out.println("Chomp is for 1 or more players (humans only).\n");
        System.out.println("Here's how a board looks (This one is 5 by 7): \n");
        System.out.println("     1 2 3 4 5 6 7 8 9");
        System.out.println("1    P * * * * * *");
        System.out.println("2    * * * * * * *");
        System.out.println("3    * * * * * * *");
        System.out.println("4    * * * * * * *");
        System.out.println("5    * * * * * * *\n\n");
        System.out.println("The board is a big cookie - R rows high and C columns wide.");
        System.out.println("You input R and C at the start. In the upper left corner of");
        System.out.println("the cookie is a poison square (P). The one who chomps the");
        System.out.println("poison square loses. To take a chomp, type the row and the");
        System.out.println("column of one of the squares on the cookie. All of the squares");
        System.out.println("below and to the right of that square (including that square, too)");
        System.out.println("disappear -- chomp!! No fair chomping squares that have already");
        System.out.println("been chomped, or that are outside the original dimensions of the cookie.\n");
        System.out.println("Here we go...\n");
    }

    private static int setPlayers(Scanner keyboard) {
        int input;

        do {
            System.out.print("How many players? ");
            while(!keyboard.hasNextInt()) {
                System.out.println("Enter a valid number");
                keyboard.next();
            }
            input = keyboard.nextInt();
            keyboard.nextLine();
            if(input < 1) {
                System.out.println("Enter a valid number");
            }

        } while(input < 1);

        return input;
    }

    private static char[][] setGrid(Scanner keyboard) {
        int rows; int columns;

        do {
            System.out.print("How many rows? ");
            while(!keyboard.hasNextInt()) {
                System.out.println("Enter a valid number");
                keyboard.next();
            }
            rows = keyboard.nextInt();
            keyboard.nextLine();
            if(rows < 1 || rows > 9) {
                System.out.println("Enter a valid number from 1 to 9");
            }

        } while(rows < 1 || rows > 9);

        do {
            System.out.print("How many columns? ");
            while(!keyboard.hasNextInt()) {
                System.out.println("Enter a valid number");
                keyboard.next();
            }
            columns = keyboard.nextInt();
            keyboard.nextLine();
            if(columns < 1 || columns > 9) {
                System.out.println("Enter a valid number from 1 to 9");
            }

        } while(columns < 1 || columns > 9);

        char[][] cookie = new char[rows][columns];

        for(int i = 0; i < cookie.length; i++) {
            for(int j = 0; j < cookie[i].length; j++) {
                if(i == 0 && j == 0) {
                    cookie[i][j] = 'P';
                }
                else {
                    cookie[i][j] = '*';
                }
            }
        }

        return cookie;
    }

    private static void printCookie(char[][] cookie) {
        String topNum = "    ";
        for(int i = 0; i < cookie[0].length; i++) {
            topNum += i+1 + " ";
        }
        System.out.println("\n" + topNum);

        for(int i = 0; i < cookie.length; i++) {
            System.out.printf("%d   ", i+1);
            for(int j = 0; j < cookie[i].length; j++) {
                System.out.print(cookie[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private static boolean crumb(char[][] cookie, int players, Scanner keyboard) {
        boolean over = false;
        int row; int col;
        for(int i = 0; i < players; i++) {
            printCookie(cookie);
            System.out.printf("Player %d\n", i+1);
            do {
                System.out.printf("Coordinates of chomp (row,column)? ");
                String coords = keyboard.nextLine();
                Scanner scanCoords = new Scanner(coords).useDelimiter(",");
                row = scanCoords.nextInt();
                col = scanCoords.nextInt();
                if(row < 1 || col < 1 || row > cookie.length || col > cookie[0].length || cookie[row-1][col-1] == 0) {
                    System.out.println("\nNo fair. You're trying to chomp on empty space!\n");
                }
            } while(row < 1 || col < 1 || row > cookie.length || col > cookie[0].length || cookie[row-1][col-1] == 0);

            crumble(cookie, row-1, col-1);

            if(row == 1 && col == 1) {
                System.out.printf("\nYou lose, Player %d\n\n", i+1);
                over = true;
            }
        }

        return over;
    }

    private static void crumble(char[][] cookie, int row, int col) {
        for(int i = row; i < cookie.length; i++) {
            for(int j = col; j < cookie[i].length; j++) {
                cookie[i][j] = 0;
            }
        }
    }

    private static boolean playAgain(Scanner keyboard) {
        boolean isOver = true;
        System.out.print("Again (y/n)? ");
        String input = keyboard.nextLine();
        if(input.equalsIgnoreCase("y")) {
            isOver = false;
        }

        return isOver;
    }
}
