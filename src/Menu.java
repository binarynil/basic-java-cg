import java.util.Scanner;

public class Menu {

    // main menu class / program
    private static String[] menuArray = {null, "Acey Ducey", "Bagels", "Dice", "Name", "Stars", "War", "quit"};
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int input;

        System.out.println("BASIC Computer Games converted into Java");
        System.out.println("Taken from http://www.atariarchives.org/basicgames/");
        /* do loop with the selection of games in alphabetical order
           number choices, last number or q or quit or exit to exit
           each game will be their own class, game called upon Game.gamemethod(); */

        do {
            System.out.println();
            System.out.println("Select Game: ");

            for(int i = 1; i < menuArray.length; i++) {
                System.out.println(i + ".   " + menuArray[i]);
            }

            System.out.println();
            System.out.print("Enter choice: ");
            input = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println();

            if(input == 1) {
                printCC(input);
                AceyDucey.ace();
            }
            else if(input == 2) {
                printCC(input);
                Bagels.butter();
            }
            else if(input == 3) {
                printCC(input);
                Dice.roll();
            }
            else if(input == 4) {
                printCC(input);
                Name.sort();
            }
            else if(input == 5) {
                printCC(input);
                Stars.star();
            }
            else if(input == 6) {
                printCC(input);
                War.machine();
            }
            else if(input == 7) {
                System.out.print("Bye.");
            }
            else {
                System.out.println("EROROROROR");
            }
        } while(input != 7);
    }

    private static void printCC(int input) {
        int spaces = (42 - menuArray[input].length()) / 2;
        //spaces = spaces / 2;
        String printGame = "";
        for(int i = 0; i < spaces; i++) {
            printGame += " ";
        }
        printGame += menuArray[input];
        System.out.println(printGame);
        System.out.println("Creative Computing  Morristown, New Jersey");
        System.out.println();
        System.out.println();
    }
}