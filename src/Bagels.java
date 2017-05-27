/**
 * In this game, the computer picks a 3-digit secret number using the digits 0 to 9,
 * and you attempt to guess what it is. You're allowed up to twenty guesses. No digit
 * is repeated. After each guess, the computer will give you clues about your guess as follows:
 * PICO      One digit is correct, but in the wrong place
 * FERMI     One digit is in the correct place
 * BAGELS    No digit is correct
 *
 * You will learn to draw inferences from the clues and, with practice, you'll learn
 * to improve your score. There are several good strategies for playing Bagels.
 * After you have found a good strategy, see if you can improve it. Or try a different
 * strategy altogether and see if it is any better. While the program allows up to twenty
 * guesses, if you use a good strategy, it should not take more than eight guesses to gey any
 * number.
 * The original authors of this program are D. Resek and P. Row of the Lawrence Hall of Science, Berkley, California
 * This is the Java conversion of that code.
 */
public class Bagels {

    public static void butter() {
        System.out.println("                 Bagels");
        System.out.println("Creative Computing  Morristown, New Jersey");
        System.out.println();
        System.out.println("I am thinking of a three-digit number.");
        System.out.println("Try to guess my number, and I will give you clues as follows");
        System.out.println("   PICO     - One digit correct, but in the wrong position");
        System.out.println("   FERMI    - One digit correct and in the right position");
        System.out.println("   BAGELS   - No digits correct");
        System.out.println();

        int[] arrayA1 = new int[6];
        int[] arrayA = new int[3];
        int[] arrayB = new int[3];




    }
}
