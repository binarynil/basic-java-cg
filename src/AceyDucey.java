import java.util.Scanner;
/*
This is a simulation of the Acey Ducey card game.
In the game, the dealer (the computer) deals two cards face up.
You have an option to bet or not to bet depending on whether or not
you feel the next card dealt will have a value between the first two.

Your initial money is set to 100; alter accordingly.
The game keeps going on until you lose all your money or interrupt the program.
The original program author (in BASIC) was Bill Palmby of Prairie View, Illinois.
This is the Java conversion of that code.
 */

public class AceyDucey {

    public static void ace() {
        Scanner keyboard = new Scanner(System.in);


        int money = 100;
        boolean win = true;
        System.out.println("           Acey Ducey Card Game");
        System.out.println("Creative Computing  Morristown, New Jersey");
        System.out.println();
        System.out.println();
        System.out.println("Acey Duecy is played in the following manner");
        System.out.println("The dealer (computer) deals two cards face up");
        System.out.println("You have an option to bet or not bet depending");
        System.out.println("on whether or not you feel the card will have");
        System.out.println("a value between the first two.");
        System.out.println("If you do not want to bet, input a 0 (zero)");

        System.out.printf("You have %d dollars \n", money);

        do {
            System.out.println("Here are you next two cards ");

            int a = rollCard();
            int b = rollCard();

            do {
                a = rollCard();
            } while(a >= b);

            printCard(a);
            printCard(b);

            System.out.println();
            System.out.println();

            int bet;

            do {
                System.out.println("What is your bet? ");
                bet = keyboard.nextInt();
                if(bet == 0) {
                    System.out.println("Chicken!!");
                }
                else if(bet <= money) {
                    int c = rollCard();
                    printCard(c);
                    if(c>a) {
                        win = checkB(b,c);
                    }
                }

            } while(bet != 0);


        } while(win);

    }

    public static boolean checkB(int b, int c) {
        boolean win = true;
        if(c >= b) {
            System.out.println(" Sorry, you lose.");
            win = false;
        }
        return win;
    }

    public static int rollCard() {
        int cardNum;
        do {
            cardNum = (int)((Math.random() * 14) + 2);
        } while(cardNum < 2 || cardNum > 14);
        return cardNum;
    }

    public static void printCard(int card) {
        if(card < 11) {
            System.out.println(" " + a);
        }
        else if(card == 11) {
            System.out.println(" Jack");
        }
        else if(card == 12) {
            System.out.println(" Queen");
        }
        else if(card == 13) {
            System.out.println(" King");
        }
        else if(card == 14) {
            System.out.println(" Ace");
        }
    }
}