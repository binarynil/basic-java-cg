import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program plays the card game of War.
 * In War, the card deck is shuffled when two
 * cards are dealt, one to each player. Players
 * compare cards and the higher card (numerically)
 * wins. In case of a tie, no one wins. The game
 * ends when you have gone through the whole deck
 * (52 cards, 26 games) or when you decide to quit.
 * The computer gives cards by suit and number,
 * for example, S-7 is 7 of spades.
 * The original BASIC code is from the book BASIC Computer games.
 * This is the Java conversion of that code.
 */
public class War {

    public static void machine() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("This is the card game of war. Each card is given by suit-#");
        System.out.println("as S-7 for Spade 7. The computer gives you and it a card");
        System.out.println("The higher card (numerically) wins. The game ends when you");
        System.out.println("choose not to continue or when you have finished the pack.");
        List<String> cards = new ArrayList<String>();
        String yourCard = "";
        String cpuCard = "";
        String[] cPrefix = {"S-", "H-", "C-", "D-"};

        for(int i = 0; i < cPrefix.length; i++) {
            String preString = cPrefix[i];

            for(int j = 0; j < 13; j++) {
                int cardNum = j + 2;
                String cSuffix = "";
                if(cardNum == 11) {
                    cSuffix = "J";
                }
                else if(cardNum == 12) {
                    cSuffix = "Q";
                }
                else if(cardNum == 13) {
                    cSuffix = "K";
                }
                else if(cardNum == 14) {
                    cSuffix = "A";
                }
                else {
                    cSuffix = "" + cardNum;
                }
                cards.add(preString+cSuffix);
            }
        }
        boolean yesNo = true;
        int yourWins = 0;
        int cpuWins = 0;
        do {
            int cardSize = cards.size() - 1;
            System.out.println("CARD SIZe " + cardSize);

            int yourNum = genNum(cardSize);
            int cpuNum = genNum(cardSize, yourNum);

            yourCard = cards.get(yourNum);
            cpuCard = cards.get(cpuNum);

            System.out.println("\nYour card: " + yourCard + "    Computer's card: " + cpuCard);
            String numString = cards.get(yourNum).substring(2);
            String cpuNString = cards.get(cpuNum).substring(2);
            cards = removeCard(cards, yourCard, cpuCard);

            yourNum = checkInt(numString);
            cpuNum = checkInt(cpuNString);
            if(yourNum > cpuNum) {
                yourWins++;
                System.out.println("You win. " + "You have " + yourWins + "  Computer has " + cpuWins);
            }
            else if(yourNum == cpuNum) {
                System.out.println("Tie. No score change.");
            }
            else {
                cpuWins++;
                System.out.println("Computer wins!!! " + "You have " + yourWins + "  Computer has " + cpuWins);
            }


            System.out.print("Do you want to continue? ");
            String input = keyboard.nextLine();
            if(input.equalsIgnoreCase("yes")) {
                yesNo = true;
            }
            else {
                yesNo = false;
            }

            if(cards.isEmpty()) {
                yesNo = false;
                System.out.println("You ran out of cards.");
                System.out.println("Final Score:  You--" + yourWins + " Computer--" + cpuWins);
            }
            if(!yesNo) {
                System.out.println("Thanks for playing. It was fun.");
            }

        } while(yesNo);
    }

    private static int checkInt(String cardNum) {
        int cardInt = 0;
        if(cardNum.equals("J")) {
            cardInt = 11;
        }
        else if(cardNum.equals("Q")) {
            cardInt = 12;
        }
        else if(cardNum.equals("K")) {
            cardInt = 13;
        }
        else if(cardNum.equals("A")) {
            cardInt = 14;
        }
        else {
            cardInt = Integer.parseInt(cardNum);
        }

        return cardInt;
    }

    private static int genNum(int cardSize) {
        int yourNum = (int)(Math.random() * cardSize);

        return yourNum;
    }

    private static int genNum(int cardSize, int yourNum) {
        int cpuNum;
        if(cardSize == 1 && yourNum == 0) {
            cpuNum = 1;
        }
        else if(cardSize == 1 && yourNum == 1) {
            cpuNum = 0;
        }
        else {
            do {

                cpuNum = (int)(Math.random() * cardSize);
            } while(cpuNum == yourNum);
        }

        return cpuNum;
    }

    private static List<String> removeCard(List<String> cards, String yourCard, String cpuCard) {
        cards.remove(cpuCard);
        cards.remove(yourCard);

        return cards;
    }
}
