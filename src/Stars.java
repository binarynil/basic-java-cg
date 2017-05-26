/*
In this game, the computer selects a random number from 1 to 100
(or any value you set). You try to guess the number and the computer
gives you clues to tell you how close you're getting. One star (*)
means you're far away from the number; seven stars (*******) means
you're really close. You get 7 guesses.
On the surface this game is very similar to GUESS; however, the guessing
strategy is quite different. See if you can come up with one or more
approaches to finding the mystery number. Bob Albrecht of People's
Computer created this game.
This is the Java conversion of that code.
 */
public class Stars {

    private static int maxValue = 100;
    private static int maxTries = 7;

    public static void star() {
        System.out.println("                   Stars");
        System.out.println("Creative Computing  Morristown, New Jersey");
        System.out.println();
        System.out.println();
        System.out.println("I am thinking of a whole number from 1 to " + maxValue);
        System.out.println("Try to guess my number. After you guess, I will");
        System.out.println("type one or more stars (*) The more stars I type,");
        System.out.println("the close you are to my number. One star (*) means");
        System.out.println("far away, seven stars (*******) means really close!");
        System.out.println("You get " + maxTries + " guesses.");
        System.out.println();



    }
}
