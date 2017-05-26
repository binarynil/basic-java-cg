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

    private static String[] cardValue = {"0", "0", "2", "3", "4", "5", "6", "7", "8", "9",
                                         "10", "Jack (11)", "Queen (12)", "King (13)", "Ace (14)"};

    public static void ace() {
        Scanner keyboard = new Scanner(System.in);


        int[] moneyBet = {100, 0}; //index 0 total money, index 1 bet
        int bet;

        boolean hasMoney = true;
        boolean yourTurn;
        boolean roundWin = true;
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
        System.out.println();

        System.out.printf("You have %d dollars \n", moneyBet[0]);

        do {

            yourTurn = false;
            hasMoney = checkMoney(hasMoney, moneyBet);

            if(!hasMoney) {
                System.out.println("You ran out of money! Game Over!");
            }
            else {
                System.out.println();
                System.out.println("Here are your next two cards ");

                int a = rollCard();
                int b = rollCard();

                while(b == 2) {
                    b = rollCard();
                   // System.out.println(b);
                }

                while(a >= b) {
                    a = rollCard();
                  //  System.out.println(a);
                }

                printCard(a);
                printCard(b);

                System.out.println();

                do {

                    System.out.println("What is your bet? ");
                    bet = keyboard.nextInt();
                    keyboard.nextLine();
                    if(bet < 0 || bet > moneyBet[0]) {
                        System.out.println("Enter a valid bet \n");
                    }
                    else {
                        moneyBet[1] = bet;
                        if(bet == 0) {
                            System.out.println("Chicken!!");
                        }
                        else if(bet <= moneyBet[0]) {
                            int c = rollCard();
                            printCard(c);
                            roundWin = inBetween(a, b, c);
                        }
                    }
                    moneyBet = calcMoney(roundWin, moneyBet);
                    yourTurn = true;
                } while(!yourTurn);
            }

        } while(hasMoney);
    }

    public static boolean inBetween(int a, int b, int c) {
        boolean roundWin;
        if(c > a && c < b) {
            roundWin = true;
        }
        else {
            roundWin = false;
            System.out.println("Sorry, you lose.");
        }
        return roundWin;
    }

    public static boolean checkMoney(boolean hasMoney, int[] moneyBet) {
        int money = moneyBet[0];
        if(money <= 0) {
            hasMoney = false;
        }
        return hasMoney;
    }

    public static int[] calcMoney(boolean roundWin, int[] moneyBet) {
        if(roundWin) {
            moneyBet[0] = moneyBet[0] + moneyBet[1];
        }
        else {
            moneyBet[0] = moneyBet[0] - moneyBet[1];
        }
        System.out.printf("You now have %d dollars \n", moneyBet[0]);
        return moneyBet;
    }

    public static int rollCard() {
        int cardNum;
        do {
            cardNum = (int)((Math.random() * 14) + 2);
        } while(cardNum < 2 || cardNum > 14);
        return cardNum;
    }

    public static void printCard(int card) {
        System.out.println(" " + cardValue[card]);
    }
}