import java.util.Scanner;

public class Menu {

    // main menu class / program
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

            System.out.println("1. Acey Duecy");
            System.out.println("2. quit");
            System.out.println();
            System.out.print("Enter choice: ");
            input = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println();

            if(input == 1) {
                AceyDucey.ace();

            }
            else if(input == 2) {
                System.out.println("Bye.");
            }
            else {
                System.out.println("EROROROROR");
            }

        } while(input != 2);

    }
}