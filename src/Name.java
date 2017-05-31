/**
 * Name is a silly little ice-breaker to get a relationship going between
 * a computer and a shy human. The sorting algorithm used is highly inefficient.
 * As any reader of Creative Computng will recognize, this is the worst possible
 * sort for speed, but the program is good fun and that's what counts here.
 * Name was originally written by Geoffrey Chase of the Abbey, Portsmouth, Rhode Island.
 * This is the Java conversion of that code.
 * I had trouble figuring out what the original BASIC sorting algorithm did, so I
 * implemented the Fischer-Yates shuffle.
 */
import java.util.Scanner;
public class Name {

    public static void sort() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Hello.");
        System.out.println("My name is Creative Computer");
        System.out.print("What is your name (first and last)? ");
        String input = keyboard.nextLine();
        String yourName = input;
        int length = yourName.length();
        String[] nameArray = new String[length];

        String nameChar = "";

        for(int i = 0; i < length; i++) {
            nameChar = yourName.substring(i, i+1);
            nameArray[i] = nameChar;
        }


        System.out.println();
        nameChar = "";

        for(int i = length-1; i >= 0; i--) {
            nameChar += nameArray[i];
        }

        System.out.println("Thank you, " + nameChar + ".");
        System.out.println("OOPS! I guess I got it backwards.");
        System.out.println("A smart computer like me shouldn't make a mistake like that!");
        System.out.println("\nBut I just noticed your letters are out of order.");
        System.out.print("Let's put them in order like this: ");
        int rndNum = 0;

        for(int i = 0; i < length-1; i++) {
            boolean inBetween = false;
            while(!inBetween) {
                rndNum = (int)(Math.random() * length-1);

                if(i <= rndNum && rndNum < length) {
                    inBetween = true;
                }
            }
            //System.out.println(rndNum+","+i);
            String rndTemp = nameArray[rndNum];
            String prevTemp = nameArray[i];
            nameArray[i] = rndTemp;
            nameArray[rndNum] = prevTemp;
        }
        /*              hello
                        01234
                        lehlo
                        lhelo
                        lhelo */
        for(String e : nameArray) {
            if(e.equalsIgnoreCase(" ")) {
                e = "";
            }
            System.out.print(e.toUpperCase());
        }


        System.out.print("\n\nDon't you like that better? ");
        input = keyboard.nextLine();
        System.out.println();
        if(input.equalsIgnoreCase("yes")) {
            System.out.println("I knew you'd agree!!");
        }
        else {
            System.out.println("I'm sorry you don't like it that way.");
        }
        System.out.println("\nI really enjoyed meeting you " + yourName);
        System.out.println("Have a nice day!");

    }
}